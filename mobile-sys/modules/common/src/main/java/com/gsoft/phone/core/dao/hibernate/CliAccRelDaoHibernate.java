/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.CliAccRel;
import com.gsoft.phone.core.dao.CliAccRelDao;

@Repository("CliAccRelDao")
public class CliAccRelDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements CliAccRelDao<T, PK>{
	public Class<CliAccRel> getModelClazz(){
		return CliAccRel.class;
	}
}