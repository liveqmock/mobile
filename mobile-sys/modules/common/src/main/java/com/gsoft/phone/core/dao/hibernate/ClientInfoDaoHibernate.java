/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.ClientInfo;
import com.gsoft.phone.core.dao.ClientInfoDao;

@Repository("ClientInfoDao")
public class ClientInfoDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements ClientInfoDao<T, PK>{
	public Class<ClientInfo> getModelClazz(){
		return ClientInfo.class;
	}
}