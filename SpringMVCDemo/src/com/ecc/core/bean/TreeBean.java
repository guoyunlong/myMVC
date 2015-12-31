package com.ecc.core.bean;

import java.util.List;

/**
 * 树对象信息
 * 
 * @author guoyl
 *
 */
public class TreeBean {
	/**
	 * 需要生成树的集合
	 */
	private List<NodeBean> nodeBeans;
	/**
	 * 已经选中树的集合
	 */
	private List<NodeBean> checkedNodeBeans;
	/**
	 * 根节点的集合
	 */
	private List<NodeBean> rootNodeBeans;
	
	
	public List<NodeBean> getNodeBeans() {
		return nodeBeans;
	}
	public void setNodeBeans(List<NodeBean> nodeBeans) {
		this.nodeBeans = nodeBeans;
	}
	public List<NodeBean> getCheckedNodeBeans() {
		return checkedNodeBeans;
	}
	public void setCheckedNodeBeans(List<NodeBean> checkedNodeBeans) {
		this.checkedNodeBeans = checkedNodeBeans;
	}
	public List<NodeBean> getRootNodeBeans() {
		return rootNodeBeans;
	}
	public void setRootNodeBeans(List<NodeBean> rootNodeBeans) {
		this.rootNodeBeans = rootNodeBeans;
	}
	
}
