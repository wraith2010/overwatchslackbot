package com.ten31f.overwatch.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;
import com.ten31f.overwatch.parser.SlackParser;

public class Lambda implements RequestHandler<String, String> {

	public String handleRequest(String input, Context context) {

		String[] players = SlackParser.parse(input);

		Engine engine = new Engine();
		Team team = engine.pick(players);

		return SlackParser.buildMessage(team);
	}

}
