package com.qa.automate;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AndroidEmulator {

	public static void main(String[] args) {
		androidUiDesign();
	}

	public static void androidUiDesign() {
		try {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "Android Emualator");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("app", "C:\\Users\\manoj.mukannan\\Android_UI_Design-1.0.apk");
				
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
			System.out.println("driver is launched");
			
			WebElement confiramtionButton = driver.findElement(By.id("android:id/button1"));
			confiramtionButton.click();
			System.out.println("Click action performed");
			
//			WebElement okButton = driver.findElement(By.id("android:id/button1"));
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.elementToBeClickable(okButton));
//			okButton.click();
//			
//			WebElement userRegistration = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
//			userRegistration.click();
//
//			WebElement userName = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
//			userName.sendKeys("Manoj");
//
//			WebElement Email = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
//			Email.sendKeys("abc@gmail.com");
//
//			WebElement password = driver
//					.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
//			password.sendKeys("123456");
//			
//			WebElement acceptAdds  = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
//			acceptAdds.click();
//			
//			WebElement registerUser  = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
//			registerUser.click();

//					DesiredCapabilities capabilities = new DesiredCapabilities();
//					capabilities.setCapability("BROWSER_NAME", "Android");
//					capabilities.setCapability("VERSION", "11");
//					capabilities.setCapability("deviceName", "Thiruvenkadam's A10");
//					capabilities.setCapability("platformName", "Android");
//					capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
//					This package name of your app (you can get it from apk info app)
//					capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator"); // This is Launcher																								// activity of your app
//									
			// (you can get it from //apk info app)
			/*
			 * 
			 * */
//					Create RemoteWebDriver instance and connect to the Appium server
//					It will launch the Calculator App in Android Device using the configurations
//					// specified in Desired Capabilities
			//
//					driver1 = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//					UiAutomator2Options options = new UiAutomator2Options();
//		          options.setDeviceName("Samsung");
//		          options.setAppPackage("com.umandroid");

//					DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//					desiredCapabilities.setCapability("deviceName", "Samsung");
//					desiredCapabilities.setCapability("udid", "RZ8M82BFZ6J");
//					desiredCapabilities.setCapability("platformName", "Android");
//					desiredCapabilities.setCapability("platformVersion", "11");
//					desiredCapabilities.setCapability("appPackage", "com.umandroid");
//					desiredCapabilities.setCapability("appActivity", "com.unandroid.MainActivity");
//			        desiredCapabilities.setCapability("automationName", "UiAutomator2");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
