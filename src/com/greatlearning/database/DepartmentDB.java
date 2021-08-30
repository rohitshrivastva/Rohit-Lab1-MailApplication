package com.greatlearning.database;

import java.util.ArrayList;
import java.util.List;

import com.greatlearning.models.Department;

public class DepartmentDB {

	public List<Department> departmentList = new ArrayList<Department>();

	public DepartmentDB() {

		this.addDepartment(1, "Technical", "Technical");
		this.addDepartment(2, "Admin", "Admin");
		this.addDepartment(3, "Human Resource", "HR");
		this.addDepartment(4, "Legal", "Legal");

	}

	public void addDepartment(int id, String departmentName, String departmentCode) {
		// TODO Auto-generated method stub
		Department _department = new Department();

		_department.setDepartmentId(id);
		_department.setDepartmentName(departmentName);
		_department.setDepartmentCode(departmentCode);

		departmentList.add(_department);

	}

}
