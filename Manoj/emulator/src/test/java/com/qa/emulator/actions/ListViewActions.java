package com.qa.emulator.actions;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.ImageView;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.pages.ListViewPage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

import io.appium.java_client.AppiumBy;

public class ListViewActions extends ReusableMethods{
	
	public static Logger logger = Logger.getLogger(ListViewActions.class);

	public void doubleTapAndFling() {
		try {
			test = extent.createTest("Double Tap And Fling gesture");
			click(HomePage.MENU_BAR);
			click(HomePage.LIST_VIEW);
			click(ListViewPage.EXPAND_CUSTOM_LISTVIEW);
			doubleTap(ListViewPage.DEMO_2);
			previousPage();
			click(ListViewPage.SCROLL_BAR_INDICATOR);
			flingGesture(ListViewPage.EXPAND_CUSTOM_LISTVIEW_PAGE, PropertiesFiles.readTestData("DownDirection"), "5000");		
			previousPage();
			test.log(Status.PASS, "Double Tap And Fling gesture Test is performed");
			logger.info("Double Tap And Fling gesture Test is performed");

		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Double Tap And Fling gesture Test is not performed : " + exception);
			assert false;
		}
	}
	
	public void barScrollindAndClicking(String country) {
		try {
			test = extent.createTest("Bar Scrolling And Clicking");
			click(ListViewPage.SCROLL_BAR_INDICATOR);
			scrollableAndClick(country);
			previousPage();
			test.log(Status.PASS, "Bar Scrolling And Clicking Test is performed");
			logger.info("Bar Scrolling And Clicking Test is performed");

		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Bar Scrolling And Clicking Test is not performed : " + exception);
			assert false;
		}
	}
}
















/*
 * List<WebElement> countryList = driver.findElements(AppiumBy.xpath(
 * "//android.widget.ListView[@resource-id='android:id/list']/android.widget.TextView"
 * )); int a = 0; String[] listOfCountry = null; if(countryList != null ) {
 * for(int i=0; i<countryList.size(); i++) { listOfCountry =
 * countryList.toArray(new String [countryList.size()]);
 * }flingGesture(ListViewPage.SCROLL_BAR_INDICATOR_PAGE,
 * PropertiesFiles.readTestData("DownDirection"), "5000"); a++; }else {
 * logger.error("countryList is null" + a); }
 */

/*
 * //			List<WebElement> countryList = driver.findElements(AppiumBy.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.TextView"));
//			int a = 0;
////			String[] listOfCountry = null;
//			List<String> listOfCountry = new ArrayList<String>();
//			
//			while (countryList != null ) {
//				for(int i=0; i<countryList.size(); i++) {
//					String listOfCountryString =  countryList.get(i).toString();
//					listOfCountry.add(listOfCountryString);
//					logger.info("check : " + Arrays.asList(listOfCountry));
//				}flingGesture(ListViewPage.SCROLL_BAR_INDICATOR_PAGE, PropertiesFiles.readTestData("DownDirection"), "5000");
//				a++;
////				if(ListViewPage.LAST_ELEMENT == true) {
////					break;
////				}
//				continue;
//			}
//			
//			
//			logger.info("check number of swipe " + a);	
			
//			logger.info("check country list : " + ;
//			logger.info("check country count " + countryList.size());

 * 
 * */
