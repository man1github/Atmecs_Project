package com.qa.emulator.actions;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.pages.TextSpeechPage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

public class TextSpeechActions extends ReusableMethods {
	
	public static Logger logger = Logger.getLogger(TextSpeechActions.class);

	public void textSpeech() {
		try {
			test = extent.createTest("Text Speech");
			click(HomePage.MENU_BAR);
			isDisplayedAssert(HomePage.TEXT_2_SPEECH);
			click(HomePage.TEXT_2_SPEECH);
			sendkeys(TextSpeechPage.TEXT_FIELD, PropertiesFiles.readTestData("SpeakText"));
			click(TextSpeechPage.SPEAK_BUTTON);
			test.log(Status.PASS, "Text Speech Test is performed");
			logger.info("Text Speech Test is performed");

		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Text Speech Test is not performed : " + exception);
			assert false;
		}
	}

}
