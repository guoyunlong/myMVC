package com.ecc.core.bean;

import java.io.Serializable;

/**
 * 元数据对象
 * 
 * @author guoyl
 */
public class MetaDataBean implements Serializable{
	
	private int type;//类型
	private String nameEn;//名称 数据库字段名称
	private String nameCn;//中文名称 标题行
	public MetaDataBean() {
		super();
	}
	public MetaDataBean(int type, String nameEn, String nameCn) {
		super();
		this.type = type;
		this.nameEn = nameEn;
		this.nameCn = nameCn;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	
	
}	
