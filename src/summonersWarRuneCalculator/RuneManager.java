package summonersWarRuneCalculator;

import java.util.Scanner;

public class RuneManager {

	/**
	 * input data at console than return the rune
	 * @return
	 */
	public Rune scanRune(Scanner scanner) {
		int temp=0;
		Rune rune=new Rune();
		//Scanner scanner =new Scanner(System.in);
		System.out.println("input, rune number, rune rank, rune level");

		if(scanner.hasNextInt())
			temp = scanner.nextInt();
		if(temp!=-1) {
			rune.setNumber(temp);
			rune.setRank(scanner.nextInt());
			rune.setRuneLevel(scanner.nextInt());
		}
		if(rune.getNumber()%2==0) {
		System.out.println("input rarity, main stat and prefix stat");
		int rarity = -1;
		rarity = scanner.nextInt();
		if(rarity!=-1) {
			rune.setRarity(rarity);
			int[]runeMainStat = new int [rune.getMainStat().length];
			runeMainStat[scanner.nextInt()]=scanner.nextInt();
			rune.setMainStat(runeMainStat);
			int[]runePrefixStat = new int [rune.getPrefixStat().length];
			runePrefixStat[scanner.nextInt()]=scanner.nextInt();
			rune.setPrefixStat(runePrefixStat);
		}
		}
		else {
			System.out.println("input rarity and prefix stat");
			int rarity = -1;
			rarity = scanner.nextInt();
			if(rarity!=-1) {
				rune.setRarity(rarity);
				int[]runePrefixStat = new int [rune.getPrefixStat().length];
				runePrefixStat[scanner.nextInt()]=scanner.nextInt();
				rune.setPrefixStat(runePrefixStat);
			}
		}
		System.out.println("input sub stats. The sequence is HP, ATK, DEF, SPD, CRr, CRd, RES, ACC, HP+, ATK+, DEF+");
		int[] subStatArray = new int[rune.getSubStatArray().length];
		for(int i=0;i<rune.getSubStatArray().length;i++) {
			subStatArray[i]=scanner.nextInt();
		}
		rune.setSubStatArray(subStatArray);
		return rune;
	}
}
