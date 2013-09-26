package com.gsoft.mobile.manager.entity;

import com.gsoft.framework.core.dataobj.Domain;

public class QrCodePayInf implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5139200102117597340L;
	private String tradeAmount;//交易金额
	private String tranReason;//交易事由
	private String payCard;//付款方卡号
	private String receiveCard;//收款方卡号
	private String password;//支付密码
	
	private String tranDate;//交易日期
	private String tranTime;//交易时间
	
	private String receiveSerial;//收款序号
	
	private String respCode;//响应吗
	private String payTerminalNo;//终端编号
	private String receiveTerminalNo;//终端编号
	private String tranPosition;//交易位置
	private String currType;//交易币种
	private String icTac;//IC卡交易验证码
	private String channel;//渠道
	private String tlr;//操作员
	private String belongInst;//所属机构号
	private String termSeq;//终端流水号
	private String sysSeqno;//系统流水号
	private String remark;//备注
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTranPosition() {
		return tranPosition;
	}
	public void setTranPosition(String tranPosition) {
		this.tranPosition = tranPosition;
	}
	public String getCurrType() {
		return currType;
	}
	public void setCurrType(String currType) {
		this.currType = currType;
	}
	public String getIcTac() {
		return icTac;
	}
	public void setIcTac(String icTac) {
		this.icTac = icTac;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getTlr() {
		return tlr;
	}
	public void setTlr(String tlr) {
		this.tlr = tlr;
	}
	public String getBelongInst() {
		return belongInst;
	}
	public void setBelongInst(String belongInst) {
		this.belongInst = belongInst;
	}
	public String getTermSeq() {
		return termSeq;
	}
	public void setTermSeq(String termSeq) {
		this.termSeq = termSeq;
	}
	public String getSysSeqno() {
		return sysSeqno;
	}
	public void setSysSeqno(String sysSeqno) {
		this.sysSeqno = sysSeqno;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getTranState() {
		return tranState;
	}
	public void setTranState(String tranState) {
		this.tranState = tranState;
	}
	private String tranState;//交易状态
	
	@Override
	public String toString() {
		return "QrCodePayInf [tradeAmount=" + tradeAmount + ", tranReason="
				+ tranReason + ", payCard=" + payCard + ", receiveCard="
				+ receiveCard + ", password=" + password + ", tranDate="
				+ tranDate + ", tranTime=" + tranTime + ", receiveSerial="
				+ receiveSerial + ", respCode=" + respCode + ", payTerminalNo="
				+ payTerminalNo + ", receiveTerminalNo=" + receiveTerminalNo
				+ ", tranPosition=" + tranPosition + ", currType=" + currType
				+ ", icTac=" + icTac + ", channel=" + channel + ", tlr=" + tlr
				+ ", belongInst=" + belongInst + ", termSeq=" + termSeq
				+ ", sysSeqno=" + sysSeqno + ", remark=" + remark
				+ ", tranState=" + tranState + "]";
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
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((payCard == null) ? 0 : payCard.hashCode());
		result = prime * result
				+ ((payTerminalNo == null) ? 0 : payTerminalNo.hashCode());
		result = prime * result
				+ ((receiveCard == null) ? 0 : receiveCard.hashCode());
		result = prime * result
				+ ((receiveSerial == null) ? 0 : receiveSerial.hashCode());
		result = prime
				* result
				+ ((receiveTerminalNo == null) ? 0 : receiveTerminalNo
						.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((respCode == null) ? 0 : respCode.hashCode());
		result = prime * result
				+ ((sysSeqno == null) ? 0 : sysSeqno.hashCode());
		result = prime * result + ((termSeq == null) ? 0 : termSeq.hashCode());
		result = prime * result + ((tlr == null) ? 0 : tlr.hashCode());
		result = prime * result
				+ ((tradeAmount == null) ? 0 : tradeAmount.hashCode());
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
		QrCodePayInf other = (QrCodePayInf) obj;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (payCard == null) {
			if (other.payCard != null)
				return false;
		} else if (!payCard.equals(other.payCard))
			return false;
		if (payTerminalNo == null) {
			if (other.payTerminalNo != null)
				return false;
		} else if (!payTerminalNo.equals(other.payTerminalNo))
			return false;
		if (receiveCard == null) {
			if (other.receiveCard != null)
				return false;
		} else if (!receiveCard.equals(other.receiveCard))
			return false;
		if (receiveSerial == null) {
			if (other.receiveSerial != null)
				return false;
		} else if (!receiveSerial.equals(other.receiveSerial))
			return false;
		if (receiveTerminalNo == null) {
			if (other.receiveTerminalNo != null)
				return false;
		} else if (!receiveTerminalNo.equals(other.receiveTerminalNo))
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
	public String getPayTerminalNo() {
		return payTerminalNo;
	}
	public void setPayTerminalNo(String payTerminalNo) {
		this.payTerminalNo = payTerminalNo;
	}
	public String getReceiveTerminalNo() {
		return receiveTerminalNo;
	}
	public void setReceiveTerminalNo(String receiveTerminalNo) {
		this.receiveTerminalNo = receiveTerminalNo;
	}
	public String getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(String tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public String getTranReason() {
		return tranReason;
	}
	public void setTranReason(String tranReason) {
		this.tranReason = tranReason;
	}
	public String getPayCard() {
		return payCard;
	}
	public void setPayCard(String payCard) {
		this.payCard = payCard;
	}
	public String getReceiveCard() {
		return receiveCard;
	}
	public void setReceiveCard(String receiveCard) {
		this.receiveCard = receiveCard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getReceiveSerial() {
		return receiveSerial;
	}
	public void setReceiveSerial(String receiveSerial) {
		this.receiveSerial = receiveSerial;
	}


}
