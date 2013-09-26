/**
 * 代码声明
 */
package com.gsoft.mobile.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mobile.core.dao.AccInfDao;
import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.service.AccInfManager;

@Service("accInfManager")
@Transactional
public class AccInfManagerImpl extends BaseManagerImpl implements AccInfManager {
	@Autowired
	private AccInfDao<AccInf, String> accInfDao;

	/**
	 * 查询列表
	 */
	@EsbServiceMapping
	public List<AccInf> getAccInfs() throws BusException {
		return accInfDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<AccInf> getAccInfs(
			@ConditionCollection(domainClazz = AccInf.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return accInfDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public AccInf getAccInf(@ServiceParam(name = "bankcardNum") String id)
			throws BusException {
		AccInf accInf =  accInfDao.getObjectByUniqueProperty("bankcardNum", id);
		
		return accInf;
	}

	@EsbServiceMapping
	public PagerRecords getPagerAccInfs(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = AccInf.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = accInfDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public AccInf saveAccInf(AccInf o) throws BusException {
		// String accInfId = o.getAccInfId();
		// boolean isUpdate = StringUtils.isNotEmpty(accInfId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		return accInfDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeAccInf(@ServiceParam(name = "bankcardNum") String id)
			throws BusException {
		accInfDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	@EsbServiceMapping
	public void removeAccInfs(String[] ids) throws BusException {
		for (String id : ids) {
			removeAccInf(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitAccInf(String id) throws BusException {
		return accInfDao.exists(id);
	}

	@EsbServiceMapping
	public boolean exsitAccInf(String propertyName, Object value)
			throws BusException {
		return accInfDao.exists(propertyName, value);
	}
	
	 /**
	 * 查询密码修改
	 */
	@EsbServiceMapping
	public Message saveAccInfQueryPwd(AccInf accInf) throws BusException {
		AccInf info = (AccInf) this.accInfDao.getObjectByUniqueProperty(
				"bankcardNum", accInf.getBankcardNum());
		String [] queryPwd = accInf.getQueryPwd().split("[|]");//0为老密码1为新密码
		
		
		// 根据取款密码来判断是否是重置
		if(StringUtils.isNotEmpty(accInf.getWithdrawPwd())){
			
			if(!accInf.getWithdrawPwd().equals(info.getWithdrawPwd())){
				return new Message("", "2");//取款密码不正确
			}else{
			
			info.setQueryPwd(queryPwd[0]);
			accInfDao.save(info);
			return new Message("", "3");//重置成功
			}
			
		}else {
			System.out.println(queryPwd[0]);
			if(queryPwd[0].equals(info.getQueryPwd())){
				//查询密码验证正确，保存新密码
				
				info.setQueryPwd(queryPwd[1]);
				accInfDao.save(info);
				return new Message("", "1");//修改成功
			
			}else {
				
				return new Message("" , "0");//查询密码不正确
			}
		}
		
		
		
	}
	
	/**
	 * 取款密码修改
	 * */
	@EsbServiceMapping
	public Message saveAccInfWithdrawPwd(AccInf accInf) throws BusException {
		AccInf info = (AccInf) this.accInfDao.getObjectByUniqueProperty(
				"bankcardNum", accInf.getBankcardNum());
		String [] withdrawPwd = accInf.getWithdrawPwd().split("[|]");//0为老密码1为新密码

			
			if(withdrawPwd[0].equals(info.getWithdrawPwd())){
				//取款密码验证正确，保存新密码
				info.setWithdrawPwd(withdrawPwd[1]);
				accInfDao.save(info);
				return new Message("", "1");//修改成功
			
			}else {
				//取款密码验证正确，保存新密码
				
				return new Message("", "0");//取款密码不正确
			
		}
		
		
		
	}
	
	

}
