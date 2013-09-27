/**
 * 代码声明
 */
package com.gsoft.phone.core.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.gsoft.phone.core.entity.SignInfo;
import com.gsoft.phone.core.dao.SignInfoDao;
import com.gsoft.phone.core.service.SignInfoManager;

@Service("signInfoManager")
@Transactional
public class SignInfoManagerImpl extends BaseManagerImpl implements SignInfoManager{
	@Autowired
	private SignInfoDao<SignInfo,String> signInfoDao;
	
    /**
     * 查询列表
     */
    public List<SignInfo> getSignInfos() throws BusException{
    	return signInfoDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<SignInfo> getSignInfos(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return signInfoDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public SignInfo getSignInfo(String id) throws BusException {
    	return signInfoDao.get(id);
    }
	
	public PagerRecords getPagerSignInfos(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = signInfoDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public SignInfo saveSignInfo(SignInfo o) throws BusException{
//    	String signInfoId = o.getSignInfoId();
//    	boolean isUpdate = StringUtils.isNotEmpty(signInfoId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return signInfoDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeSignInfo(String id) throws BusException{
    	signInfoDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSignInfos(String[] ids) throws BusException{
   		for(String id:ids){
    		removeSignInfo(id);
    	}
    }
    
    public boolean exsitSignInfo(String id) throws BusException{
		return signInfoDao.exists(id);
	}
    
    public boolean exsitSignInfo(String propertyName,Object value) throws BusException {
		return signInfoDao.exists(propertyName,value);
	}

}
