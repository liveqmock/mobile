/**
 * 代码声明
 */
package com.gsoft.mobile.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.annotation.Filter;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.mobile.core.dao.AccInfDao;
import com.gsoft.mobile.core.dao.ClientInfDao;
import com.gsoft.mobile.core.dao.LogQuiRegDao;
import com.gsoft.mobile.core.dao.SignInfDao;
import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.entity.LogQuiReg;
import com.gsoft.mobile.core.entity.SignInf;
import com.gsoft.mobile.core.service.ClientInfManager;

@Service("clientInfManager")
@Transactional
public class ClientInfManagerImpl extends BaseManagerImpl implements
		ClientInfManager {
	@Autowired
	private ClientInfDao<ClientInf, String> clientInfDao;

	@Autowired
	private AccInfDao<AccInf, String> accInfDao;

	@Autowired
	private SignInfDao<SignInf, String> signInfDao;

	@Autowired
	private LogQuiRegDao<LogQuiReg, String> logQuiRegDao;

	/**
	 * 查询列表
	 */
	@EsbServiceMapping
	public List<ClientInf> getClientInfs() throws BusException {
		return clientInfDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<ClientInf> getClientInfs(Collection<Condition> conditions,
			Collection<Order> orders) throws BusException {
		return clientInfDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public ClientInf getClientInf(@ServiceParam(name = "clientId") String id)
			throws BusException {
		ClientInf clientInf = clientInfDao.getObjectByUniqueProperty(
				"clientId", id, new String[] { "accInfs" });
		return clientInf;
	}

	// @EsbServiceMapping
	// public PagerRecords getPagerClientInfs(Pager pager,//分页条件
	// @ConditionCollection(domainClazz=ClientInf.class) Collection<Condition>
	// conditions,//查询条件
	// @OrderCollection Collection<Order> orders) throws BusException {
	// PagerRecords pagerRecords = clientInfDao.findByPager(pager, conditions,
	// orders);
	// return pagerRecords;
	// }

	@EsbServiceMapping(
//		pubConditions={
//			@PubCondition(property = "clientId", pubProperty = "params.bankcardNum")
//		},
//		filters={
//			@Filter(name = "mainAccount", operator = Condition.LIKE)
//		}
	)
	public PagerRecords getPagerClientInfs(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = ClientInf.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = clientInfDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public ClientInf saveClientInf(ClientInf o) throws BusException {
		// String clientInfId = o.getClientInfId();
		// boolean isUpdate = StringUtils.isNotEmpty(clientInfId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		return clientInfDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeClientInf(@ServiceParam(name = "clientId") String id)
			throws BusException {
		clientInfDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	@EsbServiceMapping
	public void removeClientInfs(String[] ids) throws BusException {
		for (String id : ids) {
			removeClientInf(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitClientInf(String id) throws BusException {
		return clientInfDao.exists(id);
	}

	@EsbServiceMapping
	public boolean exsitClientInf(String propertyName, Object value)
			throws BusException {
		return clientInfDao.exists(propertyName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gsoft.mobile.core.service.ClientInfManager#getClientSignInfs(java
	 * .lang.String)
	 */
	@EsbServiceMapping
	public List<SignInf> getClientSignInfs(
			@ServiceParam(name = "clientId") String clientId)
			throws BusException {
		List<SignInf> signInfs = new ArrayList<SignInf>();
		// TODO 校验
		if (clientId == null && !"".equals(clientId)) {
			throw new BusException("clientId不能为空");
		}
		// 根据客户编号查询客户信息
		ClientInf clientInf = clientInfDao.get(clientId);

		if (clientInf != null) {
			// 取出客户信息关联的账户信息
			List<AccInf> accInfs = clientInf.getAccInfs();

			// 判断存在相关联的账户信息
			if (accInfs != null && accInfs.size() != 0) {

				// 取出所有与客户信息关联的账户信息中的银行卡号
				List<String> bankcardNums = new ArrayList<String>();
				for (AccInf accInf : accInfs) {
					bankcardNums.add(accInf.getBankcardNum());
				}
				Assert.notEmpty(bankcardNums, "未找到对应的银行卡号");

				// 银行卡号作为条件查询签约信息
				Collection<Condition> conditions = new ArrayList<Condition>();
				Collection<Order> orders = new ArrayList<Order>();

				conditions.add(ConditionUtils.getCondition("bankcardNum",
						Condition.IN,
						bankcardNums.toArray(new String[bankcardNums.size()])));
				orders.add(ConditionUtils.getOrder("bankcardNum", true));
				signInfs = signInfDao.commonQuery(conditions, orders);
			}
		}
		return signInfs;
	}

	/*
	 * 信息校验——>卡号绑定判断——>未绑定用户获取卡信息——>卡信息判断——>根据卡信息绑定银行卡并获取用户信息 (non-Javadoc)
	 * 
	 * @see
	 * com.gsoft.mobile.core.service.ClientInfManager#getLoginClientInf(java
	 * .lang.String, java.lang.String)
	 */
	@EsbServiceMapping
	public ClientInf getLoginClientInf(
			@ServiceParam(name = "bankcardNum") String bankcardNum,
			@ServiceParam(name = "password") String password,
			@ServiceParam(name = "terminalBrand") String terminalBrand,
			@ServiceParam(name = "terminalState") String terminalState,
			@ServiceParam(name = "terminalModel") String terminalModel,
			@ServiceParam(name = "currPosition") String currPosition)
			throws BusException {

		Assert.notNull(bankcardNum, "卡号参数不能为空！");
		Assert.notNull(password, "密码参数不能为空！");
		// 根据卡号查询客户信息（本地）
		ClientInf clientInf = getClientInfByBankcardNum(bankcardNum);

		Record bankcardInfo;// 银行返回的卡信息

		if (clientInf != null) {// 卡号是否已经绑定
			// 调用银行接口，判断卡号密码是否正确,返回卡信息
			bankcardInfo = bankcardNumPasswordCheck(bankcardNum, password);
			// 组织相关参数

		} else {// 未绑定卡号
			bankcardInfo = getBankcardInfo(bankcardNum, password);// 银行接口获取卡信息
			if (bankcardInfo == null) {
				throw new BusException("银行卡号不存在！");
			}
			clientInf = this.bindBankcardNum(bankcardNum, bankcardInfo);
		}
		// 添加用户的登录信息到登录退出表
		LogQuiReg lqr = addLogQuiRegInf(clientInf, bankcardNum,currPosition,
				terminalBrand, terminalModel, terminalState);

		// TODO 合并客户信息和银行返回的信息
		return clientInf;
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
	private LogQuiReg addLogQuiRegInf(ClientInf clientInf, String bankcardNum, String currPosition,
			String terminalBrand, String terminalModel, String terminalState) {
		LogQuiReg lqr = new LogQuiReg();

		// 从银行返回的卡信息中取出客户相关信息
		lqr.setClientId(clientInf.getClientId().toString());
		lqr.setClientAddress(clientInf.getClientAddress());
		lqr.setBankcardNum(bankcardNum);
		lqr.setOperateType("00");// 操作类型 00—登录
		lqr.setCurrPosition(currPosition);
		lqr.setTerminalBrand(terminalBrand);
		lqr.setTerminalModel(terminalModel);
		lqr.setTerminalState(terminalState);

		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formateTime = new SimpleDateFormat("hhmmss");
		lqr.setOperateDate(formatDate.format(date));
		lqr.setOperateTime(formateTime.format(date));

		return logQuiRegDao.save(lqr);
	}

	/**
	 * 绑定银行卡到客户，客户不存在则创建
	 * 
	 * @param bankcardNum
	 * @param bankcardInfo
	 * @return
	 */
	private ClientInf bindBankcardNum(String bankcardNum, Record bankcardInfo) {

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
		
		
		// 绑定当前银行卡到客户
		cliAccInfs.add(createNewAccInf(bankcardNum, bankcardInfo));
		//添加将客户已经绑定的账户信息后重新关联给客户
		cliAccInfs.addAll(accInfs);
		clientInfWithIdCard.setAccInfs(cliAccInfs);
		
		
		// 保存客户信息
		return clientInfDao.save(clientInfWithIdCard);
	}

	/**
	 * 根据银行返回的信息创建账户
	 * 
	 * @param bankcardNum
	 * @param bankcardInfo
	 * @returni
	 */
	private AccInf createNewAccInf(String bankcardNum, Record bankcardInfo) {
		AccInf accInf = new AccInf();
		List<AccInf> accInfs = (List<AccInf>) bankcardInfo.get("accInfs");
		accInf = accInfs.get(0);
		return accInfDao.save(accInf);
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
	 * 调用银行接口，根据卡号和密码查询卡用户信息
	 * 
	 * @param bankcardNum
	 * @param password
	 * @return
	 */
	private Record getBankcardInfo(String bankcardNum, String password) {
		Record record = new Record();
		// Record record = null;
		// TODO 调用银行接口

		// 模拟数据
		ClientInf clientInf = new ClientInf();
		
		clientInf.setClientId("15");
		clientInf.setClientName("testAddClient");
		clientInf.setClientAddress("testClientAddress");
		clientInf.setDocumentNum("130643346547778909");
		clientInf.setDocumentType("01");
		clientInf.setMainAccount(bankcardNum);

		record.put("clientInf", clientInf);

		// record.put("bankcardNum", bankcardNum);
		// record.put("documentType", "02");
		// record.put("documentNum", "14598735460");

		List<AccInf> accInfs = new ArrayList<AccInf>();
		AccInf accInf = new AccInf();
		accInf.setBankcardNum(bankcardNum);
		accInf.setAccountState("00");
		accInf.setAccountType("01");
		accInf.setAffordCardInst("1234");
		accInf.setCurrType("01");
		accInfs.add(accInf);

		record.put("accInfs", accInfs);

		return record;
	}

	/**
	 * 判断卡号密码是否匹配
	 * 
	 * @param bankcardNum
	 * @param password
	 * @throws BusException
	 */
	private Record bankcardNumPasswordCheck(String bankcardNum, String password)
			throws BusException {
		// 调用银行接口
		return getBankcardInfo(bankcardNum, password);
	}

	/**
	 * 
	 * 根据卡号查询客户
	 * 
	 * @param bankcardNum
	 * @return
	 */
	private ClientInf getClientInfByBankcardNum(String bankcardNum) {
		String clientId = clientInfDao.getClientInfByBankcardNum(bankcardNum);

		return clientInfDao.getObjectByUniqueProperty("clientId", clientId);
		//
		// 根据卡号查找相关的账户信息
		// AccInf accInf = accInfManager.getAccInf(bankcardNum);
		// 取出对应的客户信息
		// Assert.notEmpty(clientInfs, "根据卡号为找到对应的客户信息");
		// 默认只存在一条相关的客户记录
	}

	@Override
	public ClientInf removeClientInfByClientId(String id) throws BusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObjectInfByBankcardNum(String bankcardNum)
			throws BusException {
		// TODO Auto-generated method stub
		return null;
	}

}
