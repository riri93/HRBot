package com.example.demo;

import javax.servlet.annotation.WebServlet;

import ai.api.model.Fulfillment;

@WebServlet("/webhook")
public class MyWebhookServlet extends AIWebhookServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
		System.out.println("***********************webhook******************************");
		output.setSpeech("You said: " + input.getResult().getFulfillment().getSpeech());
	}
}