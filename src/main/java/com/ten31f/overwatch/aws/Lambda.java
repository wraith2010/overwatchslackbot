package com.ten31f.overwatch.aws;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.json.simple.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;
import com.ten31f.overwatch.parser.AWSLambdaParser;
import com.ten31f.overwatch.parser.SlackParser;

public class Lambda {

	public JSONObject handleRequest(Map<String, Object> input, Context context) {

		Map<String, String> slackRequst = SlackParser.slackRequestParser((String) input.get("body"));

		String[] players;
		try {
			players = SlackParser.parse(URLDecoder.decode(slackRequst.get("text"), "UTF-8"));

			Engine engine = new Engine();
			Team team = engine.pick(players);

			return AWSLambdaParser.formLambdaMessage(SlackParser.buildMessage(team));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}

}
