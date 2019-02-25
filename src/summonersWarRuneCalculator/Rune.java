package summonersWarRuneCalculator;

public class Rune {
	String[] typeArray = {"폭주","신속","반격","칼날","집중","활력","맹공","절망","수호","인내","보호"};
	int type=0, number=1;
	int rarity = 4;
	int runeLevel=12;
	int []mainStat = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] subStatArray = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int []prefixStat = { 0, 0, 0, 0, 0, 0, 0, 0 };
	String monster = "물피닉스";
	boolean searchable=true;

	public Rune(int _type, int _number, int[] _mainStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.subStatArray = _subStatArray;
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _subStatArray;
	}
	
	public Rune(int _type, int _number, int _rarity, int[] _mainStat, int[] _prefixStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.rarity=_rarity;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _subStatArray;
	}

	public Rune(int _type, int _number, int _rarity, int _runeLevel, int[] _mainStat, int[] _prefixStat, int[] _subStatArray) {
		this.type = _type;
		this.number = _number;
		this.rarity=_rarity;
		this.runeLevel=_runeLevel;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _subStatArray;
	}

	
	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _subStatArray, String _monster) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _subStatArray;
		this.monster = _monster;
	}

	public Rune(int _type, int _number, int[] _mainStat, int[] _prefixStat, int[] _subStatArray, String _monster,
			boolean _searchable) {
		this.type = _type;
		this.number = _number;
		this.mainStat = _mainStat;
		this.prefixStat = _prefixStat;
		this.subStatArray = _subStatArray;
		this.monster = _monster;
		this.searchable = _searchable;
	}

}
