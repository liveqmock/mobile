/**
 * 
 */
package com.gsoft.phone.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsoft.framework.core.web.annotation.DataInfo;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.core.web.controller.DataIn;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.core.web.view.Message;

import com.gsoft.phone.core.entity.SignInfo;
import com.gsoft.phone.core.service.SignInfoManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/signInfo")
public class SignInfoData extends BaseDataController{

	@Autowired
	private SignInfoManager signInfoManager;
	
	
	/**
	 * 主键查询签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010401",text="主键查询签约信息表")
	public DataModelAndView getSignInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("signBusiness") String signBusiness){
		return new DataModelAndView(signInfoManager.getSignInfo(signBusiness));
	}
	
	/**
	 * 通用签约信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010402",text="通用签约信息表查询")
	public DataModelAndView getSignInfos(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignInfo> dataIn,
    		@ModelAttribute SignInfo signInfo,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(signInfoManager.getSignInfos(
				dataIn.getConditions(signInfo, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010403",text="分页查询签约信息表")
	public DataModelAndView getPagerSignInfos(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignInfo> dataIn,
    		@ModelAttribute SignInfo signInfo,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(signInfoManager.getPagerSignInfos(
				dataIn.getPager(),
				dataIn.getConditions(signInfo, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010404",text="保存签约信息表",log=true)
	public DataModelAndView saveSignInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignInfo> dataIn,
    		@ModelAttribute SignInfo signInfo,
    		BindingResult result){
		SignInfo webSignInfo =dataIn.getDomain(signInfo, result);//TODO 使用泛型
		SignInfo saveSignInfo = null;
		if(webSignInfo!=null){
			saveSignInfo = signInfoManager.saveSignInfo((SignInfo)webSignInfo);
		}
		return new DataModelAndView(saveSignInfo);
	}
	
	/**
	 * 主键删除签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010405",text="主键删除签约信息表",log=true)
	public DataModelAndView removeSignInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("signBusiness") String signBusiness){
		signInfoManager.removeSignInfo(signBusiness);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010406",text="主键集合删除签约信息表",log=true)
	public DataModelAndView removeSignInfos(
    		HttpServletRequest request,
    		HttpServletResponse response){
		signInfoManager.removeSignInfos(request.getParameterValues("signBusiness"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
