package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
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

import antlr.collections.List;
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

		System.out.println("intentName : " + intentName);

		System.out.println("parameters : " + parameters);

		Random rand = new Random();
		java.util.List<String> sampleLinksOsaka = new ArrayList<>();
		java.util.List<String> sampleLinksTokyo = new ArrayList<>();

		java.util.List<String> randomLinksOsaka = new ArrayList<>();
		java.util.List<String> randomLinksTokyo = new ArrayList<>();

		sampleLinksOsaka.add("http://www.cjs.ne.jp/detail_b/T0000115892.html");
		sampleLinksOsaka.add("http://www.cjs.ne.jp/detail_b/T0000394280.html");
		sampleLinksOsaka.add("http://www.cjs.ne.jp/detail_b/T0000282562.html");
		sampleLinksOsaka.add("http://www.cjs.ne.jp/detail_b/T0000301712.html");
		sampleLinksOsaka.add("http://www.cjs.ne.jp/detail_b/T0000245299.html");
		sampleLinksOsaka.add("http://www.cjs.ne.jp/detail_b/T0000242702.html");

		sampleLinksTokyo.add("http://www.cjs.ne.jp/detail_b/T0000430079.html");
		sampleLinksTokyo.add("http://www.cjs.ne.jp/detail_b/T0000016010.html");
		sampleLinksTokyo.add("http://www.cjs.ne.jp/detail_b/T0000075865.html");
		sampleLinksTokyo.add("http://www.cjs.ne.jp/detail_b/T0000007615.html");
		sampleLinksTokyo.add("http://www.cjs.ne.jp/detail_b/T0000007413.html");
		sampleLinksTokyo.add("http://www.cjs.ne.jp/detail_b/T0000255552.html");

		for (int i = 0; i < 5; i++) {
			int r = rand.nextInt(sampleLinksOsaka.size());
			if (!randomLinksOsaka.contains(sampleLinksOsaka.get(r))) {
				randomLinksOsaka.add(sampleLinksOsaka.get(r));
			}
		}

		for (int i = 0; i < 5; i++) {
			int r = rand.nextInt(sampleLinksTokyo.size());
			if (!randomLinksTokyo.contains(sampleLinksTokyo.get(r))) {
				randomLinksTokyo.add(sampleLinksTokyo.get(r));
			}
		}

		if (intentName != "Default Fallback Intent") {
			if (customerMessage.toLowerCase().equals("osaka")
					|| (parameters != null && parameters.getString("japan-cities").toLowerCase().equals("osaka"))) {
				carouselForUser(userId, channelToken, randomLinksOsaka);
			} else if (customerMessage.toLowerCase().equals("tokyo")
					|| (parameters != null && parameters.getString("japan-cities").toLowerCase().equals("tokyo"))) {
				carouselForUser(userId, channelToken, randomLinksTokyo);
			}

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
	 * @throws IOException
	 */
	private void carouselForUser(String userId, String lChannelAccessToken, java.util.List<String> randomLinks)
			throws IOException {

		java.util.List<CarouselColumn> columns = new ArrayList<>();

		for (String link : randomLinks) {

			Document doc = Jsoup.connect(link).get();
			String title = doc.title();
			String img = doc.getElementsByClass("max-width-260").get(0).attr("abs:src");

			CarouselColumn column = new CarouselColumn(img, title, "Select one for more info",
					Arrays.asList(new MessageAction("check", "check \"" + title + "\"")));
			columns.add(column);

		}

		CarouselTemplate carouselTemplate = new CarouselTemplate(columns);

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
