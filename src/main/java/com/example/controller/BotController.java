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

		// JSONObject jiji = new JSONObject(obj);

		JSONObject sizeItem = new JSONObject();
		JSONArray areasArray = new JSONArray();
		JSONObject areasItem = new JSONObject();
		JSONArray boundsArray = new JSONArray();
		JSONArray actionsArray = new JSONArray();
		JSONObject boundsItem = new JSONObject();
		JSONObject actionsItem = new JSONObject();

		sizeItem.put("width", 2500);
		sizeItem.put("height", 1686);

		json.put("size", sizeItem);
		json.put("selected", false);
		json.put("name", "nice richmenu");
		json.put("chatBarText", "touch me");

		boundsItem.put("x", 0);
		boundsItem.put("y", 0);
		boundsItem.put("width", 2500);
		boundsItem.put("height", 1686);
		boundsArray.put(boundsItem);

		actionsItem.put("type", "postback");
		actionsItem.put("data", "action=buy&itemid=123");
		actionsArray.put(boundsItem);

		areasItem.put("bounds", boundsArray);
		areasItem.put("action", actionsArray);
		areasArray.put(areasItem);

		json.put("areas", areasArray);

		System.out.println("json : " + json);

		return json;

	}
}
