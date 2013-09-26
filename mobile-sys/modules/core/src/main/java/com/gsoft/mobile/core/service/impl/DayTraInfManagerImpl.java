/**
 * 代码声明
 */
package com.gsoft.mobile.core.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.mobile.core.dao.DayTraInfDao;
import com.gsoft.mobile.core.dao.HisTraInfDao;
import com.gsoft.mobile.core.entity.DayTraInf;
import com.gsoft.mobile.core.entity.HisTraInf;
import com.gsoft.mobile.core.service.DayTraInfManager;

@Service("dayTraInfManager")
@Transactional
public class DayTraInfManagerImpl extends BaseManagerImpl implements
		DayTraInfManager {
	@Autowired
	private DayTraInfDao<DayTraInf, String> dayTraInfDao;

	@Autowired
	private HisTraInfDao<HisTraInf, String> hisTraInfDao;

	/**
	 * 查询列表
	 */
	@EsbServiceMapping
	public List<DayTraInf> getDayTraInfs() {
		return dayTraInfDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<DayTraInf> getDayTraInfs(
			@ConditionCollection(domainClazz = DayTraInf.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) {
		return dayTraInfDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public DayTraInf getDayTraInf(@ServiceParam(name = "tradeSeqno") String id) {
		return dayTraInfDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerDayTraInfs(Pager pager,// 分页条件
			@ConditionCollection(domainClazz = DayTraInf.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) {
		PagerRecords pagerRecords = dayTraInfDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public DayTraInf saveDayTraInf(DayTraInf o) {
		// String DayTraInfId = o.getDayTraInfId();
		// boolean isUpdate = StringUtils.isNotEmpty(DayTraInfId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		return dayTraInfDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeDayTraInf(@ServiceParam(name = "tradeSeqno") String id) {
		dayTraInfDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	@EsbServiceMapping
	public void removeDayTraInfs(String[] ids) {
		for (String id : ids) {
			removeDayTraInf(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitDayTraInf(String id) {
		return dayTraInfDao.exists(id);
	}

	@EsbServiceMapping
	public boolean exsitDayTraInf(String propertyName, Object value) {
		return dayTraInfDao.exists(propertyName, value);
	}

	/**
	 * 正则匹配校验
	 * @param param
	 * @param regex
	 * @return
	 */
	public  boolean checkRegex(String param, String regex) {
	   if(param!=null)	{
		   if(param.matches(regex)){
			   return true;
		   }
	   }
	   return false;
	   
	}
	/**
	 * 获取历史表记录
	 * @param cardType
	 * @param bankcardNum
	 * @param startDate
	 * @param endDate
	 * @param pager
	 * @return
	 */
	

	@EsbServiceMapping
	//必要时转换
	public PagerRecords convertRecords(PagerRecords pagerRecords,PagerRecords records){
		for(Object o : records.getRecords()){
//			HisTraInf hti = (HisTraInf)o;
			DayTraInf hti = (DayTraInf)o;
			pagerRecords.getRecords().add(hti);
		}
		return pagerRecords;
		
	}

	@EsbServiceMapping
	@Override
	public PagerRecords getPagerTraInfs(
			@ServiceParam(name = "pageIndex") String pageIndex, 
			@ServiceParam(name = "pageSize") String pageSize,
			@ServiceParam(name = "type") String type, 
			@ServiceParam(name = "bankcardNum") String bankcardNum, 
			@ServiceParam(name = "startDate") String startDate,
			@ServiceParam(name = "endDate") String endDate) {
		PagerRecords records = null;
		Collection<Condition> conditions = new ArrayList<Condition>();
		
	    //参数处理
		String cardType = "";
		if(type.equals("01")){//收款明细查询
			cardType = "receiveCard";
		}else if(type.equals("02")||type.equals("00")){//付款明细查询
			cardType = "payCard";
		}else{
			return null;
		}
		if(pageIndex.isEmpty()){pageIndex = 1+"";}
		if(pageSize.isEmpty()){pageSize = 10+"";}
		
		
		Collection<Order> orders = new ArrayList<Order>();
		orders.add(ConditionUtils.getOrder("tranDate", false));
		conditions.add(ConditionUtils.getCondition(cardType,Condition.EQUALS, bankcardNum));
//		if(type.equals("00")){
//			conditions.add(ConditionUtils.getCondition("payCard",Condition.EQUALS, bankcardNum));
//		}
		Pager pager = new Pager(Integer.parseInt(pageSize), Integer.parseInt(pageIndex), 0);	
			
		
		//1、未传送查询日期，只查询符合条件的pageSize只交易
		if(startDate==null&&endDate==null){
			return getInfs(conditions,orders,pager);
		}
		
		//2、传送查询日期
		String regex = "^\\d{8}$";
		if(checkRegex(startDate, regex)&&checkRegex(endDate, regex)){
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			//判断区间格式
			try { 
				if(format.parse(startDate).after(format.parse(endDate))){
					return null; //请输入正确的时间格式
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			records = getRecordsByConditions(conditions,orders,pager,startDate,endDate);
		}
		
		return records;
	}

	private PagerRecords getRecordsByConditions(
			Collection<Condition> conditions, Collection<Order> orders,
			Pager pager, String startDate, String endDate) {
		PagerRecords records = null;
		String today = DateUtils.getToday("yyyyMMdd");
		if(startDate.equals(today)){//只查询当日库
			conditions.add(ConditionUtils.getCondition("tranDate",
					Condition.EQUALS, startDate));
			records = dayTraInfDao.findByPager(pager, conditions, orders);
		}else if(endDate.equals(today)&&!startDate.equals(today)){//查询范围包含了当日库和历史库
			conditions.add(ConditionUtils.getCondition("tranDate",
					Condition.RIGHT_EQ, startDate));
			conditions.add(ConditionUtils.getCondition("tranDate",
					Condition.LEFT_EQ, endDate));
			records = getInfs(conditions, orders, pager);
		}else{//只查询历史库
			conditions.add(ConditionUtils.getCondition("tranDate",
					Condition.RIGHT_EQ, startDate));
			conditions.add(ConditionUtils.getCondition("tranDate",
					Condition.LEFT_EQ, endDate));//小于等于 <=
			records = hisTraInfDao.findByPager(pager, conditions, orders);
		}
		return records;
	}

	/**
	 * 待优化。。。sql语句  union
	 */
	
	private PagerRecords getInfs(Collection<Condition> conditions,
			Collection<Order> orders, Pager pager) {
		PagerRecords curPagerRecords = null;
		//查询当日表
		curPagerRecords = dayTraInfDao.findByPager(pager, conditions, orders);
		//当日表里查询出来的记录数小于要查询的总数，再从历史表里查询
		int cu = pager.getPageSize() - curPagerRecords.getTotalCount();
		
		if(cu>0){
			Pager newPager = new Pager(1, cu, 0);
			//查询历史表
			PagerRecords hisPagerRecords = hisTraInfDao.findByPager(newPager, conditions, orders);
			curPagerRecords.getRecords().addAll(hisPagerRecords.getRecords());
			curPagerRecords.setTotalCount(curPagerRecords.getTotalCount()+hisPagerRecords.getTotalCount());
		}
		return curPagerRecords;
	}
	
	 /**
     * 根据卡号和日期查找记录,返回该卡当天以消费金额
     * receiveCard 收款方账号   payCard 付款方账号
     * 如果单查收款 则将付款方输入null 反之亦然
     */
	@Override
	public double  getDayTraAmountByDate(String receiveCard,String payCard, String tranDate)
			throws BusException {
		double amount =0.0;
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("tranDate", Condition.EQUALS, tranDate));//当天日期
		conditions.add(ConditionUtils.getCondition("tranState", Condition.EQUALS, "00"));//交易状态成功
		if(receiveCard!=null){
			conditions.add(ConditionUtils.getCondition("receiveCard", Condition.EQUALS, receiveCard));
		}
		if(payCard!=null){
			conditions.add(ConditionUtils.getCondition("payCard", Condition.EQUALS, payCard));
		}
    	Collection<Order> orders=new ArrayList<Order>();
		List<DayTraInf> dayTraInfs = getDayTraInfs(conditions, orders);
		for (DayTraInf dayTraInf : dayTraInfs) {
			amount+=Double.parseDouble(dayTraInf.getTradeAmount().trim());
		}
		return amount;
	}
	
}
