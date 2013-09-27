/**
 * 代码声明
 */
package com.gsoft.mobile.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.mobile.core.dao.AccInfDao;
import com.gsoft.mobile.core.dao.ClientInfDao;
import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.entity.ParamInf;
import com.gsoft.mobile.manager.dao.BlInfDao;
import com.gsoft.mobile.manager.entity.BlInf;
import com.gsoft.mobile.manager.service.BlInfManager;

@Service("blInfManager")
@Transactional
public class BlInfManagerImpl extends BaseManagerImpl implements BlInfManager {
	@Autowired
	private BlInfDao<BlInf, String> blInfDao;

	@Autowired
	private AccInfDao<AccInf, String> accInfDao;

	@Autowired
	private ClientInfDao<ClientInf, String> clientInfDao;

	/**
	 * 查询列表
	 */
	@EsbServiceMapping
	public List<BlInf> getBlInfs() throws BusException {
		return blInfDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<BlInf> getBlInfs(
			@ConditionCollection(domainClazz = BlInf.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return blInfDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public BlInf getBlInf(@ServiceParam(name = "bankcardNum") String id)
			throws BusException {
		return blInfDao.getObjectByUniqueProperty("bankcardNum", id);
		// try {
		// return blInfDao.get(id);
		// } catch (Exception e) {
		// return new BlInf();
		// }
	}

	@EsbServiceMapping
	public PagerRecords getPagerBlInfs(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = BlInf.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {

		String bankcardNum = null;
		PagerRecords pagerRecords = null;
		for (Condition condition : conditions) {
			if (condition == null)
				continue;
			bankcardNum = condition.getValue().toString();
		}
		if (bankcardNum == null) {
			pagerRecords = blInfDao.findByPager(pager, conditions, orders);
		} else {
			BlInf blInf = this.getBlInfByBankcardNum(bankcardNum);
			if (blInf != null) {
				List<BlInf> blInfs = new ArrayList<BlInf>();
				blInfs.add(blInf);
				pagerRecords = new PagerRecords(blInfs, 1);
			}
		}
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public BlInf saveBlInf(BlInf o) throws BusException {
		// String blInfId = o.getBlInfId();
		// boolean isUpdate = StringUtils.isNotEmpty(blInfId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		return blInfDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeBlInf(@ServiceParam(name = "bankcardNum") String id)
			throws BusException {
		blInfDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	@EsbServiceMapping
	public void removeBlInfs(String[] ids) throws BusException {
		for (String id : ids) {
			removeBlInf(id);
		}
	}

	public boolean exsitBlInf(String id) throws BusException {
		return blInfDao.exists(id);
	}

	public boolean exsitBlInf(String propertyName, Object value)
			throws BusException {
		return blInfDao.exists(propertyName, value);
	}

	/**
	 * 
	 */
	@EsbServiceMapping
	public BlInf getBlInfByBankcardNum(
			@ServiceParam(name = "bankcardNum") String bankcardNum) {
		BlInf blInf = null;
		if (checkBankcardNum(bankcardNum)) {
			blInf = blInfDao.getObjectByUniqueProperty("bankcardNum",
					bankcardNum);
			// 黑名单表中未获取到对应的信息
			if (blInf == null) {
				blInf = getBlInfFromAccAndClient(bankcardNum);
			}
		}

		return blInf;
	}

	/**
	 * 
	 * @param bankcardNum
	 * @return
	 */
	private BlInf getBlInfFromAccAndClient(String bankcardNum) {
		BlInf blInf = new BlInf();

		// 账户表中查找相关的账户信息
		// 只有卡状态为活动的 账户可以添加黑名单
		List<AccInf> accInfs = accInfDao.getList(new String[] {
				"bankcardNum", "accountState" }, new Object[] { bankcardNum,
				ParamInf.accountState.get("normal")});
		//Assert.notEmpty(accInfs, "未找到对应的账户信息");
		if(accInfs.size()==0){
			return null;
		}
		
		// 查找相关的客户信息
		String clientId = clientInfDao.getClientInfByBankcardNum(bankcardNum);
		if (clientId != null) {
			ClientInf clientInf = clientInfDao.getObjectByUniqueProperty(
					"clientId", clientId);
			Assert.notNull(clientInf, "未找到对应的客户信息");

			blInf.setBankcardNum(bankcardNum);

			// 将账户表和客户表中取到的卡的相关信息添加进去
			blInf.setDocumentNum(clientInf.getDocumentNum());
			blInf.setDocumentType(clientInf.getDocumentType());
			blInf.setCardholder(clientInf.getClientName());

			blInf.setCardType(accInfs.get(0).getAccountType());
			blInf.setCardState(accInfs.get(0).getAccountState());
			blInf.setBalcklistState(ParamInf.blackListState.get("notIn"));

		}
		return blInf;
	}

	/**
	 * 修改用户黑名单状态 检验表中是否有卡号对应信息-->判断黑名单状态为是或否——>修改对应状态
	 */
	@EsbServiceMapping
	public void changeBlackListState(BlInf blInf) {
		if (blInf != null && checkBankcardNum(blInf.getBankcardNum())) {
			if (blInf.getAddQuitReason() == null
					|| blInf.getAddQuitType() == null) {
				throw new BusException("添加/撤出类型及原因不能为空");
			}

			BlInf newBlInf = this.getBlInf(blInf.getBankcardNum());
			if (null != newBlInf) {// 黑名单信息表中可以找到对应的信息
				checkBankcardNum(blInf.getBankcardNum(),
						blInf.getDocumentType(), blInf.getDocumentNum());
				String state = newBlInf.getBalcklistState();
				if ("00".equals(state)) {// 此账号信息已添加黑名单
					blInf.setBalcklistState("01");// 修改状态移除黑名单，同时修改账户状态
					changeAccoutState("cancel",blInf.getBankcardNum());
				} else if ("01".equals(state)) {// 用户不在黑名单
					blInf.setBalcklistState("00");// 添加状态移除黑名单，同时修改账户状态
					changeAccoutState("normal",blInf.getBankcardNum());
				}
				blInf.setEffectDate(getEffectDate());

			} else {// 黑名单信息表中没有对应的信息，则添加
				blInf.setBalcklistState("00");
				blInf.setEffectDate(getEffectDate());
				//同时修改账户状态为注销
				changeAccoutState("cancel",blInf.getBankcardNum());

			}
			// 将整合后的信息添加到黑名单表中
			this.saveBlInf(blInf);

		}
	}

	private void changeAccoutState(String state, String bankcardNum) {
		AccInf accInf = accInfDao.getObjectByUniqueProperty("bankcardNum",
				bankcardNum);
		if (accInf != null) {
			accInf.setAccountState(ParamInf.accountState.get(state));
			accInfDao.save(accInf);
		}

	}

	/**
	 * 获取当前日期的下一天
	 * 
	 * @return
	 */
	private String getEffectDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date date = calendar.getTime();
		return sdf.format(date);
	}

	/**
	 * 检验银行卡格式是否正确
	 * 
	 * @param bankcardNum
	 * @return
	 */
	private boolean checkBankcardNum(String bankcardNum) {
		// TODO Auto-generated method stub
		if (bankcardNum != null ) {
			String reg = "^\\d{19}$";
			if(bankcardNum.matches(reg)){
				return true;
			}
		}
		return false;
		
	}

	/**
	 * 检验输入的黑名单信息与账户表中是否对应
	 * 
	 * @param bankcardNum
	 * @param documentType
	 * @param documentNum
	 */
	private void checkBankcardNum(String bankcardNum, String documentType,
			String documentNum) {
		// TODO Auto-generated method stub
		// AccInf accInf = accInfDao.get(bankcardNum);

	}

}
