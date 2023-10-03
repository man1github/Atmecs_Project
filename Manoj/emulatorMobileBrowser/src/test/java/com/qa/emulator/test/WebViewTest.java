package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.WebViewActions;

public class WebViewTest {

	WebViewActions webViewActions = new WebViewActions();

	@Test
	public void interactMobileWebPageTest() {
		webViewActions.interactMobileWebPage();
	}
}
