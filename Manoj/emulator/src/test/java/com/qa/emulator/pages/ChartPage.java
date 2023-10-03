package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class ChartPage {

	public static final By CHART = AppiumBy.xpath("//android.widget.TextView[@text='Chart']");
	public static final By PIE_CHART = AppiumBy.id("com.boopathy.raja.tutorial:id/PieChart");
	public static final By PIE_CHART_DIAGRAM = AppiumBy.className("android.view.View");
	public static final By MANAGE_NOTIFICATION = AppiumBy.id("com.android.systemui:id/manage_text");
	public static final By MORE_OPTIONS = AppiumBy.accessibilityId("More options");
	public static final By BAR_CHART = AppiumBy.id("com.boopathy.raja.tutorial:id/BarChart");
	public static final By BAR_CHART_DIAGRAM = AppiumBy.className("android.view.View");
	
	public static final By PAINT = AppiumBy.xpath("//android.widget.TextView[@text='Paint']");
	public static final By SIMPLE_PAINT = AppiumBy.id("com.boopathy.raja.tutorial:id/simple_canvas");
	public static final By PAINT_SPACE = AppiumBy.className("android.view.View");

}
