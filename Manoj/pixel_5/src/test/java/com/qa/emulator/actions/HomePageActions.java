package com.qa.emulator.actions;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.utils.ReusableMethods;

public class HomePageActions extends ReusableMethods {

	public static Logger logger = Logger.getLogger(HomePageActions.class);

	public void alertHandle() {
		try {
			test = extent.createTest("Alert Handle");
			alert();
			alert();
			test.log(Status.INFO, "Alert is Handled");
			logger.info("Alert Handle Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Alert Handle Method is not performed : " + exception);
			assert false;
		}
	}
	
	public void angleRotation() {
		try {
			test = extent.createTest("Angle Rotation");
			click(HomePage.DOWNLOAD_ALBUM);
			click(HomePage.TEMPLE_PHOTO);
			
			angleRotation(HomePage.INTERACT_TEMPLE_PHOTO_1);
							
			test.log(Status.INFO, "Angle Rotation Method is performed");
			logger.info("Angle Rotation Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Angle Rotation Method is not performed : " + exception);
			assert false;
		}
	}
	
	public void pinchInAndPinchOut() {
		try {
			test = extent.createTest("Pinch In And Pinch Out");
			click(HomePage.DOWNLOAD_FOLDER);
			click(HomePage.SELECT_TEMPLE_PHOTO);
			pinchIn(HomePage.INTERACT_TEMPLE_PHOTO);
			pinchOut(HomePage.INTERACT_TEMPLE_PHOTO);
			test.log(Status.INFO, "Pinch In And Pinch Out is performed");
			logger.info("Pinch In And Pinch Out Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Pinch In And Pinch Out Method is not performed : " + exception);
			assert false;
		}
	}
}
