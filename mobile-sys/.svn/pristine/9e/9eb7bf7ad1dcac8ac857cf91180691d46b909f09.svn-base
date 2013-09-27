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

import com.gsoft.mobile.param.entity.ParaValInf;
import com.gsoft.mobile.param.service.ParaValInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/param/paraValInf")
public class ParaValInfData extends BaseDataController{

	@Autowired
	private ParaValInfManager paraValInfManager;
	
	
	/**
	 * 主键查询参数值表
	 */
	@RequestMapping
	@DataInfo(functionId="03030201",text="主键查询参数值表")
	public DataModelAndView getParaValInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("paraValCd") String paraValCd){
		return new DataModelAndView(paraValInfManager.getParaValInf(paraValCd));
	}
	
	/**
	 * 通用参数值表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03030202",text="通用参数值表查询")
	public DataModelAndView getParaValInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ParaValInf> dataIn,
    		@ModelAttribute ParaValInf paraValInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(paraValInfManager.getParaValInfs(
				dataIn.getConditions(paraValInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询参数值表
	 */
	@RequestMapping
	@DataInfo(functionId="03030203",text="分页查询参数值表")
	public DataModelAndView getPagerParaValInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ParaValInf> dataIn,
    		@ModelAttribute ParaValInf paraValInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(paraValInfManager.getPagerParaValInfs(
				dataIn.getPager(),
				dataIn.getConditions(paraValInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存参数值表
	 */
	@RequestMapping
	@DataInfo(functionId="03030204",text="保存参数值表",log=true)
	public DataModelAndView saveParaValInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<ParaValInf> dataIn,
    		@ModelAttribute ParaValInf paraValInf,
    		BindingResult result){
		ParaValInf webParaValInf =dataIn.getDomain(paraValInf, result);//TODO 使用泛型
		ParaValInf saveParaValInf = null;
		if(webParaValInf!=null){
			saveParaValInf = paraValInfManager.saveParaValInf((ParaValInf)webParaValInf);
		}
		return new DataModelAndView(saveParaValInf);
	}
	
	/**
	 * 主键删除参数值表
	 */
	@RequestMapping
	@DataInfo(functionId="03030205",text="主键删除参数值表",log=true)
	public DataModelAndView removeParaValInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("paraValCd") String paraValCd){
		paraValInfManager.removeParaValInf(paraValCd);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除参数值表
	 */
	@RequestMapping
	@DataInfo(functionId="03030206",text="主键集合删除参数值表",log=true)
	public DataModelAndView removeParaValInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		paraValInfManager.removeParaValInfs(request.getParameterValues("paraValCd"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
