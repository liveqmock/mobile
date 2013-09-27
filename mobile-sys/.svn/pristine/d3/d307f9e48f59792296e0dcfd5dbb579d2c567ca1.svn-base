/**
 * 代码声明
 */
package com.gsoft.mobile.manager.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.Record;
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
import com.gsoft.framework.util.Assert;
import com.gsoft.mobile.core.entity.ParamInf;
import com.gsoft.mobile.manager.dao.TerInfDao;
import com.gsoft.mobile.manager.entity.TerInf;
import com.gsoft.mobile.manager.service.TerInfManager;

@Service("terInfManager")
@Transactional
public class TerInfManagerImpl extends BaseManagerImpl implements TerInfManager{
	@Autowired
	private TerInfDao<TerInf,String> terInfDao;
	
    /**
     * 查询列表
     */
	@EsbServiceMapping
    public List<TerInf> getTerInfs() throws BusException{
    	return terInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
	@EsbServiceMapping
    public List<TerInf> getTerInfs(@ConditionCollection(domainClazz=TerInf.class) Collection<Condition> conditions,@OrderCollection Collection<Order> orders) throws BusException{
    	return terInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
	@EsbServiceMapping
    public TerInf getTerInf(@ServiceParam(name="terInfId") String id) throws BusException {
    	return terInfDao.get(id);
    }
	@EsbServiceMapping
	public PagerRecords getPagerTerInfs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=TerInf.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = terInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping
    public TerInf saveTerInf(TerInf o) throws BusException{
//    	String terInfId = o.getTerInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(terInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return terInfDao.save(o);
    }

    /**
     * 删除对象
     */
	@EsbServiceMapping
    public void removeTerInf(String id) throws BusException{
    	terInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
	@EsbServiceMapping
    public void removeTerInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeTerInf(id);
    	}
    }
	@EsbServiceMapping
    public boolean exsitTerInf(String id) throws BusException{
		return terInfDao.exists(id);
	}
	@EsbServiceMapping
    public boolean exsitTerInf(String propertyName,Object value) throws BusException {
		return terInfDao.exists(propertyName,value);
	}
    
    /**
     * 切换终端状态  暂停/恢复
     * 00 正常  01 暂停 02 注销
     */
	@EsbServiceMapping
	public TerInf updateTerInfState(@ServiceParam(name = "terminalNo") String id)
			throws BusException {
		TerInf terInf = getTerInf(id);
		
		if (ParamInf.terminalState.get("cancel").equals(terInf.getTerminalState().trim())) {
			throw new BusException("该终端已注销，不可修改！");
		}
		if (ParamInf.terminalState.get("normal").equals(terInf.getTerminalState().trim())) {
			// 当前状态为正常,则修改为暂停
			terInf.setTerminalState(ParamInf.terminalState.get("pause"));
		} else if (ParamInf.terminalState.get("pause").equals(terInf.getTerminalState().trim())) {
			terInf.setTerminalState(ParamInf.terminalState.get("normal"));
		}

		return saveTerInf(terInf);

	}

	/**
     * 注销
     * 00 正常  01 暂停 02 注销
     */
	@EsbServiceMapping
    public Message cancelTerInf(@ServiceParam(name="terminalNo") String id)throws BusException{
		TerInf terInf= getTerInf(id);
		if(ParamInf.terminalState.get("cancel").equals(terInf.getTerminalState().trim())){
			return new Message("999999", "该终端已注销，不可再次注销");
		}else{
			terInf.setTerminalState(ParamInf.terminalState.get("cancel"));
		}
		saveTerInf(terInf);
		return new Message("000000", "注销成功");
		
    }
	/**
	 * 根据机构号查找下级机构号
	 */
	@EsbServiceMapping
	public List<Record> getInstNoByParentNo(String pinstNo){
		return null;
	}
	
	

}
