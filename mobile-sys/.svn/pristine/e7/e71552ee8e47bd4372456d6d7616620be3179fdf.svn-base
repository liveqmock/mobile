/**
 * 代码声明
 */
package com.gsoft.mobile.core.service.impl;

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

import com.gsoft.mobile.core.entity.LogQuiReg;
import com.gsoft.mobile.core.dao.LogQuiRegDao;
import com.gsoft.mobile.core.service.LogQuiRegManager;

@Service("logQuiRegManager")
@Transactional
public class LogQuiRegManagerImpl extends BaseManagerImpl implements LogQuiRegManager{
	@Autowired
	private LogQuiRegDao<LogQuiReg,String> logQuiRegDao;
	
    /**
     * 查询列表
     */
    public List<LogQuiReg> getLogQuiRegs() throws BusException{
    	return logQuiRegDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<LogQuiReg> getLogQuiRegs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return logQuiRegDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public LogQuiReg getLogQuiReg(String id) throws BusException {
    	return logQuiRegDao.get(id);
    }
	
	public PagerRecords getPagerLogQuiRegs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = logQuiRegDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public LogQuiReg saveLogQuiReg(LogQuiReg o) throws BusException{
//    	String logQuiRegId = o.getLogQuiRegId();
//    	boolean isUpdate = StringUtils.isNotEmpty(logQuiRegId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return logQuiRegDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeLogQuiReg(String id) throws BusException{
    	logQuiRegDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeLogQuiRegs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeLogQuiReg(id);
    	}
    }
    
    public boolean exsitLogQuiReg(String id) throws BusException{
		return logQuiRegDao.exists(id);
	}
    
    public boolean exsitLogQuiReg(String propertyName,Object value) throws BusException {
		return logQuiRegDao.exists(propertyName,value);
	}

}
