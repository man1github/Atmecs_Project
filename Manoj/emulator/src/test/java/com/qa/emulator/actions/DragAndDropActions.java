package com.qa.emulator.actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Var;
import com.qa.emulator.pages.DragAndDropPage;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.options.app.ActivityOptions;

public class DragAndDropActions extends ReusableMethods {

	public static Logger logger = Logger.getLogger(DragAndDropActions.class);
	public static Duration SCROLL_DUR = Duration.ofMillis(500);
	String message;

	public void dragAndDropGesture() {
		try {
			test = extent.createTest("Drag And Drop Gesture");
			click(HomePage.MENU_BAR);
			click(DragAndDropPage.DRAG_AND_DROP);
			click(DragAndDropPage.SIMPLE_DRAG_AND_DROP);		
			dragAndDrop(DragAndDropPage.DRAG_1, 880, 505);
			message = toastMessage();
			Assert.assertEquals(message, PropertiesFiles.readTestData("Drag1ToDrop1"));
			dragAndDrop(DragAndDropPage.DRAG_2, 880, 889);
			message = toastMessage();
			Assert.assertEquals(message, PropertiesFiles.readTestData("Drag2ToDrop2"));
			dragAndDrop(DragAndDropPage.DRAG_3, 963, 1271);
			message = toastMessage();
			Assert.assertEquals(message, PropertiesFiles.readTestData("Drag3ToDrop3"));
			previousPage();
			test.log(Status.PASS, "Drag And Drop Method is performed");
			logger.info("Drag And Drop Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Drag And Drop Method is not performed : " + exception);
			assert false;
		}
	}
	
	public void handleNotifications() {
		try {
			test = extent.createTest("Handle Notifications");
			openNotificationPanel();
			clearNotification();
			test.log(Status.PASS, "Handle Notifications Method is performed");
			logger.info("Handle Notifications Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Handle Notifications Method is not performed : " + exception);
			assert false;
		}
	}
}