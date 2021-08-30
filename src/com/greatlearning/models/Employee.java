package com.greatlearning.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.greatlearning.database.EmployeeDB;

public class Employee {

	private String firstName;
	private String lastName;
	private String companyName;

	public Employee() {

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Employee(String firstName, String lastName) {
		// TODO Auto-generated constructor stub

		this.setFirstName(firstName);
		this.setLastName(lastName);

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee getRandomEmployee() {

		EmployeeDB employeeDB = new EmployeeDB();
		;
		List<Employee> employees = new ArrayList<>();

		employees = employeeDB.employeeList;
		return employees.get(new Random().nextInt(employees.size()));

	}

}
