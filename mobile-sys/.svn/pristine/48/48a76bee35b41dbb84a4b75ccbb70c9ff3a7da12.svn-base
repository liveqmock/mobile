/**
 * 代码声明
 */
package com.gsoft.mobile.manager.service.impl;

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
import com.gsoft.mobile.manager.dao.DayTemInfDao;
import com.gsoft.mobile.manager.entity.DayTemInf;
import com.gsoft.mobile.manager.entity.QrCodePayInf;
import com.gsoft.mobile.manager.service.DayTemInfManager;
import com.gsoft.mobile.manager.service.QrCodePayManager;




@Service("dayTemInfManager")
@Transactional
public class DayTemInfManagerImpl extends BaseManagerImpl implements DayTemInfManager{
	
	@Autowired
	private DayTemInfDao<DayTemInf, String> dayTemInfDao;

	@Autowired
	private QrCodePayManager qrCodePay;
	
    /**
     * 查询列表
     */
    public List<DayTemInf> getDayTemInfs() throws BusException{
    	
    	return dayTemInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<DayTemInf> getDayTemInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return dayTemInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public DayTemInf getDayTemInf(@ServiceParam(name = "tranNo") String tranNo) throws BusException {
    	
    	return (DayTemInf) dayTemInfDao.getObjectByUniqueProperty("tranNo", tranNo);
    }
    
	@EsbServiceMapping
	public PagerRecords getPagerDayTemInfs(
			Pager pager,
			@ConditionCollection(domainClazz = DayTemInf.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = this.dayTemInfDao.findByPager(pager,
				conditions, orders);
		return pagerRecords;
	}


    /**
     * 删除对象
     */

    public void removeDayTemInf(String id) throws BusException{
    	dayTemInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDayTemInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeDayTemInf(id);
    	}
    }
    
    public boolean exsitDayTemInf(String id) throws BusException{
		return dayTemInfDao.exists(id);
	}
    
    public boolean exsitDayTemInf(String propertyName,Object value) throws BusException {
		return dayTemInfDao.exists(propertyName,value);
	}


	
	
	
		
		
}
