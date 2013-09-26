package com.gsoft.mobile.core.entity;

import java.util.HashMap;
import java.util.Map;

public class ParamInf {
	//账户状态 00 正常  01 取消
	public static final Map<String,String>  accountState = new HashMap<String, String>();
	//商户状态 00 正常  01 暂停 02 解约
	public static final Map<String,String>  merState = new HashMap<String, String>();
	//终端状态 00 正常  01 暂停 02 注销
	public static final Map<String,String>  terminalState = new HashMap<String, String>();
	//客户状态 00 正常  01 注销
	public static final Map<String,String>  clientState = new HashMap<String, String>();
	//商户手续费类型  00：按月份固定收费，01:按交易费率收费，02：暂不收费
	public static final Map<String,String>  serviceChargeType = new HashMap<String, String>();
	//签约业务：00-移动支付，01-移动理财 
	public static final Map<String,String>  signBusiness = new HashMap<String, String>();
	//交易状态：00 正常 01失败 02 未完成
	public static final Map<String,String>  tranState = new HashMap<String, String>();
	//客户类型：00 客户 01商户
	public static final Map<String,String>  clientType = new HashMap<String, String>();
	//黑名单状态：00 在黑名单 01不在黑名单
	public static final Map<String,String>  blackListState = new HashMap<String, String>();
	
    static{
    	  //账户
    	  accountState.put("normal", "00");
    	  accountState.put("cancel", "01");
    	  //商户
    	  merState.put("normal", "00");
    	  merState.put("pause", "01");
    	  merState.put("cancel", "02");
    	  //终端
    	  terminalState.put("normal", "00");
    	  terminalState.put("pause", "01");
    	  terminalState.put("cancel", "02");
    	  //客户
    	  clientState.put("normal", "00");
    	  clientState.put("pause", "01");
    	  //手续费
    	  serviceChargeType.put("month", "00");
    	  serviceChargeType.put("tranrate", "01");
    	  serviceChargeType.put("free", "02");
    	  //签约业务
    	  signBusiness.put("payTreaty", "00");
    	  signBusiness.put("", "01");
    	  //交易状态
    	  tranState.put("normal", "00");
    	  tranState.put("fail", "01");
    	  tranState.put("undone", "02");
    	//客户类型
    	  clientType.put("client", "00");
    	  clientType.put("merch", "01");
    	  //黑名单状态
    	  blackListState.put("in", "00");
    	  blackListState.put("notIn", "01");

    	 
	}
 
}
