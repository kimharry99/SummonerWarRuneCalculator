package summonersWarRuneCalculator;

import java.util.Scanner;

public class RuneManager {
	
	public Rune scanRune() {
		Scanner scanner =new Scanner(System.in);
		RuneCalculation runecalculation = new RuneCalculation();
		
		System.out.println("���� ������ ��ȣ, �ִɷ�ġ�� ������� �Է��� �ּ���");
		int runeType = scanner.nextInt();
		int runeNumber = scanner.nextInt();
		int[]runeMainStat = new int [8];
		for(int i=0;i<runeMainStat.length;i++) {
			runeMainStat[i]=0;
		}
		runeMainStat[scanner.nextInt()]=scanner.nextInt();
		System.out.println("���� �ɷ�ġ�� �Է��� �ּ��� ü��, ���ݷ�, ����, ���ݼӵ�, ġ��Ÿ Ȯ��, ġ��Ÿ ����, ȿ�� ����, ȿ�� ���� ������");
		int[] statArray = new int[8];
		for(int i=0;i<8;i++) {
			statArray[i]=scanner.nextInt();
		}
		
		Rune rune = new Rune(runeType,runeNumber,runeMainStat,statArray);
		scanner.close();
		
		return rune;
	}
}
