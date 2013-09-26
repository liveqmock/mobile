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

import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.service.ClientInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/clientInf")
public class ClientInfData extends BaseDataController{

	@Autowired
	private ClientInfManager clientInfManager;
	
	
	/**
	 * 主键查询客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010101",text="主键查询客户信息表")
	public DataModelAndView getClientInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("clientId") String clientId){
		return new DataModelAndView(clientInfManager.getClientInf(clientId));
	}
	
	/**
	 * 通用客户信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010102",text="通用客户信息表查询")
	public DataModelAndView getClientInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ClientInf> dataIn,
    		@ModelAttribute ClientInf clientInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(clientInfManager.getClientInfs(
				dataIn.getConditions(clientInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010103",text="分页查询客户信息表")
	public DataModelAndView getPagerClientInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ClientInf> dataIn,
    		@ModelAttribute ClientInf clientInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(clientInfManager.getPagerClientInfs(
				dataIn.getPager(),
				dataIn.getConditions(clientInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010104",text="保存客户信息表",log=true)
	public DataModelAndView saveClientInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ClientInf> dataIn,
    		@ModelAttribute ClientInf clientInf,
    		BindingResult result){
		ClientInf webClientInf =dataIn.getDomain(clientInf, result);//TODO 使用泛型
		ClientInf saveClientInf = null;
		if(webClientInf!=null){
			saveClientInf = clientInfManager.saveClientInf((ClientInf)webClientInf);
		}
		return new DataModelAndView(saveClientInf);
	}
	
	/**
	 * 主键删除客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010105",text="主键删除客户信息表",log=true)
	public DataModelAndView removeClientInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("clientId") String clientId){
		clientInfManager.removeClientInf(clientId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010106",text="主键集合删除客户信息表",log=true)
	public DataModelAndView removeClientInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		clientInfManager.removeClientInfs(request.getParameterValues("clientId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
