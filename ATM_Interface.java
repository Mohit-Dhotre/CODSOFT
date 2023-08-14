package Bank;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ATM_Interface {

	private double bal = 5000;
	private int pass;
	double amount;
	Scanner sc = new Scanner(System.in);

	public void Deposite(double amount) {
		System.out.println("");
		System.out.print("Enter Your Password : ");

		pass = sc.nextInt();
		if (pass == 4797) {
			System.out.println("");
			System.out.print("Enter Your Deposite Amount : ");
			amount = sc.nextDouble();
			bal = bal + amount;
			System.out.println("");
			System.out.println("Successfully Deposited : " + amount);
			System.out.println("");
			System.out.println("your Total Balance : " + bal);
			System.out.println(LocalDateTime.now());

		} else {
			System.out.println("");
			System.out.println("Incorrect Password..... Try Again !!");

		}

	}

	public void Withdraw(double amount) {
		System.out.println("");
		System.out.print("Enter Your Password : ");

		pass = sc.nextInt();
		if (pass == 4797) {
			System.out.println("");
			System.out.print("Enter Withdraw Amount : ");
			amount = sc.nextDouble();
			if (amount <= bal) {
				bal = bal - amount;
				System.out.println("Amount Withdraw Successfully : " + amount);
				System.out.println("");
				System.out.println("Total Remainig Balance:" + bal);
				System.out.println(LocalDateTime.now());
			} else {
				System.out.println("");
				System.out.println("Insufficient Balance.....");
				System.out.println(LocalDateTime.now());
			}
		} else {
			System.out.println("");
			System.out.println("Incorrect Password.... Try Again !!");
		}
	}

	public void Check_Balance() {
		System.out.println("");
		System.out.print("Enter Your Password : ");
		pass = sc.nextInt();
		if (pass == 4797) {
			System.out.println("");
			System.out.println("your Total Balance : " + bal);
			System.out.println(LocalDateTime.now());

		} else {
			System.out.println("");
			System.out.println("Incorrect Password..... Try Again !!");
		}

	}

	public static void main(String[] args) {
		ATM_Interface ref = new ATM_Interface();
		Scanner sc = new Scanner(System.in);
		int ch;
		System.out.println("!!...........................................................!!");
		System.out.println("!!                                                           !!");
		System.out.println("!!....    Codesoft Task 3 - ATM Interface                ....!!");
		System.out.println("!!                                                           !!");
		System.out.println("!!...........................................................!!");
		System.out.println("");
		System.out.println("1.Deposite : ");
		System.out.println("");
		System.out.println("2.Withdraw : ");
		System.out.println("");
		System.out.println("3.Check your Balance : ");
		System.out.println("");
		System.out.print("Enter Your Choice Here : ");
		ch = sc.nextInt();

		switch (ch) {
		case 1:
			ref.Deposite(0);
			break;
		case 2:
			ref.Withdraw(0);

			break;
		case 3:
			ref.Check_Balance();

			break;
		default:
			System.out.println("Invalid Choice...");

		}

	}

}
