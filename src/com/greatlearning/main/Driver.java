package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.services.CredentialService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int option;

		do {

			System.out.println("-----Please Enter the Department from Following-----");
			System.out.println(
					"1. Technical \n" + "2. Admin \n" + "3. Human Resource \n" + "4. Legal \n" + "0. Sytem.exit(0)");

			option = sc.nextInt();

			if (option >= 1 && option <= 4) {
				new CredentialService().showCredential(option);
			} else if (option == 0) {
				System.out.println("-----THANK YOU------");
				System.exit(0);
			} else {
				System.out.println("[WARNING] Please Select The Correct Input Again ... \n");
			}

		} while (option != 0);

		sc.close();

	}

}
