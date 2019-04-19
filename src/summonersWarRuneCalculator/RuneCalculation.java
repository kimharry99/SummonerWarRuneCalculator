package summonersWarRuneCalculator;

import java.util.Arrays;

public class RuneCalculation {
	double[][] scoreArray = { { 0.5, 1, 0, 1, 1, 1, 0, 0 }, { 0.5, 1, 0.5, 0.5, 1, 1, 0.5, 0 },
			{ 0.5, 0, 1, 1, 1, 1, 0, 0 }, { 1, 0, 1, 0.5, 0, 0, 1, 0.5 }, { 1, 0, 1, 1, 0, 0, 1, 0.5 },
			{ 1, 1, 0.5, 1, 0.5, 0.5, 0, 0 },  { 1, 0, 1, 1, 1, 0.5, 0, 0.5 },
			{ 0.5, 1, 0, 1, 0.5, 0.5, 0, 1 } };
	String[] roleArray = { "Main Dealer", "Raid Dealer", "DEF Dealer", "Takner", "Healer", "ATK Healer",
			"Bruiser", "Bomb Dealer" };

	/**
	 * check runeMainStat than exclude some monster role
	 * 
	 * @param _mainStat
	 * @return booleanList
	 */
	public boolean[] excludeRuneRole(Rune _rune) {
		int[] _mainStat = _rune.getMainStat();
		boolean[] booleanArray = new boolean[scoreArray.length];
		for (int i = 0; i < booleanArray.length; i++) {
			booleanArray[i] = true;
		}
		for (int i = 0; i < _mainStat.length; i++) {
			if (_mainStat[i] != 0) {
				switch (i) {
				case 0:
					booleanArray[0] = false;
					booleanArray[2] = false;
					booleanArray[7] = false;
					if (_rune.getNumber() == 2) {
						booleanArray[4] = false;
						booleanArray[5] = false;
						booleanArray[6] = false;
					}
					if (_rune.getNumber() == 4) {
						booleanArray[1] = false;
						booleanArray[6] = false;
					}

					break;
				case 1:
					booleanArray[2] = false;
					booleanArray[3] = false;
					booleanArray[4]=false;
					booleanArray[5] = false;
					booleanArray[6] = false;
					if (_rune.getNumber() == 2) {
						booleanArray[4] = false;
						booleanArray[6] = false;
					}
					break;
				case 2:
					booleanArray[0] = false;
					if (_rune.getNumber() == 2) {
						booleanArray[4] = false;
						booleanArray[6] = false;
					}
					if (_rune.getNumber() == 4) {
						booleanArray[1] = false;
						booleanArray[5] = false;
					}
					booleanArray[7] = false;
					break;
				case 3:
					booleanArray[3] = false;
					break;
				case 4:
					booleanArray[3] = false;
					booleanArray[4] = false;
					if (_rune.getNumber() == 2) {
						booleanArray[5] = false;
					}
					break;
				case 5:
					booleanArray[3] = false;
					booleanArray[4] = false;
					if (_rune.getNumber() == 2) {
						booleanArray[5] = false;
					}
					break;
				case 6:
					booleanArray[0] = false;
					booleanArray[1] = false;
					booleanArray[5] = false;
					booleanArray[4] = false;
					booleanArray[6] = false;
					booleanArray[7] = false;
					break;
				case 7:
					booleanArray[0] = false;
					booleanArray[1] = false;
					booleanArray[2] = false;
					booleanArray[5] = false;
					booleanArray[7] = false;
					break;
				default:
					break;
				}
			}
		}
		return booleanArray;
	}

	/**
	 * return type of rune options in order. base value is 8
	 * 
	 * @param _rune
	 * @return int[] optionTypeNumber
	 */
	public int[] optionTypeNumber(Rune _rune) {
		int[] optionTypeNumber = { 8, 8, 8, 8 };
		int cnt = 0;
		for (int i = 0; i < _rune.getSubStatArray().length; i++) {
			if (_rune.getSubStatArray()[i] > 0) {
				optionTypeNumber[cnt] = i;
				++cnt;
			}
		}
		return optionTypeNumber;
	}

	/**
	 * 
	 * @param _rune
	 * @return
	 */
	public int[] selectUpgradeableOptions(Rune _rune) {
		int a = 11;
		// hp% atk% def% spd+ ... acc% hp+ atk+ def+
		boolean[] tempBooleanArray = new boolean[11];
		for (int i = 0; i < tempBooleanArray.length; i++) {
			tempBooleanArray[i] = true;
		}
		// main stat
		for (int i = 0; i < _rune.getSubStatArray().length; i++) {
			if (_rune.getSubStatArray()[i] != 0) {
				--a;
				tempBooleanArray[i] = false;
			}
		}
		for (int i = 0; i < _rune.getPrefixStat().length; i++) {
			if (_rune.getPrefixStat()[i] != 0) {
				--a;
				tempBooleanArray[i] = false;
			}
		}
		switch (_rune.getNumber()) {
		// case atk : exclude def+ def%
		case 1:
			tempBooleanArray[2] = false;
			tempBooleanArray[10] = false;
			tempBooleanArray[9] = false;
			a = a - 3;
			break;
		case 3:
			tempBooleanArray[1] = false;
			tempBooleanArray[9] = false;
			tempBooleanArray[10] = false;
			a = a - 3;
			break;
		case 2:
		case 4:
		case 6:
			for (int i = 0; i < _rune.getMainStat().length; i++) {
				if (_rune.getMainStat()[i] != 0) {
					--a;
					tempBooleanArray[i] = false;
				}
			}
			break;
		default:
			break;
		}
		int[] upgradeableOptionsArray = new int[a];

		for (int i = 0; i < 11; i++) {
			if (tempBooleanArray[i]) {
				upgradeableOptionsArray[a - 1] = i;
				--a;
			}
		}
		return upgradeableOptionsArray;
	}

	/**
	 * return all cases of rune upgrade
	 * 
	 * @param _rune
	 * @return runeArray
	 */
	public Rune[] temporarilyUpgradeRune(Rune _rune) {
		Rune[] runeCaseArray;
		int runeCase = 0;
		int[] upgradeableOptions = selectUpgradeableOptions(_rune);
		runeCaseArray = new Rune[(int) Math.pow(_rune.getRarity(), _rune.getRarity()) * upgradeableOptions.length
				* (upgradeableOptions.length - 1)];
		for (int i0 = 0; i0 < _rune.getRarity(); i0++) {
			for (int i1 = 0; i1 < _rune.getRarity(); i1++) {
				for (int i2 = 0; i2 < _rune.getRarity(); i2++) {
					for (int i3 = 0; i3 < _rune.getRarity(); i3++) {
						for (int j0 = 0; j0 < upgradeableOptions.length; j0++) {
							for (int j1 = 0; j1 < upgradeableOptions.length
									&& runeCase < runeCaseArray.length; runeCase++, j1++) {
								if (j0 == j1) {
									runeCase--;
									continue;
								}
								// upgrade tempCntTh option (tempUpgradeArray[tempCnt]) times
								int[] tempMainStat = new int[_rune.getMainStat().length];
								System.arraycopy(_rune.getMainStat(), 0, tempMainStat, 0, _rune.getMainStat().length);
								int[] tempPrefixStat = new int[_rune.getPrefixStat().length];
								System.arraycopy(_rune.getPrefixStat(), 0, tempPrefixStat, 0,
										_rune.getPrefixStat().length);
								int[] tempSubStatArray = new int[_rune.getSubStatArray().length];
								System.arraycopy(_rune.getSubStatArray(), 0, tempSubStatArray, 0,
										_rune.getSubStatArray().length);
								Rune tempRune = new Rune(_rune.getType(), _rune.getNumber(), _rune.getRarity(), 0,
										tempMainStat, tempPrefixStat, tempSubStatArray);
								tempRune.setRank(_rune.getRank());
								tempRune.setRuneLevel(_rune.getRuneLevel());

								int[] tempUpgradeArray = new int[4];
								if (_rune.getRarity() - _rune.getRuneLevel() / 3 > 0) {
									++tempUpgradeArray[i3];
									if (_rune.getRarity() - _rune.getRuneLevel() / 3 > 1) {
										++tempUpgradeArray[i2];
										if (_rune.getRarity() - _rune.getRuneLevel() / 3 > 2) {
											++tempUpgradeArray[i1];
											if (_rune.getRarity() - _rune.getRuneLevel() / 3 > 3) {
												++tempUpgradeArray[i0];
											}
										}
									}
								}

								double[] tempUpgradeGradeArray = new double[_rune.statGradeArray[1].length];
								for (int t = 0; t < tempUpgradeArray.length; t++) {
									if (this.optionTypeNumber(_rune)[t] < 8) {
										tempUpgradeGradeArray[this.optionTypeNumber(_rune)[t]] = _rune
												.getStatGradeArray()[1][this.optionTypeNumber(_rune)[t]]
												+ tempUpgradeArray[t];
									}
								}
								// TODO: case rarity < 4 upgrade random stat
								if (_rune.getRarity() < 4) {
									if (upgradeableOptions[j0] < 8)
										++tempUpgradeGradeArray[upgradeableOptions[j0]];
									if (_rune.getRarity() < 3) {
										if (upgradeableOptions[j1] < 8)
											++tempUpgradeGradeArray[upgradeableOptions[j1]];
									}
								}
								tempRune.setSubStatGradeArray(tempUpgradeGradeArray);
								runeCaseArray[runeCase] = tempRune;
							}
						}
					}
				}
			}
		}
		return runeCaseArray;
	}

	/**
	 * return max value of runeScore and prints best role
	 * 
	 * @param _rune
	 * @return max value of runeScore
	 */
	public double calculateRuneScore(Rune _rune, boolean _printInformation) {
		int maxScoreRole = 0;
		double runeScore = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			double tempScore = 0;
			if (this.excludeRuneRole(_rune)[i]) {
				for (int j = 0; j < scoreArray[i].length; j++) {
					tempScore += _rune.getStatGradeArray()[0][j] * scoreArray[i][j];
					tempScore += _rune.getStatGradeArray()[1][j] * scoreArray[i][j];
				}
			}
			if (runeScore < tempScore) {
				runeScore = tempScore;
				maxScoreRole = i;
			}
		}
		runeScore = Math.round(runeScore * 100) / 100.0;
		if (_printInformation)
			System.out.println(
					"\nThe best role of this rune is " + roleArray[maxScoreRole] + " and the score is " + runeScore);
		return runeScore;
	}

	public void calculateRunePotentional(Rune _rune) {
		int probability = 0;
		double meanScore=0;
		int cnt=0;
		Rune[] tempUpgradeRuneArray = this.temporarilyUpgradeRune(_rune);
		for (int i = 0; i < tempUpgradeRuneArray.length; i++) {
			double tempRuneScore = this.calculateRuneScore(tempUpgradeRuneArray[i], false);
			if (tempUpgradeRuneArray[i].getNumber() % 2 == 1) {
				if (tempRuneScore >= 5.8) {
					++probability;
					cnt++;
					meanScore += tempRuneScore;
					System.out.println(Arrays.toString(tempUpgradeRuneArray[i].getSubStatArray()) + " "
							+ this.calculateRuneScore(tempUpgradeRuneArray[i], true));

				}
			} else {
				if (this.calculateRuneScore(tempUpgradeRuneArray[i], false) >= 3.8) {
					++probability;
					++cnt;
					meanScore += tempRuneScore;
					System.out.println(Arrays.toString(tempUpgradeRuneArray[i].getSubStatArray()) + " "
							+ Math.round(this.calculateRuneScore(tempUpgradeRuneArray[i], true) * 100 / 100.0));
				}
			}
		}
		System.out.println("average score of rune is "+Math.round(meanScore/cnt * 100) / 100.0);
		System.out.println("this rune can be over " + ((_rune.getNumber() % 2 == 0) ? 4 : 6) + " score about "
				+ (double) probability * 100 / tempUpgradeRuneArray.length + "%");

	}

}
