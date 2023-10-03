package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class AddToCartPage {
	
	public static final By ADD_TO_CART_PRODUCT_1 =  AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]");
	public static final By ADD_TO_CART_PRODUCT_2 =  AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]");
	public static final By ADD_TO_CART_PRODUCT_3 =  AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[3]");
	public static final By PRODUCT_1 =  AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName'])[1]");
	public static final By PRODUCT_2 =  AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName'])[2]");
	public static final By PRODUCT_3 =  AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName'])[3]");
	public static final By CART_ICON =  AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
	
//	public static final By ADD_TO_CART (Integer productNumber) {
//		return AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])['"+ productNumber +"']");
//	} 

}
