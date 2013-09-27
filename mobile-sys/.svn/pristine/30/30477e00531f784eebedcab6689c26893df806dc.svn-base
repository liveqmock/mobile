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
import com.gsoft.mobile.manager.entity.BlInf;
import com.gsoft.mobile.manager.service.BlInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/manager/blInf")
public class BlInfData extends BaseDataController{

	@Autowired
	private BlInfManager blInfManager;
	
	
	/**
	 * 主键查询黑名单信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040101",text="主键查询黑名单信息表")
	public DataModelAndView getBlInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("blacklistNo") String blacklistNo){
		return new DataModelAndView(blInfManager.getBlInf(blacklistNo));
	}
	
	/**
	 * 通用黑名单信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03040102",text="通用黑名单信息表查询")
	public DataModelAndView getBlInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<BlInf> dataIn,
    		@ModelAttribute BlInf blInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(blInfManager.getBlInfs(
				dataIn.getConditions(blInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询黑名单信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040103",text="分页查询黑名单信息表")
	public DataModelAndView getPagerBlInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<BlInf> dataIn,
    		@ModelAttribute BlInf blInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(blInfManager.getPagerBlInfs(
				dataIn.getPager(),
				dataIn.getConditions(blInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存黑名单信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040104",text="保存黑名单信息表",log=true)
	public DataModelAndView saveBlInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<BlInf> dataIn,
    		@ModelAttribute BlInf blInf,
    		BindingResult result){
		BlInf webBlInf =dataIn.getDomain(blInf, result);//TODO 使用泛型
		BlInf saveBlInf = null;
		if(webBlInf!=null){
			saveBlInf = blInfManager.saveBlInf((BlInf)webBlInf);
		}
		return new DataModelAndView(saveBlInf);
	}
	
	/**
	 * 主键删除黑名单信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040105",text="主键删除黑名单信息表",log=true)
	public DataModelAndView removeBlInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("blacklistNo") String blacklistNo){
		blInfManager.removeBlInf(blacklistNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除黑名单信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03040106",text="主键集合删除黑名单信息表",log=true)
	public DataModelAndView removeBlInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		blInfManager.removeBlInfs(request.getParameterValues("blacklistNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
