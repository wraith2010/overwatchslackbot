package com.ten31f.overwatch.parser;

public class AWSLambdaParser {

	public static String[] parse(String input) {

		try {

			int playerCount = Integer.parseInt(input);

			String[] players = new String[playerCount];

			for (int index = 0; index < playerCount; index++) {

				players[index] = "Player " + (index + 1);

			}

			return players;

		} catch (NumberFormatException numberFormatException) {

		}

		return input.split(",");
	}
	
}
