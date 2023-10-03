package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class WebViewPage {

	public static final By SEARCH_BAR = AppiumBy.xpath("//android.widget.EditText[@resource-id='mib']");
	public static final By SEARCH_BUTTON = AppiumBy.xpath("//android.widget.Button[@resource-id='tsbb']");
	public static final By ALL_BUTTON = AppiumBy.xpath("//android.view.View[@text='ALL']");

}
