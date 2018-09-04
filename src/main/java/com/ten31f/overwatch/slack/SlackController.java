package com.ten31f.overwatch.slack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ten31f.overwatch.engine.Character;
import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;

@RestController
public class SlackController {

	private static final Logger logger = LoggerFactory.getLogger(SlackController.class);

	@RequestMapping(value = "/overwatchme", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Message slack(@RequestParam(value = "token", required = false) String token,
			@RequestParam(value = "team_id", required = false) String teamID,
			@RequestParam(value = "team_domain", required = false) String teamDomain,
			@RequestParam(value = "enterprise_id", required = false) String enterpriseID,
			@RequestParam(value = "enterprise_name", required = false) String enterpriseName,
			@RequestParam(value = "channel_id", required = false) String channelID,
			@RequestParam(value = "channel_name", required = false) String channelName,
			@RequestParam(value = "user_id", required = false) String userID,
			@RequestParam(value = "user_name", required = false) String userName,
			@RequestParam(value = "command", required = false) String command,
			@RequestParam(value = "text", required = false) String text,
			@RequestParam(value = "response_url", required = false) String responseURL,
			@RequestParam(value = "trigger_id", required = false) String triggerID) {

		logger.info("token:\t{}", token);
		logger.info("team_id:\t{}", teamID);
		logger.info("team_domain:\t{}", teamDomain);
		logger.info("enterprise_id:\t{}", enterpriseID);
		logger.info("enterprise_name:\t{}", enterpriseName);
		logger.info("channel_id:\t{}", channelID);
		logger.info("channel_name:\t{}", channelName);
		logger.info("user_id:\t{}", userID);
		logger.info("user_name:\t{}", userName);
		logger.info("command:\t{}", command);
		logger.info("text:\t{}", text);
		logger.info("response_url:\t{}", responseURL);
		logger.info("trigger_id:\t{}", triggerID);

		String[] players = parse(text);

		Engine engine = new Engine();
		Team team = engine.pick(players);

		return buildMessage(team);
	}

	private Message buildMessage(Team team) {

		Message message = new Message();

		message.setResponseType(Message.ResponseType.IN_CHANNEL);

		List<Attachment> attachments = new ArrayList<>();

		Attachment attachment = new Attachment();
		attachment.setFallback(team.toString());
		attachment.setPretext(DJQuote.getRandom().toString());

		List<Field> fields = new ArrayList<>();

		for (Entry<String, Character> entry : team.getCharacterMap().entrySet()) {

			Field field = new Field();
			field.setShortBoolean(true);
			field.setTitle(entry.getKey());
			field.setValue(
					String.format("%s(%s)", entry.getValue().getCharacterName(), entry.getValue().getCharacterClass()));

			fields.add(field);
		}

		attachment.setFields(fields);

		attachments.add(attachment);

		message.setAttachments(attachments);

		return message;

	}

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
