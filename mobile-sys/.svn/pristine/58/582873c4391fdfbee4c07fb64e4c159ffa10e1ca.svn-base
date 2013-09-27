/**
 * 代码声明
 */
package com.gsoft.mobile.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.mobile.core.entity.SignTerReg;
import com.gsoft.mobile.core.dao.SignTerRegDao;

@Repository("SignTerRegDao")
public class SignTerRegDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements SignTerRegDao<T, PK>{
	public Class<SignTerReg> getModelClazz(){
		return SignTerReg.class;
	}
}