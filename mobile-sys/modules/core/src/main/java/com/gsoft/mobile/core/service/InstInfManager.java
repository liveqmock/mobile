/**
 * 代码声明
 */
package com.gsoft.mobile.core.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.core.web.view.Message;

import com.gsoft.mobile.core.entity.MerInf;

public interface InstInfManager extends BaseManager{

	public List<Record>  getInstNoByParentNo(String pInstNo) throws BusException;
}
