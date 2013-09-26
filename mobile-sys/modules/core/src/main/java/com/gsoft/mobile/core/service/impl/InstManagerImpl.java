/**
 * 
 */
package com.gsoft.mobile.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.mobile.core.service.InstInfManager;

/**
 * @author Administrator
 *
 */
@Service("instManager")
@Transactional
public class InstManagerImpl  extends BaseManagerImpl implements InstInfManager{

	/**
	 * 查找子级机构
	 * 调用银行接口
	 */
	@EsbServiceMapping
	public List<Record>  getInstNoByParentNo(@ServiceParam(name = "pInstNo") String pInstNo) {
		List<Record> records = new ArrayList<Record> ();
			Record record = new Record();
			record.put("instNo",11005293);
			record.put("instCaption", "总行");
			records.add(record);
		return records;
	}


}
