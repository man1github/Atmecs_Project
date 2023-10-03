package com.qa.emulator.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.pages.WebViewPage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

public class WebViewActions extends ReusableMethods{

	public static Logger logger = Logger.getLogger(WebViewActions.class);

	public void interactMobileWebPage() {
		try {
			test = extent.createTest("Interact Mobile WebPage");
			sendkeys(WebViewPage.SEARCH_BAR, PropertiesFiles.readTestData("SearchContent"));
			click(WebViewPage.SEARCH_BUTTON);
			isDisplayedAssert(WebViewPage.ALL_BUTTON);
			previousPage();
			Assert.assertTrue(driver.findElement(HomePage.LET_SHOP).isEnabled());
			test.log(Status.PASS, "Mobile WebPage Method is performed");
			logger.info("Mobile WebPage Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Mobile WebPage Method is not performed" + exception);
			assert false;
		}
	}
}
