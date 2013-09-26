/**
 * 代码声明
 */
package com.gsoft.mobile.param.service.impl;

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

import com.gsoft.mobile.param.dao.ParaValInfDao;
import com.gsoft.mobile.param.entity.ParaValInf;
import com.gsoft.mobile.param.service.ParaValInfManager;

@Service("paraValInfManager")
@Transactional
public class ParaValInfManagerImpl extends BaseManagerImpl implements ParaValInfManager{
	@Autowired
	private ParaValInfDao<ParaValInf,String> paraValInfDao;
	
    /**
     * 查询列表
     */
    public List<ParaValInf> getParaValInfs() throws BusException{
    	return paraValInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<ParaValInf> getParaValInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return paraValInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public ParaValInf getParaValInf(String id) throws BusException {
    	return paraValInfDao.get(id);
    }
	
	public PagerRecords getPagerParaValInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = paraValInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public ParaValInf saveParaValInf(ParaValInf o) throws BusException{
//    	String paraValInfId = o.getParaValInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(paraValInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return paraValInfDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeParaValInf(String id) throws BusException{
    	paraValInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeParaValInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeParaValInf(id);
    	}
    }
    
    public boolean exsitParaValInf(String id) throws BusException{
		return paraValInfDao.exists(id);
	}
    
    public boolean exsitParaValInf(String propertyName,Object value) throws BusException {
		return paraValInfDao.exists(propertyName,value);
	}

}
