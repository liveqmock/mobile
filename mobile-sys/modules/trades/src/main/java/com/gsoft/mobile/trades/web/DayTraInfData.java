/**
 * 
 */
package com.gsoft.mobile.trades.web;

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

import com.gsoft.mobile.trades.entity.DayTraInf;
import com.gsoft.mobile.trades.service.DayTraInfManager;
/**
 * @author 
 *
 */

@Controller
@RequestMapping("/trades/dayTraInf")
public class DayTraInfData extends BaseDataController{

	@Autowired
	private DayTraInfManager dayTraInfManager;
	
	
	/**
	 * 主键查询当日交易流水表
	 */
	@RequestMapping
	@DataInfo(functionId="03020101",text="主键查询当日交易流水表")
	public DataModelAndView getDayTraInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("tradeSeqno") String tradeSeqno){
		return new DataModelAndView(dayTraInfManager.getDayTraInf(tradeSeqno));
	}
	
	/**
	 * 通用当日交易流水表查询
	 */
	@RequestMapping
	@DataInfo(functionId="03020102",text="通用当日交易流水表查询")
	public DataModelAndView getDayTraInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<DayTraInf> dataIn,
    		@ModelAttribute DayTraInf dayTraInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(dayTraInfManager.getDayTraInfs(
				dataIn.getConditions(dayTraInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 分页查询当日交易流水表
	 */
	@RequestMapping
	@DataInfo(functionId="03020103",text="分页查询当日交易流水表")
	public DataModelAndView getPagerDayTraInfs(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<DayTraInf> dataIn,
    		@ModelAttribute DayTraInf dayTraInf,
    		BindingResult result){
		//返回并包装数据
		return new DataModelAndView(dayTraInfManager.getPagerDayTraInfs(
				dataIn.getPager(),
				dataIn.getConditions(dayTraInf, result), 
				dataIn.getOrders()));
	}
	
	/**
	 * 保存当日交易流水表
	 */
	@RequestMapping
	@DataInfo(functionId="03020104",text="保存当日交易流水表",log=true)
	public DataModelAndView saveDayTraInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		DataIn<DayTraInf> dataIn,
    		@ModelAttribute DayTraInf dayTraInf,
    		BindingResult result){
		DayTraInf webDayTraInf =dataIn.getDomain(dayTraInf, result);//TODO 使用泛型
		DayTraInf saveDayTraInf = null;
		if(webDayTraInf!=null){
			saveDayTraInf = dayTraInfManager.saveDayTraInf((DayTraInf)webDayTraInf);
		}
		return new DataModelAndView(saveDayTraInf);
	}
	
	/**
	 * 主键删除当日交易流水表
	 */
	@RequestMapping
	@DataInfo(functionId="03020105",text="主键删除当日交易流水表",log=true)
	public DataModelAndView removeDayTraInf(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam("tradeSeqno") String tradeSeqno){
		dayTraInfManager.removeDayTraInf(tradeSeqno);
		return new DataModelAndView(new Message(SUCCESS_CODE,"删除成功"));
	}
	
	/**
	 * 主键集合删除当日交易流水表
	 */
	@RequestMapping
	@DataInfo(functionId="03020106",text="主键集合删除当日交易流水表",log=true)
	public DataModelAndView removeDayTraInfs(
    		HttpServletRequest request,
    		HttpServletResponse response){
		dayTraInfManager.removeDayTraInfs(request.getParameterValues("tradeSeqno"));
		return new DataModelAndView(new Message(SUCCESS_CODE,"集合删除成功"));
	}
}
