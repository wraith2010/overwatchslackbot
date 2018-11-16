package com.ten31f.overwatch.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;
import com.ten31f.overwatch.parser.SlackParser;

public class SlackParserTest {

	@Test
	public void convertMessageToJson() {

		String[] players = "ben, kristen, dave, evan, ron, ca dave".split(",");

		Engine engine = new Engine();
		Team team = engine.pick(players);

		System.out.println(SlackParser.buildMessage(team).toJSONString());
	}

	@Test
	public void slackRequestStringTest() {

		String requestString = "token=84ofwkN9qx2uWH8JWG13O6dt&team_id=T1ETWDNBX&team_domain=dudestormlog&channel_id=CCK7A442C&channel_name=bot-testing&user_id=U1ETPLA8N&user_name=wraith2010&command=%2Foverwatchme&text=ben%2Ckristen%2Cbill%2Cdave%2Csteve%2Cjim&response_url=https%3A%2F%2Fhooks.slack.com%2Fcommands%2FT1ETWDNBX%2F481794091234%2FowoDkq0qYlddOenF3gOSh7RL&trigger_id=481190078753.48948464405.ee6e8e4b41e51c5e2a1eda4edb2ef635";

		Map<String, String> requstMap = SlackParser.slackRequestParser(requestString);

		assertEquals("ben%2Ckristen%2Cbill%2Cdave%2Csteve%2Cjim", requstMap.get("text"));
	}
	
	@Test
	public void slackRequestStringBlankTextTest() {

		String requestString = "token=84ofwkN9qx2uWH8JWG13O6dt&team_id=T1ETWDNBX&team_domain=dudestormlog&channel_id=CCK7A442C&channel_name=bot-testing&user_id=U1ETPLA8N&user_name=wraith2010&command=%2Foverwatchme&text=&response_url=https%3A%2F%2Fhooks.slack.com%2Fcommands%2FT1ETWDNBX%2F481794091234%2FowoDkq0qYlddOenF3gOSh7RL&trigger_id=481190078753.48948464405.ee6e8e4b41e51c5e2a1eda4edb2ef635";

		Map<String, String> requstMap = SlackParser.slackRequestParser(requestString);

		assertNull(requstMap.get("text"));
	}

}
