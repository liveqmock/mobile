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

import com.gsoft.phone.core.entity.CliAccRel;
import com.gsoft.phone.core.dao.CliAccRelDao;
import com.gsoft.phone.core.service.CliAccRelManager;

@Service("cliAccRelManager")
@Transactional
public class CliAccRelManagerImpl extends BaseManagerImpl implements CliAccRelManager{
	@Autowired
	private CliAccRelDao<CliAccRel,String> cliAccRelDao;
	
    /**
     * 查询列表
     */
    public List<CliAccRel> getCliAccRels() throws BusException{
    	return cliAccRelDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<CliAccRel> getCliAccRels(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return cliAccRelDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public CliAccRel getCliAccRel(String id) throws BusException {
    	return cliAccRelDao.get(id);
    }
	
	public PagerRecords getPagerCliAccRels(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = cliAccRelDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public CliAccRel saveCliAccRel(CliAccRel o) throws BusException{
//    	String cliAccRelId = o.getCliAccRelId();
//    	boolean isUpdate = StringUtils.isNotEmpty(cliAccRelId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return cliAccRelDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeCliAccRel(String id) throws BusException{
    	cliAccRelDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeCliAccRels(String[] ids) throws BusException{
   		for(String id:ids){
    		removeCliAccRel(id);
    	}
    }
    
    public boolean exsitCliAccRel(String id) throws BusException{
		return cliAccRelDao.exists(id);
	}
    
    public boolean exsitCliAccRel(String propertyName,Object value) throws BusException {
		return cliAccRelDao.exists(propertyName,value);
	}

}
