package com.example.controller;

import java.util.HashMap;
import java.util.Map;

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
	private @ResponseBody Map<String, Object> webhook(@RequestBody Map<String, Object> obj) throws JSONException {

		System.out.println("WEBHOOOOOOOOOOK");
		
		Map<String, Object> json = new HashMap<String, Object>();

		JSONObject jiji = new JSONObject(obj);

		String eventName = jiji.getJSONObject("event").getString("name");

		System.out.println("event lkol : " + jiji.getJSONObject("event"));

		System.out.println("eventName : " + eventName);

		if (eventName.equals("welcome")) {
			json.put("speech", " hhhhhhhhhhhhhhh");
			json.put("displayText", " Do you have an account? ");
			json.put("source", "apiai-onlinestore-shipping");

		}

		return json;

	}
}
