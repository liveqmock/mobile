/**
 * 代码声明
 */
package com.gsoft.mobile.core.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mobile.core.dao.MerInfDao;
import com.gsoft.mobile.core.entity.MerInf;
import com.gsoft.mobile.core.entity.ParamInf;
import com.gsoft.mobile.core.service.MerInfManager;

@Service("merInfManager")
@Transactional
public class MerInfManagerImpl extends BaseManagerImpl implements MerInfManager{
	@Autowired
	private MerInfDao<MerInf,String> merInfDao;
    /**
     * 查询列表
     */
	@EsbServiceMapping
    public List<MerInf> getMerInfs() throws BusException{
    	return merInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
	@EsbServiceMapping
    public List<MerInf> getMerInfs(@ConditionCollection(domainClazz=MerInf.class) Collection<Condition> conditions,
    		@OrderCollection Collection<Order> orders) throws BusException{
		//conditions.add(ConditionUtils.getCondition("belongInst",Condition.LIKE , "111")); 
    	return merInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
	@EsbServiceMapping
    public MerInf getMerInf(@ServiceParam(name="merchantNo") String id) throws BusException {
    	return merInfDao.get(id);
    }
	/**
	 * 查出查出该机构本级及下辖的所有商户
	 */
	@EsbServiceMapping
	public PagerRecords getPagerMerInfs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=MerInf.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		//查出改机构下辖的所有商户
		List<Condition> cd=(ArrayList<Condition>)conditions;
		if(cd.isEmpty()){
			//如果查询条件为空，不做任何操作
		}else{
			//如果有机构号，则查出该机构本级及下辖的所有商户
			//传入的参数值  机构号：cd.get(0).getValue(),根据机构号查出下级的机构号
			System.out.println("输入的机构号："+cd.get(0).getValue());
			//conditions.clear();//清空原来的条件
			conditions.add(ConditionUtils.getCondition("belongInst", Condition.IN, new Object[]{cd.get(0).getValue()}));
		}
		conditions.add(ConditionUtils.getCondition("merState", Condition.NOT_EQUALS, ParamInf.merState.get("cancel")));
		PagerRecords pagerRecords = merInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     * 手续费类型选月份固定收费时  每月金额必输
     * 手续费类型选按交易费率收费  手续费率必输
     * 00：按月份固定收费，01:按交易费率收费，02：暂不收费
     */
	@EsbServiceMapping
    public MerInf saveMerInf(MerInf o) throws BusException{
//		 String merInfId = o.getMerchantNo();
//		 boolean isUpdate = StringUtils.isNotEmpty(merInfId);
//		 if(isUpdate){//修改
//		
//		 }else{//新增
//		    o.setDailyProcBala(o.getd)
//		 }
		
    	return merInfDao.save(o);
    }
    /**
     * 删除对象
     */
	@EsbServiceMapping
    public void removeMerInf(@ServiceParam(name="merInfId") String id) throws BusException{
    	merInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
	@EsbServiceMapping
    public void removeMerInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeMerInf(id);
    	}
    }
	@EsbServiceMapping
    public boolean exsitMerInf( @ServiceParam(name="merInfId") String id) throws BusException{
		return merInfDao.exists(id);
	}
	@EsbServiceMapping
    public boolean exsitMerInf(String propertyName,Object value) throws BusException {
		return merInfDao.exists(propertyName,value);
	}
	/**
	 * 商户解约操作
	 * 00正常 01 暂停  02 解约
	 */
	@EsbServiceMapping
	public void signoutMer(@ServiceParam(name="merchantNo") String id) throws BusException {
		MerInf merInf = getMerInf(id);
		Assert.notNull(merInf, "不存在此商户");
			
		if(!ParamInf.merState.get("cancel").equals(merInf.getMerState().trim())){//如果商户当前状态不是解约状态
			merInf.setMerState(ParamInf.merState.get("cancel"));
               //获取当前的年 、月、 日
			Calendar calendar = Calendar.getInstance();
			Date date=calendar.getTime();
			DateFormat formatter= new SimpleDateFormat("yyyyMMdd");
			String logoutDate=formatter.format(date);
            //记录注消日期为今天
            merInf.setLogoutDate(logoutDate);
		}else{
			throw new BusException("该商户已经解约！");
		}
		saveMerInf(merInf);
		
	}
	/**
	 * 切换商户状态
	 * 00正常 01 暂停  
	 */
	@EsbServiceMapping
	public void updateMerInfState(@ServiceParam(name="merchantNo") String id) throws BusException{
		MerInf merInf = getMerInf(id);
		Assert.notNull(merInf, "输入信息有误！");
		
		if(ParamInf.merState.get("cancel").equals(merInf.getMerState().trim())){
			throw new BusException("该商户已解约，不能进行此操作！");
		}else{
			if(ParamInf.merState.get("normal").equals(merInf.getMerState().trim())){
				merInf.setMerState(ParamInf.merState.get("pause"));
			}else if(ParamInf.merState.get("pause").equals(merInf.getMerState().trim())){
				merInf.setMerState(ParamInf.merState.get("normal"));
			}
		}
		saveMerInf(merInf);
	}
	/**
	 * 条件查询  只获取正常签约的商户
	 * 00正常 01 暂停  02 解约
	 */
	@EsbServiceMapping
	public PagerRecords getSignedPagerMerInfs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=MerInf.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		conditions.add(ConditionUtils.getCondition("merState", Condition.NOT_EQUALS, ParamInf.merState.get("cancel")));
		PagerRecords pagerRecords = merInfDao.findByPager(pager, conditions,orders);
		return pagerRecords;
	}
	
	 /**
     * 根据卡号查询
     */
	@EsbServiceMapping
    public MerInf getMerInfByCardNum(@ServiceParam(name="cardNum") String cardNum) throws BusException {
		Collection<Condition>  conditions= new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("merCardnum",Condition.EQUALS , cardNum)); 
		Collection<Order>  orders= new ArrayList<Order>();
		List<MerInf> merInfs= getMerInfs(conditions, orders);
		return merInfs.size() == 0? null:merInfs.get(0);
		
    }
	/**
	 * 商户签约
	 */
	@Override
	@EsbServiceMapping
	public Message signMer(MerInf o) throws BusException {
		if(isNull(o)){
			return new Message("999999","请输入必输项");
		}
		 String merInfId = o.getMerchantNo();
		 boolean isUpdate = StringUtils.isNotEmpty(merInfId);
		 if(isUpdate){//修改
		
		 }else{//新增
		    o.setDailyProcBala(o.getDailyProcLimit());
		 }
        String clrType = o.getServiceChargeType();
        if("00".equals(clrType) ){//如果手续费类型是  按月份固定收费
            if("".equals(o.getMonthAmount())||null == o.getMonthAmount()){
                  return new Message("999999", "手续费类型是:按月份固定收费,必须输入每月金额");
            }
         }else if("01".equals(clrType)){ //如果手续费类型是  按交易费率收费
           if("".equals(o.getServiceChargeRate())||null == o.getServiceChargeRate()){
        	   return new Message("999999", "手续费类型是:按交易费率收费,必须输入交易费率");
            }
       }
        if(str2double(o.getDailyProcLimit())>str2double(o.getDailyPayLimit())
           ||str2double(o.getSingleProcLim())>str2double(o.getSinglePayLimit())
           ||str2double(o.getDailyProcLimit())<str2double(o.getSingleProcLim())
           ||str2double(o.getDailyPayLimit())<str2double(o.getSinglePayLimit())){
        	return new Message("999999", "输入限额信息不正确");
        }
    	MerInf merInf=merInfDao.save(o);
    	if(merInf!=null){
    		return new Message("000000", "操作成功");
    	}
    	return new Message("999999", "签约失败");
    	
	}
	private double str2double(String str){
		double amount ;
		try {
		 amount = Double.parseDouble(str.trim());
			if(amount<0){
				throw new BusException("金额不正确");
			}
		} catch (Exception e) {
			throw new BusException("交易金额数字不正确");
		}
		return amount;
	}
	//签约必输限额判断
	private boolean isNull(MerInf o){
		return StringUtils.isEmpty(o.getDailyProcLimit())||StringUtils.isEmpty(o.getSingleProcLim())
		||StringUtils.isEmpty(o.getDailyPayLimit())||StringUtils.isEmpty(o.getSinglePayLimit());
	}

}
