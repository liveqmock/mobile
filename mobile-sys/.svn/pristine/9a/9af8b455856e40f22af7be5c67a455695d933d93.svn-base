/**
 * 代码声明
 */
package com.gsoft.mobile.param.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.param.dao.ParaInfDao;
import com.gsoft.mobile.param.entity.ParaInf;

@Repository("ParaInfDao")
public class ParaInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements ParaInfDao<T, PK>{
	public Class<ParaInf> getModelClazz(){
		return ParaInf.class;
	}
}