/**
 *
 */
package com.gsoft.mobile.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 终端信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_TER_INF")
public class TerInf implements Domain{
	
	//private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2071889271563135042L;

//	@Id @GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Id
	@Column(name = "TERMINAL_NO")
	private String terminalNo;//终端编号

	@Column(name = "PHONE_NUM")
	@Length(max=11)
	private String phoneNum;//手机号码

	@Column(name = "TERMINAL_BRAND")
	@Length(max=10)
	private String terminalBrand;//终端品牌

	@Column(name = "BELONG_INST")
	@Length(max=10)
	private String belongInst;//所属机构

//	@Column(name = "BELONG_MERCHANT")
//	@Length(max=32)
//	private String belongMerchant;//所属商户

	@Column(name = "TERMINAL_STATE")
	@Length(max=2)
	private String terminalState;//终端状态

	@Column(name = "TERMINAL_MODEL")
	@Length(max=10)
	private String terminalModel;//终端型号

	@Column(name = "CURR_POSITION")
	@Length(max=100)
	private String currPosition;//当前位置

	@Column(name = "MERCHANT_NO")
	private String merchantNo;//商户编号
	
	public String getTerminalNo(){
		return this.terminalNo;
	}
	
	public void setTerminalNo(String terminalNo){
		this.terminalNo = terminalNo;
	}
	public String getPhoneNum(){
		return this.phoneNum;
	}
	
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}
	public String getTerminalBrand(){
		return this.terminalBrand;
	}
	
	public void setTerminalBrand(String terminalBrand){
		this.terminalBrand = terminalBrand;
	}
	public String getBelongInst(){
		return this.belongInst;
	}
	
	public void setBelongInst(String belongInst){
		this.belongInst = belongInst;
	}
//	public String getBelongMerchant(){
//		return this.belongMerchant;
//	}
//	
//	public void setBelongMerchant(String belongMerchant){
//		this.belongMerchant = belongMerchant;
//	}
	public String getTerminalState(){
		return this.terminalState;
	}
	
	public void setTerminalState(String terminalState){
		this.terminalState = terminalState;
	}
	public String getTerminalModel(){
		return this.terminalModel;
	}
	
	public void setTerminalModel(String terminalModel){
		this.terminalModel = terminalModel;
	}
	public String getCurrPosition(){
		return this.currPosition;
	}
	
	public void setCurrPosition(String currPosition){
		this.currPosition = currPosition;
	}
	public String getMerchantNo(){
		return this.merchantNo;
	}
	
	public void setMerchantNo(String merchantNo){
		this.merchantNo = merchantNo;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((terminalNo == null) ? 0 : terminalNo.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((terminalBrand == null) ? 0 : terminalBrand.hashCode());
		result = prime * result + ((belongInst == null) ? 0 : belongInst.hashCode());
//		result = prime * result + ((belongMerchant == null) ? 0 : belongMerchant.hashCode());
		result = prime * result + ((terminalState == null) ? 0 : terminalState.hashCode());
		result = prime * result + ((terminalModel == null) ? 0 : terminalModel.hashCode());
		result = prime * result + ((currPosition == null) ? 0 : currPosition.hashCode());
		result = prime * result + ((merchantNo == null) ? 0 : merchantNo.hashCode());
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
		final TerInf other = (TerInf) obj;
		if (terminalNo == null) {
			if (other.terminalNo != null)
				return false;
		} else if (!terminalNo.equals(other.terminalNo))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (terminalBrand == null) {
			if (other.terminalBrand != null)
				return false;
		} else if (!terminalBrand.equals(other.terminalBrand))
			return false;
		if (belongInst == null) {
			if (other.belongInst != null)
				return false;
		} else if (!belongInst.equals(other.belongInst))
			return false;
//		if (belongMerchant == null) {
//			if (other.belongMerchant != null)
//				return false;
//		} else if (!belongMerchant.equals(other.belongMerchant))
//			return false;
		if (terminalState == null) {
			if (other.terminalState != null)
				return false;
		} else if (!terminalState.equals(other.terminalState))
			return false;
		if (terminalModel == null) {
			if (other.terminalModel != null)
				return false;
		} else if (!terminalModel.equals(other.terminalModel))
			return false;
		if (currPosition == null) {
			if (other.currPosition != null)
				return false;
		} else if (!currPosition.equals(other.currPosition))
			return false;
		if (merchantNo == null) {
			if (other.merchantNo != null)
				return false;
		} else if (!merchantNo.equals(other.merchantNo))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}