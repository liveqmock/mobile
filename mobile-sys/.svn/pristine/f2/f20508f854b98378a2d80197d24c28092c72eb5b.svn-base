/**
 * 代码声明
 */
package com.gsoft.mobile.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.core.dao.DayTraInfDao;
import com.gsoft.mobile.core.entity.DayTraInf;

@Repository("DayTraInfDao")
public class DayTraInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements DayTraInfDao<T, PK>{
	public Class<DayTraInf> getModelClazz(){
		return DayTraInf.class;
	}
}