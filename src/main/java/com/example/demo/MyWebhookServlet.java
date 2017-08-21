package com.example.demo;

import javax.servlet.annotation.WebServlet;

import ai.api.model.Fulfillment;

@WebServlet("/webhook")
public class MyWebhookServlet extends AIWebhookServlet {
	@Override
	protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
		output.setSpeech("You said: " + input.getResult().getFulfillment().getSpeech());
	}
}