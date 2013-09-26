/**
 *
 */
package com.gsoft.phone.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 客户登陆/退出登记簿
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_LOG_QUI_REG")
public class LogQuiReg implements Domain{
	
	//private static final long serialVersionUID = 1L;
	

	@Column(name = "CURR_POSITION")
	@Length(max=100)
	private String currPosition;//当前位置

	@Column(name = "OPERATE_DATE")
	@Length(max=10)
	private String operateDate;//操作日期

	@Column(name = "TERMINAL_STATE")
	@Length(max=2)
	private String terminalState;//终端状态

	@Column(name = "MER_ADDRESS")
	@Length(max=50)
	private String merAddress;//商户地址

	@Column(name = "OPERATE_TYPE")
	@Length(max=2)
	private String operateType;//操作类型
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "LOGIN_QUIT_NO")
	private String loginQuitNo;//客户登陆/退出登记簿编号

	@Column(name = "TERMINAL_BRAND")
	@Length(max=4)
	private String terminalBrand;//终端品牌

	@Column(name = "TERMINAL_MODEL")
	@Length(max=4)
	private String terminalModel;//终端型号

	@Column(name = "OPERATE_TIME")
	@Length(max=10)
	private String operateTime;//操作时间

	@Column(name = "BELONG_MERCHANT")
	@Length(max=20)
	private String belongMerchant;//所属商户

	@Column(name = "CLIENT_ID")
	private String clientId;//客户ID
	
	public String getCurrPosition(){
		return this.currPosition;
	}
	
	public void setCurrPosition(String currPosition){
		this.currPosition = currPosition;
	}
	public String getOperateDate(){
		return this.operateDate;
	}
	
	public void setOperateDate(String operateDate){
		this.operateDate = operateDate;
	}
	public String getTerminalState(){
		return this.terminalState;
	}
	
	public void setTerminalState(String terminalState){
		this.terminalState = terminalState;
	}
	public String getMerAddress(){
		return this.merAddress;
	}
	
	public void setMerAddress(String merAddress){
		this.merAddress = merAddress;
	}
	public String getOperateType(){
		return this.operateType;
	}
	
	public void setOperateType(String operateType){
		this.operateType = operateType;
	}
	public String getLoginQuitNo(){
		return this.loginQuitNo;
	}
	
	public void setLoginQuitNo(String loginQuitNo){
		this.loginQuitNo = loginQuitNo;
	}
	public String getTerminalBrand(){
		return this.terminalBrand;
	}
	
	public void setTerminalBrand(String terminalBrand){
		this.terminalBrand = terminalBrand;
	}
	public String getTerminalModel(){
		return this.terminalModel;
	}
	
	public void setTerminalModel(String terminalModel){
		this.terminalModel = terminalModel;
	}
	public String getOperateTime(){
		return this.operateTime;
	}
	
	public void setOperateTime(String operateTime){
		this.operateTime = operateTime;
	}
	public String getBelongMerchant(){
		return this.belongMerchant;
	}
	
	public void setBelongMerchant(String belongMerchant){
		this.belongMerchant = belongMerchant;
	}
	public String getClientId(){
		return this.clientId;
	}
	
	public void setClientId(String clientId){
		this.clientId = clientId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currPosition == null) ? 0 : currPosition.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((terminalState == null) ? 0 : terminalState.hashCode());
		result = prime * result + ((merAddress == null) ? 0 : merAddress.hashCode());
		result = prime * result + ((operateType == null) ? 0 : operateType.hashCode());
		result = prime * result + ((loginQuitNo == null) ? 0 : loginQuitNo.hashCode());
		result = prime * result + ((terminalBrand == null) ? 0 : terminalBrand.hashCode());
		result = prime * result + ((terminalModel == null) ? 0 : terminalModel.hashCode());
		result = prime * result + ((operateTime == null) ? 0 : operateTime.hashCode());
		result = prime * result + ((belongMerchant == null) ? 0 : belongMerchant.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
		final LogQuiReg other = (LogQuiReg) obj;
		if (currPosition == null) {
			if (other.currPosition != null)
				return false;
		} else if (!currPosition.equals(other.currPosition))
			return false;
		if (operateDate == null) {
			if (other.operateDate != null)
				return false;
		} else if (!operateDate.equals(other.operateDate))
			return false;
		if (terminalState == null) {
			if (other.terminalState != null)
				return false;
		} else if (!terminalState.equals(other.terminalState))
			return false;
		if (merAddress == null) {
			if (other.merAddress != null)
				return false;
		} else if (!merAddress.equals(other.merAddress))
			return false;
		if (operateType == null) {
			if (other.operateType != null)
				return false;
		} else if (!operateType.equals(other.operateType))
			return false;
		if (loginQuitNo == null) {
			if (other.loginQuitNo != null)
				return false;
		} else if (!loginQuitNo.equals(other.loginQuitNo))
			return false;
		if (terminalBrand == null) {
			if (other.terminalBrand != null)
				return false;
		} else if (!terminalBrand.equals(other.terminalBrand))
			return false;
		if (terminalModel == null) {
			if (other.terminalModel != null)
				return false;
		} else if (!terminalModel.equals(other.terminalModel))
			return false;
		if (operateTime == null) {
			if (other.operateTime != null)
				return false;
		} else if (!operateTime.equals(other.operateTime))
			return false;
		if (belongMerchant == null) {
			if (other.belongMerchant != null)
				return false;
		} else if (!belongMerchant.equals(other.belongMerchant))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}