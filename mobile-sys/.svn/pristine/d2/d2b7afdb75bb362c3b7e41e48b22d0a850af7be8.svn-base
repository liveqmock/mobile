/**
 *
 */
package com.gsoft.phone.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 客户与账户对应关系表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_CLI_ACC_REL")
public class CliAccRel implements Domain{
	
	//private static final long serialVersionUID = 1L;
	

	@Column(name = "ACCOUNT_ID")
	private String accountId;//账户编号

	@Column(name = "CLIENT_ID")
	private String clientId;//客户ID

	@Column(name = "LASTDATETIME")
	@Length(max=10)
	private String lastdatetime;//最新更新日期
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "CLIENT_ACCOUNT_NO")
	private String clientAccountNo;//客户与账户对应关系编号

	@Column(name = "CLIENT_TYPE")
	@Length(max=2)
	private String clientType;//客户类型

	@Column(name = "VALIDMARK")
	@Length(max=2)
	private String validmark;//无效标记
	
	public String getAccountId(){
		return this.accountId;
	}
	
	public void setAccountId(String accountId){
		this.accountId = accountId;
	}
	public String getClientId(){
		return this.clientId;
	}
	
	public void setClientId(String clientId){
		this.clientId = clientId;
	}
	public String getLastdatetime(){
		return this.lastdatetime;
	}
	
	public void setLastdatetime(String lastdatetime){
		this.lastdatetime = lastdatetime;
	}
	public String getClientAccountNo(){
		return this.clientAccountNo;
	}
	
	public void setClientAccountNo(String clientAccountNo){
		this.clientAccountNo = clientAccountNo;
	}
	public String getClientType(){
		return this.clientType;
	}
	
	public void setClientType(String clientType){
		this.clientType = clientType;
	}
	public String getValidmark(){
		return this.validmark;
	}
	
	public void setValidmark(String validmark){
		this.validmark = validmark;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((lastdatetime == null) ? 0 : lastdatetime.hashCode());
		result = prime * result + ((clientAccountNo == null) ? 0 : clientAccountNo.hashCode());
		result = prime * result + ((clientType == null) ? 0 : clientType.hashCode());
		result = prime * result + ((validmark == null) ? 0 : validmark.hashCode());
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
		final CliAccRel other = (CliAccRel) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (lastdatetime == null) {
			if (other.lastdatetime != null)
				return false;
		} else if (!lastdatetime.equals(other.lastdatetime))
			return false;
		if (clientAccountNo == null) {
			if (other.clientAccountNo != null)
				return false;
		} else if (!clientAccountNo.equals(other.clientAccountNo))
			return false;
		if (clientType == null) {
			if (other.clientType != null)
				return false;
		} else if (!clientType.equals(other.clientType))
			return false;
		if (validmark == null) {
			if (other.validmark != null)
				return false;
		} else if (!validmark.equals(other.validmark))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}