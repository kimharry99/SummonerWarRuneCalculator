package summonersWarRuneCalculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=-1;
		Scanner scanner	= new Scanner(System.in);;
		while (true) {
			System.out.print("0 : calculate rune score 1 : calculate rune potentional >>");
			a = scanner.nextInt();
			//scanner.close();
			switch (a) {
			case 0:
				Rune rune0 = new RuneManager().scanRune(scanner);
				new RuneCalculation().calculateRuneScore(rune0, true);
			case 1:
				Rune rune1 = new RuneManager().scanRune(scanner);

				new RuneCalculation().calculateRunePotentional(rune1);
				break;
			default :
				System.out.println("input integer error.");
				break;
			}
			if(a==-1) {
				break;
			}
		}
		
	}
}
