/**
 *
 */
package com.gsoft.mobile.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.gsoft.framework.core.dataobj.Domain;

/**
 * 实体: 交易缓存
 * 
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_DAY_TEM_INF")
public class DayTemInf implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5251593242993686266L;

	@Id
	@Column(name = "TRAN_NO")
	private String tranNo;// 交易编号

	@Column(name = "TRADE_AMO")
	@Length(max = 10)
	private String tradeAmo;// 交易金额

	@Column(name = "TRAN_REASON")
	@Length(max = 200)
	private String tranReason;// 交易事由

	@Column(name = "PAY_CARD")
	@Length(max = 22)
	private String payCard;// 付款账号

	@Column(name = "RECEIVE_CARD")
	@Length(max = 20)
	private String receiveCard;// 收款账号

	@Column(name = "TRAN_POSITION")
	@Length(max = 300)
	private String tranPosition;// 交易位置

	@Column(name = "CURR_TYPE")
	@Length(max = 8)
	private String currType;// 货币类型

	@Column(name = "BELONG_INST")
	@Length(max = 11)
	private String belongInst;// 所属机构

	@Column(name = "TERM_SEQ")
	@Length(max = 32)
	private String termSeq;// 终端流水号

	@Column(name = "TERMINAL_NO")
	@Length(max = 32)
	private String terminalNo;// 终端编号

	@Column(name = "TRAN_STATE")
	@Length(max = 4)
	private String tranState;// 交易状态

	@Transient
	private String payPassword;//支付密码

	@Override
	public String toString() {
		return "DayTemInf [tranNo=" + tranNo + ", tradeAmo=" + tradeAmo
				+ ", tranReason=" + tranReason + ", payCard=" + payCard
				+ ", receiveCard=" + receiveCard + ", tranPosition="
				+ tranPosition + ", currType=" + currType + ", belongInst="
				+ belongInst + ", termSeq=" + termSeq + ", terminalNo="
				+ terminalNo + ", tranState=" + tranState + "]";
	}

//	public String getPayPassword() {
//		return payPassword;
//	}
//
//	public void setPayPassword(String password) {
//		this.payPassword = password;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((belongInst == null) ? 0 : belongInst.hashCode());
		result = prime * result
				+ ((currType == null) ? 0 : currType.hashCode());
		//result = prime * result+ ((payPassword == null) ? 0 : payPassword.hashCode());
		result = prime * result + ((payCard == null) ? 0 : payCard.hashCode());
		result = prime * result
				+ ((receiveCard == null) ? 0 : receiveCard.hashCode());
		result = prime * result + ((termSeq == null) ? 0 : termSeq.hashCode());
		result = prime * result
				+ ((terminalNo == null) ? 0 : terminalNo.hashCode());
		result = prime * result
				+ ((tradeAmo == null) ? 0 : tradeAmo.hashCode());
		result = prime * result + ((tranNo == null) ? 0 : tranNo.hashCode());
		result = prime * result
				+ ((tranPosition == null) ? 0 : tranPosition.hashCode());
		result = prime * result
				+ ((tranReason == null) ? 0 : tranReason.hashCode());
		result = prime * result
				+ ((tranState == null) ? 0 : tranState.hashCode());
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
		DayTemInf other = (DayTemInf) obj;
		if (belongInst == null) {
			if (other.belongInst != null)
				return false;
		} else if (!belongInst.equals(other.belongInst))
			return false;
		if (currType == null) {
			if (other.currType != null)
				return false;
		} else if (!currType.equals(other.currType))
			return false;
//		if (payPassword == null) {
//			if (other.payPassword != null)
//				return false;
//		} else if (!payPassword.equals(other.payPassword))
//			return false;
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
		if (tradeAmo == null) {
			if (other.tradeAmo != null)
				return false;
		} else if (!tradeAmo.equals(other.tradeAmo))
			return false;
		if (tranNo == null) {
			if (other.tranNo != null)
				return false;
		} else if (!tranNo.equals(other.tranNo))
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
		return true;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getTradeAmo() {
		return tradeAmo;
	}

	public void setTradeAmo(String tradeAmo) {
		this.tradeAmo = tradeAmo;
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

	public String getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

	public String getTranState() {
		return tranState;
	}

	public void setTranState(String tranState) {
		this.tranState = tranState;
	}

	public String getTranNo() {
		return tranNo;
	}

	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}