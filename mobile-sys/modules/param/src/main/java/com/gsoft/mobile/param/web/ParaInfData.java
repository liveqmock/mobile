/**
 * 
 */
package com.gsoft.mobile.param.web;

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

import com.gsoft.mobile.param.entity.ParaInf;
import com.gsoft.mobile.param.service.ParaInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/param/paraInf")
public class ParaInfData extends BaseDataController{

	@Autowired
	private ParaInfManager paraInfManager;
	
	
	/**
	 * 主键查询参数信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03030101",text="主键查询参数信息表")
	public DataModelAndView getParaInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("paraNo") String paraNo){
		return new DataModelAndView(paraInfManager.getParaInf(paraNo));
	}
	
	/**
	 * 通用参数信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03030102",text="通用参数信息表查询")
	public DataModelAndView getParaInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ParaInf> dataIn,
    		@ModelAttribute ParaInf paraInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(paraInfManager.getParaInfs(
				dataIn.getConditions(paraInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询参数信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03030103",text="分页查询参数信息表")
	public DataModelAndView getPagerParaInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ParaInf> dataIn,
    		@ModelAttribute ParaInf paraInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(paraInfManager.getPagerParaInfs(
				dataIn.getPager(),
				dataIn.getConditions(paraInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存参数信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03030104",text="保存参数信息表",log=true)
	public DataModelAndView saveParaInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ParaInf> dataIn,
    		@ModelAttribute ParaInf paraInf,
    		BindingResult result){
		ParaInf webParaInf =dataIn.getDomain(paraInf, result);//TODO 使用泛型
		ParaInf saveParaInf = null;
		if(webParaInf!=null){
			saveParaInf = paraInfManager.saveParaInf((ParaInf)webParaInf);
		}
		return new DataModelAndView(saveParaInf);
	}
	
	/**
	 * 主键删除参数信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03030105",text="主键删除参数信息表",log=true)
	public DataModelAndView removeParaInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("paraNo") String paraNo){
		paraInfManager.removeParaInf(paraNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除参数信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03030106",text="主键集合删除参数信息表",log=true)
	public DataModelAndView removeParaInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		paraInfManager.removeParaInfs(request.getParameterValues("paraNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
