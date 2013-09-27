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

import com.gsoft.mobile.core.entity.CommInf;
import com.gsoft.mobile.core.service.CommInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/core/commInf")
public class CommInfData extends BaseDataController{

	@Autowired
	private CommInfManager commInfManager;
	
	
	/**
	 * 主键查询商品信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010801",text="主键查询商品信息表")
	public DataModelAndView getCommInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("belongMerchant") String belongMerchant){
		return new DataModelAndView(commInfManager.getCommInf(belongMerchant));
	}
	
	/**
	 * 通用商品信息表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03010802",text="通用商品信息表查询")
	public DataModelAndView getCommInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<CommInf> dataIn,
    		@ModelAttribute CommInf commInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(commInfManager.getCommInfs(
				dataIn.getConditions(commInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询商品信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010803",text="分页查询商品信息表")
	public DataModelAndView getPagerCommInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<CommInf> dataIn,
    		@ModelAttribute CommInf commInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(commInfManager.getPagerCommInfs(
				dataIn.getPager(),
				dataIn.getConditions(commInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存商品信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010804",text="保存商品信息表",log=true)
	public DataModelAndView saveCommInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<CommInf> dataIn,
    		@ModelAttribute CommInf commInf,
    		BindingResult result){
		CommInf webCommInf =dataIn.getDomain(commInf, result);//TODO 使用泛型
		CommInf saveCommInf = null;
		if(webCommInf!=null){
			saveCommInf = commInfManager.saveCommInf((CommInf)webCommInf);
		}
		return new DataModelAndView(saveCommInf);
	}
	
	/**
	 * 主键删除商品信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010805",text="主键删除商品信息表",log=true)
	public DataModelAndView removeCommInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("belongMerchant") String belongMerchant){
		commInfManager.removeCommInf(belongMerchant);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除商品信息表
	 */
	@RequestMapping
	@DataInfo(functionId="03010806",text="主键集合删除商品信息表",log=true)
	public DataModelAndView removeCommInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		commInfManager.removeCommInfs(request.getParameterValues("belongMerchant"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
