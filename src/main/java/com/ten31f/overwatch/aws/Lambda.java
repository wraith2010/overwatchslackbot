package com.ten31f.overwatch.aws;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.json.simple.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;
import com.ten31f.overwatch.parser.AWSLambdaParser;
import com.ten31f.overwatch.parser.SlackParser;

public class Lambda {

	private static final String KEY_BODY = "body";
	private static final String KEY_TEXT = "text";

	public JSONObject handleRequest(Map<String, Object> input, Context context) {

		LambdaLogger logger = context.getLogger();

		Map<String, String> slackRequst = SlackParser.slackRequestParser((String) input.get(KEY_BODY));

		String[] players;
		try {
			if (slackRequst.containsKey(KEY_TEXT)) {
				players = SlackParser.parse(URLDecoder.decode(slackRequst.get(KEY_TEXT), "UTF-8"));
			} else {
				players = SlackParser.parse(null);
			}

			Engine engine = new Engine();
			Team team = engine.pick(players);

			return AWSLambdaParser.formLambdaMessage(SlackParser.buildMessage(team));

		} catch (UnsupportedEncodingException unsupportedEncodingException) {

			logger.log(unsupportedEncodingException.getMessage());
		}

		return null;
	}

}
