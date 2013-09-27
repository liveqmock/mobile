/**
 *
 */
package com.gsoft.mobile.param.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 参数信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "MOBILE_PARA_INF")
public class ParaInf implements Domain{
	
	//private static final long serialVersionUID = 1L;
	

	@Column(name = "RMK")
	@Length(max=512)
	private String rmk;//备注

	@Column(name = "PARA_ENAME")
	@Length(max=32)
	private String paraEname;//参数英文名称

	@Column(name = "PARA_CD")
	@Length(max=8)
	private String paraCd;//参数代码

	@Column(name = "LASTDATETIME")
	@Length(max=10)
	private String lastdatetime;//最近更新日期时间

	@Column(name = "PARA_CNAME")
	@Length(max=64)
	private String paraCname;//参数中文名称

	@Column(name = "VALIDMARK")
	@Length(max=2)
	private String validmark;//无效标记

	@Column(name = "TLR")
	@Length(max=16)
	private String tlr;//操作人

	@Column(name = "PARA_ADD_DATE")
	@Length(max=8)
	private String paraAddDate;//参数新增日期
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PARA_NO")
	private String paraNo;//参数编号
	
	public String getRmk(){
		return this.rmk;
	}
	
	public void setRmk(String rmk){
		this.rmk = rmk;
	}
	public String getParaEname(){
		return this.paraEname;
	}
	
	public void setParaEname(String paraEname){
		this.paraEname = paraEname;
	}
	public String getParaCd(){
		return this.paraCd;
	}
	
	public void setParaCd(String paraCd){
		this.paraCd = paraCd;
	}
	public String getLastdatetime(){
		return this.lastdatetime;
	}
	
	public void setLastdatetime(String lastdatetime){
		this.lastdatetime = lastdatetime;
	}
	public String getParaCname(){
		return this.paraCname;
	}
	
	public void setParaCname(String paraCname){
		this.paraCname = paraCname;
	}
	public String getValidmark(){
		return this.validmark;
	}
	
	public void setValidmark(String validmark){
		this.validmark = validmark;
	}
	public String getTlr(){
		return this.tlr;
	}
	
	public void setTlr(String tlr){
		this.tlr = tlr;
	}
	public String getParaAddDate(){
		return this.paraAddDate;
	}
	
	public void setParaAddDate(String paraAddDate){
		this.paraAddDate = paraAddDate;
	}
	public String getParaNo(){
		return this.paraNo;
	}
	
	public void setParaNo(String paraNo){
		this.paraNo = paraNo;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rmk == null) ? 0 : rmk.hashCode());
		result = prime * result + ((paraEname == null) ? 0 : paraEname.hashCode());
		result = prime * result + ((paraCd == null) ? 0 : paraCd.hashCode());
		result = prime * result + ((lastdatetime == null) ? 0 : lastdatetime.hashCode());
		result = prime * result + ((paraCname == null) ? 0 : paraCname.hashCode());
		result = prime * result + ((validmark == null) ? 0 : validmark.hashCode());
		result = prime * result + ((tlr == null) ? 0 : tlr.hashCode());
		result = prime * result + ((paraAddDate == null) ? 0 : paraAddDate.hashCode());
		result = prime * result + ((paraNo == null) ? 0 : paraNo.hashCode());
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
		final ParaInf other = (ParaInf) obj;
		if (rmk == null) {
			if (other.rmk != null)
				return false;
		} else if (!rmk.equals(other.rmk))
			return false;
		if (paraEname == null) {
			if (other.paraEname != null)
				return false;
		} else if (!paraEname.equals(other.paraEname))
			return false;
		if (paraCd == null) {
			if (other.paraCd != null)
				return false;
		} else if (!paraCd.equals(other.paraCd))
			return false;
		if (lastdatetime == null) {
			if (other.lastdatetime != null)
				return false;
		} else if (!lastdatetime.equals(other.lastdatetime))
			return false;
		if (paraCname == null) {
			if (other.paraCname != null)
				return false;
		} else if (!paraCname.equals(other.paraCname))
			return false;
		if (validmark == null) {
			if (other.validmark != null)
				return false;
		} else if (!validmark.equals(other.validmark))
			return false;
		if (tlr == null) {
			if (other.tlr != null)
				return false;
		} else if (!tlr.equals(other.tlr))
			return false;
		if (paraAddDate == null) {
			if (other.paraAddDate != null)
				return false;
		} else if (!paraAddDate.equals(other.paraAddDate))
			return false;
		if (paraNo == null) {
			if (other.paraNo != null)
				return false;
		} else if (!paraNo.equals(other.paraNo))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}