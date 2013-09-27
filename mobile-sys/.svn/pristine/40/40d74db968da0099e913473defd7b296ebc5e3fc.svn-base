/**
 * 代码声明
 */
package com.gsoft.mobile.param.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.param.dao.ParaValInfDao;
import com.gsoft.mobile.param.entity.ParaValInf;

@Repository("ParaValInfDao")
public class ParaValInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements ParaValInfDao<T, PK>{
	public Class<ParaValInf> getModelClazz(){
		return ParaValInf.class;
	}
}