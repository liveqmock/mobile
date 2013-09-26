/**
 * 代码声明
 */
package com.gsoft.mobile.trades.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.trades.dao.DayTraInfDao;
import com.gsoft.mobile.trades.entity.DayTraInf;

@Repository("DayTraInfDao")
public class DayTraInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements DayTraInfDao<T, PK>{
	public Class<DayTraInf> getModelClazz(){
		return DayTraInf.class;
	}
}