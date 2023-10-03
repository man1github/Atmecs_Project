package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class HomePage {
	public static final By COUNTRY_DROPDOWN = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
	public static final By NAME_FIELD = AppiumBy.id("com.androidsample.generalstore:id/nameField");
	public static final By MALE = AppiumBy.id(
			"com.androidsample.generalstore:id/radioMale");
	public static final By FEMALE = AppiumBy.id(
			"com.androidsample.generalstore:id/radioFemale");
	public static final By LET_SHOP = AppiumBy
			.id("com.androidsample.generalstore:id/btnLetsShop");

}
