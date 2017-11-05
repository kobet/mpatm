package com.example.mpatm.model;

public class TreeNode {
	
	/**节点id*/
	private Integer id;
	/**父节点id*/
	private Integer pId;
	/**节点名称*/
	private String name;
	/**是否展开*/
	private boolean open;
	
	public TreeNode(Integer id, Integer pId, String name, boolean open) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + "]";
	}

}
