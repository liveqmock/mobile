/**
 *
 */
package com.gsoft.phone.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商户信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_MER_INFO")
public class MerInfo implements Domain{
	
	//private static final long serialVersionUID = 1L;
	

	@Column(name = "SERVICE_CHARGE_TYPE")
	@Length(max=2)
	private String serviceChargeType;//手续费类型

	@Column(name = "MER_KIND")
	@Length(max=2)
	private String merKind;//商户种类

	@Column(name = "MONTH_AMOUNT")
	@Length(max=8)
	private String monthAmount;//每月金额

	@Column(name = "MER_STATE")
	@Length(max=2)
	private String merState;//商户状态

	@Column(name = "SERVICE_CHARGE_RATE")
	@Length(max=8)
	private String serviceChargeRate;//手续费率

	@Column(name = "SETTLE_ACCOUNT_CYCLE")
	@Length(max=8)
	private String settleAccountCycle;//结算周期

	@Column(name = "MER_TYPE")
	@Length(max=2)
	private String merType;//商户类型

	@Column(name = "MER_NAME")
	@Length(max=30)
	private String merName;//商户全称

	@Column(name = "SINGLE_PAY_LIMIT")
	@Length(max=12)
	private String singlePayLimit;//单笔交易限额

	@Column(name = "MER_ADDRESS")
	@Length(max=50)
	private String merAddress;//商户地址

	@Column(name = "CONTACT_NUM")
	@Length(max=11)
	private String contactNum;//联系电话

	@Column(name = "BELONG_INST")
	@Length(max=10)
	private String belongInst;//所属机构

	@Column(name = "LOGOUT_DATE")
	@Length(max=10)
	private String logoutDate;//注销日期

	@Column(name = "DAILY_PAY_LIMIT")
	@Length(max=12)
	private String dailyPayLimit;//每日交易限额

	@Column(name = "SIGN_DATE")
	@Length(max=10)
	private String signDate;//签约日期
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MERCHANT_NO")
	private String merchantNo;//商户编号

	@Column(name = "MER_OPENBANK")
	@Length(max=30)
	private String merOpenbank;//商户开户行

	@Column(name = "CONTACTS")
	@Length(max=20)
	private String contacts;//联系人

	@Column(name = "MER_CARDNUM")
	@Length(max=19)
	private String merCardnum;//商户帐号
	
	public String getServiceChargeType(){
		return this.serviceChargeType;
	}
	
	public void setServiceChargeType(String serviceChargeType){
		this.serviceChargeType = serviceChargeType;
	}
	public String getMerKind(){
		return this.merKind;
	}
	
	public void setMerKind(String merKind){
		this.merKind = merKind;
	}
	public String getMonthAmount(){
		return this.monthAmount;
	}
	
	public void setMonthAmount(String monthAmount){
		this.monthAmount = monthAmount;
	}
	public String getMerState(){
		return this.merState;
	}
	
	public void setMerState(String merState){
		this.merState = merState;
	}
	public String getServiceChargeRate(){
		return this.serviceChargeRate;
	}
	
	public void setServiceChargeRate(String serviceChargeRate){
		this.serviceChargeRate = serviceChargeRate;
	}
	public String getSettleAccountCycle(){
		return this.settleAccountCycle;
	}
	
	public void setSettleAccountCycle(String settleAccountCycle){
		this.settleAccountCycle = settleAccountCycle;
	}
	public String getMerType(){
		return this.merType;
	}
	
	public void setMerType(String merType){
		this.merType = merType;
	}
	public String getMerName(){
		return this.merName;
	}
	
	public void setMerName(String merName){
		this.merName = merName;
	}
	public String getSinglePayLimit(){
		return this.singlePayLimit;
	}
	
	public void setSinglePayLimit(String singlePayLimit){
		this.singlePayLimit = singlePayLimit;
	}
	public String getMerAddress(){
		return this.merAddress;
	}
	
	public void setMerAddress(String merAddress){
		this.merAddress = merAddress;
	}
	public String getContactNum(){
		return this.contactNum;
	}
	
	public void setContactNum(String contactNum){
		this.contactNum = contactNum;
	}
	public String getBelongInst(){
		return this.belongInst;
	}
	
	public void setBelongInst(String belongInst){
		this.belongInst = belongInst;
	}
	public String getLogoutDate(){
		return this.logoutDate;
	}
	
	public void setLogoutDate(String logoutDate){
		this.logoutDate = logoutDate;
	}
	public String getDailyPayLimit(){
		return this.dailyPayLimit;
	}
	
	public void setDailyPayLimit(String dailyPayLimit){
		this.dailyPayLimit = dailyPayLimit;
	}
	public String getSignDate(){
		return this.signDate;
	}
	
	public void setSignDate(String signDate){
		this.signDate = signDate;
	}
	public String getMerchantNo(){
		return this.merchantNo;
	}
	
	public void setMerchantNo(String merchantNo){
		this.merchantNo = merchantNo;
	}
	public String getMerOpenbank(){
		return this.merOpenbank;
	}
	
	public void setMerOpenbank(String merOpenbank){
		this.merOpenbank = merOpenbank;
	}
	public String getContacts(){
		return this.contacts;
	}
	
	public void setContacts(String contacts){
		this.contacts = contacts;
	}
	public String getMerCardnum(){
		return this.merCardnum;
	}
	
	public void setMerCardnum(String merCardnum){
		this.merCardnum = merCardnum;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceChargeType == null) ? 0 : serviceChargeType.hashCode());
		result = prime * result + ((merKind == null) ? 0 : merKind.hashCode());
		result = prime * result + ((monthAmount == null) ? 0 : monthAmount.hashCode());
		result = prime * result + ((merState == null) ? 0 : merState.hashCode());
		result = prime * result + ((serviceChargeRate == null) ? 0 : serviceChargeRate.hashCode());
		result = prime * result + ((settleAccountCycle == null) ? 0 : settleAccountCycle.hashCode());
		result = prime * result + ((merType == null) ? 0 : merType.hashCode());
		result = prime * result + ((merName == null) ? 0 : merName.hashCode());
		result = prime * result + ((singlePayLimit == null) ? 0 : singlePayLimit.hashCode());
		result = prime * result + ((merAddress == null) ? 0 : merAddress.hashCode());
		result = prime * result + ((contactNum == null) ? 0 : contactNum.hashCode());
		result = prime * result + ((belongInst == null) ? 0 : belongInst.hashCode());
		result = prime * result + ((logoutDate == null) ? 0 : logoutDate.hashCode());
		result = prime * result + ((dailyPayLimit == null) ? 0 : dailyPayLimit.hashCode());
		result = prime * result + ((signDate == null) ? 0 : signDate.hashCode());
		result = prime * result + ((merchantNo == null) ? 0 : merchantNo.hashCode());
		result = prime * result + ((merOpenbank == null) ? 0 : merOpenbank.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((merCardnum == null) ? 0 : merCardnum.hashCode());
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
		final MerInfo other = (MerInfo) obj;
		if (serviceChargeType == null) {
			if (other.serviceChargeType != null)
				return false;
		} else if (!serviceChargeType.equals(other.serviceChargeType))
			return false;
		if (merKind == null) {
			if (other.merKind != null)
				return false;
		} else if (!merKind.equals(other.merKind))
			return false;
		if (monthAmount == null) {
			if (other.monthAmount != null)
				return false;
		} else if (!monthAmount.equals(other.monthAmount))
			return false;
		if (merState == null) {
			if (other.merState != null)
				return false;
		} else if (!merState.equals(other.merState))
			return false;
		if (serviceChargeRate == null) {
			if (other.serviceChargeRate != null)
				return false;
		} else if (!serviceChargeRate.equals(other.serviceChargeRate))
			return false;
		if (settleAccountCycle == null) {
			if (other.settleAccountCycle != null)
				return false;
		} else if (!settleAccountCycle.equals(other.settleAccountCycle))
			return false;
		if (merType == null) {
			if (other.merType != null)
				return false;
		} else if (!merType.equals(other.merType))
			return false;
		if (merName == null) {
			if (other.merName != null)
				return false;
		} else if (!merName.equals(other.merName))
			return false;
		if (singlePayLimit == null) {
			if (other.singlePayLimit != null)
				return false;
		} else if (!singlePayLimit.equals(other.singlePayLimit))
			return false;
		if (merAddress == null) {
			if (other.merAddress != null)
				return false;
		} else if (!merAddress.equals(other.merAddress))
			return false;
		if (contactNum == null) {
			if (other.contactNum != null)
				return false;
		} else if (!contactNum.equals(other.contactNum))
			return false;
		if (belongInst == null) {
			if (other.belongInst != null)
				return false;
		} else if (!belongInst.equals(other.belongInst))
			return false;
		if (logoutDate == null) {
			if (other.logoutDate != null)
				return false;
		} else if (!logoutDate.equals(other.logoutDate))
			return false;
		if (dailyPayLimit == null) {
			if (other.dailyPayLimit != null)
				return false;
		} else if (!dailyPayLimit.equals(other.dailyPayLimit))
			return false;
		if (signDate == null) {
			if (other.signDate != null)
				return false;
		} else if (!signDate.equals(other.signDate))
			return false;
		if (merchantNo == null) {
			if (other.merchantNo != null)
				return false;
		} else if (!merchantNo.equals(other.merchantNo))
			return false;
		if (merOpenbank == null) {
			if (other.merOpenbank != null)
				return false;
		} else if (!merOpenbank.equals(other.merOpenbank))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (merCardnum == null) {
			if (other.merCardnum != null)
				return false;
		} else if (!merCardnum.equals(other.merCardnum))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}