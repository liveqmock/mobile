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

import com.gsoft.phone.core.entity.AccInf;
import com.gsoft.phone.core.service.AccInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/accInf")
public class AccInfData extends BaseDataController{

	@Autowired
	private AccInfManager accInfManager;
	
	
	/**
	 * 主键查询账户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010301",text="主键查询账户信息表")
	public DataModelAndView getAccInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("accountId") String accountId){
		return new DataModelAndView(accInfManager.getAccInf(accountId));
	}
	
	/**
	 * 通用账户信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010302",text="通用账户信息表查询")
	public DataModelAndView getAccInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<AccInf> dataIn,
    		@ModelAttribute AccInf accInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(accInfManager.getAccInfs(
				dataIn.getConditions(accInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询账户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010303",text="分页查询账户信息表")
	public DataModelAndView getPagerAccInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<AccInf> dataIn,
    		@ModelAttribute AccInf accInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(accInfManager.getPagerAccInfs(
				dataIn.getPager(),
				dataIn.getConditions(accInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存账户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010304",text="保存账户信息表",log=true)
	public DataModelAndView saveAccInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<AccInf> dataIn,
    		@ModelAttribute AccInf accInf,
    		BindingResult result){
		AccInf webAccInf =dataIn.getDomain(accInf, result);//TODO 使用泛型
		AccInf saveAccInf = null;
		if(webAccInf!=null){
			saveAccInf = accInfManager.saveAccInf((AccInf)webAccInf);
		}
		return new DataModelAndView(saveAccInf);
	}
	
	/**
	 * 主键删除账户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010305",text="主键删除账户信息表",log=true)
	public DataModelAndView removeAccInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("accountId") String accountId){
		accInfManager.removeAccInf(accountId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除账户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010306",text="主键集合删除账户信息表",log=true)
	public DataModelAndView removeAccInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		accInfManager.removeAccInfs(request.getParameterValues("accountId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
