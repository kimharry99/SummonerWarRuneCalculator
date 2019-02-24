package summonersWarRuneCalculator;

public class Rune {
	int type, number;
	int rarity = 4;
	int []mainStat = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] subStatArray = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int []prefixStat = { 0, 0, 0, 0, 0, 0, 0, 0 };
	String monster;
	boolean searchable;

	public Rune(int _type, int _number, int[] _mainStat, int[] _statArray) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.subStatArray = _statArray;
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _statArray) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _statArray;
	}
	
	public Rune(int _type, int _number, int _rarity, int[] _mainStat, int[] _prefixStat, int[] _statArray) {
		this.type = _type;
		this.number = _number;
		this.rarity=_rarity;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _statArray;
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _statArray, String _monster) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _statArray;
		this.monster = _monster;
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _statArray, String _monster,
			boolean _searchable) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _statArray;
		this.monster = _monster;
		this.searchable = _searchable;
	}

}
