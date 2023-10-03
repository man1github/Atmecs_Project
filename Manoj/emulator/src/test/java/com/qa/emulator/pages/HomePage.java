package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class HomePage {
	public static final By CONFIRMATION_BUTTON = AppiumBy.id("android:id/button1");
	public static final By MENU_BAR = AppiumBy.id("android:id/up");
	public static final By HEADING = AppiumBy.id("android:id/action_bar_title");
	public static final By ICON = AppiumBy.id("android:id/home");
	public static final By ANDROID_UI_DESIGN = AppiumBy
			.xpath("//android.widget.LinearLayout[@content-desc=\"Android UI Design, Close navigation drawer\"]");
	public static final By OPTIONS = AppiumBy.xpath(
			"//android.widget.TextView[contains(@text,'OPTIONS')]");
	public static final By TEXT_2_SPEECH = AppiumBy.xpath(
			"//android.widget.TextView[@text='Text 2 Speech']");
	public static final By LIST_VIEW = AppiumBy.xpath(
			"//android.widget.TextView[@text='ListView']");
	public static final By VIEW_FLOW = AppiumBy.xpath("//android.widget.TextView[@text='ViewFlow']");
}
