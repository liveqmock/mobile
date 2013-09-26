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

import com.gsoft.phone.core.entity.LogQuiReg;
import com.gsoft.phone.core.service.LogQuiRegManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/logQuiReg")
public class LogQuiRegData extends BaseDataController{

	@Autowired
	private LogQuiRegManager logQuiRegManager;
	
	
	/**
	 * 主键查询客户登陆/退出登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010601",text="主键查询客户登陆/退出登记簿")
	public DataModelAndView getLogQuiReg(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("loginQuitNo") String loginQuitNo){
		return new DataModelAndView(logQuiRegManager.getLogQuiReg(loginQuitNo));
	}
	
	/**
	 * 通用客户登陆/退出登记簿查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010602",text="通用客户登陆/退出登记簿查询")
	public DataModelAndView getLogQuiRegs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<LogQuiReg> dataIn,
    		@ModelAttribute LogQuiReg logQuiReg,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(logQuiRegManager.getLogQuiRegs(
				dataIn.getConditions(logQuiReg, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询客户登陆/退出登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010603",text="分页查询客户登陆/退出登记簿")
	public DataModelAndView getPagerLogQuiRegs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<LogQuiReg> dataIn,
    		@ModelAttribute LogQuiReg logQuiReg,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(logQuiRegManager.getPagerLogQuiRegs(
				dataIn.getPager(),
				dataIn.getConditions(logQuiReg, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存客户登陆/退出登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010604",text="保存客户登陆/退出登记簿",log=true)
	public DataModelAndView saveLogQuiReg(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<LogQuiReg> dataIn,
    		@ModelAttribute LogQuiReg logQuiReg,
    		BindingResult result){
		LogQuiReg webLogQuiReg =dataIn.getDomain(logQuiReg, result);//TODO 使用泛型
		LogQuiReg saveLogQuiReg = null;
		if(webLogQuiReg!=null){
			saveLogQuiReg = logQuiRegManager.saveLogQuiReg((LogQuiReg)webLogQuiReg);
		}
		return new DataModelAndView(saveLogQuiReg);
	}
	
	/**
	 * 主键删除客户登陆/退出登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010605",text="主键删除客户登陆/退出登记簿",log=true)
	public DataModelAndView removeLogQuiReg(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("loginQuitNo") String loginQuitNo){
		logQuiRegManager.removeLogQuiReg(loginQuitNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除客户登陆/退出登记簿
	 */
	@RequestMapping
	@DataInfo(functionId="03010606",text="主键集合删除客户登陆/退出登记簿",log=true)
	public DataModelAndView removeLogQuiRegs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		logQuiRegManager.removeLogQuiRegs(request.getParameterValues("loginQuitNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
