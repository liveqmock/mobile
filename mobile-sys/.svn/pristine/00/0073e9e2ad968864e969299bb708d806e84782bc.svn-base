package com.gsoft.mobile.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.mobile.core.dao.AccInfDao;
import com.gsoft.mobile.core.dao.ClientInfDao;
import com.gsoft.mobile.core.dao.LogQuiRegDao;
import com.gsoft.mobile.core.dao.MerInfDao;
import com.gsoft.mobile.core.dao.SignInfDao;
import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.entity.LogQuiReg;
import com.gsoft.mobile.core.entity.MerInf;
import com.gsoft.mobile.core.entity.ParamInf;
import com.gsoft.mobile.core.entity.SignInf;
import com.gsoft.mobile.manager.dao.TerInfDao;
import com.gsoft.mobile.manager.entity.TerInf;
import com.gsoft.mobile.manager.service.LoginManager;

@Service("loginManager")
@Transactional
public class LoginManagerImpl implements LoginManager{
	
	@Autowired
	private ClientInfDao<ClientInf, String> clientInfDao;
	
	@Autowired
	private AccInfDao<AccInf, String> accInfDao;

	@Autowired
	private SignInfDao<SignInf, String> signInfDao;

	@Autowired
	private LogQuiRegDao<LogQuiReg, String> logQuiRegDao;

	@Autowired
	private MerInfDao<MerInf, String> merInfDao;
	
	@Autowired
	private TerInfDao<TerInf, String> terInfDao;


	/**
	 * 根据银行卡号和密码获取登录信息
	 * 信息校验——>卡号绑定判断——>未绑定用户获取卡信息——>卡信息判断——>根据卡信息绑定银行卡并获取用户信息 
	 */
	@Override
	@EsbServiceMapping
	public Message getLoginInf(
			@ServiceParam(name = "bankcardNum") String bankcardNum,
			@ServiceParam(name = "password") String password,TerInf terInf) throws BusException {
		if (!checkBankcardNum(bankcardNum) ||password==null) {
			return new Message("999999", "卡号或密码格式不对");
		}
		// 根据卡号查询账户信息。判断用户是否存在，若存在是客户还是商户,若账户未在启用状态则返回账户信息。
		Object object = getObjectInfByBankcardNum(bankcardNum);
		ClientInf clientInf = null;
		Record bankcardInfo;// 银行返回的卡信息
		//默认 用户的终端状态为可用
		terInf.setTerminalState(ParamInf.terminalState.get("normal"));

		if (object != null) {// 若卡号已经绑定
			if (object instanceof AccInf) {
				return new Message("999999", "该账户未在启用状态");
			}
			
			// 调用银行接口，判断卡号密码是否正确,返回卡信息
			if(!bankcardNumPasswordCheck(bankcardNum, password)){
				return new Message("999999", "登录失败");
			}
			// 组织相关参数......
			
			if (object instanceof ClientInf) {
				clientInf = (ClientInf) object;
				if(!clientInf.getClientState().equals(ParamInf.clientState.get("normal"))){
					return new Message("999999", "该客户未在启用状态");
				}
				//将客户的终端信息放入客户信息表中
				clientInf.setTerminalBrand(terInf.getTerminalBrand());
				clientInf.setTerminalModel(terInf.getTerminalModel());
				clientInf.setTerminalState(terInf.getTerminalState());
				clientInfDao.save(clientInf);
				
			} else if (object instanceof MerInf) {
				MerInf merInf = (MerInf) object;
				if(!merInf.getMerState().equals(ParamInf.merState.get("normal"))){
					return new Message("999999", "该商户未在启用状态");
				}
				try {
					// 将商户对应的终端信息放入终端信息表
					TerInf newTerInf = saveTerInf(merInf,terInf);
					LogQuiReg lqr = addLogQuiRegInf(merInf, bankcardNum, terInf,"00");
				} catch (Exception e) {
					return new Message("999999", "信息有误");
				}
				
				return new Message("000000", "登录成功");
			}
			

		} else {// 未绑定卡号
			bankcardInfo = getBankcardInfo(bankcardNum, password);// 银行接口获取卡信息
			if (bankcardInfo == null) {
				throw new BusException("银行卡号不存在！");
			}
			try {
				clientInf = this.bindBankcardNum(bankcardNum, bankcardInfo,terInf);
			} catch (Exception e) {
				e.printStackTrace();
				return new Message("999999", "绑定信息有误");
			}
		}
		// 添加用户的登录信息到登录退出表
		LogQuiReg lqr = addLogQuiRegInf(clientInf, bankcardNum,terInf,"00");
		return new Message("000000", "登录成功");
	}
	
	/**
	 * 密码校验
	 * @param bankcardNum
	 * @param password
	 * @return
	 */
	private boolean checkPwd(String bankcardNum, String password) {
		if (password != null) {
			String regex = "^\\d{6}$";
			if (password.matches(regex)) {
				AccInf accInf = accInfDao.getObjectByUniqueProperty("bankcardNum", bankcardNum);
				if(accInf!=null&&accInf.getQueryPwd().equals(password)){
					return true;
				}
				
			}
		}
		return false;
	}

	/**
	 * 校验银行卡格式
	 * @param bankcardNum
	 * @return
	 */
	private boolean checkBankcardNum(String bankcardNum) {
		if (bankcardNum != null) {
			String regex = "^\\d{19}$";
			if (bankcardNum.matches(regex)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 根据卡号查询信息，如果卡号为停用状态，直接返回账户信息。否则，为客户时返回客户信息，为商户时返回商户信息
	 * 
	 * @param bankcardNum
	 * @return
	 */
	public Object getObjectInfByBankcardNum(String bankcardNum)
			throws BusException {
		AccInf accInf = accInfDao.getObjectByUniqueProperty("bankcardNum",
				bankcardNum);
		// 根据卡号查询账户信息并且客户编号和类型不能为空
		if (accInf != null && accInf.getClientId() != null
				&& accInf.getClientType() != null) {
			if (!ParamInf.accountState.get("normal").equals(
					accInf.getAccountState())) {// 账户未在正常启用状态
				return accInf;
			}
			String clientType = accInf.getClientType();
			if (ParamInf.clientType.get("client").equals(clientType)) {// 该账号对应的客户类型是客户
				ClientInf clientInf = clientInfDao.getObjectByUniqueProperty(
						"clientId", accInf.getClientId().toString());
				if (clientInf != null)
					return clientInf;
			} else if (ParamInf.clientType.get("merch").equals(clientType)) {// 该账号对应的客户类型是商户
				MerInf merInf = merInfDao.getObjectByUniqueProperty(
						"merchantNo", accInf.getClientId());
				if (merInf != null)
					return merInf;
			}
		}
		return null;
	}

	
	/**
	 * 判断卡号密码是否匹配
	 * 
	 * @param bankcardNum
	 * @param password
	 * @throws BusException
	 */
	private boolean bankcardNumPasswordCheck(String bankcardNum, String password)
			throws BusException {
		// 此方法应调用银行接口
		
		if(password.matches("^\\d{6}$")){
			AccInf accInf = accInfDao.getObjectByUniqueProperty("bankcardNum", bankcardNum);
			if(accInf!=null&&accInf.getQueryPwd().equals(password)){
				return true;
			}
		}
		return false;
//		getBankcardInfo(bankcardNum, password);
	}
	
	
	/**
	 * 调用银行接口，根据卡号和密码查询卡用户信息
	 * 
	 * @param bankcardNum
	 * @param password
	 * @return
	 */
	private Record getBankcardInfo(String bankcardNum, String password) {
		Record record = new Record();
		// TODO 调用银行接口

		// 模拟数据
		ClientInf clientInf = new ClientInf();

		clientInf.setClientId("15");
		clientInf.setClientState(ParamInf.clientState.get("normal"));
		clientInf.setClientName("杨玉斌");
		clientInf.setClientAddress("北京市丰台区丰台北路128号");
		clientInf.setDocumentNum("130227198906046002");
		clientInf.setDocumentType("01");
		clientInf.setContacts("杨玉斌");
		clientInf.setContactNum("13832654293");
		clientInf.setMainAccount(bankcardNum);
		clientInf.setClientType(ParamInf.clientType.get("client"));

		record.put("clientInf", clientInf);

		List<AccInf> accInfs = new ArrayList<AccInf>();
		AccInf accInf = new AccInf();
		accInf.setBankcardNum(bankcardNum);
		accInf.setAccountState("00");
		accInf.setAccountType("01");
		accInf.setAffordCardInst("1234");
		accInf.setCurrType("01");
		accInf.setClientType("00");
		accInf.setQueryPwd("123456");
		accInf.setWithdrawPwd("000000");
		accInf.setBalance("0");
		
		accInfs.add(accInf);

		record.put("accInfs", accInfs);

		return record;
	}
	
	/**
	 * 根据证件类型和证件号码查询账户
	 * 
	 * @param object
	 * @param object2
	 * @return
	 */
	private ClientInf getClientInfByIdCard(Object documentType,
			Object documentNum) {
		List<ClientInf> clientInfs = clientInfDao.getList(new String[] {
				"documentType", "documentNum" }, new Object[] { documentType,
				documentNum });
		return CollectionUtils.isEmpty(clientInfs) ? null : clientInfs.get(0);
	}
	
	/**
	 * 根据银行返回的信息创建客户
	 * 
	 * @param bankcardNum
	 * @param bankcardInfo
	 * @return
	 */
	private ClientInf createNewClientInf(String bankcardNum, Record bankcardInfo) {

		// 模拟数据
		ClientInf clientInf = (ClientInf) bankcardInfo.get("clientInf");
		List<AccInf> accInfs = (List<AccInf>) bankcardInfo.get("accInfs");
		Assert.notNull(clientInf, "银行没有返回客户信息");
		Assert.notEmpty(accInfs, "银行没有返回账户信息");
		clientInf.setAccInfs(accInfs);

		return clientInf;
	}
	
	/**
	 * 根据银行返回的信息创建账户
	 * 
	 * @param bankcardNum
	 * @param bankcardInfo
	 * @return
	 */
	private AccInf createNewAccInf(String bankcardNum, Record bankcardInfo) {
		AccInf accInf = new AccInf();
		List<AccInf> accInfs = (List<AccInf>) bankcardInfo.get("accInfs");
		accInf = accInfs.get(0);
		if(accInf!=null){
			return accInfDao.save(accInf);
		}
		return null;
	}
	
	
	/**
	 * 绑定银行卡到客户，客户不存在则创建
	 * 
	 * @param bankcardNum
	 * @param bankcardInfo
	 * @return
	 */
	private ClientInf bindBankcardNum(String bankcardNum, Record bankcardInfo,TerInf terInf) {

		// 根据bankcardInfo里面的证件类型和证件号码查询客户
		ClientInf clientInf = (ClientInf) bankcardInfo.get("clientInf");
		Assert.notNull(clientInf.getDocumentType(), "银行没有返回证件类型！");
		Assert.notNull(clientInf.getDocumentNum(), "银行没有返回证件号码！");

		ClientInf clientInfWithIdCard = getClientInfByIdCard(
				clientInf.getDocumentType(), clientInf.getDocumentNum());
		List<AccInf> cliAccInfs = new ArrayList<AccInf>();// 客户绑定的银行卡

		if (clientInfWithIdCard == null) {
			// 如果客户不存在，创建客户
			clientInfWithIdCard = createNewClientInf(bankcardNum, bankcardInfo);
			if (clientInfWithIdCard.getAccInfs() != null) {
				cliAccInfs.addAll(clientInfWithIdCard.getAccInfs());
			}
		}

		List<AccInf> accInfs = clientInfWithIdCard.getAccInfs();
		Assert.notEmpty(accInfs, "未找到对应的账户信息");

		//创建账户信息
		AccInf accInf = createNewAccInf(bankcardNum, bankcardInfo);
		if(accInf==null){
			return null;
		}
		
		// 绑定当前银行卡到客户
		cliAccInfs.add(accInf);
		// 添加将客户已经绑定的账户信息后重新关联给客户
		cliAccInfs.addAll(accInfs);
		clientInfWithIdCard.setAccInfs(cliAccInfs);
		
		//终端信息
		clientInf.setTerminalBrand(terInf.getTerminalBrand());
		clientInf.setTerminalModel(terInf.getTerminalModel());
		clientInf.setTerminalState(terInf.getTerminalState());
		
		//添加新导入的卡信息相关的签约信息
//		saveSignInf(accInf,clientInfWithIdCard);

		// 保存客户信息
		return clientInfDao.save(clientInfWithIdCard);
	}

	/**
	 * 绑定账户的签约信息
	 * @param accInf
	 */
	private SignInf saveSignInf(AccInf accInf,ClientInf clientInf) {
		SignInf signInf = new SignInf();
		signInf.setBankcardNum(accInf.getBankcardNum());
		signInf.setAffordCardInst(accInf.getAffordCardInst());
		signInf.setWithdrawPwd(accInf.getWithdrawPwd());
		
		signInf.setDocumentNum(clientInf.getDocumentNum());
		signInf.setDocumentType(clientInf.getDocumentType());
		signInf.setClientState(clientInf.getClientState());
		signInf.setPhoneNum(clientInf.getContactNum());
		
		signInf.setDailyPayLimit("1000");
		signInf.setSinglePayLimit("800");
		signInf.setSignBusiness(ParamInf.signBusiness.get("payTreaty"));
		signInf.setSignDate(DateUtils.getToday("yyyyMMdd"));
		
		return signInfDao.save(signInf);
	}

	/**
	 * 添加登录信息到客户登录退出表
	 * 
	 * @param bankcardInfo
	 * @param currPosition
	 * @param terminalBrand
	 * @param terminalModel
	 * @param terminalState
	 * @param terminalState2
	 */
	private LogQuiReg addLogQuiRegInf(Object object, String bankcardNum,
			TerInf terInf,String type) {
		LogQuiReg lqr = new LogQuiReg();
		if(object instanceof ClientInf){
			ClientInf clientInf = (ClientInf)object;
			// 从银行返回的卡信息中取出客户相关信息
			lqr.setClientId(clientInf.getClientId().toString());
			lqr.setClientAddress(clientInf.getClientAddress());
		}else if(object instanceof MerInf){
			MerInf merInf = (MerInf)object;
			lqr.setClientId(merInf.getMerchantNo());
			lqr.setClientAddress(merInf.getMerAddress());
		}

		lqr.setLoginType(type);//00 登录
		lqr.setBankcardNum(bankcardNum);
		lqr.setOperateType("00");// 操作类型 00—登录
		lqr.setCurrPosition(terInf.getCurrPosition());
		lqr.setTerminalBrand(terInf.getTerminalBrand());
		lqr.setTerminalModel(terInf.getTerminalModel());
		lqr.setTerminalState(terInf.getTerminalState());

		// 获取当前时间
		lqr.setOperateDate(DateUtils.getToday("yyyyMMdd"));
		lqr.setOperateTime(DateUtils.getToday("HHmmss"));

		return logQuiRegDao.save(lqr);
	}

	
	/**
	 * 保存商户的终端信息
	 * @param merInf
	 * @param terminalBrand
	 * @param terminalState
	 * @param terminalModel
	 * @param currPosition
	 * @return
	 */
	private TerInf saveTerInf(MerInf merInf, TerInf terInf) {
		String merchantNo = merInf.getMerchantNo();
		if(terInf.getTerminalNo()==null||merchantNo==null||"".equals(merchantNo)){
			return null;
		}
		terInf.setMerchantNo(merchantNo);
		return terInfDao.save(terInf);
	}

	/**
	 * 用户退出
	 */
	@Override
	@EsbServiceMapping
	public void quit(@ServiceParam(name = "bankcardNum") String bankcardNum,TerInf terInf) throws BusException {
		if(checkBankcardNum(bankcardNum)){
			AccInf accInf = accInfDao.getObjectByUniqueProperty("bankcardNum", bankcardNum);
			LogQuiReg  logQuiReg;
			if(accInf!=null){
				if(accInf.getClientType().equals(ParamInf.clientType.get("client"))){//客户登录
					ClientInf clientInf = clientInfDao.getObjectByUniqueProperty("clientId", accInf.getClientId());
					logQuiReg = addLogQuiRegInf(clientInf, bankcardNum, terInf,"01");
				}else if(accInf.getClientType().equals(ParamInf.clientType.get("merch"))){//商户登录
			    	MerInf merInf = merInfDao.getObjectByUniqueProperty("merchantNo", accInf.getClientId());
			    	logQuiReg = addLogQuiRegInf(merInf, bankcardNum, terInf,"01");
				}
			}
		}
	}
}
