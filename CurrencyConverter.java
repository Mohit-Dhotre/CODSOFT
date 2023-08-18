package codesofTask5;

import java.util.Scanner;

public class CurrencyConverter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("!!...........................................................!!");
		System.out.println("!!                                                           !!");
		System.out.println("!!....       Codesoft Task 4 - Currency Management       ....!!");
		System.out.println("!!                                                           !!");
		System.out.println("!!...........................................................!!");
		System.out.println("Your Base Currency is Indian Rupees (INR)");
		System.out.println("");
		System.out.println("Select Your Target Currency From The List : ");
		System.out.println("");
		System.out.println("1. USD (United States Dollar)");
		System.out.println("2. EUR (Euro)");
		System.out.println("3. JPY (Japanese Yen)");
		System.out.println("");
		System.out.print("Enter target currency choice (1/2/3): ");
		int targetChoice = scanner.nextInt();

		String targetCurrency = "";
		switch (targetChoice) {
		case 1:
			targetCurrency = "USD";
			break;
		case 2:
			targetCurrency = "EUR";
			break;
		case 3:
			targetCurrency = "JPY";
			break;
		default:
			System.out.println("Invalid choice. Exiting.");
			scanner.close();
			System.exit(1);
		}

		double exchangeRate = fetchExchangeRate("INR", targetCurrency);

		System.out.print("Enter amount in Indian Rupees (INR) to convert: ");
		double amount = scanner.nextDouble();

		double convertedAmount = convertCurrency(amount, exchangeRate);
		System.out.println("");
		System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);

		scanner.close();
	}

	private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {

		if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
			return 0.014;
		} else if (baseCurrency.equals("INR") && targetCurrency.equals("EUR")) {
			return 0.012;
		} else if (baseCurrency.equals("INR") && targetCurrency.equals("JPY")) {
			return 1.53;
		} else {
			System.out.println("Exchange rate not available for selected currencies.");
			System.exit(1);
			return 0.0;
		}
	}

	private static double convertCurrency(double amount, double exchangeRate) {
		return amount * exchangeRate;
	}
}
