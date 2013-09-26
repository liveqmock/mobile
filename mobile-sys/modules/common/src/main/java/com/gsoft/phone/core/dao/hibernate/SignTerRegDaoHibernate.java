/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.SignTerReg;
import com.gsoft.phone.core.dao.SignTerRegDao;

@Repository("SignTerRegDao")
public class SignTerRegDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements SignTerRegDao<T, PK>{
	public Class<SignTerReg> getModelClazz(){
		return SignTerReg.class;
	}
}