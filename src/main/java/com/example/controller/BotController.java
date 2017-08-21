package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	private @ResponseBody JSONArray webhook(@RequestBody Map<String, Object> obj) throws JSONException {
		System.out.println("************* ******************" + obj);
		// Map<String, Object> json = new HashMap<String, Object>();

		JSONObject json = new JSONObject();

		String Speech = "The cost of shipping to  is  for " + obj.get("result");

		json.put("speech", Speech);
		json.put("displayText", " The cost of shipping to  is  1000 euros.");

		json.put("source", "apiai-onlinestore-shipping");

		JSONArray ja = new JSONArray();
		ja.put(json);

		return ja;

	}
}
