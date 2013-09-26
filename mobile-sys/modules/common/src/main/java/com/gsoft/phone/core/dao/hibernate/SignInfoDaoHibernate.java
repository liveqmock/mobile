/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.SignInfo;
import com.gsoft.phone.core.dao.SignInfoDao;

@Repository("SignInfoDao")
public class SignInfoDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements SignInfoDao<T, PK>{
	public Class<SignInfo> getModelClazz(){
		return SignInfo.class;
	}
}