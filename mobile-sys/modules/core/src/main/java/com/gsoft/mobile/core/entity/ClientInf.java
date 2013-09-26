/**
 *
 */
package com.gsoft.mobile.core.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.gsoft.framework.core.dataobj.Domain;

/**
 * 实体: 客户信息表
 * 
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_CLIENT_INF")
public class ClientInf implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5114321383137814453L;

	@Column(name = "CLIENT_STATE")
	@Length(max = 2)
	private String clientState;// 客户状态

	@Column(name = "CONTACTS")
	@Length(max = 64)
	private String contacts;// 联系人

	@Column(name = "DOCUMENT_NUM")
	@Length(max = 20)
	private String documentNum;// 证件号码

	@Column(name = "TERMINAL_MODEL")
	@Length(max = 10)
	private String terminalModel;// 终端型号

	@Column(name = "TERMINAL_STATE")
	@Length(max = 2)
	private String terminalState;// 终端状态

	@Column(name = "CLIENT_KIND")
	@Length(max = 2)
	private String clientKind;// 客户种类

	@Column(name = "DOCUMENT_TYPE")
	@Length(max = 2)
	private String documentType;// 证件类型

	@Column(name = "TERMINAL_BRAND")
	@Length(max = 10)
	private String terminalBrand;// 终端品牌

	@Column(name = "CLIENT_TYPE")
	@Length(max = 2)
	private String clientType;// 客户类型

	@Column(name = "LOGIN_PWD")
	@Length(max = 3)
	private String loginPwd;// 登陆密码

	@Column(name = "CLIENT_NAME")
	@Length(max = 30)
	private String clientName;// 客户姓名

	@Column(name = "CONTACT_NUM")
	@Length(max = 11)
	private String contactNum;// 联系电话

	@Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name="system-uuid", strategy = "uuid.hex")
//	@GeneratedValue(generator = "businessKeyGenerator")
//	@GenericGenerator(name = "businessKeyGenerator", strategy = "com.gsoft.framework.core.orm.hibernate.SeqTableGenerator")
	@Column(name = "CLIENT_ID")
	private String clientId;// 客户ID

	@Column(name = "MAIN_ACCOUNT")
	@Length(max = 20)
	private String mainAccount;// 主账号

	@Column(name = "CLIENT_ADDRESS")
	@Length(max = 64)
	private String clientAddress;// 客户地址

	@OneToMany(targetEntity = AccInf.class, cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	private List<AccInf> accInfs;

	public String getClientState() {
		return this.clientState;
	}

	public List<AccInf> getAccInfs() {
		return accInfs;
	}

	public void setAccInfs(List<AccInf> accInfs) {
		this.accInfs = accInfs;
	}

	public void setClientState(String clientState) {
		this.clientState = clientState;
	}

	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getDocumentNum() {
		return this.documentNum;
	}

	public void setDocumentNum(String documentNum) {
		this.documentNum = documentNum;
	}

	public String getTerminalModel() {
		return this.terminalModel;
	}

	public void setTerminalModel(String terminalModel) {
		this.terminalModel = terminalModel;
	}

	public String getTerminalState() {
		return this.terminalState;
	}

	public void setTerminalState(String terminalState) {
		this.terminalState = terminalState;
	}

	public String getClientKind() {
		return this.clientKind;
	}

	public void setClientKind(String clientKind) {
		this.clientKind = clientKind;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getTerminalBrand() {
		return this.terminalBrand;
	}

	public void setTerminalBrand(String terminalBrand) {
		this.terminalBrand = terminalBrand;
	}

	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getMainAccount() {
		return this.mainAccount;
	}

	public void setMainAccount(String mainAccount) {
		this.mainAccount = mainAccount;
	}

	public String getClientAddress() {
		return this.clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientState == null) ? 0 : clientState.hashCode());
		result = prime * result
				+ ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result
				+ ((documentNum == null) ? 0 : documentNum.hashCode());
		result = prime * result
				+ ((terminalModel == null) ? 0 : terminalModel.hashCode());
		result = prime * result
				+ ((terminalState == null) ? 0 : terminalState.hashCode());
		result = prime * result
				+ ((clientKind == null) ? 0 : clientKind.hashCode());
		result = prime * result
				+ ((documentType == null) ? 0 : documentType.hashCode());
		result = prime * result
				+ ((terminalBrand == null) ? 0 : terminalBrand.hashCode());
		result = prime * result
				+ ((clientType == null) ? 0 : clientType.hashCode());
		result = prime * result
				+ ((loginPwd == null) ? 0 : loginPwd.hashCode());
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result
				+ ((contactNum == null) ? 0 : contactNum.hashCode());
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result
				+ ((mainAccount == null) ? 0 : mainAccount.hashCode());
		result = prime * result
				+ ((clientAddress == null) ? 0 : clientAddress.hashCode());
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
		final ClientInf other = (ClientInf) obj;
		if (clientState == null) {
			if (other.clientState != null)
				return false;
		} else if (!clientState.equals(other.clientState))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (documentNum == null) {
			if (other.documentNum != null)
				return false;
		} else if (!documentNum.equals(other.documentNum))
			return false;
		if (terminalModel == null) {
			if (other.terminalModel != null)
				return false;
		} else if (!terminalModel.equals(other.terminalModel))
			return false;
		if (terminalState == null) {
			if (other.terminalState != null)
				return false;
		} else if (!terminalState.equals(other.terminalState))
			return false;
		if (clientKind == null) {
			if (other.clientKind != null)
				return false;
		} else if (!clientKind.equals(other.clientKind))
			return false;
		if (documentType == null) {
			if (other.documentType != null)
				return false;
		} else if (!documentType.equals(other.documentType))
			return false;
		if (terminalBrand == null) {
			if (other.terminalBrand != null)
				return false;
		} else if (!terminalBrand.equals(other.terminalBrand))
			return false;
		if (clientType == null) {
			if (other.clientType != null)
				return false;
		} else if (!clientType.equals(other.clientType))
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
		if (contactNum == null) {
			if (other.contactNum != null)
				return false;
		} else if (!contactNum.equals(other.contactNum))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (mainAccount == null) {
			if (other.mainAccount != null)
				return false;
		} else if (!mainAccount.equals(other.mainAccount))
			return false;
		if (clientAddress == null) {
			if (other.clientAddress != null)
				return false;
		} else if (!clientAddress.equals(other.clientAddress))
			return false;
		return true;
	}

	public String toString() {
		return super.toString();
	}
}
