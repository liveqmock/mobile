/**
 *
 */
package com.gsoft.mobile.param.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 参数值表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_PARA_VAL_INF")
public class ParaValInf implements Domain{
	
	//private static final long serialVersionUID = 1L;
	

	@Column(name = "LASTDATETIME")
	@Length(max=10)
	private String lastdatetime;//最近更新日期时间

	@Column(name = "VALIDMARK")
	@Length(max=2)
	private String validmark;//无效标记

	@Column(name = "PARA_NO")
	private String paraNo;//参数编号
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PARA_VAL_CD")
	private String paraValCd;//参数值编号

	@Column(name = "PARA_VAL")
	@Length(max=32)
	private String paraVal;//参数值

	@Column(name = "TLR")
	@Length(max=16)
	private String tlr;//操作人
	
	public String getLastdatetime(){
		return this.lastdatetime;
	}
	
	public void setLastdatetime(String lastdatetime){
		this.lastdatetime = lastdatetime;
	}
	public String getValidmark(){
		return this.validmark;
	}
	
	public void setValidmark(String validmark){
		this.validmark = validmark;
	}
	public String getParaNo(){
		return this.paraNo;
	}
	
	public void setParaNo(String paraNo){
		this.paraNo = paraNo;
	}
	public String getParaValCd(){
		return this.paraValCd;
	}
	
	public void setParaValCd(String paraValCd){
		this.paraValCd = paraValCd;
	}
	public String getParaVal(){
		return this.paraVal;
	}
	
	public void setParaVal(String paraVal){
		this.paraVal = paraVal;
	}
	public String getTlr(){
		return this.tlr;
	}
	
	public void setTlr(String tlr){
		this.tlr = tlr;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastdatetime == null) ? 0 : lastdatetime.hashCode());
		result = prime * result + ((validmark == null) ? 0 : validmark.hashCode());
		result = prime * result + ((paraNo == null) ? 0 : paraNo.hashCode());
		result = prime * result + ((paraValCd == null) ? 0 : paraValCd.hashCode());
		result = prime * result + ((paraVal == null) ? 0 : paraVal.hashCode());
		result = prime * result + ((tlr == null) ? 0 : tlr.hashCode());
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
		final ParaValInf other = (ParaValInf) obj;
		if (lastdatetime == null) {
			if (other.lastdatetime != null)
				return false;
		} else if (!lastdatetime.equals(other.lastdatetime))
			return false;
		if (validmark == null) {
			if (other.validmark != null)
				return false;
		} else if (!validmark.equals(other.validmark))
			return false;
		if (paraNo == null) {
			if (other.paraNo != null)
				return false;
		} else if (!paraNo.equals(other.paraNo))
			return false;
		if (paraValCd == null) {
			if (other.paraValCd != null)
				return false;
		} else if (!paraValCd.equals(other.paraValCd))
			return false;
		if (paraVal == null) {
			if (other.paraVal != null)
				return false;
		} else if (!paraVal.equals(other.paraVal))
			return false;
		if (tlr == null) {
			if (other.tlr != null)
				return false;
		} else if (!tlr.equals(other.tlr))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}