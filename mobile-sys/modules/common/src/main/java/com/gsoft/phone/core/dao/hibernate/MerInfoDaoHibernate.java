/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.MerInfo;
import com.gsoft.phone.core.dao.MerInfoDao;

@Repository("MerInfoDao")
public class MerInfoDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements MerInfoDao<T, PK>{
	public Class<MerInfo> getModelClazz(){
		return MerInfo.class;
	}
}