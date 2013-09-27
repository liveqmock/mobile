/**
 * 代码声明
 */
package com.gsoft.phone.core.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.gsoft.phone.core.entity.CommInf;
import com.gsoft.phone.core.dao.CommInfDao;

@Repository("CommInfDao")
public class CommInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements CommInfDao<T, PK>{
	public Class<CommInf> getModelClazz(){
		return CommInf.class;
	}
}