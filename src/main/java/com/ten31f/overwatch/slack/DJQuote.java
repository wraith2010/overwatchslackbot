package com.ten31f.overwatch.slack;

import java.util.Random;

public enum DJQuote {

	PLANTS("You gotta water your plants. Nobody can water them for you."), PLAY("Don’t ever play yourself."), OVERWATCH(
			"Overwatch Me!!!!"), TWO_SINGLES("Another one, no. Another two, drop two singles at a time."), ROCK(
					"I don’t have no favorite rock bands. I’m a fan of rock music though."), CHANGE(
							"I changed… a lot."), JETSKI("They don’t want you to jet ski."), ADVICE(
									"You want my advice? Don’t play yourself."), WINNING(
											"Winning, to me, is easy. Winning more is the challenge."), COCOA_BUTER(
													"I love having an unlimited supply of cocoa butter."), UP(
															"People will try to bring you down, but you gotta go up.");

	private String text;

	private DJQuote(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {

		return String.format("\"%s\"\n\t\t--DJKhaled", getText());
	}

	public static DJQuote getRandom() {

		Random random = new Random(System.currentTimeMillis());

		return values()[random.nextInt(values().length)];

	}
}
