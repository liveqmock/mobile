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

import com.gsoft.phone.core.entity.SignTerReg;
import com.gsoft.phone.core.service.SignTerRegManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/signTerReg")
public class SignTerRegData extends BaseDataController{

	@Autowired
	private SignTerRegManager signTerRegManager;
	
	
	/**
	 * 主键查询签约/解约登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010701",text="主键查询签约/解约登记簿")
	public DataModelAndView getSignTerReg(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("signBusiness") String signBusiness){
		return new DataModelAndView(signTerRegManager.getSignTerReg(signBusiness));
	}
	
	/**
	 * 通用签约/解约登记簿查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010702",text="通用签约/解约登记簿查询")
	public DataModelAndView getSignTerRegs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignTerReg> dataIn,
    		@ModelAttribute SignTerReg signTerReg,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(signTerRegManager.getSignTerRegs(
				dataIn.getConditions(signTerReg, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询签约/解约登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010703",text="分页查询签约/解约登记簿")
	public DataModelAndView getPagerSignTerRegs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignTerReg> dataIn,
    		@ModelAttribute SignTerReg signTerReg,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(signTerRegManager.getPagerSignTerRegs(
				dataIn.getPager(),
				dataIn.getConditions(signTerReg, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存签约/解约登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010704",text="保存签约/解约登记簿",log=true)
	public DataModelAndView saveSignTerReg(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<SignTerReg> dataIn,
    		@ModelAttribute SignTerReg signTerReg,
    		BindingResult result){
		SignTerReg webSignTerReg =dataIn.getDomain(signTerReg, result);//TODO 使用泛型
		SignTerReg saveSignTerReg = null;
		if(webSignTerReg!=null){
			saveSignTerReg = signTerRegManager.saveSignTerReg((SignTerReg)webSignTerReg);
		}
		return new DataModelAndView(saveSignTerReg);
	}
	
	/**
	 * 主键删除签约/解约登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010705",text="主键删除签约/解约登记簿",log=true)
	public DataModelAndView removeSignTerReg(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("signBusiness") String signBusiness){
		signTerRegManager.removeSignTerReg(signBusiness);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除签约/解约登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010706",text="主键集合删除签约/解约登记簿",log=true)
	public DataModelAndView removeSignTerRegs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		signTerRegManager.removeSignTerRegs(request.getParameterValues("signBusiness"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
