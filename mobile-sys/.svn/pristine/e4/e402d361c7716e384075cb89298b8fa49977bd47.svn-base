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

import com.gsoft.phone.core.entity.SignTerReg;
import com.gsoft.phone.core.dao.SignTerRegDao;
import com.gsoft.phone.core.service.SignTerRegManager;

@Service("signTerRegManager")
@Transactional
public class SignTerRegManagerImpl extends BaseManagerImpl implements SignTerRegManager{
	@Autowired
	private SignTerRegDao<SignTerReg,String> signTerRegDao;
	
    /**
     * 查询列表
     */
    public List<SignTerReg> getSignTerRegs() throws BusException{
    	return signTerRegDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<SignTerReg> getSignTerRegs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return signTerRegDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public SignTerReg getSignTerReg(String id) throws BusException {
    	return signTerRegDao.get(id);
    }
	
	public PagerRecords getPagerSignTerRegs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = signTerRegDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public SignTerReg saveSignTerReg(SignTerReg o) throws BusException{
//    	String signTerRegId = o.getSignTerRegId();
//    	boolean isUpdate = StringUtils.isNotEmpty(signTerRegId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return signTerRegDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeSignTerReg(String id) throws BusException{
    	signTerRegDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSignTerRegs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeSignTerReg(id);
    	}
    }
    
    public boolean exsitSignTerReg(String id) throws BusException{
		return signTerRegDao.exists(id);
	}
    
    public boolean exsitSignTerReg(String propertyName,Object value) throws BusException {
		return signTerRegDao.exists(propertyName,value);
	}

}
