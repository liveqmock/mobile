/**
 * 代码声明
 */
package com.gsoft.phone.core.service.impl;

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
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.phone.core.dao.ClientInfoDao;
import com.gsoft.phone.core.entity.ClientInfo;
import com.gsoft.phone.core.service.ClientInfoManager;

@Service("clientInfoManager")
@Transactional
public class ClientInfoManagerImpl extends BaseManagerImpl implements ClientInfoManager{
	@Autowired
	private ClientInfoDao<ClientInfo,String> clientInfoDao;
	
    /**
     * 查询列表
     */
	
	@EsbServiceMapping
    public List<ClientInfo> getClientInfos() throws BusException{
    	System.out.println("***********getClientInfos***********");
    	return clientInfoDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ClientInfo> getClientInfos(
    		@ConditionCollection(domainClazz=ClientInfo.class) Collection<Condition> conditions,
    		@OrderCollection Collection<Order> orders) throws BusException{
    	return clientInfoDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ClientInfo getClientInfo(@ServiceParam(name="clientId") String id) throws BusException {
    	return clientInfoDao.get(id);
    }
	
    @EsbServiceMapping
	public PagerRecords getPagerClientInfos(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ClientInfo.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = clientInfoDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ClientInfo saveClientInfo(ClientInfo o) throws BusException{
//    	String clientInfoId = o.getClientInfoId();
//    	boolean isUpdate = StringUtils.isNotEmpty(clientInfoId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return clientInfoDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeClientInfo(@ServiceParam(name="clientId") String id) throws BusException{
    	clientInfoDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeClientInfos(String[] ids) throws BusException{
   		for(String id:ids){
    		removeClientInfo(id);
    	}
    }
    
    public boolean exsitClientInfo(String id) throws BusException{
		return clientInfoDao.exists(id);
	}
    
    public boolean exsitClientInfo(String propertyName,Object value) throws BusException {
		return clientInfoDao.exists(propertyName,value);
	}

}
