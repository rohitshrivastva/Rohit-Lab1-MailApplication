package com.greatlearning.database;

import java.util.ArrayList;
import java.util.List;

import com.greatlearning.models.Employee;

public class EmployeeDB {

	public List<Employee> employeeList = new ArrayList<Employee>();

	public EmployeeDB() {

		this.addEmployee("Joe", "Tribbiani", "Friends");
		this.addEmployee("John", "Snow", "GOT");
		this.addEmployee("Shrikant", "Tiwari", "TheFamilyMan");

	}

	public void addEmployee(String firstName, String lastName, String companyName) {
		// TODO Auto-generated method stub
		Employee _employee = new Employee();

		_employee.setFirstName(firstName);
		_employee.setLastName(lastName);
		_employee.setCompanyName(companyName);

		employeeList.add(_employee);

	}

}
