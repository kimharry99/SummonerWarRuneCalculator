package summonersWarRuneCalculator;

public class Rune {
	String[] typeArray = { "Violent", "Swift", "Revenge", "Blade", "Focus", "Energy", "Fatal", "Despair", "Guard",
			"Endure", "Shield" };
	private int type = 0;
	private int number = 1;
	private int rarity = 4;
	private int runeLevel = 12;
	private int rank = 5;
	private int[] mainStat = new int [8];
	private int[] subStatArray = new int [11];
	int[] prefixStat = new int [11];
	/**
	 * 0 : prefixStat 1 : subStat
	 */
	double[][] statGradeArray = new double[2][8];
	String monster = "pheonix (water)";
	boolean searchable = true;

	public int getType() {
		return type;
	}

	public void setType(int _type) {
		this.type = _type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int _number) {
		this.number = _number;
	}

	public int getRarity() {
		return this.rarity;
	}

	public void setRarity(int _rarity) {
		this.rarity = _rarity;
	}

	public int getRuneLevel() {
		return this.runeLevel;
	}

	public void setRuneLevel(int _runeLevel) {
		this.runeLevel = _runeLevel;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int _rank) {
		this.rank = _rank;
	}

	public int[] getMainStat() {
		return mainStat;
	}

	public void setMainStat(int[] _mainStat) {
		this.mainStat = _mainStat;
	}

	public int[] getSubStatArray() {
		return subStatArray;
	}

	public void setSubStatArray(int[] _subStatArray) {
		this.subStatArray = _subStatArray;
		for (int i = 0; i < statGradeArray[1].length; i++) {
			if (0 <= i && i <= 2) {
				statGradeArray[1][i] = _subStatArray[i] / 6.5;
			} else if (2 < i && i < 5) {
				statGradeArray[1][i] = _subStatArray[i] / 5.0;
			} else if (i == 5) {
				statGradeArray[1][i] = _subStatArray[i] / 5.5;
			} else {
				statGradeArray[1][i] = _subStatArray[i] / 6.0;
			}
		}
	}

	public int[] getPrefixStat() {
		return prefixStat;
	}

	public void setPrefixStat(int[] _prefixStat) {
		this.prefixStat = _prefixStat;
		if (this.getRank() == 6) {
			for (int i = 0; i < statGradeArray[1].length; i++) {
				if (0 <= i && i <= 2) {
					statGradeArray[0][i] = _prefixStat[i] / 6.5;
				} else if (2 < i && i < 5) {
					statGradeArray[0][i] = _prefixStat[i] / 5.0;
				} else if (i == 5) {
					statGradeArray[0][i] = _prefixStat[i] / 5.5;
				} else {
					statGradeArray[0][i] = _prefixStat[i] / 6.0;
				}
			}
		} else {
			for (int i = 0; i < statGradeArray[1].length; i++) {
				if (0 <= i && i <= 2) {
					statGradeArray[0][i] = _prefixStat[i] / 5.5;
				} else if (2 < i && i < 5) {
					statGradeArray[0][i] = _prefixStat[i] / 4.0;
				} else if (i == 5) {
					statGradeArray[0][i] = _prefixStat[i] / 4.0;
				} else {
					statGradeArray[0][i] = _prefixStat[i] / 5.0;
				}
			}
		}
	}

	public double[][] getStatGradeArray() {
		return statGradeArray;
	}

	public void setStatGradeArray(double[][] _statGradeArray) {
		this.statGradeArray = _statGradeArray;
		if (this.getRank() == 6) {
			for (int i = 0; i < statGradeArray[0].length; i++) {
				if (0 <= i && i <= 2) {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 6.5);
				} else if (2 < i && i < 5) {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 5);
				} else if (i == 5) {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 5.5);
				} else {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 6);
				}
			}
			for (int i = 0; i < statGradeArray[1].length; i++) {
				if (0 <= i && i <= 2) {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 6.5);
				} else if (2 < i && i < 5) {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5);
				} else if (i == 5) {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5.5);
				} else {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 6);
				}
			}
		} else {
			for (int i = 0; i < statGradeArray[0].length; i++) {
				if (0 <= i && i <= 2) {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 5.5);
				} else if (2 < i && i < 5) {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 4);
				} else if (i == 5) {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 4);
				} else {
					prefixStat[i] = (int) Math.round(statGradeArray[0][i] * 5);
				}
			}
			for (int i = 0; i < statGradeArray[1].length; i++) {
				if (0 <= i && i <= 2) {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5.5);
				} else if (2 < i && i < 5) {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 4);
				} else if (i == 5) {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 4);
				} else {
					subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5);
				}
			}
		}
	}

	public void setSubStatGradeArray(double[] _subStatGradeArray) {
		this.statGradeArray[1] = _subStatGradeArray;
		if (this.getRank() == 6) {
			for (int i = 0; i < statGradeArray[1].length; i++) {
				if (0 <= i && i <= 2) {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 6.5);
				} else if (2 < i && i < 5) {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5);
				} else if (i == 5) {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5.5);
				} else {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 6);
				}
			}
		} else {
			for (int i = 0; i < statGradeArray[1].length; i++) {
				if (0 <= i && i <= 2) {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5.5);
				} else if (2 < i && i < 5) {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 4);
				} else if (i == 5) {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 4);
				} else {
					this.subStatArray[i] = (int) Math.round(statGradeArray[1][i] * 5);
				}
			}
		}
	}

	public Rune() {

	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.setSubStatArray(_subStatArray);
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.setPrefixStat(_prefixStat);
		this.setSubStatArray(_subStatArray);
	}

	public Rune(int _type, int _number, int _rarity, int[] _mainStat, int[] _prefixStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.rarity = _rarity;
		this.mainStat = _mainStat;
		this.setPrefixStat(_prefixStat);
		this.setSubStatArray(_subStatArray);
	}

	public Rune(int _type, int _number, int _rarity, int _runeLevel, int[] _mainStat, int[] _prefixStat,
			int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.rarity = _rarity;
		this.runeLevel = _runeLevel;
		this.mainStat = _mainStat;
		this.setPrefixStat(_prefixStat);
		this.setSubStatArray(_subStatArray);
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _subStatArray, String _monster) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.setPrefixStat(_prefixStat);
		this.setSubStatArray(_subStatArray);
		this.monster = _monster;
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _subStatArray, String _monster,
			boolean _searchable) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.setPrefixStat(_prefixStat);
		this.setSubStatArray(_subStatArray);
		this.monster = _monster;
		this.searchable = _searchable;
	}

}
