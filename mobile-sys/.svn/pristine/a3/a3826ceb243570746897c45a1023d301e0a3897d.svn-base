/**
 * 代码声明
 */
package com.gsoft.mobile.manager.dao.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.mobile.manager.dao.DayTemInfDao;
import com.gsoft.mobile.manager.entity.DayTemInf;



@Repository("DayTemInfDao")
public class DayTemInfDaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements DayTemInfDao<T, PK>{
	public Class<DayTemInf> getModelClazz(){
		return DayTemInf.class;
	}
	
}