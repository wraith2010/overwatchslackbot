package com.ten31f.overwatch.parser;

import org.junit.Test;

import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;

public class AWSLambdaPaserTest {

	@Test
	public void formLambdaMessageTest() {

		String[] players = "ben, kristen, dave, evan, ron, ca dave".split(",");

		Engine engine = new Engine();
		Team team = engine.pick(players);

		System.out.println(AWSLambdaParser.formLambdaMessage(SlackParser.buildMessage(team)).toJSONString());

	}

}
