package com.example.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	private @ResponseBody Map<String, Object> webhook(@RequestBody Map<String, Object> obj)
			throws JSONException, IOException {

		System.out.println("*******************WEBHOOOOOOOOOOK*******************");

		Map<String, Object> json = new HashMap<String, Object>();

		JSONObject jsonResult = new JSONObject(obj);

		System.out.println("jsonResult : " + jsonResult);

//		JSONObject rsl = jsonResult.getJSONObject("originalRequest");
//		JSONObject data = rsl.getJSONObject("data");
//		JSONObject source = data.getJSONObject("source");
//		JSONObject message = data.getJSONObject("message");
//		String userId = source.getString("userId");
//		String customerMessage = message.getString("text");
//		String timestamp = jsonResult.getString("timestamp");
//		JSONObject result = jsonResult.getJSONObject("result");
//		JSONObject metadata = result.getJSONObject("metadata");
//		String intentName = metadata.getString("intentName");
//		JSONObject parameters = result.getJSONObject("parameters");
//		JSONObject fulfillment = result.getJSONObject("fulfillment");
//		String speech = fulfillment.getString("speech");

		return json;

	}
}
