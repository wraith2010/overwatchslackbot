package com.ten31f.overwatch.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {

	private Map<String, Character> characterMap = null;

	public Team() {
		setCharacterMap(new HashMap<String, Character>());
	}

	public void accept(String player, Character character) {
		getCharacterMap().put(player, character);
	}

	public List<Character> clear() {

		List<Character> characters = new ArrayList<>();

		for (String player : getCharacterMap().keySet()) {
			characters.add(getCharacterMap().get(player));
		}

		getCharacterMap().clear();

		return characters;
	}

	public boolean validTeam() {

		if (!haveSupport() || !haveTank())
			return false;

		if (count(CharacterClass.TANK) > 2)
			return false;

		if (count(CharacterClass.SUPPORT) > 2)
			return false;

		return true;
	}

	private boolean haveTank() {

		for (String player : getCharacterMap().keySet()) {
			if (getCharacterMap().get(player).getCharacterClass().equals(CharacterClass.TANK))
				return true;
		}

		return false;
	}

	private boolean haveSupport() {

		for (String player : getCharacterMap().keySet()) {
			if (getCharacterMap().get(player).getCharacterClass().equals(CharacterClass.SUPPORT))
				return true;
		}

		return false;
	}

	public Map<String, Character> getCharacterMap() {
		return characterMap;
	}

	private void setCharacterMap(Map<String, Character> characterMap) {
		this.characterMap = characterMap;
	}

	private int count(CharacterClass characterClass) {
		int count = 0;

		for (String player : getCharacterMap().keySet()) {
			if (getCharacterMap().get(player).getCharacterClass().equals(characterClass))
				count++;
		}

		return count;
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		for (String player : getCharacterMap().keySet()) {
			stringBuilder.append(player + " -> " + getCharacterMap().get(player).getCharacterName() + "("
					+ getCharacterMap().get(player).getCharacterClass() + ")" + "\n");
		}

		return stringBuilder.toString();
	}

}
