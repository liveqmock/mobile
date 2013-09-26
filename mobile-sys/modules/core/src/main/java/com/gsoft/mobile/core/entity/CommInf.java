/**
 *
 */
package com.gsoft.mobile.core.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_COMM_INF")
public class CommInf implements Domain{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2165421058556735023L;

	

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	//@Id
	@Column(name = "COMMODITY_NO")
	@Length(max=32)
	private String commodityNo;//商品编号

	@Column(name = "COMM_STATE")
	@Length(max=2)
	private String commState;//商品状态

	@Column(name = "COMM_PRICES")
	@Length(max=8)
	private String commPrices;//商品价格

	@Column(name = "COMM_NAME")
	@Length(max=50)
	private String commName;//商品名称

	@Column(name = "COMM_BARCD")
	@Length(max=30)
	private String commBarcd;//商品条码

	@Column(name = "ENTER_TIME")
	@Length(max=10)
	private String enterTime;//录入时间

	
	@Column(name = "BELONG_MERCHANT")
	@Length(max=32)
	private String belongMerchant;//所属商户
	
	@Column(name = "COMM_UNIT")
	@Length(max=4)
	private String commUnit;//商品单位
	


	public String getCommodityNo() {
		return commodityNo;
	}


	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}


	public String getCommState() {
		return commState;
	}


	public void setCommState(String commState) {
		this.commState = commState;
	}


	public String getCommPrices() {
		return commPrices;
	}


	public void setCommPrices(String commPrices) {
		this.commPrices = commPrices;
	}


	public String getCommName() {
		return commName;
	}


	public void setCommName(String commName) {
		this.commName = commName;
	}


	public String getCommBarcd() {
		return commBarcd;
	}


	public void setCommBarcd(String commBarcd) {
		this.commBarcd = commBarcd;
	}


	public String getEnterTime() {
		return enterTime;
	}


	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((belongMerchant == null) ? 0 : belongMerchant.hashCode());
		result = prime * result
				+ ((commBarcd == null) ? 0 : commBarcd.hashCode());
		result = prime * result
				+ ((commName == null) ? 0 : commName.hashCode());
		result = prime * result
				+ ((commPrices == null) ? 0 : commPrices.hashCode());
		result = prime * result
				+ ((commState == null) ? 0 : commState.hashCode());
		result = prime * result
				+ ((commUnit == null) ? 0 : commUnit.hashCode());
		result = prime * result
				+ ((commodityNo == null) ? 0 : commodityNo.hashCode());
		result = prime * result
				+ ((enterTime == null) ? 0 : enterTime.hashCode());
		return result;
	}
	
//	public int generateId() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((belongMerchant == null) ? 0 : belongMerchant.hashCode());
//		result = prime * result
//				+ ((commBarcd == null) ? 0 : commBarcd.hashCode());
//		result = prime * result
//				+ ((commName == null) ? 0 : commName.hashCode());
//		result = prime * result
//				+ ((commPrices == null) ? 0 : commPrices.hashCode());
//		result = prime * result
//				+ ((commState == null) ? 0 : commState.hashCode());
//		result = prime * result
//				+ ((commUnit == null) ? 0 : commUnit.hashCode());
//		return result;
//	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommInf other = (CommInf) obj;
		if (belongMerchant == null) {
			if (other.belongMerchant != null)
				return false;
		} else if (!belongMerchant.equals(other.belongMerchant))
			return false;
		if (commBarcd == null) {
			if (other.commBarcd != null)
				return false;
		} else if (!commBarcd.equals(other.commBarcd))
			return false;
		if (commName == null) {
			if (other.commName != null)
				return false;
		} else if (!commName.equals(other.commName))
			return false;
		if (commPrices == null) {
			if (other.commPrices != null)
				return false;
		} else if (!commPrices.equals(other.commPrices))
			return false;
		if (commState == null) {
			if (other.commState != null)
				return false;
		} else if (!commState.equals(other.commState))
			return false;
		if (commUnit == null) {
			if (other.commUnit != null)
				return false;
		} else if (!commUnit.equals(other.commUnit))
			return false;
		if (commodityNo == null) {
			if (other.commodityNo != null)
				return false;
		} else if (!commodityNo.equals(other.commodityNo))
			return false;
		if (enterTime == null) {
			if (other.enterTime != null)
				return false;
		} else if (!enterTime.equals(other.enterTime))
			return false;
		return true;
	}


	public String getBelongMerchant() {
		return belongMerchant;
	}


	public void setBelongMerchant(String belongMerchant) {
		this.belongMerchant = belongMerchant;
	}


	public String getCommUnit() {
		return commUnit;
	}


	public void setCommUnit(String commUnit) {
		this.commUnit = commUnit;
	}

	public String toString(){
		return super.toString();
	}
}