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
import com.gsoft.mobile.core.entity.HisTraInf;
import com.gsoft.mobile.core.service.HisTraInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/batcfg/HisTraInf")
public class HisTraInfData extends BaseDataController{

	@Autowired
	private HisTraInfManager HisTraInfManager;
	
	
	/**
	 * 主键查询历史交易明细表
	 */
	@RequestMapping(value="/getHisTraInf.json")
	@DataInfo(functionId="03020201",text="主键查询历史交易明细表")
	public DataModelAndView getHisTraInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("tradeSeqno") String tradeSeqno){
		return new DataModelAndView(HisTraInfManager.getHisTraInf(tradeSeqno));
	}
	
	/**
	 * 通用历史交易明细表查询
	 */
	@RequestMapping(value="/getHisTraInfs.json")
	@DataInfo(functionId="03020202",text="通用历史交易明细表查询")
	public DataModelAndView getHisTraInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<HisTraInf> dataIn,
    		@ModelAttribute HisTraInf HisTraInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(HisTraInfManager.getHisTraInfs(
				dataIn.getConditions(HisTraInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询历史交易明细表
	 */
	@RequestMapping(value="/getPagerHisTraInfs.json")
	@DataInfo(functionId="03020203",text="分页查询历史交易明细表")
	public DataModelAndView getPagerHisTraInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<HisTraInf> dataIn,
    		@ModelAttribute HisTraInf HisTraInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(HisTraInfManager.getPagerHisTraInfs(
				dataIn.getPager(),
				dataIn.getConditions(HisTraInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存历史交易明细表
	 */
	@RequestMapping(value="/saveHisTraInf.json")
	@DataInfo(functionId="03020204",text="保存历史交易明细表",log=true)
	public DataModelAndView saveHisTraInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<HisTraInf> dataIn,
    		@ModelAttribute HisTraInf HisTraInf,
    		BindingResult result){
		HisTraInf webHisTraInf =dataIn.getDomain(HisTraInf, result);//TODO 使用泛型
		HisTraInf saveHisTraInf = null;
		if(webHisTraInf!=null){
			saveHisTraInf = HisTraInfManager.saveHisTraInf((HisTraInf)webHisTraInf);
		}
		return new DataModelAndView(saveHisTraInf);
	}
	
	/**
	 * 主键删除历史交易明细表
	 */
	@RequestMapping(value="/removeHisTraInf.json")
	@DataInfo(functionId="03020205",text="主键删除历史交易明细表",log=true)
	public DataModelAndView removeHisTraInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("tradeSeqno") String tradeSeqno){
		HisTraInfManager.removeHisTraInf(tradeSeqno);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除历史交易明细表
	 */
	@RequestMapping(value="/removeHisTraInfs.json")
	@DataInfo(functionId="03020206",text="主键集合删除历史交易明细表",log=true)
	public DataModelAndView removeHisTraInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		HisTraInfManager.removeHisTraInfs(request.getParameterValues("tradeSeqno"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
