/**
 *
 */
package com.gsoft.mobile.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 当日交易流水表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_DAY_TRA_INF")
public class DayTraInf implements Domain{
	
	//private static final long serialVersionUID = 1L;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404025693546935580L;

	@Column(name = "TRAN_TIME")
	@Length(max=8)
	private String tranTime;//交易时间

	@Column(name = "TRAN_STATE")
	@Length(max=2)
	private String tranState;//交易状态

	@Column(name = "BELONG_INST")
	@Length(max=15) String belongInst;//所属机构号
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TRADE_SEQNO")
	private String tradeSeqno;//交易流水号

	@Column(name = "TERMINAL_NO")
	@Length(max=15)
	private String terminalNo;//商户终端编号

	@Column(name = "TRAN_REASON")
	@Length(max=50)
	private String tranReason;//交易事由

	@Column(name = "TRAN_POSITION")
	@Length(max=60)
	private String tranPosition;//交易位置

	@Column(name = "CURR_TYPE")
	@Length(max=3)
	private String currType;//交易币种

	@Column(name = "TRADE_AMOUNT")
	@Length(max=12)
	private String tradeAmount;//交易金额

	@Column(name = "IC_TAC")
	@Length(max=8)
	private String icTac;//IC卡交易验证码

	@Column(name = "CHANNEL")
	@Length(max=2) String channel;//渠道

	@Column(name = "RECEIVE_CARD")
	@Length(max=19)
	private String receiveCard;//收款方卡号

	@Column(name = "TERM_SEQ")
	@Length(max=20)
	private String termSeq;//终端流水号
	
	@Column(name = "PLAT_SEQ")
	@Length(max=20)
	private String platSeq;//平台流水号
	
	@Column(name = "REMARK")
	@Length(max=128)
	private String remark;//备注
	
	@Column(name = "SERVICE_CHARGE")
	@Length(max=10)
	private String serviceCharge;//手续费

	public String getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPlatSeq() {
		return platSeq;
	}

	public void setPlatSeq(String platSeq) {
		this.platSeq = platSeq;
	}

	@Column(name = "TRAN_CODE")
	@Length(max=10)
	private String tranCode;//交易代码

	@Column(name = "TRAN_DATE")
	@Length(max=10)
	private String tranDate;//交易日期

	@Column(name = "PAY_CARD")
	@Length(max=19)
	private String payCard;//付款方卡号

	@Column(name = "TLR")
	@Length(max=1024)
	private String tlr;//操作员

	@Column(name = "SYS_SEQNO")
	@Length(max=15)
	private String sysSeqno;//系统流水号

	@Column(name = "RESP_CODE")
	@Length(max=10)
	private String respCode;//响应码
	
	public String getTranTime(){
		return this.tranTime;
	}
	
	public void setTranTime(String tranTime){
		this.tranTime = tranTime;
	}
	public String getTranState(){
		return this.tranState;
	}
	
	public void setTranState(String tranState){
		this.tranState = tranState;
	}
	public String getBelongInst(){
		return this.belongInst;
	}
	
	public void setBelongInst(String belongInst){
		this.belongInst = belongInst;
	}
	public String getTradeSeqno(){
		return this.tradeSeqno;
	}
	
	public void setTradeSeqno(String tradeSeqno){
		this.tradeSeqno = tradeSeqno;
	}
	public String getTerminalNo(){
		return this.terminalNo;
	}
	
	public void setTerminalNo(String terminalNo){
		this.terminalNo = terminalNo;
	}
	public String getTranReason(){
		return this.tranReason;
	}
	
	public void setTranReason(String tranReason){
		this.tranReason = tranReason;
	}
	public String getTranPosition(){
		return this.tranPosition;
	}
	
	public void setTranPosition(String tranPosition){
		this.tranPosition = tranPosition;
	}
	public String getCurrType(){
		return this.currType;
	}
	
	public void setCurrType(String currType){
		this.currType = currType;
	}
	public String getTradeAmount(){
		return this.tradeAmount;
	}
	
	public void setTradeAmount(String tradeAmount){
		this.tradeAmount = tradeAmount;
	}
	public String getIcTac(){
		return this.icTac;
	}
	
	public void setIcTac(String icTac){
		this.icTac = icTac;
	}
	public String getChannel(){
		return this.channel;
	}
	
	public void setChannel(String channel){
		this.channel = channel;
	}
	public String getReceiveCard(){
		return this.receiveCard;
	}
	
	public void setReceiveCard(String receiveCard){
		this.receiveCard = receiveCard;
	}
	public String getTermSeq(){
		return this.termSeq;
	}
	
	public void setTermSeq(String termSeq){
		this.termSeq = termSeq;
	}
	public String getTranCode(){
		return this.tranCode;
	}
	
	public void setTranCode(String tranCode){
		this.tranCode = tranCode;
	}
	public String getTranDate(){
		return this.tranDate;
	}
	
	public void setTranDate(String tranDate){
		this.tranDate = tranDate;
	}
	public String getPayCard(){
		return this.payCard;
	}
	
	public void setPayCard(String payCard){
		this.payCard = payCard;
	}
	public String getTlr(){
		return this.tlr;
	}
	
	public void setTlr(String tlr){
		this.tlr = tlr;
	}
	public String getSysSeqno(){
		return this.sysSeqno;
	}
	
	public void setSysSeqno(String sysSeqno){
		this.sysSeqno = sysSeqno;
	}
	public String getRespCode(){
		return this.respCode;
	}
	
	public void setRespCode(String respCode){
		this.respCode = respCode;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((belongInst == null) ? 0 : belongInst.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result
				+ ((currType == null) ? 0 : currType.hashCode());
		result = prime * result + ((icTac == null) ? 0 : icTac.hashCode());
		result = prime * result + ((payCard == null) ? 0 : payCard.hashCode());
		result = prime * result + ((platSeq == null) ? 0 : platSeq.hashCode());
		result = prime * result
				+ ((receiveCard == null) ? 0 : receiveCard.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((respCode == null) ? 0 : respCode.hashCode());
		result = prime * result
				+ ((serviceCharge == null) ? 0 : serviceCharge.hashCode());
		result = prime * result
				+ ((sysSeqno == null) ? 0 : sysSeqno.hashCode());
		result = prime * result + ((termSeq == null) ? 0 : termSeq.hashCode());
		result = prime * result
				+ ((terminalNo == null) ? 0 : terminalNo.hashCode());
		result = prime * result + ((tlr == null) ? 0 : tlr.hashCode());
		result = prime * result
				+ ((tradeAmount == null) ? 0 : tradeAmount.hashCode());
		result = prime * result
				+ ((tradeSeqno == null) ? 0 : tradeSeqno.hashCode());
		result = prime * result
				+ ((tranCode == null) ? 0 : tranCode.hashCode());
		result = prime * result
				+ ((tranDate == null) ? 0 : tranDate.hashCode());
		result = prime * result
				+ ((tranPosition == null) ? 0 : tranPosition.hashCode());
		result = prime * result
				+ ((tranReason == null) ? 0 : tranReason.hashCode());
		result = prime * result
				+ ((tranState == null) ? 0 : tranState.hashCode());
		result = prime * result
				+ ((tranTime == null) ? 0 : tranTime.hashCode());
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
		DayTraInf other = (DayTraInf) obj;
		if (belongInst == null) {
			if (other.belongInst != null)
				return false;
		} else if (!belongInst.equals(other.belongInst))
			return false;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (currType == null) {
			if (other.currType != null)
				return false;
		} else if (!currType.equals(other.currType))
			return false;
		if (icTac == null) {
			if (other.icTac != null)
				return false;
		} else if (!icTac.equals(other.icTac))
			return false;
		if (payCard == null) {
			if (other.payCard != null)
				return false;
		} else if (!payCard.equals(other.payCard))
			return false;
		if (platSeq == null) {
			if (other.platSeq != null)
				return false;
		} else if (!platSeq.equals(other.platSeq))
			return false;
		if (receiveCard == null) {
			if (other.receiveCard != null)
				return false;
		} else if (!receiveCard.equals(other.receiveCard))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (respCode == null) {
			if (other.respCode != null)
				return false;
		} else if (!respCode.equals(other.respCode))
			return false;
		if (serviceCharge == null) {
			if (other.serviceCharge != null)
				return false;
		} else if (!serviceCharge.equals(other.serviceCharge))
			return false;
		if (sysSeqno == null) {
			if (other.sysSeqno != null)
				return false;
		} else if (!sysSeqno.equals(other.sysSeqno))
			return false;
		if (termSeq == null) {
			if (other.termSeq != null)
				return false;
		} else if (!termSeq.equals(other.termSeq))
			return false;
		if (terminalNo == null) {
			if (other.terminalNo != null)
				return false;
		} else if (!terminalNo.equals(other.terminalNo))
			return false;
		if (tlr == null) {
			if (other.tlr != null)
				return false;
		} else if (!tlr.equals(other.tlr))
			return false;
		if (tradeAmount == null) {
			if (other.tradeAmount != null)
				return false;
		} else if (!tradeAmount.equals(other.tradeAmount))
			return false;
		if (tradeSeqno == null) {
			if (other.tradeSeqno != null)
				return false;
		} else if (!tradeSeqno.equals(other.tradeSeqno))
			return false;
		if (tranCode == null) {
			if (other.tranCode != null)
				return false;
		} else if (!tranCode.equals(other.tranCode))
			return false;
		if (tranDate == null) {
			if (other.tranDate != null)
				return false;
		} else if (!tranDate.equals(other.tranDate))
			return false;
		if (tranPosition == null) {
			if (other.tranPosition != null)
				return false;
		} else if (!tranPosition.equals(other.tranPosition))
			return false;
		if (tranReason == null) {
			if (other.tranReason != null)
				return false;
		} else if (!tranReason.equals(other.tranReason))
			return false;
		if (tranState == null) {
			if (other.tranState != null)
				return false;
		} else if (!tranState.equals(other.tranState))
			return false;
		if (tranTime == null) {
			if (other.tranTime != null)
				return false;
		} else if (!tranTime.equals(other.tranTime))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DayTraInf [tranTime=" + tranTime + ", tranState=" + tranState
				+ ", belongInst=" + belongInst + ", tradeSeqno=" + tradeSeqno
				+ ", terminalNo=" + terminalNo + ", tranReason=" + tranReason
				+ ", tranPosition=" + tranPosition + ", currType=" + currType
				+ ", tradeAmount=" + tradeAmount + ", icTac=" + icTac
				+ ", channel=" + channel + ", receiveCard=" + receiveCard
				+ ", termSeq=" + termSeq + ", platSeq=" + platSeq + ", remark="
				+ remark + ", serviceCharge=" + serviceCharge + ", tranCode="
				+ tranCode + ", tranDate=" + tranDate + ", payCard=" + payCard
				+ ", tlr=" + tlr + ", sysSeqno=" + sysSeqno + ", respCode="
				+ respCode + "]";
	}
}