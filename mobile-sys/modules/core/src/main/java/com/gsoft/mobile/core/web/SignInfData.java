/**
 * 
 */
package com.gsoft.mobile.core.web;

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

import com.gsoft.mobile.core.entity.SignInf;
import com.gsoft.mobile.core.service.SignInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/signInf")
public class SignInfData extends BaseDataController{

	@Autowired
	private SignInfManager signInfManager;
	
	
	/**
	 * 主键查询签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010401",text="主键查询签约信息表")
	public DataModelAndView getSignInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("signBusiness") String signBusiness){
		return new DataModelAndView(signInfManager.getSignInf(signBusiness));
	}
	
	/**
	 * 通用签约信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010402",text="通用签约信息表查询")
	public DataModelAndView getSignInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignInf> dataIn,
    		@ModelAttribute SignInf signInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(signInfManager.getSignInfs(
				dataIn.getConditions(signInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010403",text="分页查询签约信息表")
	public DataModelAndView getPagerSignInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignInf> dataIn,
    		@ModelAttribute SignInf signInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(signInfManager.getPagerSignInfs(
				dataIn.getPager(),
				dataIn.getConditions(signInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010404",text="保存签约信息表",log=true)
	public DataModelAndView saveSignInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignInf> dataIn,
    		@ModelAttribute SignInf signInf,
    		BindingResult result){
		SignInf webSignInf =dataIn.getDomain(signInf, result);//TODO 使用泛型
		SignInf saveSignInf = null;
		if(webSignInf!=null){
//			saveSignInf = signInfManager.saveSignInf((SignInf)webSignInf);
		}
		return new DataModelAndView(saveSignInf);
	}
	
	/**
	 * 主键删除签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010405",text="主键删除签约信息表",log=true)
	public DataModelAndView removeSignInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("signBusiness") String signBusiness){
		signInfManager.removeSignInf(signBusiness);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除签约信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010406",text="主键集合删除签约信息表",log=true)
	public DataModelAndView removeSignInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		signInfManager.removeSignInfs(request.getParameterValues("signBusiness"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
