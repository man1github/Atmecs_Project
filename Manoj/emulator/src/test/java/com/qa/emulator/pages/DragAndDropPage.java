package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class DragAndDropPage {	
	public static final By DRAG_AND_DROP = AppiumBy.xpath("//android.widget.TextView[@text='Drag & Drop']");
	public static final By SIMPLE_DRAG_AND_DROP = AppiumBy.id("com.boopathy.raja.tutorial:id/Drag_and_Drop_Simple");
	public static final By DRAG_1 = AppiumBy.id("com.boopathy.raja.tutorial:id/DragDrop_Drag1");
	public static final By DROP_1 = AppiumBy.id("com.boopathy.raja.tutorial:id/DragDrop_Drop1");
	public static final By DRAG_2 = AppiumBy.id("com.boopathy.raja.tutorial:id/DragDrop_Drag2");
	public static final By DROP_2 = AppiumBy.id("com.boopathy.raja.tutorial:id/DragDrop_Drop2");
	public static final By DRAG_3 = AppiumBy.id("com.boopathy.raja.tutorial:id/DragDrop_Drag3");
	public static final By DROP_3 = AppiumBy.id("com.boopathy.raja.tutorial:id/DragDrop_Drop3");
	public static final By CLEAR_ALL = AppiumBy.id("com.android.systemui:id/dismiss_text");
	public static final By NOTIFICATION_LIST = AppiumBy.xpath("//android.widget.ScrollView[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout");
	public static final By NOTIFICATION_LIST_4 = AppiumBy.xpath("(//android.widget.ScrollView[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout)[4]");
	public static final By NOTIFICATION_LIST_1 = AppiumBy.xpath("(//android.widget.ScrollView[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout)[1]");
	public static final By NOTIFICATION_LIST_2 = AppiumBy.xpath("(//android.widget.ScrollView[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout)[2]");
	public static final By NOTIFICATION_LIST_3 = AppiumBy.xpath("(//android.widget.ScrollView[@resource-id='com.android.systemui:id/notification_stack_scroller']/android.widget.FrameLayout)[3]");
	public static final By MANAGE_NOTIFICATION_BAR = AppiumBy.xpath("(//android.widget.FrameLayout[contains(@resource-id,'com.android.systemui:id/content')])[1]");
}
