package com.qa.emulator.basetest;

import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.emulator.constants.Constants;
import com.qa.emulator.utils.ReusableMethods;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public static Logger logger = Logger.getLogger(BaseTest.class);
	public static AndroidDriver driver;
	public static UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
	public static URL url;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
  
	@BeforeSuite
	@Parameters({ "platformName", "deviceName", "udid", "appPath", "unlockType", "unlockKey" })
	public static void setCapabilites(String platformName, String deviceName, String udid, String appPath,
			String unlockType, String unlockKey) {
		try {
			ReusableMethods.launchEmulator(Constants.PIXEL_4);
			Thread.sleep(15000);
			ReusableMethods.keyboardEvents(KeyEvent.VK_ALT, KeyEvent.VK_TAB);
			uiAutomator2Options.setCapability("platformName", platformName);
			uiAutomator2Options.setCapability("deviceName", deviceName);
			uiAutomator2Options.setCapability("udid", udid);
			uiAutomator2Options.setCapability("app", appPath);
			uiAutomator2Options.setCapability("unlockType", unlockType);
			uiAutomator2Options.setCapability("unlockKey", unlockKey);
			uiAutomator2Options.setCapability("automationName", "UiAutomator2");
			uiAutomator2Options.setCapability("noReset", false);
			uiAutomator2Options.setCapability("fullReset", false);
			htmlReporter = new ExtentHtmlReporter("./test-output/Android_UI_Design_App_Test_Report.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception exception) {
			logger.error("Desired Capability is Not Passed : " + exception);
		}
	}

	@BeforeTest
	@Parameters({ "appium_Url" })
	public static void driverLaunch(String appium_Url) {
		try {
			driver = new AndroidDriver(new URL(appium_Url), uiAutomator2Options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logger.info("Driver launched Successfully");
			logger.info("Application launched Successfully");
		} catch (Exception exception) {
			logger.error("Appium driver is not conneted : " + exception);
		}
	}

	@AfterTest
	public static void extendReportFlush() {
		extent.flush();
	}

	@AfterSuite
	public static void tearDown() {
		driver.quit();
		logger.info("Application Successfully Closed and Appium server is stopped");
	}
}

/*
 * 
 * @BeforeSuite
	@Parameters({ "platformName", "deviceName", "udid", "appPath", "unlockType", "unlockKey"})
	public static void desiredCapabilites(String platformName, String deviceName, String udid, String appPath, String unlockType, String unlockKey) {
		try {
			ReusableMethods.launchEmulator(Constants.PIXEL_4);
			Thread.sleep(15000);
//			ReusableMethods.keyboardEvents(KeyEvent.VK_WINDOWS, KeyEvent.VK_M);
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", udid);
			desiredCapabilities.setCapability("app", appPath);
			desiredCapabilities.setCapability("unlockType", unlockType);
			desiredCapabilities.setCapability("unlockKey", unlockKey);
//			desiredCapabilities.setCapability("skipDeviceInitialization", true);
//			desiredCapabilities.setCapability("skipServerInstallation", true);
//			desiredCapabilities.setCapability("appWaitDuration", 30000);
//			desiredCapabilities.setCapability("deviceReadyTimeout", 5);
//			desiredCapabilities.setCapability("noReset", true);
//			desiredCapabilities.setCapability("androidDeviceReadyTimeout", 30);
			htmlReporter = new ExtentHtmlReporter("./test-output/Android_UI_Design_App_Test_Report.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception exception) {
			logger.error("Desired Capability is Not Passed : " + exception);
		}
	}
	
	@BeforeTest
	@Parameters({ "appium_Url" })
	public static void driverLaunch(String appium_Url) {
		try {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
			driver = new AndroidDriver(new URL(appium_Url), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logger.info("Driver launched Successfully");
			logger.info("Application launched Successfully");

		} catch (Exception exception) {
			logger.error("Appium driver is not conneted : " + exception);
		}
	}

	@AfterTest
	public static void extendReportFlush() {
		extent.flush();
	}

	@AfterSuite
	public static void tearDown() {
		driver.quit();
		service.stop();
		logger.info("Application Successfully Closed and Appium server is stopped");
	}
 * 
 * */


/*Parallel testing
 * 
 * 
@BeforeTest
@Parameters({"platformName", "deviceName", "udid", "appPath", "unlockType", "unlockKey", "appium_Url"})
public static void driverLaunch(String platformName, String deviceName, String udid, String appPath, String unlockType, String unlockKey, String appium_Url) {
	try {
//		if (deviceName.equalsIgnoreCase("Pixel_4") ) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
//		}
		if (deviceName.equalsIgnoreCase("Pixel_4") ) {
			ReusableMethods.launchEmulator(Constants.PIXEL_4);
			Thread.sleep(5000);
//			ReusableMethods.keyboardEvents(KeyEvent.VK_WINDOWS, KeyEvent.VK_M);
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", udid);
			desiredCapabilities.setCapability("app", appPath);
			desiredCapabilities.setCapability("skipDeviceInitialization", true);
			desiredCapabilities.setCapability("skipServerInstallation", true);
			desiredCapabilities.setCapability("unlockType", unlockType);	
			desiredCapabilities.setCapability("unlockKey", unlockKey);
			htmlReporter = new ExtentHtmlReporter("./test-output/Pixel_4_Android_UI_Design_App_Test_Report.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			driver = new AndroidDriver(new URL(appium_Url), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			logger.info("Driver launched Successfully" +  "Device Name is : "  + deviceName );
			logger.info("Application launched Successfully");	
		}else if (deviceName.equalsIgnoreCase("Pixel_5_API_33")) {
			Thread.sleep(5000);
			ReusableMethods.launchEmulator(Constants.Pixel_5_API_33);
			Thread.sleep(5000);
//			ReusableMethods.keyboardEvents(KeyEvent.VK_WINDOWS, KeyEvent.VK_M);
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", udid);
			desiredCapabilities.setCapability("app", appPath);
			desiredCapabilities.setCapability("skipDeviceInitialization", true);
			desiredCapabilities.setCapability("skipServerInstallation", true);
			desiredCapabilities.setCapability("unlockType", unlockType);	
			desiredCapabilities.setCapability("unlockKey", unlockKey);
			htmlReporter = new ExtentHtmlReporter("./test-output/Pixel_5_API_33_Android_UI_Design_App_Test_Report.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			driver = new AndroidDriver(new URL(appium_Url), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			logger.info("Driver launched Successfully" +  "Device Name is : "  + deviceName );
			logger.info("Application launched Successfully");	
		}
		else {
			logger.error("Device name is not matched" );
			Assert.fail();
		}
		
	} catch (Exception exception) {
		logger.error("Appium driver is not conneted and Desired Capability is Not Passed : " + exception);
		Assert.fail();
	}
}

@AfterTest
public static void extendReportFlush() {
	extent.flush();
}

@AfterSuite
public static void tearDown() {
	driver.quit();
//	service.stop();
	logger.info("Application Successfully Closed and Appium server is stopped");
}

 * */

  
