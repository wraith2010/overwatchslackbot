package com.ten31f.overwatch.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Engine {

	private List<Character> characters;

	private Random random;

	public Engine() {

		setRandom(new Random(System.currentTimeMillis()));

		setCharacters(new ArrayList<Character>());

		getCharacters().add(new Character("D.VA", CharacterClass.TANK));
		getCharacters().add(new Character("ORISA", CharacterClass.TANK));
		getCharacters().add(new Character("REINHARDT", CharacterClass.TANK));
		getCharacters().add(new Character("ROADHOG", CharacterClass.TANK));
		getCharacters().add(new Character("WINSTON", CharacterClass.TANK));
		getCharacters().add(new Character("WRECKING BALL", CharacterClass.TANK));
		getCharacters().add(new Character("ZARYTA", CharacterClass.TANK));

		getCharacters().add(new Character("BASTION", CharacterClass.DAMAGE));
		getCharacters().add(new Character("DOOMFIST", CharacterClass.DAMAGE));
		getCharacters().add(new Character("GENJI", CharacterClass.DAMAGE));
		getCharacters().add(new Character("HANZO", CharacterClass.DAMAGE));
		getCharacters().add(new Character("JUNKRAT", CharacterClass.DAMAGE));
		getCharacters().add(new Character("MCCREE", CharacterClass.DAMAGE));
		getCharacters().add(new Character("MEI", CharacterClass.DAMAGE));

		getCharacters().add(new Character("PHARAH", CharacterClass.DAMAGE));
		getCharacters().add(new Character("REAPER", CharacterClass.DAMAGE));
		getCharacters().add(new Character("SOLDIER: 76", CharacterClass.DAMAGE));
		getCharacters().add(new Character("SOMBRA", CharacterClass.DAMAGE));
		getCharacters().add(new Character("SYMMETRA", CharacterClass.DAMAGE));
		getCharacters().add(new Character("TORBJORN", CharacterClass.DAMAGE));
		getCharacters().add(new Character("TRACER", CharacterClass.DAMAGE));

		getCharacters().add(new Character("WINDOWMAKER", CharacterClass.DAMAGE));
		getCharacters().add(new Character("ANA", CharacterClass.SUPPORT));
		getCharacters().add(new Character("BRIGITTE", CharacterClass.SUPPORT));
		getCharacters().add(new Character("LUCIO", CharacterClass.SUPPORT));
		getCharacters().add(new Character("MERCY", CharacterClass.SUPPORT));
		getCharacters().add(new Character("MOIRA", CharacterClass.SUPPORT));
		getCharacters().add(new Character("ZENYATTA", CharacterClass.SUPPORT));
		
		getCharacters().add(new Character("ASHE", CharacterClass.DAMAGE));	
	}

	public Team pick(String[] players) {

		Team team = new Team();

		List<String> playerList = Arrays.asList(players);

		Collections.shuffle(playerList);

		while (!team.validTeam()) {

			getCharacters().addAll(team.clear());

			playerList.stream().forEach(
					player -> team.accept(player, getCharacters().remove(getRandom().nextInt(getCharacters().size()))));
		}

		return team;

	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

}
