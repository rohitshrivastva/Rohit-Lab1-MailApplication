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
		System.out.println("Password ---> " + password);

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

		char[] password = new char[passwordLength];

		final char[] lowerCaseLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		final char[] upperCaseLetters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		final char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		final char[] specialChars = { '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*',
				'+', '.', '>' };

		final char[] allChars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9', '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*', '+',
				'.', '>' };

		// password policy
		// 1. length - 8 chars
		// 2. atleast 1 - uppercase, 1 - lowercase, 1 - number, 1 - special char

		// take random 4 types of letter for at-least one letter
		password[0] = lowerCaseLetters[new Random().nextInt(lowerCaseLetters.length)];
		password[1] = upperCaseLetters[new Random().nextInt(upperCaseLetters.length)];
		password[2] = numbers[new Random().nextInt(numbers.length)];
		password[3] = specialChars[new Random().nextInt(specialChars.length)];

		// randomly select 4 other characters from all type

		for (int i = 4; i < passwordLength; i++) {
			password[i] = allChars[new Random().nextInt(allChars.length)];
		}

		// shuffle the password
		for (int i = 0; i < password.length; i++) {

			int randomPosition = new Random().nextInt(password.length);

			char temp = password[i];
			password[i] = password[randomPosition];
			password[randomPosition] = temp;

		}

		return new String(password);
	}

}
