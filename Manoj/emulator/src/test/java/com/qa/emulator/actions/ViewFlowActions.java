package com.qa.emulator.actions;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.pages.ViewFlowPage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

public class ViewFlowActions extends ReusableMethods{
	
	public static Logger logger = Logger.getLogger(ViewFlowActions.class);

	public void tabSwiping() {
		try {
			test = extent.createTest("Tab Swipping");
			click(HomePage.MENU_BAR);
			click(HomePage.VIEW_FLOW);
			click(ViewFlowPage.SWIPE_TAB);
			swipeAction(ViewFlowPage.SWIPE_LAYOUT_1, PropertiesFiles.readTestData("LeftDirection"));
			swipeAction(ViewFlowPage.SWIPE_LAYOUT_2, PropertiesFiles.readTestData("RightDirection"));
			previousPage();
			test.log(Status.PASS, "Tab Swipping Test is performed");
			logger.info("Tab Swipping Test is performed");

		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Tab Swipping Test is not performed : " + exception);
			assert false;
		}
	}
}












/*
 * 
 * public void performScreenOrientation() {
		try {
			test = extent.createTest("Screen Orientation");
//			screenOrientation(PropertiesFiles.readTestData("LandscapeOrientation"));
			waitForElementLocated(ViewFlowPage.SCROLLING_TAB);
			click(ViewFlowPage.SCROLLING_TAB);
			scrollableAndClick(PropertiesFiles.readTestData("Tab3"));
//			screenOrientation(PropertiesFiles.readTestData("PortraitOrientation"));
			previousPage();
			test.log(Status.PASS, "Screen Orientation Test is performed");
			logger.info("Screen Orientation Test is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Screen Orientation Test is not performed : " + exception);
			assert false;
		}
	}
 * */