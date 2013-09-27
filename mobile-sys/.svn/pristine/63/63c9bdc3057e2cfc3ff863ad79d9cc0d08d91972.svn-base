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

import com.gsoft.phone.core.entity.MerInfo;
import com.gsoft.phone.core.service.MerInfoManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/merInfo")
public class MerInfoData extends BaseDataController{

	@Autowired
	private MerInfoManager merInfoManager;
	
	
	/**
	 * 主键查询商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010201",text="主键查询商户信息表")
	public DataModelAndView getMerInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("merchantNo") String merchantNo){
		return new DataModelAndView(merInfoManager.getMerInfo(merchantNo));
	}
	
	/**
	 * 通用商户信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010202",text="通用商户信息表查询")
	public DataModelAndView getMerInfos(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<MerInfo> dataIn,
    		@ModelAttribute MerInfo merInfo,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(merInfoManager.getMerInfos(
				dataIn.getConditions(merInfo, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010203",text="分页查询商户信息表")
	public DataModelAndView getPagerMerInfos(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<MerInfo> dataIn,
    		@ModelAttribute MerInfo merInfo,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(merInfoManager.getPagerMerInfos(
				dataIn.getPager(),
				dataIn.getConditions(merInfo, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010204",text="保存商户信息表",log=true)
	public DataModelAndView saveMerInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<MerInfo> dataIn,
    		@ModelAttribute MerInfo merInfo,
    		BindingResult result){
		MerInfo webMerInfo =dataIn.getDomain(merInfo, result);//TODO 使用泛型
		MerInfo saveMerInfo = null;
		if(webMerInfo!=null){
			saveMerInfo = merInfoManager.saveMerInfo((MerInfo)webMerInfo);
		}
		return new DataModelAndView(saveMerInfo);
	}
	
	/**
	 * 主键删除商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010205",text="主键删除商户信息表",log=true)
	public DataModelAndView removeMerInfo(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("merchantNo") String merchantNo){
		merInfoManager.removeMerInfo(merchantNo);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商户信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010206",text="主键集合删除商户信息表",log=true)
	public DataModelAndView removeMerInfos(
    		HttpServletRequest request,
    		HttpServletResponse response){
		merInfoManager.removeMerInfos(request.getParameterValues("merchantNo"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
