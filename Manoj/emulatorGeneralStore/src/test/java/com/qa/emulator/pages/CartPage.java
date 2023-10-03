package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class CartPage {
	
	public static final By CART_SHOE_3 =  AppiumBy.xpath("//android.widget.TextView[@text='Converse All Star']");
	public static final By CART_SHOE_1 =  AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']");
	public static final By CART_SHOE_2 =  AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']");
	public static final By CART_PRODUCT_PRICE =  AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']");
	public static final By CART_TOTAL_PRICE =  AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']");
	public static final By CART_PRODUCT_IMAGE =  AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.androidsample.generalstore:id/productImage'])[3]");
	public static final By TERMS_CONDITIONS =  AppiumBy.id("com.androidsample.generalstore:id/termsButton");
	public static final By VISIT_WEBSITE =  AppiumBy.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnProceed']");
	public static final By CHECK_BOX =  AppiumBy.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");

	
}
