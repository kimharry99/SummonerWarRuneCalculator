package summonersWarRuneCalculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		Rune rune = new RuneManager().scanRune();
		double temp = new RuneCalculation().calculateRuneScore(rune);
		
		scanner.close();
	}

}
