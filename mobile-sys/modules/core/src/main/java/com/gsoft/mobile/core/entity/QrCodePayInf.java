package com.gsoft.mobile.core.entity;

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
	@Override
	public String toString() {
		return "QrCodePayInf [tradeAmount=" + tradeAmount + ", tranReason="
				+ tranReason + ", payCard=" + payCard + ", receiveCard="
				+ receiveCard + ", password=" + password + ", tranDate="
				+ tranDate + ", tranTime=" + tranTime + ", receiveSerial="
				+ receiveSerial + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((payCard == null) ? 0 : payCard.hashCode());
		result = prime * result
				+ ((receiveCard == null) ? 0 : receiveCard.hashCode());
		result = prime * result
				+ ((receiveSerial == null) ? 0 : receiveSerial.hashCode());
		result = prime * result
				+ ((tradeAmount == null) ? 0 : tradeAmount.hashCode());
		result = prime * result
				+ ((tranDate == null) ? 0 : tranDate.hashCode());
		result = prime * result
				+ ((tranReason == null) ? 0 : tranReason.hashCode());
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
		if (tranReason == null) {
			if (other.tranReason != null)
				return false;
		} else if (!tranReason.equals(other.tranReason))
			return false;
		if (tranTime == null) {
			if (other.tranTime != null)
				return false;
		} else if (!tranTime.equals(other.tranTime))
			return false;
		return true;
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
	private String tranTime;//交易时间
	private String receiveSerial;//收款序号

}
