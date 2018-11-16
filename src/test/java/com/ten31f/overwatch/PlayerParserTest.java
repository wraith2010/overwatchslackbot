package com.ten31f.overwatch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ten31f.overwatch.parser.SlackParser;

public class PlayerParserTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
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

	@Test
	public void blankTest() {

		String[] players = SlackParser.parse(" ");

		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}

		players = SlackParser.parse("");
		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}
	}
}
