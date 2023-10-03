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
		@Parameters({ "platformName", "deviceName", "udid", "appPath"})
		public static void setCapabilites(String platformName, String deviceName, String udid, String appPath) {
			try {
//				ReusableMethods.launchEmulator(Constants.PIXEL_4);
//				Thread.sleep(15000);
//				ReusableMethods.keyboardEvents(KeyEvent.VK_ALT, KeyEvent.VK_TAB);
				uiAutomator2Options.setCapability("platformName", platformName);				
				uiAutomator2Options.setCapability("deviceName", deviceName);
				uiAutomator2Options.setCapability("udid", udid);
				uiAutomator2Options.setCapability("app", appPath);
				uiAutomator2Options.setCapability("automationName", "UiAutomator2");
				htmlReporter = new ExtentHtmlReporter("./test-output/General_Store_App_Test_Report.html");
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
			} catch (Exception exception) {
				logger.error("Capability is Not Passed : " + exception);
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
//			driver.quit();
			logger.info("Application Successfully Closed and Appium server is stopped");
		}
	  
	  

	
}


