package summonersWarRuneCalculator;

public class RuneCalculation {
	double[][] scoreArray = { { 0.5, 1, 0.5, 1, 1, 1, 0, 0 }, { 1, 1, 0.5, 0.5, 1, 1, 0, 0 },
			{ 0.5, 0, 1, 1, 1, 1, 0.5, 0 }, { 1, 0, 1, 1, 0, 0, 1, 0.5 }, { 1, 0, 1, 1, 0, 0, 1, 0.5 },
			{ 1, 1, 0.5, 1, 1, 0.5, 0, 0 }, { 1, 0.5, 1, 1, 0, 0, 0.5, 1 }, { 1, 0, 1, 1, 1, 0.5, 0, 0.5 } };
	String[] roleArray = { "Main Dealer", "Raid Dealer", "DEF Dealer", "Takner", "Healer", "ATK Healer", "Debuffer",
			"Bruiser" };

	public double calculateRuneScore(Rune _rune) {
		double[][] statGradeArray = _rune.statGradeArray;
		int maxScoreRole = 0;
		double runeScore = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			double tempScore = 0;
			if (this.checkRuneMainStat(_rune.mainStat)[i]) {
				for (int j = 0; j < scoreArray[i].length; j++) {
					tempScore += statGradeArray[0][j] * scoreArray[i][j];
					tempScore += statGradeArray[1][j] * scoreArray[i][j];
				}
			}
			if (runeScore < tempScore) {
				runeScore = tempScore;
				maxScoreRole = i;
			}
		}
		System.out
				.println("The best role of this rune is " + roleArray[maxScoreRole] + " and the score is " + runeScore);
		return runeScore;
	}

	public void calculateRunePotentional(Rune _rune) {
		double[][] statGradeArray = _rune.getStatGradeArray();
		
	}

	public boolean[] checkRuneMainStat(int[] _mainStat) {
		boolean[] booleanArray = { true, true, true, true, true, true, true, true, };
		for (int i = 0; i < _mainStat.length; i++) {
			if (_mainStat[i] != 0) {
				switch (i) {
				case 0:
					booleanArray[0] = false;
					booleanArray[2] = false;
					break;
				case 1:
					booleanArray[2] = false;
					booleanArray[3] = false;
					booleanArray[5] = false;
					booleanArray[7] = false;
					break;
				case 2:
					booleanArray[0] = false;
					break;
				case 3:
					booleanArray[3] = false;
					break;
				case 4:
					booleanArray[3] = false;
					booleanArray[4] = false;
					booleanArray[6] = false;
					break;
				case 5:
					booleanArray[3] = false;
					booleanArray[4] = false;
					booleanArray[6] = false;
					break;
				case 6:
					booleanArray[0] = false;
					booleanArray[1] = false;
					booleanArray[5] = false;
					booleanArray[7] = false;
					break;
				case 7:
					booleanArray[0] = false;
					booleanArray[1] = false;
					booleanArray[2] = false;
					booleanArray[5] = false;
					break;
				default:
					break;
				}
			}
		}
		return booleanArray;
	}
}
