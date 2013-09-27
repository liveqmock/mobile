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

import com.gsoft.phone.core.entity.ClientInfo;
import com.gsoft.phone.core.service.ClientInfoManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/clientInfo")
public class ClientInfoData extends BaseDataController{

	@Autowired
	private ClientInfoManager clientInfoManager;
	
	
	/**
	 * 主键查询客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010101",text="主键查询客户信息表")
	public DataModelAndView getClientInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("clientId") String clientId){
		return new DataModelAndView(clientInfoManager.getClientInfo(clientId));
	}
	
	/**
	 * 通用客户信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010102",text="通用客户信息表查询")
	public DataModelAndView getClientInfos(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ClientInfo> dataIn,
    		@ModelAttribute ClientInfo clientInfo,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(clientInfoManager.getClientInfos(
				dataIn.getConditions(clientInfo, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010103",text="分页查询客户信息表")
	public DataModelAndView getPagerClientInfos(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ClientInfo> dataIn,
    		@ModelAttribute ClientInfo clientInfo,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(clientInfoManager.getPagerClientInfos(
				dataIn.getPager(),
				dataIn.getConditions(clientInfo, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010104",text="保存客户信息表",log=true)
	public DataModelAndView saveClientInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ClientInfo> dataIn,
    		@ModelAttribute ClientInfo clientInfo,
    		BindingResult result){
		ClientInfo webClientInfo =dataIn.getDomain(clientInfo, result);//TODO 使用泛型
		ClientInfo saveClientInfo = null;
		if(webClientInfo!=null){
			saveClientInfo = clientInfoManager.saveClientInfo((ClientInfo)webClientInfo);
		}
		return new DataModelAndView(saveClientInfo);
	}
	
	/**
	 * 主键删除客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010105",text="主键删除客户信息表",log=true)
	public DataModelAndView removeClientInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("clientId") String clientId){
		clientInfoManager.removeClientInfo(clientId);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除客户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010106",text="主键集合删除客户信息表",log=true)
	public DataModelAndView removeClientInfos(
    		HttpServletRequest request,
    		HttpServletResponse response){
		clientInfoManager.removeClientInfos(request.getParameterValues("clientId"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
