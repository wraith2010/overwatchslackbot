package com.ten31f.overwatch.parser;

import org.json.simple.JSONObject;

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

	public static JSONObject formLambdaMessage(JSONObject body) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("isBase64Encoded", false);
		jsonObject.put("statusCode", 200);
		jsonObject.put("body", body.toJSONString());
		jsonObject.put("headers", null);

		return jsonObject;

	}

}
