package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class ListViewPage {

	public static final By SCROLL_BAR_INDICATOR = AppiumBy.id("com.boopathy.raja.tutorial:id/List_ScrollIndicator");
	public static final By NORWAY = AppiumBy.xpath("//android.widget.TextView[@text='Norway']");
	public static final By EXPAND_CUSTOM_LISTVIEW = AppiumBy.id("com.boopathy.raja.tutorial:id/List_Custom_ExpandListView");
	public static final By DEMO_2 = AppiumBy.xpath("//android.widget.TextView[@text='Demo 2']");
	
	public static final By EXPAND_CUSTOM_LISTVIEW_PAGE = AppiumBy.id("android:id/list");
	public static final By SCROLL_BAR_INDICATOR_PAGE = AppiumBy.id("android:id/list");
	public static final By LAST_ELEMENT = AppiumBy.xpath("//android.widget.TextView[@text='Zimbabwe']");

}
