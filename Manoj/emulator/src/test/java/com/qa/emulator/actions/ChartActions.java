package com.qa.emulator.actions;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.ChartPage;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.utils.ReusableMethods;

public class ChartActions extends ReusableMethods{

	public void handleLongPress() {
		try {
			test = extent.createTest("Long Press action Handling");
			click(HomePage.MENU_BAR);		
			openNotificationPanel();
			click(ChartPage.MANAGE_NOTIFICATION);
			longPress(ChartPage.MORE_OPTIONS);
			test.log(Status.PASS, "Long Press action Test is performed");
			logger.info("Long Press action Test is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Long Press action Test is not performed : " + exception);
		}
	}
}
