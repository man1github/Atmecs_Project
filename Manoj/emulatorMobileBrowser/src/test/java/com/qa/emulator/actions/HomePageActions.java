package com.qa.emulator.actions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;


public class HomePageActions extends ReusableMethods{

	public static Logger logger = Logger.getLogger(HomePageActions.class);

	public void fillTheForm() {
		try {
			test = extent.createTest("Fill The Form");
			click(HomePage.LET_SHOP);
			String message = toastMessage();
			Assert.assertEquals(message, PropertiesFiles.readTestData("Let'sShop"));
			click(HomePage.COUNTRY_DROPDOWN);
			scrollableAndClick(PropertiesFiles.readTestData("Country"));
			sendkeys(HomePage.NAME_FIELD, PropertiesFiles.readTestData("Name"));
			click(HomePage.MALE);
			click(HomePage.LET_SHOP);
			test.log(Status.PASS, "Fill The Form Method is performed");
			logger.info("Fill The Form Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Fill The Form Method is not performed" + exception);
			assert false;
		}
	}
}