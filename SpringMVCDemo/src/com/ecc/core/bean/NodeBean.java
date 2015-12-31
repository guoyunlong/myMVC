package com.ecc.core.bean;

import java.util.List;


/**
 * 节点对象信息
 * 
 * @author guoyl
 *
 */
public class NodeBean {
	/**
	 * 节点编号
	 */
	private int id; 
	/**
	 * 节点显示名称
	 */
	private String text;
	/**
	 * 是否默认打开 
	 * 	 open or closed
	 */
	private String state;
	/**
	 * 节点样式
	 */
	private String iconCls;
	/**
	 * 节点跳转路径
	 */
	private String url;
	/**
	 * 是否默认选中
	 */
	private boolean checked;
	/**
	 * 是否为叶子节点
	 */
	private boolean leaf;
	/**
	 * 子节点集合
	 */
	private List<NodeBean> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public List<NodeBean> getChildren() {
		return children;
	}
	public void setChildren(List<NodeBean> children) {
		this.children = children;
	}
	
	
}
