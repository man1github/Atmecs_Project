package com.qa.automate;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AndroidDevice {

	public static void main(String[] args) {
		openUMAndroid();
	}

	public static void openUMAndroid() {
		try {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformDevice", "11");
			desiredCapabilities.setCapability("deviceName", "Samsung");
			desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
			desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
			desiredCapabilities.setCapability("udid", "RZ8M82BFZ6J");
//			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
			
			WebElement number5 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
			number5.click();
			
			WebElement add = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
			add.click();
			
			WebElement number7 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));
			number7.click();
			
			WebElement equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
			equal.click();
			
			
//			Thread.sleep(3000);
//	        driver.findElement(AppiumBy.accessibilityId("preference")).click();

//	        String sessionId = driver.getSessionId().toString();
//	        System.out.println(sessionId);

//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability("BROWSER_NAME", "Android");
//			capabilities.setCapability("VERSION", "11");
//			capabilities.setCapability("deviceName", "Thiruvenkadam's A10");
//			capabilities.setCapability("platformName", "Android");
//			capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
//			This package name of your app (you can get it from apk info app)
//			capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator"); // This is Launcher																								// activity of your app
//							
// (you can get it from					//apk info app)
			/*
			 * 
			 * */
//			Create RemoteWebDriver instance and connect to the Appium server
//			It will launch the Calculator App in Android Device using the configurations
//			// specified in Desired Capabilities
//
//			driver1 = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			

//			UiAutomator2Options options = new UiAutomator2Options();
//          options.setDeviceName("Samsung");
//          options.setAppPackage("com.umandroid");
            
//			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//			desiredCapabilities.setCapability("deviceName", "Samsung");
//			desiredCapabilities.setCapability("udid", "RZ8M82BFZ6J");
//			desiredCapabilities.setCapability("platformName", "Android");
//			desiredCapabilities.setCapability("platformVersion", "11");
//			desiredCapabilities.setCapability("appPackage", "com.umandroid");
//			desiredCapabilities.setCapability("appActivity", "com.unandroid.MainActivity");
//	        desiredCapabilities.setCapability("automationName", "UiAutomator2");


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
