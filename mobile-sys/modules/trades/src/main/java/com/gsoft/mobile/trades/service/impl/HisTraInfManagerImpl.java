/**
 * 代码声明
 */
package com.gsoft.mobile.trades.service.impl;

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

import com.gsoft.mobile.trades.dao.HisTraInfDao;
import com.gsoft.mobile.trades.entity.HisTraInf;
import com.gsoft.mobile.trades.service.HisTraInfManager;

@Service("hisTraInfManager")
@Transactional
public class HisTraInfManagerImpl extends BaseManagerImpl implements HisTraInfManager{
	@Autowired
	private HisTraInfDao<HisTraInf,String> hisTraInfDao;
	
    /**
     * 查询列表
     */
    public List<HisTraInf> getHisTraInfs() throws BusException{
    	return hisTraInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<HisTraInf> getHisTraInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return hisTraInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public HisTraInf getHisTraInf(String id) throws BusException {
    	return hisTraInfDao.get(id);
    }
	
	public PagerRecords getPagerHisTraInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = hisTraInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public HisTraInf saveHisTraInf(HisTraInf o) throws BusException{
//    	String hisTraInfId = o.getHisTraInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(hisTraInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return hisTraInfDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeHisTraInf(String id) throws BusException{
    	hisTraInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeHisTraInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeHisTraInf(id);
    	}
    }
    
    public boolean exsitHisTraInf(String id) throws BusException{
		return hisTraInfDao.exists(id);
	}
    
    public boolean exsitHisTraInf(String propertyName,Object value) throws BusException {
		return hisTraInfDao.exists(propertyName,value);
	}

}
