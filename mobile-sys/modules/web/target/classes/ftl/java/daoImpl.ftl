/**
 * 代码声明
 */
package ${package}.hibernate;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import ${modelPath}.${modelClassName};
import ${daoClassPath};

@Repository("${modelClassName}Dao")
public class ${modelClassName}DaoHibernate<T, PK extends Serializable> extends 
		BaseDaoHibernate<T, PK> implements ${modelClassName}Dao<T, PK>{
	public Class<${modelClassName}> getModelClazz(){
		return ${modelClassName}.class;
	}
}