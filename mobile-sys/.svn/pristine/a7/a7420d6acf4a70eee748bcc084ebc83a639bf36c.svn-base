/**
 * 代码声明
 */
package com.gsoft.mobile.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.core.entity.MerInf;
import com.gsoft.mobile.core.dao.MerInfDao;

@Repository("MerInfDao")
public class MerInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements MerInfDao<T, PK>{
	public Class<MerInf> getModelClazz(){
		return MerInf.class;
	}
}