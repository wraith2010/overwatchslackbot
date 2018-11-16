package com.ten31f.overwatch;

import org.junit.Test;

import com.ten31f.overwatch.parser.SlackParser;

public class PlayerParserTest {

	@Test
	public void listOfNamesTest() {

		String input = "Ben, Kristen, Dave, Evan, Ron, CA Dave";

		String[] players = SlackParser.parse(input);

		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}
	}

	@Test
	public void numberTest() {

		String[] players = SlackParser.parse("6");

		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}
	}
	
	@Test
	public void nullTest() {

		String[] players = SlackParser.parse(null);

		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}
	}

}
