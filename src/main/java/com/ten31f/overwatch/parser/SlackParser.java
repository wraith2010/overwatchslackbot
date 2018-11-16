package com.ten31f.overwatch.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ten31f.overwatch.engine.Character;
import com.ten31f.overwatch.engine.DJQuote;
import com.ten31f.overwatch.engine.Team;

public class SlackParser {

	private SlackParser() {
		// hide the constructor this class is static only
	}

	public static String[] parse(String input) {

		if (input == null || input.isEmpty() || StringUtils.isBlank(input)) {
			input = "6";
		}

		try {

			int playerCount = Integer.parseInt(input);
			String[] players = new String[playerCount];

			for (int index = 0; index < playerCount; index++) {
				players[index] = "Player " + (index + 1);
			}

			return players;

		} catch (NumberFormatException numberFormatException) {
			return input.split(",");
		}
	}

	@SuppressWarnings("unchecked")
	public static JSONObject buildMessage(Team team) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("response_type", "in_channel");

		JSONArray attachmentsJSONArray = new JSONArray();

		JSONObject attachmentJsonObject = new JSONObject();
		attachmentJsonObject.put("fallback", team.toString());
		attachmentJsonObject.put("pretext", DJQuote.getRandom().toString());

		JSONArray fieldsJSONArray = new JSONArray();

		List<String> keys = new ArrayList<>(team.getCharacterMap().keySet());

		Collections.sort(keys);

		for (String key : keys) {

			Character character = team.getCharacterMap().get(key);

			JSONObject fieldJsonObject = new JSONObject();
			fieldJsonObject.put("title", key);
			fieldJsonObject.put("short", true);
			fieldJsonObject.put("value",
					String.format("%s(%s)", character.getCharacterName(), character.getCharacterClass()));

			fieldsJSONArray.add(fieldJsonObject);
		}

		attachmentJsonObject.put("fields", fieldsJSONArray);

		attachmentsJSONArray.add(attachmentJsonObject);

		jsonObject.put("attachments", attachmentsJSONArray);

		return jsonObject;
	}

	public static Map<String, String> slackRequestParser(String requestString) {

		Map<String, String> result = new HashMap<>();

		List<String> dividedString = Arrays.asList(requestString.split("&"));

		for (String item : dividedString) {

			String[] parts = item.split("=");

			if (parts.length == 2) {
				result.put(parts[0], parts[1]);
			}
		}

		return result;
	}

}
