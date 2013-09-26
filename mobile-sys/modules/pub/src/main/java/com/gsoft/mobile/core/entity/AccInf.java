/**
 *
 */
package com.gsoft.mobile.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 账户信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_ACC_INF")
public class AccInf implements Domain{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2291640251567398986L;

	@Id
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BANKCARD_NUM")
	@Length(max=20)
	private String bankcardNum;//卡号
	
	
	@Column(name = "CLIENT_ID")
	@Length(max=32)
	private String clientId;//客户编号
	
	
	@Column(name = "ACCOUNT_TYPE")
	@Length(max=2)
	private String accountType;//账户类型
	
	
	@Column(name = "CURR_TYPE")
	@Length(max=2)
	private String currType;//币种


	@Column(name = "BALANCE")
	@Length(max=10)
	private String balance;//余额
	
	
	@Column(name = "RATE")
	@Length(max=6)
	private String rate;//利率

	@Column(name = "ACCOUNT_STATE")
	@Length(max=2)
	private String accountState;//账户状态

	
	@Column(name = "AFFORD_CARD_INST")
	@Length(max=64)
	private String affordCardInst;//发卡机构

	
	@Column(name = "CLIENT_TYPE")
	@Length(max=2)
	private String clientType;//客户类型
	
	
	@Column(name = "LASTDATETIME")
	@Length(max=10)
	private String lastDateTime;//最近更新日期
	
	
	@Column(name = "QUERY_PWD")
	@Length(max=8)
	private String queryPwd;//查询密码
	
	@Column(name = "WITHDRAW_PWD")
	@Length(max=8)
	private String withdrawPwd;//取款密码

	
	
	public String getQueryPwd() {
		return queryPwd;
	}

	public void setQueryPwd(String queryPwd) {
		this.queryPwd = queryPwd;
	}

	public String getWithdrawPwd() {
		return withdrawPwd;
	}

	public void setWithdrawPwd(String withdrawPwd) {
		this.withdrawPwd = withdrawPwd;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getLastDateTime() {
		return lastDateTime;
	}

	public void setLastDateTime(String lastDateTime) {
		this.lastDateTime = lastDateTime;
	}

	public String getBankcardNum(){
		return this.bankcardNum;
	}
	
	public void setBankcardNum(String bankcardNum){
		this.bankcardNum = bankcardNum;
	}
	public String getBalance(){
		return this.balance;
	}
	
	public void setBalance(String balance){
		this.balance = balance;
	}
	public String getAffordCardInst(){
		return this.affordCardInst;
	}
	
	public void setAffordCardInst(String affordCardInst){
		this.affordCardInst = affordCardInst;
	}
	public String getAccountState(){
		return this.accountState;
	}
	
	public void setAccountState(String accountState){
		this.accountState = accountState;
	}
	public String getCurrType(){
		return this.currType;
	}
	
	public void setCurrType(String currType){
		this.currType = currType;
	}
	public String getAccountType(){
		return this.accountType;
	}
	
	public void setAccountType(String accountType){
		this.accountType = accountType;
	}
	public String getRate(){
		return this.rate;
	}
	
	public void setRate(String rate){
		this.rate = rate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountState == null) ? 0 : accountState.hashCode());
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result
				+ ((affordCardInst == null) ? 0 : affordCardInst.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((bankcardNum == null) ? 0 : bankcardNum.hashCode());
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result
				+ ((clientType == null) ? 0 : clientType.hashCode());
		result = prime * result
				+ ((currType == null) ? 0 : currType.hashCode());
		result = prime * result
				+ ((lastDateTime == null) ? 0 : lastDateTime.hashCode());
		result = prime * result
				+ ((queryPwd == null) ? 0 : queryPwd.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result
				+ ((withdrawPwd == null) ? 0 : withdrawPwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccInf other = (AccInf) obj;
		if (accountState == null) {
			if (other.accountState != null)
				return false;
		} else if (!accountState.equals(other.accountState))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (affordCardInst == null) {
			if (other.affordCardInst != null)
				return false;
		} else if (!affordCardInst.equals(other.affordCardInst))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (bankcardNum == null) {
			if (other.bankcardNum != null)
				return false;
		} else if (!bankcardNum.equals(other.bankcardNum))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientType == null) {
			if (other.clientType != null)
				return false;
		} else if (!clientType.equals(other.clientType))
			return false;
		if (currType == null) {
			if (other.currType != null)
				return false;
		} else if (!currType.equals(other.currType))
			return false;
		if (lastDateTime == null) {
			if (other.lastDateTime != null)
				return false;
		} else if (!lastDateTime.equals(other.lastDateTime))
			return false;
		if (queryPwd == null) {
			if (other.queryPwd != null)
				return false;
		} else if (!queryPwd.equals(other.queryPwd))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (withdrawPwd == null) {
			if (other.withdrawPwd != null)
				return false;
		} else if (!withdrawPwd.equals(other.withdrawPwd))
			return false;
		return true;
	}

	public String toString(){
		return super.toString();
	}
}

