package com.ten31f.overwatch;

import org.junit.Test;

import com.ten31f.overwatch.slack.SlackController;

public class PlayerParserTest {

	@Test
	public void listOfNamesTest() {

		String input = "Ben, Kristen, Dave, Evan, Ron, CA Dave";

		String[] players = SlackController.parse(input);

		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}
	}

	@Test
	public void numberTest() {

		String[] players = SlackController.parse("6");

		for (int index = 0; index < players.length; index++) {
			System.out.println(players[index]);
		}
	}

}
