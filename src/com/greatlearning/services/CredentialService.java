package com.greatlearning.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.greatlearning.database.DepartmentDB;
import com.greatlearning.database.EmployeeDB;
import com.greatlearning.models.Department;
import com.greatlearning.models.Employee;

public class CredentialService {

	EmployeeDB employeeDB = new EmployeeDB();
	DepartmentDB departmentDB = new DepartmentDB();
	Employee employee = new Employee();
	Department department = new Department();
	int option;

	public void showCredential(int option) {

		this.option = option;

		// get the random employee
		Employee _emp = employee.getRandomEmployee();

		// get the department Id
		String departmentCode = department.getDepartmentCodeById(option);

		// generate the email
		String email = this.generateEmailAddress(_emp, departmentCode);
		String password = this.generatePassword(8);

		System.out.println("\nDear " + _emp.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email ---> " + email);
		System.out.println("Password ---> " +password);
		

		System.out.println('\n');
	}

	public String generateEmailAddress(Employee emp, String departmentCode) {

		String email = "";

		String firstName = emp.getFirstName();
		String lastName = emp.getLastName();
		String companyName = emp.getCompanyName();

		email = firstName + lastName + "." + departmentCode + "@" + companyName + ".com";

		return email.toLowerCase();
	}

	public String generatePassword(int passwordLength) {

		String password = "";
		
		final char[] lowerCaseLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		final char[] upperCaseLetters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		final char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		final char[] specialChars = { '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*',
				'+', '.', '>' };

		// password policy
		// 1. length - 8 chars
		// 2. atleast 1 - uppercase, 1 - lowercase, 1 - number, 1 - special char

		// take random 4 types of letter for at-least one letter
		char randomLowerCaseLetter = lowerCaseLetters[new Random().nextInt(lowerCaseLetters.length)];
		char randomUpperCaseLetter = upperCaseLetters[new Random().nextInt(upperCaseLetters.length)];
		char randomNumber = numbers[new Random().nextInt(numbers.length)];
		char randomSpecialChar = specialChars[new Random().nextInt(specialChars.length)];

		
		
		password += randomLowerCaseLetter;
		password += randomUpperCaseLetter;
		password += randomNumber;
		password += randomSpecialChar;
		
		// randomly select 4 other characters from all type
		StringBuilder sb = new StringBuilder();
		sb.append(lowerCaseLetters);
		sb.append(upperCaseLetters);
		sb.append(numbers);
		sb.append(specialChars);

		for (int i = 0; i < passwordLength - 4; i++) {
			password += sb.charAt(new Random().nextInt(sb.length()));
		}

		// shuffle the password 
		Collections.shuffle(Arrays.asList(password.toCharArray()));
		
		return password.toString();
	}

}
