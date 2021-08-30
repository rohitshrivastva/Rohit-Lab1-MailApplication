package com.greatlearning.models;

import java.util.List;

import com.greatlearning.database.DepartmentDB;

public class Department {

	private int departmentId;
	private String departmentName;
	private String departmentCode;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentCodeById(int option) {

		String departmentCode = "";

		DepartmentDB departmentDB = new DepartmentDB();

		List<Department> departments = departmentDB.departmentList;
		for (Department _department : departments) {
			if (_department.getDepartmentId() == option)
				departmentCode = _department.getDepartmentCode();
		}

		return departmentCode;
	}

}
