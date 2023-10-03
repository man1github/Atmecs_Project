package com.qa.emulator.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

public class HomePageActions extends ReusableMethods{

	public static Logger logger = Logger.getLogger(HomePageActions.class);

	public void alertHandle() {
		try {
			test = extent.createTest("Alert Handle");
			assertEquals(HomePage.CONFIRMATION_BUTTON, PropertiesFiles.readTestData("ConfirmationText"));
			alert();
//			DeviceRotation deviceRotation = new DeviceRotation(0, 0, 90);
			test.log(Status.PASS, "Alert Handle Method is performed");
			logger.info("Alert Handle Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Alert Handle Method is not performed : " + exception);
		}
	}
}
