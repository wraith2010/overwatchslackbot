package com.ten31f.overwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ten31f.overwatch.engine.Engine;
import com.ten31f.overwatch.engine.Team;
import com.ten31f.overwatch.slack.Attachment;
import com.ten31f.overwatch.slack.Field;
import com.ten31f.overwatch.slack.Message;
import com.ten31f.overwatch.engine.Character;

public class MessageToJsonTest {

	private static final String QUOTE = "\"Don’t ever play yourself.\"\n\t\t--DJ Khaled";

	@Test
	public void convertMessageToJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		String[] players = "ben, kristen, dave, evan, ron, ca dave".split(",");

		Engine engine = new Engine();
		Team team = engine.pick(players);

		Message message = new Message();

		message.setText(QUOTE);

		List<Attachment> attachments = new ArrayList<>();

		Attachment attachment = new Attachment();
		attachment.setFallback(team.toString());
		attachment.setPretext(QUOTE);

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

		System.out.println(mapper.writeValueAsString(message));
	}

}
