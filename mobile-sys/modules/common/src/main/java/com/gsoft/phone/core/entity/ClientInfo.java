/**
 *
 */
package com.gsoft.phone.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 客户信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_CLIENT_INFO")
public class ClientInfo implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2159700946023949993L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	
	@Column(name = "CLIENT_ID")
	private String clientId;//客户ID

	@Column(name = "MER_KIND")
	@Length(max=2)
	private String merKind;//商户种类

	@Column(name = "TERMINAL_MODEL")
	@Length(max=4)
	private String terminalModel;//终端型号

	@Column(name = "MER_ADDRESS")
	@Length(max=50)
	private String merAddress;//商户地址

	@Column(name = "CLIENT_STATE")
	@Length(max=2)
	private String clientState;//客户状态

	@Column(name = "CONTACT_NUM")
	@Length(max=11)
	private String contactNum;//联系电话

	@Column(name = "MER_TYPE")
	@Length(max=2)
	private String merType;//商户类型

	@Column(name = "BELONG_INST")
	@Length(max=10)
	private String belongInst;//所属机构

	@Column(name = "TERMINAL_STATE")
	@Length(max=2)
	private String terminalState;//终端状态

	@Column(name = "LOGIN_PWD")
	@Length(max=6)
	private String loginPwd;//登陆密码

	@Column(name = "CLIENT_NAME")
	@Length(max=30)
	private String clientName;//客户姓名

	@Column(name = "CONTACTS")
	@Length(max=20)
	private String contacts;//联系人

	@Column(name = "TERMINAL_BRAND")
	@Length(max=4)
	private String terminalBrand;//终端品牌
	
	public String getClientId(){
		return this.clientId;
	}
	
	public void setClientId(String clientId){
		this.clientId = clientId;
	}
	public String getMerKind(){
		return this.merKind;
	}
	
	public void setMerKind(String merKind){
		this.merKind = merKind;
	}
	public String getTerminalModel(){
		return this.terminalModel;
	}
	
	public void setTerminalModel(String terminalModel){
		this.terminalModel = terminalModel;
	}
	public String getMerAddress(){
		return this.merAddress;
	}
	
	public void setMerAddress(String merAddress){
		this.merAddress = merAddress;
	}
	public String getClientState(){
		return this.clientState;
	}
	
	public void setClientState(String clientState){
		this.clientState = clientState;
	}
	public String getContactNum(){
		return this.contactNum;
	}
	
	public void setContactNum(String contactNum){
		this.contactNum = contactNum;
	}
	public String getMerType(){
		return this.merType;
	}
	
	public void setMerType(String merType){
		this.merType = merType;
	}
	public String getBelongInst(){
		return this.belongInst;
	}
	
	public void setBelongInst(String belongInst){
		this.belongInst = belongInst;
	}
	public String getTerminalState(){
		return this.terminalState;
	}
	
	public void setTerminalState(String terminalState){
		this.terminalState = terminalState;
	}
	public String getLoginPwd(){
		return this.loginPwd;
	}
	
	public void setLoginPwd(String loginPwd){
		this.loginPwd = loginPwd;
	}
	public String getClientName(){
		return this.clientName;
	}
	
	public void setClientName(String clientName){
		this.clientName = clientName;
	}
	public String getContacts(){
		return this.contacts;
	}
	
	public void setContacts(String contacts){
		this.contacts = contacts;
	}
	public String getTerminalBrand(){
		return this.terminalBrand;
	}
	
	public void setTerminalBrand(String terminalBrand){
		this.terminalBrand = terminalBrand;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((merKind == null) ? 0 : merKind.hashCode());
		result = prime * result + ((terminalModel == null) ? 0 : terminalModel.hashCode());
		result = prime * result + ((merAddress == null) ? 0 : merAddress.hashCode());
		result = prime * result + ((clientState == null) ? 0 : clientState.hashCode());
		result = prime * result + ((contactNum == null) ? 0 : contactNum.hashCode());
		result = prime * result + ((merType == null) ? 0 : merType.hashCode());
		result = prime * result + ((belongInst == null) ? 0 : belongInst.hashCode());
		result = prime * result + ((terminalState == null) ? 0 : terminalState.hashCode());
		result = prime * result + ((loginPwd == null) ? 0 : loginPwd.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((terminalBrand == null) ? 0 : terminalBrand.hashCode());
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
		final ClientInfo other = (ClientInfo) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (merKind == null) {
			if (other.merKind != null)
				return false;
		} else if (!merKind.equals(other.merKind))
			return false;
		if (terminalModel == null) {
			if (other.terminalModel != null)
				return false;
		} else if (!terminalModel.equals(other.terminalModel))
			return false;
		if (merAddress == null) {
			if (other.merAddress != null)
				return false;
		} else if (!merAddress.equals(other.merAddress))
			return false;
		if (clientState == null) {
			if (other.clientState != null)
				return false;
		} else if (!clientState.equals(other.clientState))
			return false;
		if (contactNum == null) {
			if (other.contactNum != null)
				return false;
		} else if (!contactNum.equals(other.contactNum))
			return false;
		if (merType == null) {
			if (other.merType != null)
				return false;
		} else if (!merType.equals(other.merType))
			return false;
		if (belongInst == null) {
			if (other.belongInst != null)
				return false;
		} else if (!belongInst.equals(other.belongInst))
			return false;
		if (terminalState == null) {
			if (other.terminalState != null)
				return false;
		} else if (!terminalState.equals(other.terminalState))
			return false;
		if (loginPwd == null) {
			if (other.loginPwd != null)
				return false;
		} else if (!loginPwd.equals(other.loginPwd))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (terminalBrand == null) {
			if (other.terminalBrand != null)
				return false;
		} else if (!terminalBrand.equals(other.terminalBrand))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}