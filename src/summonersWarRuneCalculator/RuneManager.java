package summonersWarRuneCalculator;

import java.util.Scanner;

public class RuneManager {
	
	public Rune scanRune() {
		Scanner scanner =new Scanner(System.in);
		RuneCalculation runecalculation = new RuneCalculation();
		
		System.out.println("룬의 종류와 번호, 주능력치를 순서대로 입력해 주세요");
		int runeType = scanner.nextInt();
		int runeNumber = scanner.nextInt();
		int[]runeMainStat = new int [8];
		for(int i=0;i<runeMainStat.length;i++) {
			runeMainStat[i]=0;
		}
		runeMainStat[scanner.nextInt()]=scanner.nextInt();
		System.out.println("룬의 능력치를 입력해 주세요 체력, 공격력, 방어력, 공격속도, 치명타 확률, 치명타 피해, 효과 저항, 효과 적중 순으로");
		int[] statArray = new int[8];
		for(int i=0;i<8;i++) {
			statArray[i]=scanner.nextInt();
		}
		
		Rune rune = new Rune(runeType,runeNumber,runeMainStat,statArray);
		scanner.close();
		
		return rune;
	}
}
