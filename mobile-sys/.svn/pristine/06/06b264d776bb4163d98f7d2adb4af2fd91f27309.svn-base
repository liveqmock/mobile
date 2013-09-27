/**
 * 代码声明
 */
package com.gsoft.mobile.manager.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.mobile.manager.entity.TerInf;

public interface TerInfManager extends BaseManager {

	/**
	 * 查询列表
	 */
	public List<TerInf> getTerInfs() throws BusException;

	/**
	 * 条件查询列表
	 */
	public List<TerInf> getTerInfs(Collection<Condition> conditions,
			Collection<Order> orders) throws BusException;

	/**
	 * 根据主键查询
	 */
	public TerInf getTerInf(String id) throws BusException;

	/**
	 * 分页查询用户
	 * 
	 * @return 分页对象
	 */
	public PagerRecords getPagerTerInfs(Pager pager,// 分页条件
			Collection<Condition> conditions,// 查询条件
			Collection<Order> orders) throws BusException;

	/**
	 * 保存并返回对象
	 */
	public TerInf saveTerInf(TerInf o) throws BusException;

	/**
	 * 删除对象
	 */
	public void removeTerInf(String id) throws BusException;

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeTerInfs(String[] ids) throws BusException;

	/**
	 * 主键是否已经使用
	 * 
	 * @param ids
	 */
	public boolean exsitTerInf(String id) throws BusException;

	/**
	 * 属性值是否已经使用
	 * 
	 * @param ids
	 */
	public boolean exsitTerInf(String propertyName, Object value)
			throws BusException;

	/**
	 * 切换终端状态 暂停/恢复
	 */
	public TerInf updateTerInfState(String id) throws BusException;

	/**
	 * 注销 00 正常 01 暂停 02 注销
	 */
	public Message cancelTerInf(String id) throws BusException;

	/**
	 * 根据机构号查找下级机构号
	 */
	public List<Record> getInstNoByParentNo(String pinstNo) throws BusException;
}
