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

import com.gsoft.phone.core.entity.AccInf;
import com.gsoft.phone.core.dao.AccInfDao;
import com.gsoft.phone.core.service.AccInfManager;

@Service("accInfManager")
@Transactional
public class AccInfManagerImpl extends BaseManagerImpl implements AccInfManager{
	@Autowired
	private AccInfDao<AccInf,String> accInfDao;
	
    /**
     * 查询列表
     */
    public List<AccInf> getAccInfs() throws BusException{
    	return accInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<AccInf> getAccInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return accInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public AccInf getAccInf(String id) throws BusException {
    	return accInfDao.get(id);
    }
	
	public PagerRecords getPagerAccInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = accInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public AccInf saveAccInf(AccInf o) throws BusException{
//    	String accInfId = o.getAccInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(accInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return accInfDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeAccInf(String id) throws BusException{
    	accInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeAccInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeAccInf(id);
    	}
    }
    
    public boolean exsitAccInf(String id) throws BusException{
		return accInfDao.exists(id);
	}
    
    public boolean exsitAccInf(String propertyName,Object value) throws BusException {
		return accInfDao.exists(propertyName,value);
	}

}
