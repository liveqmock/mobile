/**
 *
 */
package com.gsoft.mobile.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.Length;

import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.mobile.core.entity.AccInf;
/**
 * 实体: 黑名单信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_BL_INF")
public class BlInf implements Domain{	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4763117767838545363L;

	@Id
	@Column(name = "BANKCARD_NUM")
	@Length(max=20)
	private String bankcardNum;//卡号

	@Column(name = "ADD_QUIT_TYPE")
	@Length(max=4)
	private String addQuitType;//添加/撤出类型
	
	@Column(name = "CARD_TYPE")
	@Length(max=3)
	private String cardType;//卡类型

	@Column(name = "CARD_STATE")
	@Length(max=2)
	private String cardState;//卡状态

	@Column(name = "EFFECT_DATE")
	@Length(max=10)
	private String effectDate;//生效日期

	@Column(name = "DOCUMENT_NUM")
	@Length(max=20)
	private String documentNum;//证件号码

	@Column(name = "ADD_QUIT_REASON")
	@Length(max=6)
	private String addQuitReason;//添加/撤出原因

	@Column(name = "CARDHOLDER")
	@Length(max=30)
	private String cardholder;//持卡人姓名

	@Column(name = "DOCUMENT_TYPE")
	@Length(max=2)
	private String documentType;//证件类型

	@Column(name = "BALCKLIST_STATE")
	@Length(max=2)
	private String balcklistState;//黑名单状态
	
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private AccInf accInf;
//	
//	
//	public AccInf getAccInf() {
//		return accInf;
//	}
//
//	public void setAccInf(AccInf accInf) {
//		this.accInf = accInf;
//	}

	public String getBankcardNum(){
		return this.bankcardNum;
	}
	
	public void setBankcardNum(String bankcardNum){
		this.bankcardNum = bankcardNum;
	}
	public String getAddQuitType(){
		return this.addQuitType;
	}
	
	public void setAddQuitType(String addQuitType){
		this.addQuitType = addQuitType;
	}
	
	
	
//	public String getBlacklistNo(){
//		return this.blacklistNo;
//	}
//	
//	public void setBlacklistNo(String blacklistNo){
//		this.blacklistNo = blacklistNo;
//	}
	public String getCardType(){
		return this.cardType;
	}
	
	public void setCardType(String cardType){
		this.cardType = cardType;
	}
	public String getCardState(){
		return this.cardState;
	}
	
	public void setCardState(String cardState){
		this.cardState = cardState;
	}
	public String getEffectDate(){
		return this.effectDate;
	}
	
	public void setEffectDate(String effectDate){
		this.effectDate = effectDate;
	}
	public String getDocumentNum(){
		return this.documentNum;
	}
	
	public void setDocumentNum(String documentNum){
		this.documentNum = documentNum;
	}
	public String getAddQuitReason(){
		return this.addQuitReason;
	}
	
	public void setAddQuitReason(String addQuitReason){
		this.addQuitReason = addQuitReason;
	}
	public String getCardholder(){
		return this.cardholder;
	}
	
	public void setCardholder(String cardholder){
		this.cardholder = cardholder;
	}
	public String getDocumentType(){
		return this.documentType;
	}
	
	public void setDocumentType(String documentType){
		this.documentType = documentType;
	}
	public String getBalcklistState(){
		return this.balcklistState;
	}
	
	public void setBalcklistState(String balcklistState){
		this.balcklistState = balcklistState;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankcardNum == null) ? 0 : bankcardNum.hashCode());
		result = prime * result + ((addQuitType == null) ? 0 : addQuitType.hashCode());
//		result = prime * result + ((blacklistNo == null) ? 0 : blacklistNo.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((cardState == null) ? 0 : cardState.hashCode());
		result = prime * result + ((effectDate == null) ? 0 : effectDate.hashCode());
		result = prime * result + ((documentNum == null) ? 0 : documentNum.hashCode());
		result = prime * result + ((addQuitReason == null) ? 0 : addQuitReason.hashCode());
		result = prime * result + ((cardholder == null) ? 0 : cardholder.hashCode());
		result = prime * result + ((documentType == null) ? 0 : documentType.hashCode());
		result = prime * result + ((balcklistState == null) ? 0 : balcklistState.hashCode());
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
		final BlInf other = (BlInf) obj;
		if (bankcardNum == null) {
			if (other.bankcardNum != null)
				return false;
		} else if (!bankcardNum.equals(other.bankcardNum))
			return false;
		if (addQuitType == null) {
			if (other.addQuitType != null)
				return false;
		} else if (!addQuitType.equals(other.addQuitType))
			return false;
//		if (blacklistNo == null) {
//			if (other.blacklistNo != null)
//				return false;
//		} else if (!blacklistNo.equals(other.blacklistNo))
//			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (cardState == null) {
			if (other.cardState != null)
				return false;
		} else if (!cardState.equals(other.cardState))
			return false;
		if (effectDate == null) {
			if (other.effectDate != null)
				return false;
		} else if (!effectDate.equals(other.effectDate))
			return false;
		if (documentNum == null) {
			if (other.documentNum != null)
				return false;
		} else if (!documentNum.equals(other.documentNum))
			return false;
		if (addQuitReason == null) {
			if (other.addQuitReason != null)
				return false;
		} else if (!addQuitReason.equals(other.addQuitReason))
			return false;
		if (cardholder == null) {
			if (other.cardholder != null)
				return false;
		} else if (!cardholder.equals(other.cardholder))
			return false;
		if (documentType == null) {
			if (other.documentType != null)
				return false;
		} else if (!documentType.equals(other.documentType))
			return false;
		if (balcklistState == null) {
			if (other.balcklistState != null)
				return false;
		} else if (!balcklistState.equals(other.balcklistState))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}