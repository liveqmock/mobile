/**
 *
 */
package com.gsoft.phone.core.entity;

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
	private static final long serialVersionUID = 1472870514466466983L;

	@Column(name = "ACCOUNT_STATE")
	@Length(max=2)
	private String accountState;//账户状态

	@Column(name = "BANKCARD_NUM")
	@Length(max=19)
	private String bankcardNum;//卡号

	@Column(name = "BALANCE")
	@Length(max=8)
	private String balance;//余额
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ACCOUNT_ID")
	private String accountId;//账户编号

	@Column(name = "RATE")
	@Length(max=8)
	private String rate;//利率

	@Column(name = "CURR_TYPE")
	@Length(max=2)
	private String currType;//币种

	@Column(name = "ACCOUNT_TYPE")
	@Length(max=2)
	private String accountType;//账户类型
	
	public String getAccountState(){
		return this.accountState;
	}
	
	public void setAccountState(String accountState){
		this.accountState = accountState;
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
	public String getAccountId(){
		return this.accountId;
	}
	
	public void setAccountId(String accountId){
		this.accountId = accountId;
	}
	public String getRate(){
		return this.rate;
	}
	
	public void setRate(String rate){
		this.rate = rate;
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountState == null) ? 0 : accountState.hashCode());
		result = prime * result + ((bankcardNum == null) ? 0 : bankcardNum.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((currType == null) ? 0 : currType.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
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
		final AccInf other = (AccInf) obj;
		if (accountState == null) {
			if (other.accountState != null)
				return false;
		} else if (!accountState.equals(other.accountState))
			return false;
		if (bankcardNum == null) {
			if (other.bankcardNum != null)
				return false;
		} else if (!bankcardNum.equals(other.bankcardNum))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (currType == null) {
			if (other.currType != null)
				return false;
		} else if (!currType.equals(other.currType))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}