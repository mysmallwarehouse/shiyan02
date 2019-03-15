package com.wys.javabean;

public class Company {
	int companyId; // 企业标识
	String companyName;// 公司的名称
	String companyArea;// 公司地址
	String companySize; // 公司的规模
	String companyType; // 公司的性质
	String companybrief;// 公司简介
	int companyState; // 招聘状态 ： 1.招聘中 2.已暂停 3.已结束
	int companySort;// 排序序号
	int companyViewnum;// 浏览数
	String companyPic;// 宣传图片
	
	

	public Company( String companyName, String companyArea, String companySize, String companyType,
			String companybrief, int companyState, int companySort, int companyViewnum, String companyPic) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyArea = companyArea;
		this.companySize = companySize;
		this.companyType = companyType;
		this.companybrief = companybrief;
		this.companyState = companyState;
		this.companySort = companySort;
		this.companyViewnum = companyViewnum;
		this.companyPic = companyPic;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyArea() {
		return companyArea;
	}

	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanybrief() {
		return companybrief;
	}

	public void setCompanybrief(String companybrief) {
		this.companybrief = companybrief;
	}

	public int getCompanyState() {
		return companyState;
	}

	public void setCompanyState(int companyState) {
		this.companyState = companyState;
	}

	public int getCompanySort() {
		return companySort;
	}

	public void setCompanySort(int companySort) {
		this.companySort = companySort;
	}

	public int getCompanyViewnum() {
		return companyViewnum;
	}

	public void setCompanyViewnum(int companyViewnum) {
		this.companyViewnum = companyViewnum;
	}

	public String getCompanyPic() {
		return companyPic;
	}

	public void setCompanyPic(String companyPic) {
		this.companyPic = companyPic;
	}

}
