/**
 *
 */
package com.gsoft.mobile.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 签约信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_SIGN_INF")
public class SignInf implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5251593242993686266L;

	@Column(name = "DOCUMENT_TYPE")
	@Length(max=2)
	private String documentType;//证件类型

	@Column(name = "PHONE_NUM")
	@Length(max=11)
	private String phoneNum;//手机号码

	@Column(name = "BANKCARD_NUM")
	@Length(max=20)
	private String bankcardNum;//卡号

	@Column(name = "SIGN_DATE")
	@Length(max=10)
	private String signDate;//签约日期

	@Column(name = "DOCUMENT_NUM")
	@Length(max=20)
	private String documentNum;//证件号码

	@Column(name = "AFFORD_CARD_INST")
	@Length(max=64)
	private String affordCardInst;//发卡机构

	@Column(name = "DAILY_PAY_LIMIT")
	@Length(max=12)
	private String dailyPayLimit;//每日交易限额

	@Column(name = "LOGOUT_DATE")
	@Length(max=10)
	private String logoutDate;//注销日期

	@Column(name = "SINGLE_PAY_LIMIT")
	@Length(max=12)
	private String singlePayLimit;//单笔交易限额

	@Column(name = "CLIENT_STATE")
	@Length(max=2)
	private String clientState;//客户状态

	@Column(name = "WITHDRAW_PWD")
	@Length(max=8)
	private String withdrawPwd;//取款密码

	@Column(name = "SIGN_BUSINESS")
	@Length(max=2)
	private String signBusiness;//签约业务
	
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "SING_NO")
	private String singNo;//签约编号
	
	public String getDocumentType(){
		return this.documentType;
	}
	
	public void setDocumentType(String documentType){
		this.documentType = documentType;
	}
	public String getPhoneNum(){
		return this.phoneNum;
	}
	
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}
	public String getBankcardNum(){
		return this.bankcardNum;
	}
	
	public void setBankcardNum(String bankcardNum){
		this.bankcardNum = bankcardNum;
	}
	public String getSignDate(){
		return this.signDate;
	}
	
	public void setSignDate(String signDate){
		this.signDate = signDate;
	}
	public String getDocumentNum(){
		return this.documentNum;
	}
	
	public void setDocumentNum(String documentNum){
		this.documentNum = documentNum;
	}
	public String getAffordCardInst(){
		return this.affordCardInst;
	}
	
	public void setAffordCardInst(String affordCardInst){
		this.affordCardInst = affordCardInst;
	}
	public String getDailyPayLimit(){
		return this.dailyPayLimit;
	}
	
	public void setDailyPayLimit(String dailyPayLimit){
		this.dailyPayLimit = dailyPayLimit;
	}
	public String getLogoutDate(){
		return this.logoutDate;
	}
	
	public void setLogoutDate(String logoutDate){
		this.logoutDate = logoutDate;
	}
	public String getSinglePayLimit(){
		return this.singlePayLimit;
	}
	
	public void setSinglePayLimit(String singlePayLimit){
		this.singlePayLimit = singlePayLimit;
	}
	public String getClientState(){
		return this.clientState;
	}
	
	public void setClientState(String clientState){
		this.clientState = clientState;
	}
	public String getWithdrawPwd(){
		return this.withdrawPwd;
	}
	
	public void setWithdrawPwd(String withdrawPwd){
		this.withdrawPwd = withdrawPwd;
	}
	public String getSignBusiness(){
		return this.signBusiness;
	}
	
	public void setSignBusiness(String signBusiness){
		this.signBusiness = signBusiness;
	}
	public String getSingNo(){
		return this.singNo;
	}
	
	public void setSingNo(String singNo){
		this.singNo = singNo;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentType == null) ? 0 : documentType.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((bankcardNum == null) ? 0 : bankcardNum.hashCode());
		result = prime * result + ((signDate == null) ? 0 : signDate.hashCode());
		result = prime * result + ((documentNum == null) ? 0 : documentNum.hashCode());
		result = prime * result + ((affordCardInst == null) ? 0 : affordCardInst.hashCode());
		result = prime * result + ((dailyPayLimit == null) ? 0 : dailyPayLimit.hashCode());
		result = prime * result + ((logoutDate == null) ? 0 : logoutDate.hashCode());
		result = prime * result + ((singlePayLimit == null) ? 0 : singlePayLimit.hashCode());
		result = prime * result + ((clientState == null) ? 0 : clientState.hashCode());
		result = prime * result + ((withdrawPwd == null) ? 0 : withdrawPwd.hashCode());
		result = prime * result + ((signBusiness == null) ? 0 : signBusiness.hashCode());
		result = prime * result + ((singNo == null) ? 0 : singNo.hashCode());
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
		final SignInf other = (SignInf) obj;
		if (documentType == null) {
			if (other.documentType != null)
				return false;
		} else if (!documentType.equals(other.documentType))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (bankcardNum == null) {
			if (other.bankcardNum != null)
				return false;
		} else if (!bankcardNum.equals(other.bankcardNum))
			return false;
		if (signDate == null) {
			if (other.signDate != null)
				return false;
		} else if (!signDate.equals(other.signDate))
			return false;
		if (documentNum == null) {
			if (other.documentNum != null)
				return false;
		} else if (!documentNum.equals(other.documentNum))
			return false;
		if (affordCardInst == null) {
			if (other.affordCardInst != null)
				return false;
		} else if (!affordCardInst.equals(other.affordCardInst))
			return false;
		if (dailyPayLimit == null) {
			if (other.dailyPayLimit != null)
				return false;
		} else if (!dailyPayLimit.equals(other.dailyPayLimit))
			return false;
		if (logoutDate == null) {
			if (other.logoutDate != null)
				return false;
		} else if (!logoutDate.equals(other.logoutDate))
			return false;
		if (singlePayLimit == null) {
			if (other.singlePayLimit != null)
				return false;
		} else if (!singlePayLimit.equals(other.singlePayLimit))
			return false;
		if (clientState == null) {
			if (other.clientState != null)
				return false;
		} else if (!clientState.equals(other.clientState))
			return false;
		if (withdrawPwd == null) {
			if (other.withdrawPwd != null)
				return false;
		} else if (!withdrawPwd.equals(other.withdrawPwd))
			return false;
		if (signBusiness == null) {
			if (other.signBusiness != null)
				return false;
		} else if (!signBusiness.equals(other.signBusiness))
			return false;
		if (singNo == null) {
			if (other.singNo != null)
				return false;
		} else if (!singNo.equals(other.singNo))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}