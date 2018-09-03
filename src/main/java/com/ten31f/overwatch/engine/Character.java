package com.ten31f.overwatch.engine;

public class Character {

	private CharacterClass characterClass;
	
	private String characterName;

	public Character(String characterName, CharacterClass characterClass) {
		setCharacterClass(characterClass);
		setCharacterName(characterName);
	}
	
		
	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(CharacterClass characterClass) {
		this.characterClass = characterClass;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	
	
}
