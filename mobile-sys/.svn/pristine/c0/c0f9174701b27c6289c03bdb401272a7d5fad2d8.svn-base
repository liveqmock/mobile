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

import com.gsoft.mobile.core.entity.MerInf;
import com.gsoft.mobile.core.service.MerInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/merInf")
public class MerInfData extends BaseDataController{

	@Autowired
	private MerInfManager merInfManager;
	
	
	/**
	 * 主键查询商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010201",text="主键查询商户信息表")
	public DataModelAndView getMerInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("merchantNo") String merchantNo){
		return new DataModelAndView(merInfManager.getMerInf(merchantNo));
	}
	
	/**
	 * 通用商户信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010202",text="通用商户信息表查询")
	public DataModelAndView getMerInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<MerInf> dataIn,
    		@ModelAttribute MerInf merInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(merInfManager.getMerInfs(
				dataIn.getConditions(merInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010203",text="分页查询商户信息表")
	public DataModelAndView getPagerMerInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<MerInf> dataIn,
    		@ModelAttribute MerInf merInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(merInfManager.getPagerMerInfs(
				dataIn.getPager(),
				dataIn.getConditions(merInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010204",text="保存商户信息表",log=true)
	public DataModelAndView saveMerInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<MerInf> dataIn,
    		@ModelAttribute MerInf merInf,
    		BindingResult result){
		MerInf webMerInf =dataIn.getDomain(merInf, result);//TODO 使用泛型
		MerInf saveMerInf = null;
		if(webMerInf!=null){
			saveMerInf = merInfManager.saveMerInf((MerInf)webMerInf);
		}
		return new DataModelAndView(saveMerInf);
	}
	
	/**
	 * 主键删除商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010205",text="主键删除商户信息表",log=true)
	public DataModelAndView removeMerInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("merchantNo") String merchantNo){
		merInfManager.removeMerInf(merchantNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010206",text="主键集合删除商户信息表",log=true)
	public DataModelAndView removeMerInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		merInfManager.removeMerInfs(request.getParameterValues("merchantNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
