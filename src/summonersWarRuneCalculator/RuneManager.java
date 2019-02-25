package summonersWarRuneCalculator;

import java.util.Scanner;

public class RuneManager {
	
	public Rune scanRune() {
		Scanner scanner =new Scanner(System.in);
		RuneCalculation runecalculation = new RuneCalculation();
		
		System.out.println("Please input type, number and main stat");
		int runeType = scanner.nextInt();
		int runeNumber = scanner.nextInt();
		int[]runeMainStat = new int [8];
		for(int i=0;i<runeMainStat.length;i++) {
			runeMainStat[i]=0;
		}
		runeMainStat[scanner.nextInt()]=scanner.nextInt();
		System.out.println("input sub stats. The sequence is HP, ATK, DEF, SPD, CRr, CRd, RES, ACC");
		int[] statArray = new int[8];
		for(int i=0;i<8;i++) {
			statArray[i]=scanner.nextInt();
		}
		
		Rune rune = new Rune(runeType,runeNumber,runeMainStat,statArray);
		scanner.close();
		
		return rune;
	}
}
