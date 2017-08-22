package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.HairSalon;
import com.example.repository.HairSaloonRepository;

@RestController
public class BotController {

	@Autowired
	HairSaloonRepository hairSaloonRepository;

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	private @ResponseBody Map<String, Object> webhook(@RequestBody Map<String, Object> obj) throws JSONException {

		Map<String, Object> json = new HashMap<String, Object>();

		String Speech = "The cost of shipping to  is  for " + obj.get("result");

		HairSalon hairSalon = hairSaloonRepository.getHairSaloonByZone("Europe");

		json.put("speech", " The name of the Hair salon in Europe is : " + hairSalon.getName());
		json.put("displayText", " The name of the Hair salon in Europe is : " + hairSalon.getName());

		json.put("source", "apiai-onlinestore-shipping");

		System.out.println("*************************************");
		System.out.println(obj.get("result"));
		System.out.println("*************************************");
		return json;

	}
}
