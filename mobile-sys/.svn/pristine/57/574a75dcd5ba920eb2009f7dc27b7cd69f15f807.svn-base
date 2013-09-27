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

import com.gsoft.phone.core.entity.MerInfo;
import com.gsoft.phone.core.dao.MerInfoDao;
import com.gsoft.phone.core.service.MerInfoManager;

@Service("merInfoManager")
@Transactional
public class MerInfoManagerImpl extends BaseManagerImpl implements MerInfoManager{
	@Autowired
	private MerInfoDao<MerInfo,String> merInfoDao;
	
    /**
     * 查询列表
     */
    public List<MerInfo> getMerInfos() throws BusException{
    	return merInfoDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<MerInfo> getMerInfos(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return merInfoDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public MerInfo getMerInfo(String id) throws BusException {
    	return merInfoDao.get(id);
    }
	
	public PagerRecords getPagerMerInfos(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = merInfoDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public MerInfo saveMerInfo(MerInfo o) throws BusException{
//    	String merInfoId = o.getMerInfoId();
//    	boolean isUpdate = StringUtils.isNotEmpty(merInfoId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return merInfoDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeMerInfo(String id) throws BusException{
    	merInfoDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMerInfos(String[] ids) throws BusException{
   		for(String id:ids){
    		removeMerInfo(id);
    	}
    }
    
    public boolean exsitMerInfo(String id) throws BusException{
		return merInfoDao.exists(id);
	}
    
    public boolean exsitMerInfo(String propertyName,Object value) throws BusException {
		return merInfoDao.exists(propertyName,value);
	}

}
