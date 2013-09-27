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

import com.gsoft.phone.core.entity.CliAccRel;
import com.gsoft.phone.core.service.CliAccRelManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/cliAccRel")
public class CliAccRelData extends BaseDataController{

	@Autowired
	private CliAccRelManager cliAccRelManager;
	
	
	/**
	 * 主键查询客户与账户对应关系表
	 */
	@RequestMapping
	@DataInfo(functionId="03010501",text="主键查询客户与账户对应关系表")
	public DataModelAndView getCliAccRel(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("clientAccountNo") String clientAccountNo){
		return new DataModelAndView(cliAccRelManager.getCliAccRel(clientAccountNo));
	}
	
	/**
	 * 通用客户与账户对应关系表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010502",text="通用客户与账户对应关系表查询")
	public DataModelAndView getCliAccRels(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<CliAccRel> dataIn,
    		@ModelAttribute CliAccRel cliAccRel,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(cliAccRelManager.getCliAccRels(
				dataIn.getConditions(cliAccRel, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询客户与账户对应关系表
	 */
	@RequestMapping
	@DataInfo(functionId="03010503",text="分页查询客户与账户对应关系表")
	public DataModelAndView getPagerCliAccRels(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<CliAccRel> dataIn,
    		@ModelAttribute CliAccRel cliAccRel,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(cliAccRelManager.getPagerCliAccRels(
				dataIn.getPager(),
				dataIn.getConditions(cliAccRel, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存客户与账户对应关系表
	 */
	@RequestMapping
	@DataInfo(functionId="03010504",text="保存客户与账户对应关系表",log=true)
	public DataModelAndView saveCliAccRel(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<CliAccRel> dataIn,
    		@ModelAttribute CliAccRel cliAccRel,
    		BindingResult result){
		CliAccRel webCliAccRel =dataIn.getDomain(cliAccRel, result);//TODO 使用泛型
		CliAccRel saveCliAccRel = null;
		if(webCliAccRel!=null){
			saveCliAccRel = cliAccRelManager.saveCliAccRel((CliAccRel)webCliAccRel);
		}
		return new DataModelAndView(saveCliAccRel);
	}
	
	/**
	 * 主键删除客户与账户对应关系表
	 */
	@RequestMapping
	@DataInfo(functionId="03010505",text="主键删除客户与账户对应关系表",log=true)
	public DataModelAndView removeCliAccRel(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("clientAccountNo") String clientAccountNo){
		cliAccRelManager.removeCliAccRel(clientAccountNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除客户与账户对应关系表
	 */
	@RequestMapping
	@DataInfo(functionId="03010506",text="主键集合删除客户与账户对应关系表",log=true)
	public DataModelAndView removeCliAccRels(
    		HttpServletRequest request,
    		HttpServletResponse response){
		cliAccRelManager.removeCliAccRels(request.getParameterValues("clientAccountNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
