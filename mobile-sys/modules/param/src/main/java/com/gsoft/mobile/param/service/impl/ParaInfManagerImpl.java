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

import com.gsoft.mobile.param.dao.ParaInfDao;
import com.gsoft.mobile.param.entity.ParaInf;
import com.gsoft.mobile.param.service.ParaInfManager;

@Service("paraInfManager")
@Transactional
public class ParaInfManagerImpl extends BaseManagerImpl implements ParaInfManager{
	@Autowired
	private ParaInfDao<ParaInf,String> paraInfDao;
	
    /**
     * 查询列表
     */
    public List<ParaInf> getParaInfs() throws BusException{
    	return paraInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<ParaInf> getParaInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return paraInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public ParaInf getParaInf(String id) throws BusException {
    	return paraInfDao.get(id);
    }
	
	public PagerRecords getPagerParaInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = paraInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public ParaInf saveParaInf(ParaInf o) throws BusException{
//    	String paraInfId = o.getParaInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(paraInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return paraInfDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeParaInf(String id) throws BusException{
    	paraInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeParaInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeParaInf(id);
    	}
    }
    
    public boolean exsitParaInf(String id) throws BusException{
		return paraInfDao.exists(id);
	}
    
    public boolean exsitParaInf(String propertyName,Object value) throws BusException {
		return paraInfDao.exists(propertyName,value);
	}

}
