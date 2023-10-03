package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class ViewFlowPage {
	public static final By SWIPE_TAB = AppiumBy.id("com.boopathy.raja.tutorial:id/ViewPager_SwiepyTab");
	public static final By SWIPE_LAYOUT_1 = AppiumBy.xpath("//android.widget.TextView[@text='Layout No.1']");
	public static final By SWIPE_LAYOUT_2 = AppiumBy.xpath("//android.widget.TextView[@text='Layout No.2']");
	public static final By SCROLLING_TAB = AppiumBy.id("com.boopathy.raja.tutorial:id/ViewPager_ScrollingTab");
	public static final By SCROLLING_TAB_3 = AppiumBy.xpath("//android.widget.Button[@text='ScrollingTab - 3']");
}
