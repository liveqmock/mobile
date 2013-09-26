/**
 * 代码声明
 */
package com.gsoft.mobile.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.core.entity.LogQuiReg;
import com.gsoft.mobile.core.dao.LogQuiRegDao;

@Repository("LogQuiRegDao")
public class LogQuiRegDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements LogQuiRegDao<T, PK>{
	public Class<LogQuiReg> getModelClazz(){
		return LogQuiReg.class;
	}
}