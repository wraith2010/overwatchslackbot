package com.ten31f.overwatch.parser;

import org.json.simple.JSONObject;

public class AWSLambdaParser {

	private AWSLambdaParser() {
		// hide the constructor this class is static only
	}

	@SuppressWarnings("unchecked")
	public static JSONObject formLambdaMessage(JSONObject body) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("isBase64Encoded", false);
		jsonObject.put("statusCode", 200);
		jsonObject.put("body", body.toJSONString());
		jsonObject.put("headers", null);

		return jsonObject;

	}

}
