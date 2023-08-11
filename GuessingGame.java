
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		play();
	}

	public static void play() {
		String playAgain = "";
		do {
			Scanner SC = new Scanner(System.in);
			Random R = new Random();
			int numberToGuess = R.nextInt(100) + 1;
			System.out.println("!!.......................................................!!");
			System.out.println("!!                                                       !!");
			System.out.println("!!.......    Codesoft Task 1 - Number Game       ........!!");
			System.out.println("!!.......         WELCOME TO THE GAME            ........!!");
			System.out.println("!!                                                       !!");
			System.out.println("!!.......................................................!!");
			System.out.println("");
			System.out.println("COMPUTER IS THINKING OF NUMBER BETWEEN 1-100");
			int maxAttempts = 5;

			int attempts = 0;

			if (attempts < maxAttempts) {

				while (attempts < maxAttempts) {
					System.out.println("GUESS NUMBER " + (attempts + 1) + ":");
					int guess = SC.nextInt();
					attempts++;

					if (guess < numberToGuess) {
						System.out.println("NUMBER IS TOO LOW!!");
					} else if (guess > numberToGuess) {

						System.out.println("NUMBER IS TOO HIGH!!");

					} else {
						System.out.println(
								"!!........................................................................!!");
						System.out.println(
								"!!                                                                        !!");
						System.out.println("!!.....    CONGRATULATIONS !! You Guessed The Number In " + attempts + " "
								+ "Attempts" + "    ....!!");
						System.out.println(
								"!!                                                                        !!");
						System.out.println(
								"!!........................................................................!!");

						System.out.println("Would You Want To Play Agin (1/0) ?? ");
						int choice = SC.nextInt();
						while (choice == 1) {
							play();
						}
						while (choice == 0) {
							System.out.println("");
							System.out.println("!!..... Thank you For Playing .....!!");
							return;
						}
						SC.close();
						return;
					}
				}
				System.out.println("!!..........................................!!");
				System.out.println("!!                                          !!");
				System.out.println("!!....    You Are Out of Your Limits    ....!!");
				System.out.println("!!                                          !!");
				System.out.println("!!..........................................!!");
				System.out.println("");
				System.out.print("Would You Want To Play Agin (y/n) ?? ");
			}
			playAgain = SC.next();

		} while (playAgain.equalsIgnoreCase("y"));
		System.out.println("");
		System.out.println(".....Thank You For Playing....");
	}
}
