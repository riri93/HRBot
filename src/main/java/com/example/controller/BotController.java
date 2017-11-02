package com.example.controller;

import java.io.IOException;
import java.util.Arrays;
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

import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.ImageMessage;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.response.BotApiResponse;

import retrofit2.Response;

@RestController
public class BotController {

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	private @ResponseBody Map<String, Object> webhook(@RequestBody Map<String, Object> obj)
			throws JSONException, IOException {

		System.out.println("*******************WEBHOOOOOOOOOOK*******************");

		String channelToken = "pW48DucPjjO3rTx7SLMA9Ui98uVQjB+O0xLGqHs+PJynEdKiNBnva1pLSw5IJP0uOdwrR+Am4xkVm4kopj6GnsUvIyc0GqXQ4+oMUXT4OyS6zDN+2pHc20uHD0mLFQNsXWlPo9P1j89m6g2CG4mnmAdB04t89/1O/w1cDnyilFU=";

		Map<String, Object> json = new HashMap<String, Object>();

		JSONObject jsonResult = new JSONObject(obj);

		System.out.println("jsonResult : " + jsonResult);

		JSONObject rsl = jsonResult.getJSONObject("originalRequest");
		JSONObject data = rsl.getJSONObject("data");
		JSONObject source = data.getJSONObject("source");
		JSONObject message = data.getJSONObject("message");
		String userId = source.getString("userId");
		String customerMessage = message.getString("text");
		String timestamp = jsonResult.getString("timestamp");
		JSONObject result = jsonResult.getJSONObject("result");
		JSONObject metadata = result.getJSONObject("metadata");
		String intentName = metadata.getString("intentName");
		JSONObject parameters = result.getJSONObject("parameters");
		JSONObject fulfillment = result.getJSONObject("fulfillment");
		String speech = fulfillment.getString("speech");

		if (customerMessage.equals("osaka")) {
			carouselForUser(userId, channelToken, "Mutsuko", "Orino",
					"https://i.pinimg.com/736x/96/a0/54/96a0544ab7b6fa7cbdddff9c5d8397be--japanese-hairstyles-korean-hairstyles.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTH27Sxx6jQ5IraidAQovMU1OTnQWL-hqfN0kiEF5JoRXVoQ8N-g");

		} else {

		}

		return json;

	}

	/**
	 * Method for send carousel template message to use
	 * 
	 * @param userId
	 * @param lChannelAccessToken
	 * @param nameSatff1
	 * @param nameSatff2
	 * @param poster1_url
	 * @param poster2_url
	 */
	private void carouselForUser(String userId, String lChannelAccessToken, String nameSatff1, String nameSatff2,
			String poster1_url, String poster2_url) {
		CarouselTemplate carouselTemplate = new CarouselTemplate(
				Arrays.asList(
						new CarouselColumn(poster1_url, nameSatff1, "Select one for more info",
								Arrays.asList(new MessageAction("Call", "Call \"" + nameSatff1 + "\""),
										new MessageAction("Send email", "Send email \"" + nameSatff1 + "\""),
										new MessageAction("Availability of",
												"Availability of \"" + nameSatff1 + "\""))),
						new CarouselColumn(poster2_url, nameSatff2, "Select one for more info", Arrays.asList(
								new MessageAction("Call", "Call \"" + nameSatff2 + "\""),
								new MessageAction("Send email", "Send email \"" + nameSatff2 + "\""),
								new MessageAction("Availability of", "Availability of \"" + nameSatff2 + "\"")))));
		TemplateMessage templateMessage = new TemplateMessage("Your search result", carouselTemplate);
		PushMessage pushMessage = new PushMessage(userId, templateMessage);
		try {
			Response<BotApiResponse> response = LineMessagingServiceBuilder.create(lChannelAccessToken).build()
					.pushMessage(pushMessage).execute();
			System.out.println(response.code() + " " + response.message());
		} catch (IOException e) {
			System.out.println("Exception is raised ");
			e.printStackTrace();
		}
	}
}
