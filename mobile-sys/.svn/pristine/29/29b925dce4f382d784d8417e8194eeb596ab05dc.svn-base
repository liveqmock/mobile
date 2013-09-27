/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.AccInf;
import com.gsoft.phone.core.dao.AccInfDao;

@Repository("AccInfDao")
public class AccInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements AccInfDao<T, PK>{
	public Class<AccInf> getModelClazz(){
		return AccInf.class;
	}
}