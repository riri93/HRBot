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

		Map<String, Object> json = new HashMap<String, Object>();

		JSONObject jiji = new JSONObject(obj);

		String shippingZone = jiji.getJSONObject("result").getJSONObject("parameters").getString("shipping-zone");

		json.put("speech", " The name of the Hair salOon in " + shippingZone + " is : ");
		json.put("displayText", " The name of the Hair salon in " + shippingZone + " is : ");
		json.put("source", "apiai-onlinestore-shipping");

		return json;

	}
}
