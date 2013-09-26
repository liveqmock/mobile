package com.gsoft.mobile.core.service.impl;

import java.text.DecimalFormat;
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
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mobile.core.dao.CommInfDao;
import com.gsoft.mobile.core.entity.CommInf;
import com.gsoft.mobile.core.service.CommInfManager;

@Service("commInfManager")
@Transactional
public class CommInfManagerImpl extends BaseManagerImpl implements CommInfManager{
	@Autowired
	private CommInfDao<CommInf,String> commInfDao;
	
    /**
     * 查询列表
     */
	@EsbServiceMapping
    public List<CommInf> getCommInfs() throws BusException{
    	return commInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
	@EsbServiceMapping
    public List<CommInf> getCommInfs(@ConditionCollection(domainClazz=CommInf.class)Collection<Condition> conditions,@OrderCollection Collection<Order> orders) throws BusException{
    	return commInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
	@EsbServiceMapping
    public CommInf getCommInf(@ServiceParam(name="commodityNo") String id) throws BusException {
    	return commInfDao.get(id);
    }
	@EsbServiceMapping
	public PagerRecords getPagerCommInfs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=CommInf.class)	Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = commInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping
    public CommInf saveCommInf(CommInf o) throws BusException{
		//判断非空  所属商户
		
		if("".equals(o.getBelongMerchant())||null==o.getBelongMerchant()){
			throw new BusException("所属商户不能为空！");
			
		}
    	String commInfId = o.getCommodityNo();
    	boolean isUpdate = StringUtils.isNotEmpty(commInfId);
    	if(isUpdate){//修改
    	}else{//新增
    		//增加入库时间
    	}
    	o.setEnterTime(DateUtils.getToday("yyyyMMdd"));
    	DecimalFormat df=new DecimalFormat("0.00");
    	o.setCommPrices(df.format(Double.parseDouble(o.getCommPrices())));
    	return commInfDao.save(o);
    }

    /**
     * 删除对象
     */
	@EsbServiceMapping
    public Message removeCommInf( @ServiceParam(name="commodityNo") String id) throws BusException{
		if(StringUtils.isEmpty(id)){
			return new Message("999999","商品编号不存在！");
		}
		commInfDao.remove(id);
		return new Message("000000","删除成功");
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
	@EsbServiceMapping
    public void removeCommInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeCommInf(id);
    	}
    }
	@EsbServiceMapping
    public boolean exsitCommInf( @ServiceParam(name="commodityNo") String id) throws BusException{
		return commInfDao.exists(id);
	}
	@EsbServiceMapping
    public boolean exsitCommInf(String propertyName,Object value) throws BusException {
		return commInfDao.exists(propertyName,value);
	}

}
