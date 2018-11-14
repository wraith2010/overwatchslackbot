package com.ten31f.overwatch.parser;

import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ten31f.overwatch.engine.Character;
import com.ten31f.overwatch.engine.Team;
import com.ten31f.overwatch.slack.DJQuote;

public class SlackParser {

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
	
	@SuppressWarnings("unchecked")
	public static String buildMessage(Team team) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("response_type", "in_channel");

		JSONArray attachmentsJSONArray = new JSONArray();

		JSONObject attachmentJsonObject = new JSONObject();
		attachmentJsonObject.put("fallback", team.toString());
		attachmentJsonObject.put("pretext", DJQuote.getRandom().toString());

		JSONArray fieldsJSONArray = new JSONArray();

		for (Entry<String, Character> entry : team.getCharacterMap().entrySet()) {

			JSONObject fieldJsonObject = new JSONObject();
			fieldJsonObject.put("title", fieldJsonObject);
			fieldJsonObject.put("short", false);
			fieldJsonObject.put("value",
					String.format("%s(%s)", entry.getValue().getCharacterName(), entry.getValue().getCharacterClass()));

			fieldsJSONArray.add(fieldJsonObject);
		}

		attachmentJsonObject.put("fields", fieldsJSONArray);

		attachmentsJSONArray.add(attachmentJsonObject);

		jsonObject.put("attachments", attachmentsJSONArray);

		return jsonObject.toJSONString();
	}

}
