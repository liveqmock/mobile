/**
 * 代码声明
 */
package com.gsoft.mobile.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.core.entity.SignInf;
import com.gsoft.mobile.core.dao.SignInfDao;

@Repository("SignInfDao")
public class SignInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements SignInfDao<T, PK>{
	public Class<SignInf> getModelClazz(){
		return SignInf.class;
	}
}