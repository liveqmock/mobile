/**
 * 代码声明
 */
package com.gsoft.mobile.core.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

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
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mobile.core.dao.SignInfDao;
import com.gsoft.mobile.core.entity.SignInf;
import com.gsoft.mobile.core.service.SignInfManager;

@Service("signInfManager")
@Transactional
public class SignInfManagerImpl extends BaseManagerImpl implements SignInfManager{
	@Autowired
	private SignInfDao<SignInf,String> signInfDao;
	
    /**
     * 查询列表
     */
    public List<SignInf> getSignInfs() throws BusException{
    	return signInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<SignInf> getSignInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return signInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public SignInf getSignInf(@ServiceParam(name = "bankcardNum") String bankcardNum) throws BusException {
    	return signInfDao.getObjectByUniqueProperty("bankcardNum", bankcardNum);
    }
    
	@EsbServiceMapping
	public PagerRecords getPagerSignInfs(
			Pager pager,
			@ConditionCollection(domainClazz = SignInf.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = this.signInfDao.findByPager(pager,
				conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
//    public SignInf saveSignInf(SignInf o) throws BusException{
////    	String signInfId = o.getSignInfId();
////    	boolean isUpdate = StringUtils.isNotEmpty(signInfId);
////    	if(isUpdate){//修改
////    	
////    	}else{//新增
////    		
////    	}
//    	return signInfDao.save(o);
//    }

    /**
     * 删除对象
     */
    public void removeSignInf(String id) throws BusException{
    	signInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSignInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeSignInf(id);
    	}
    }
    
    public boolean exsitSignInf(String id) throws BusException{
		return signInfDao.exists(id);
	}
    
    public boolean exsitSignInf(String propertyName,Object value) throws BusException {
		return signInfDao.exists(propertyName,value);
	}

    /**
     * 根据签约类型和卡号查找签约记录
     * 应该只返回一条记录
     */
    public SignInf getSignInfByCardNo(String cardNo,String signBusiness )throws BusException{
    	Collection<Condition> conditions = new ArrayList<Condition>();
    	conditions.add(ConditionUtils.getCondition("bankcardNum", Condition.EQUALS, cardNo));
    	conditions.add(ConditionUtils.getCondition("signBusiness", Condition.EQUALS, signBusiness));
    	
    	Collection<Order> orders=new ArrayList<Order>();
    	List<SignInf> signInfs=getSignInfs(conditions, orders);
    	
    	return signInfs.size() != 0?signInfs.get(0):null;
    }
    
    /*
    * 保存对象
    */
	@EsbServiceMapping
	public Message saveSignInf(@ModelAttribute SignInf signInf)
			throws BusException {
		SignInf info = (SignInf) this.signInfDao.getObjectByUniqueProperty(
				"singNo", signInf.getSingNo());
		
		SignInf bankcardNum = (SignInf) this.signInfDao.getObjectByUniqueProperty(
				"bankcardNum", signInf.getBankcardNum());
		
		if (!signInfDao.exists("singNo", signInf.getSingNo())) {
			signInf.setClientState("00");
			 if (!isIdentityId(signInf.getDocumentNum()))
			 return new Message("", "0");//身份证号验证
			 
			 if(bankcardNum!=null){
				 if (bankcardNum.getClientState().equals("00")&&!signInfDao.exists("bankcardNum", signInf.getBankcardNum())) {
						return new Message("", "1");//卡号已存在
					} 
			 }
			
			signInf.setSignDate(DateUtils.getToday("yyyyMMdd"));
			signInfDao.save(signInf);
			
			return new Message("", "2");//签约已成功
			
		} 
		else if (StringUtils.isNotEmpty(signInf.getClientState())) {
//			System.out.println("123123123123");
			if(!info.getWithdrawPwd().equals(signInf.getWithdrawPwd())){
				return new Message("", "6");//取款密码不正确
			}else if (!info.getDocumentNum().equals(signInf.getDocumentNum())){
				return new Message("", "7");//身份证不正确
			}
			if (info.getClientState().equals("00"))
				info.setClientState("01");
			else if (info.getClientState().equals("01")) {
				return new Message("", "8");//此协议已取消
			}
			signInfDao.save(info);
			return new Message("", "4");//取消签订成功
		}
		else if (info!=null&&(!signInfDao.exists("dailyPayLimit", signInf.getDailyPayLimit())||!signInfDao.exists("singlePayLimit", signInf.getSinglePayLimit()))) {
		info.setDailyPayLimit(signInf.getDailyPayLimit());
		info.setSinglePayLimit(signInf.getSinglePayLimit());
		signInfDao.save(info);
		return new Message("", "3");
		}
		else{
			
			return new Message("", "5");
			
		}

	}
	
	 /**
    * 验证身份证
    * */
   public static String fixPersonIDCode(String personIDCode)
   {
     if ((personIDCode == null) || (personIDCode.trim().length() != 15)) {
       if ((personIDCode != null) && (personIDCode.trim().length() == 18)) {
         personIDCode = personIDCode.trim().toUpperCase();
       }
       return personIDCode;
     }
     if (personIDCode.endsWith("x")) {
       personIDCode = personIDCode.substring(0, personIDCode.length() - 1) + "X";
     }

     String id17 = personIDCode.substring(0, 6) + "19" + 
       personIDCode.substring(6, 15);
     char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
     int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 };
     int[] idcd = new int[18];

     for (int i = 1; i < 18; i++) {
       int j = 17 - i;
       idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
     }

     int sum = 0;
     for (int i = 1; i < 18; i++) {
       sum += idcd[i] * factor[i];
     }
     int remainder = sum % 11;
     String lastCheckBit = String.valueOf(code[remainder]);
     return id17 + lastCheckBit;
   }

   public static boolean isIdentityId(String identityId)
   {
     if (isEmpty(identityId)) {
       return false;
     }
     try
     {
       if (identityId.length() == 18)
       {
         String identityId15 = identityId.substring(0, 6) + 
           identityId.substring(8, 17);

         return fixPersonIDCode(identityId15).equalsIgnoreCase(identityId);
       }

       if (identityId.length() == 15)
       {
         try
         {
           Long.parseLong(identityId);

           return true;
         }
         catch (Exception ex)
         {
           return false;
         }

       }

       return false;
     }
     catch (Exception ex)
     {
     }

     return false;
   }

   public static boolean isEmpty(String sValue)
   {
     if (sValue == null) {
       return true;
     }
     return sValue.trim().equals("");
   }
    
    
    
    
}
