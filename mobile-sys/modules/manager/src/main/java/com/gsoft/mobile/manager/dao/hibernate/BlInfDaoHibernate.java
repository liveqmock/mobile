/**
 * 代码声明
 */
package com.gsoft.mobile.manager.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.mobile.manager.dao.BlInfDao;
import com.gsoft.mobile.manager.entity.BlInf;

@Repository("BlInfDao")
public class BlInfDaoHibernate<T, PK extends Serializable> extends
		BaseDaoHibernate<T, PK> implements BlInfDao<T, PK> {
	public Class<BlInf> getModelClazz() {
		return BlInf.class;
	}

	public String getClientInfByBankcardNum(final String bankcardNum) {

		return this.getHibernateTemplate().execute(
				new HibernateCallback<String>() {
					@Override
					public String doInHibernate(Session session)
							throws HibernateException, SQLException {
						String queryString = "SELECT client_id FROM mobile_cli_acc_rel where BANKCARD_NUM=?";
						SQLQuery query = session.createSQLQuery(queryString);
						query.addScalar("client_id", Hibernate.STRING);
						query.setString(0, bankcardNum);

						Object clientId = query.uniqueResult();

						return clientId != null ? clientId.toString() : null;
					}

				});
	}
}