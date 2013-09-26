/**
 * 
 */
package com.gsoft.mobile.manager.web;

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
import com.gsoft.mobile.manager.entity.TerInf;
import com.gsoft.mobile.manager.service.TerInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/manager/terInf")
public class TerInfData extends BaseDataController{

	@Autowired
	private TerInfManager terInfManager;
	
	
	/**
	 * 主键查询终端信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040201",text="主键查询终端信息表")
	public DataModelAndView getTerInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("terminalNo") String terminalNo){
		return new DataModelAndView(terInfManager.getTerInf(terminalNo));
	}
	
	/**
	 * 通用终端信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03040202",text="通用终端信息表查询")
	public DataModelAndView getTerInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<TerInf> dataIn,
    		@ModelAttribute TerInf terInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(terInfManager.getTerInfs(
				dataIn.getConditions(terInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询终端信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040203",text="分页查询终端信息表")
	public DataModelAndView getPagerTerInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<TerInf> dataIn,
    		@ModelAttribute TerInf terInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(terInfManager.getPagerTerInfs(
				dataIn.getPager(),
				dataIn.getConditions(terInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存终端信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040204",text="保存终端信息表",log=true)
	public DataModelAndView saveTerInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<TerInf> dataIn,
    		@ModelAttribute TerInf terInf,
    		BindingResult result){
		TerInf webTerInf =dataIn.getDomain(terInf, result);//TODO 使用泛型
		TerInf saveTerInf = null;
		if(webTerInf!=null){
			saveTerInf = terInfManager.saveTerInf((TerInf)webTerInf);
		}
		return new DataModelAndView(saveTerInf);
	}
	
	/**
	 * 主键删除终端信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040205",text="主键删除终端信息表",log=true)
	public DataModelAndView removeTerInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("terminalNo") String terminalNo){
		terInfManager.removeTerInf(terminalNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除终端信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040206",text="主键集合删除终端信息表",log=true)
	public DataModelAndView removeTerInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		terInfManager.removeTerInfs(request.getParameterValues("terminalNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
