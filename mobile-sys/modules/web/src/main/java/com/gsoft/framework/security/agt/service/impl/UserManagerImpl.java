/**
 * 代码声明
 */
package com.gsoft.framework.security.agt.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.menu.IMenu;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.security.LoginAccountProvider;
import com.gsoft.framework.security.PrincipalConfig;
import com.gsoft.framework.security.agt.dao.UserConfigItemDao;
import com.gsoft.framework.security.agt.dao.UserDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.entity.UserAccount;
import com.gsoft.framework.security.agt.entity.UserConfigItem;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.security.fuc.dao.RoleDao;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.security.fuc.service.MenuManager;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.util.StringUtils;

@Service("userManager")
@Transactional
public class UserManagerImpl extends BaseManagerImpl implements UserManager,LoginAccountProvider<UserAccount>{
	@Autowired
	private UserDao<User,String> userDao;
	
	@Autowired
	private RoleDao<Role,String> roleDao;
	
	@Autowired
	private UserConfigItemDao<UserConfigItem,String> userConfigItemDao;//用户配置项
	
	@Autowired
	private MenuManager menuManager;
	
    /**
     * 查询列表
     */
    public List<User> getUsers() throws BusException{
    	return userDao.getAll();
    }
     /**
     * 条件查询列表
     */
    
    @EsbServiceMapping
    public List<User> getUsers(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return userDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public User getUser(String id){
    	return userDao.get(id);
    }
	
    @EsbServiceMapping
	public PagerRecords getPagerUsers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=User.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders) throws BusException{
		PagerRecords pagerRecords = userDao.findByPager(pager, conditions, orders);
		System.out.println("**********getPagerUsers*******");
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public User saveUser(User o) throws BusException{
    	String userId = o.getUserId();
    	boolean isUpdate = StringUtils.isNotEmpty(userId);
    	if(isUpdate){//修改
    		User user = userDao.get(userId);
    		Assert.notNull(user,"user is null!");
    		o.setPassword(user.getPassword());
    	}else{//新增
    		o.setPassword(PasswordUtils.md5Password("123456"));
    	}
    	return userDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeUser(String id) throws BusException{
    	userDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeUsers(String[] ids) throws BusException{
   		for(String id:ids){
    		removeUser(id);
    	}
    }
    
    public boolean exsitUser(String id) throws BusException{
		return userDao.exists(id);
	}
    
    public boolean exsitUser(String propertyName,Object value) throws BusException{
		return userDao.exists(propertyName,value);
	}
    
	@Override
	public UserAccount getAccount(String username) {
		//根据登录名查找用户
		User user = userDao.getObjectByUniqueProperty("loginName", username);
		//未查询到用户直接返回
		if(user==null)return null;
		//设置用户配置项属性
		user.setPrincipalConfig(queryPrincipalConfig(user.getUserId()));
		//创建登录账户
		UserAccount loginUser = new UserAccount(user);
		
		return loginUser;
	}
	/* (non-Javadoc)
	 * @see org.youi.common.security.LoginAccountProvider#getProviderMenus()
	 */
	@Override
	public List<IMenu> getProviderMenus() {
		Collection<Order> orders = new ArrayList<Order>();
		orders.add(ConditionUtils.getOrder("menuNum", true));
		List<Menu> menus = menuManager.getMenus(null,orders );
		List<IMenu> providerMenus = new ArrayList<IMenu>();
		for(Menu menu:menus){
			providerMenus.add(menu);
		}
		return providerMenus;
	}
	/* (non-Javadoc)
	 * @see org.youi.common.security.LoginAccountProvider#getAccountMenus(org.youi.common.security.LoginAccount)
	 */
	@Override
	public List<String> getAccountMenus(UserAccount account) {
		return roleDao.getMenuIdsByRoles(account.getRoles());
	}

	/*
	 * 修改用户密码
	 */
	public void modifyPassword(String username,String password,
			String confirmPassword,
			String oldPassword) throws BusException{
		Assert.notNull(oldPassword,"旧密码不能为空！");
		Assert.notNull(password,"新密码不能为空！");
		Assert.notNull(confirmPassword,"确认密码不能为空！");
		
		User user = null;
		try {
			user = userDao.getObjectByUniqueProperty("loginName", username);
		} catch (Exception e) {
			throw new BusException("查找用户["+username+"]出错！");
		}
		Assert.notNull(user, "未找到用户！");
		//旧密码不符
		if(!PasswordUtils.md5Password(oldPassword).equals(user.getPassword())){
			throw new BusException("请输入正确的旧密码！");
		}
		//两次输入的密码不一致
		if(!password.equals(confirmPassword)){
			throw new BusException("两次输入的密码不一致！");
		}
		
		user.setPassword(PasswordUtils.md5Password(password));
		this.saveUser(user);
	}
	/*
	 *重置密码 
	 */
	public void resetPassword(String id)  throws BusException{
		User user = getUser(id);
		Assert.notNull(user, "未找到用户！");
		user.setPassword(PasswordUtils.md5Password("123456"));
		this.saveUser(user);
	}
	
	/**
	 * 
	 * 根据用户主键（userId）获取登录用户配置
	 * @param userId 用户主键
	 * @return
	 */
	private PrincipalConfig queryPrincipalConfig(String userId){
		//创建登录用户配置项
		PrincipalConfig principalConfig = new PrincipalConfig();//用户配置项
		//根据用户ID查询用户配置项
		List<UserConfigItem> configItems = 
			userConfigItemDao.getList("userId", userId);
		for(UserConfigItem configItem:configItems){
			if(StringUtils.isNotEmpty(configItem.getName())){
				principalConfig.put(configItem.getName(), configItem.getValue());
			}
		}
		return principalConfig;
	}
}
