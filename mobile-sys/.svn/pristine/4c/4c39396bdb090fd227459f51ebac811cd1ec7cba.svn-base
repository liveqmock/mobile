/**
 * 代码声明
 */
package com.gsoft.mobile.manager.dao.hibernate;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.mobile.manager.dao.TerInfDao;
import com.gsoft.mobile.manager.entity.TerInf;

@Repository("TerInfDao")
public class TerInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements TerInfDao<T, PK>{
	public Class<TerInf> getModelClazz(){
		return TerInf.class;
	}
}