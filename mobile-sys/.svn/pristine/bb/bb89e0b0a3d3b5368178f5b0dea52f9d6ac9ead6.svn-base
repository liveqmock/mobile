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

import com.gsoft.phone.core.entity.CommInf;
import com.gsoft.phone.core.dao.CommInfDao;
import com.gsoft.phone.core.service.CommInfManager;

@Service("commInfManager")
@Transactional
public class CommInfManagerImpl extends BaseManagerImpl implements CommInfManager{
	@Autowired
	private CommInfDao<CommInf,String> commInfDao;
	
    /**
     * 查询列表
     */
    public List<CommInf> getCommInfs() throws BusException{
    	return commInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<CommInf> getCommInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return commInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public CommInf getCommInf(String id) throws BusException {
    	return commInfDao.get(id);
    }
	
	public PagerRecords getPagerCommInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = commInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public CommInf saveCommInf(CommInf o) throws BusException{
//    	String commInfId = o.getCommInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(commInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return commInfDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeCommInf(String id) throws BusException{
    	commInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeCommInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeCommInf(id);
    	}
    }
    
    public boolean exsitCommInf(String id) throws BusException{
		return commInfDao.exists(id);
	}
    
    public boolean exsitCommInf(String propertyName,Object value) throws BusException {
		return commInfDao.exists(propertyName,value);
	}

}
