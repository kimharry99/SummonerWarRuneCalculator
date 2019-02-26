package summonersWarRuneCalculator;

public class Rune {
	String[] typeArray = {"Violent","Swift","Revenge","Blade","Focus","Energy","Fatal","Despair","Guard","Endure","Shield"};
	int type=0, number=1;
	int rarity = 4;
	int runeLevel=12;
	int []mainStat = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] subStatArray = { 0, 0, 0, 0, 0, 0, 0, 0 };
	double[][] statGradeArray=new double [2][8];
	int []prefixStat = { 0, 0, 0, 0, 0, 0, 0, 0 };
	String monster = "pheonix (water)";
	boolean searchable=true;

	public int getRarity() {
		return this.rarity;
	}
	public void setRarity(int _rarity) {
		this.rarity=_rarity;
	}
	public int getRuneLevel() {
		return this.runeLevel;
	}
	public void setruneLevel(int _runeLevel) {
		this.runeLevel=_runeLevel;
	}
	public int[] getSubStatArray() {
		return subStatArray;
	}
	public void setSubStatArray(int [] _subStatArray) {
		this.subStatArray=_subStatArray;
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
	public int[] getprefixStat() {
		return prefixStat;
	}
	public void setPrefixStat(int [] _prefixStat) {
		this.prefixStat=_prefixStat;
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
	}
	public double[][] getStatGradeArray() {
		return statGradeArray;
	}
	public void setStatGradeArray(double[][] _statGradeArray) {
		this.statGradeArray = _statGradeArray;
		for(int i=0;i<statGradeArray[0].length;i++) {
			if (0 <= i && i <= 2) {
				prefixStat[i]=(int)Math.round(statGradeArray[0][i]*6.5);
			} else if (2 < i && i < 5) {
				prefixStat[i]=(int)Math.round(statGradeArray[0][i]*5);
			} else if (i == 5) {
				prefixStat[i]=(int)Math.round(statGradeArray[0][i]*5.5);
			} else {
				prefixStat[i]=(int)Math.round(statGradeArray[0][i]*6);
			}
		}
		for(int i=0;i<statGradeArray[1].length;i++) {
			if (0 <= i && i <= 2) {
				subStatArray[i]=(int)Math.round(statGradeArray[1][i]*6.5);
			} else if (2 < i && i < 5) {
				subStatArray[i]=(int)Math.round(statGradeArray[1][i]*5);
			} else if (i == 5) {
				subStatArray[i]=(int)Math.round(statGradeArray[1][i]*5.5);
			} else {
				subStatArray[i]=(int)Math.round(statGradeArray[1][i]*6);
			}
		}
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
		this.rarity=_rarity;
		this.mainStat = _mainStat;
		this.setPrefixStat(_prefixStat);
		this.setSubStatArray(_subStatArray);
	}

	public Rune(int _type, int _number, int _rarity, int _runeLevel, int[] _mainStat, int[] _prefixStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.rarity=_rarity;
		this.runeLevel=_runeLevel;
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
