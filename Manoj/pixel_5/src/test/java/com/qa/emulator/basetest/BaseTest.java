package com.qa.emulator.basetest;

import java.net.URL;
import java.time.Duration;
import org.apache.log4j.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {
	
	public static Logger logger = Logger.getLogger(BaseTest.class);
	public static AndroidDriver driver;
	public static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	public static URL url;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static AppiumDriverLocalService service;

	@BeforeSuite
	@Parameters({"platformName", "deviceName", "udid", "appPackage", "appActivity"})
	public static void desiredCapabilites(String platformName, String deviceName, String udid, String appPackage, String appActivity) {
		try {
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", udid);
			desiredCapabilities.setCapability("appPackage", appPackage);
			desiredCapabilities.setCapability("appActivity", appActivity);
			htmlReporter = new ExtentHtmlReporter("./test-output/Android_UI_Design_App_Test_Report.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception exception) {
			logger.error("Desired Capability is Not Passed : " + exception);
		}
	}
	
    @BeforeTest
	@Parameters({"appium_Url"})
	public static void driverLaunch(String appium_Url) {
		try {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
			driver = new AndroidDriver(new URL(appium_Url), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			logger.info("Driver launched Successfully");	
			logger.info("Application launched Successfully");
		} catch (Exception exception) {
			logger.error("Appium driver is not conneted : " + exception);		}
	}
    
    @AfterTest
    public static void extendReportFlush() {
		extent.flush();
    }
	
	@AfterSuite
	public static void tearDown() {
//		driver.quit();
		service.stop();
		logger.info("Application Successfully Closed and appium server stopped");
	}

}
