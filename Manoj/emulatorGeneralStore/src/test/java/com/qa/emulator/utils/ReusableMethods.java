package com.qa.emulator.utils;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.And;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.qa.emulator.basetest.BaseTest;
import com.qa.emulator.constants.Constants;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.properties.PropertiesFiles;
import io.appium.java_client.AppiumBy;
import net.sf.cglib.transform.AbstractClassFilterTransformer;

public class ReusableMethods extends BaseTest {

	public static WebDriverWait wait;
	public static Duration THOUSAND_MILLI = Duration.ofMillis(1000);
	public static Duration THREE_HUNDREAD_MILLI = Duration.ofMillis(300);
	public static Duration TWO_SEC = Duration.ofSeconds(2);
	public static JSONObject object;
	public static String value;

	public static void click(By locator) {
		try {
			driver.findElement(locator).click();
			logger.info("Click Method is performed");
			test.log(Status.PASS, "Verified Click Method is performed");
		} catch (Exception exception) {
			logger.error("Click is not performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static WebElement clickButton(By locator) {
		try {
			WebElement clickButton = driver.findElement(locator);
			return clickButton;
		} catch (Exception exception) {
			logger.error("Clear all button is not available : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
		return null;
	}
	
	public static void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			logger.info("Implicitly Wait is applied");
			test.log(Status.PASS, "Implicitly Wait is performed");
		} catch (Exception exception) {
			logger.error("Implicitly Wait is not applied : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void waitForClickable(By locator) {
		try {
			wait = new WebDriverWait(driver,
					Duration.ofSeconds(Integer.parseInt(PropertiesFiles.readTestData("Seconds"))));
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			logger.info("using elementToBeClickable Wait,  Element is clicked");
			test.log(Status.PASS, "Wait For Clickable is performed");
		} catch (Exception exception) {
			logger.error("using elementToBeClickable Wait,  Element is not clicked : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void waitForElementLocated(By locator) {
		try {
			wait = new WebDriverWait(driver,
					Duration.ofSeconds(Integer.parseInt(PropertiesFiles.readTestData("Seconds"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logger.info("using elementToBeClickable Wait,  Element is clicked");
			test.log(Status.PASS, "Wait For Element Located is performed");
		} catch (Exception exception) {
			logger.error("using elementToBeClickable Wait,  Element is not clicked : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void alert() {
		try {
			driver.switchTo().alert().accept();
			logger.info("Alert is Handled");
			test.log(Status.PASS, "Alert is Handled");
		} catch (Exception exception) {
			logger.error("Alert is not Handled : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void sendkeys(By locator, String text) {
		try {
			driver.findElement(locator).sendKeys(text);
			logger.info("Text passing is achieved");
			test.log(Status.PASS, "Text passing is achieved");
		} catch (Exception exception) {
			logger.error("Text passing is not achieved : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void scrollableAndClick(String country) {
		try {
			driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
					+ ".scrollIntoView(new UiSelector().textContains(\"" + country + "\"))")).click();
			logger.info("Using Scroll action, click Operation is Performed");
			test.log(Status.PASS, "Using Scroll action, click Operation is Performed");
		} catch (Exception exception) {
			logger.error("Using Scroll action, click Operation is not Performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void scrollUntilEnd(String direction) { //working
		try {
			boolean canScrollMore = true;
			do {
				canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", direction,
					    "percent", 3.0
					));
			} while (canScrollMore);    
			logger.info("Scroll until end action is Performed");
			test.log(Status.PASS, "Scroll until end action is Performed");
		} catch (Exception exception) {
			logger.error("Scroll until end action is not Performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void littleScroll(String direction) { 
		try {
			
			((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", direction,
					    "percent", 7.0
					));
			logger.info("Scroll until end action is Performed");
			test.log(Status.PASS, "Scroll until end action is Performed");
		} catch (Exception exception) {
			logger.error("Scroll until end action is not Performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void previousPage() {
		try {
			driver.navigate().back();
			logger.info("Back to the Previous Page");
			test.log(Status.PASS, "Back to the Previous Page");
		} catch (Exception exception) {
			logger.error("Back to the Previous Page is not performed: " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void swipeAction(By locator, String swipeDirection) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) element).getId(), "direction", swipeDirection, "percent", 0.75));
			logger.info("Swipe Action is achieved");
			test.log(Status.PASS, "Swipe Action is achieved");
		} catch (Exception exception) {
			logger.error("Swipe Action is not achieved : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static String getText(By locators) {
		try {
			return driver.findElement(locators).getText();
		} catch (Exception exception) {
			logger.error("Button is not displayed : " + exception);
		}
		return null;
	}

	public static void isDisplayedAssert(By locators) {
		try {
			Assert.assertTrue(driver.findElement(locators).isDisplayed());
			logger.info("Button is displayed");
		} catch (Exception exception) {
			logger.error("Button is not displayed : " + exception);
		}
	}
	
	public static void assertEquals(By locators, String text) {
		String actual = null;
			try {
				actual = driver.findElement(locators).getText();
				if (actual == text) {
					Assert.assertEquals(actual, text);
					logger.info("Matched, Actual value : '"+ actual +" and Expected value : "+ text +"' is Asserted");
				}else {
					logger.error("Not Matched, Actual value : '"+ actual +" and Expected value : "+ text +"' is Asserted");
				}
			} catch (Exception exception) {
				logger.error("Actual value : '"+ actual +" and Expected value : "+ text +"' : " + exception);
			}
	}

	public static Point getCenterOfElement(By element) {
		try {
			WebElement element1 = driver.findElement(element);
			Point location = element1.getLocation();
			Dimension size = element1.getSize();
			return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
		} catch (Exception exception) {
			logger.error("Drag and Drop is not performed : - 1 " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
		return null;
	}

	public static void dragAndDrop(Point start, Point end, Duration duration) {

		try {
			PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			Sequence sequence = new Sequence(input, 0);
			sequence.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), start.x, start.y));
			sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			sequence.addAction(new Pause(input, duration)); 
			// Adjust the duration as needed
			sequence.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
			sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			// Perform the drag-and-drop operation
			driver.perform(ImmutableList.of(sequence));
		} catch (Exception exception) {
			logger.error("Drag and Drop is not performed " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
			assert false;
		}
	}

	public static void dragAndDrop(By source, By target) { //known source and target loctaor
		try {
			Point sourceElement = getCenterOfElement(source);
			Point targetElement = getCenterOfElement(target);
			dragAndDrop(sourceElement, targetElement, THOUSAND_MILLI);
			logger.info("Drag and Drop is performed ");
			test.log(Status.PASS, "Drag and Drop is performed ");
		} catch (Exception exception) {
			logger.error("Drag and Drop is not performed: " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void dragAndDrop(By source, Integer dropXCoordinates, Integer dropYCoordinates) { //known source loctaor, unknown target loctaor 
		try {
			WebElement element = driver.findElement(source);
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(),
				    "endX", dropXCoordinates,
				    "endY", dropYCoordinates
				));
			logger.info("Drag and Drop is performed ");
			test.log(Status.PASS, "Drag and Drop is performed ");
		} catch (Exception exception) {
			logger.error("Drag and Drop is not performed: " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void longPress(By element) {
		try {
			Point point = getCenterOfElement(element);
			longPress(point, TWO_SEC);
			logger.info("Long Press is performed ");
			test.log(Status.PASS, "Long Press is performed ");
		} catch (Exception exception) {
			logger.error("Long Press is not performed: " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void longPress(Point point, Duration duration) {

		try {
			PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			Sequence sequence = new Sequence(input, 0);
			sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y));
			sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			sequence.addAction(new Pause(input, duration)); 
			// Adjust the duration as needed
			sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(ImmutableList.of(sequence));
		} catch (Exception exception) {
			logger.error("Long Press is not performed " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void doubleTap(By element) {
		try {
			Point point = getCenterOfElement(element);
			doubleTap(point, THREE_HUNDREAD_MILLI);
			logger.info("Double Tap is performed");
			test.log(Status.PASS, "Double Tap is performed");
		} catch (Exception exception) {
			logger.error("Double Tap is not performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void doubleTap(Point point, Duration duration) {
		try {
			PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			Sequence sequence = new Sequence(input, 1)
					.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y))
					.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(input, duration))
					.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(input, duration))
					.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(input, duration))
					.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			driver.perform(Collections.singletonList(sequence));
		} catch (Exception exception) {
			logger.error("Double Tap is not performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
			assert false;
		}
	}
	
	public static void pinchIn(By element) { //working
		try {
			Point point = getCenterOfElement(element);
			pinchIn(point);
			logger.info("pinchIn is performed ");
			test.log(Status.PASS, "pinchIn is performed ");
		} catch (Exception exception) {
			logger.error("pinchIn is not performed: " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void pinchIn(Point point) {
		try {
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
			Sequence sequence = new Sequence(finger1, 1)
			.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y))
			.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofMillis(200)))
			.addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), point.getX() + 100, point.getY() - 100))
			// Adjust the duration as needed
			.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence sequence1 = new Sequence(finger2, 1)
					.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y))
					.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger2, Duration.ofMillis(200)))
					.addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), point.getX() - 100, point.getY() + 100))
					// Adjust the duration as needed
					.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(Arrays.asList(sequence, sequence1));
		} catch (Exception exception) {
			logger.error("pinchIn is not performed " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void openNotificationPanel() {
		try {
			driver.openNotifications();
			logger.info("Pull down the notification bar is performed");
			test.log(Status.PASS, "Pull down the notification bar is performed");
		} catch (Exception exception) {
			logger.error("Pull down the notification bar is not performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}

	public static void flingGesture(By locator, String swipeDirection, String length) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(),
				    "direction", swipeDirection,
				    "speed", length));
			logger.info("Fling Gesture is performed");
			test.log(Status.INFO, "Fling Gesture is performed");
		} catch (Exception exception) {
			logger.error("Fling Gesture is not performed : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
	}
	
	public static void launchEmulator(String filePath) {
		try {
			File fileToOpen = new File(filePath);
			Desktop desktop = Desktop.getDesktop();
			desktop.open(fileToOpen);
			logger.info("Emulator is Opened and path is : " + filePath);
		} catch (Exception exception) {
			logger.error("Emulator is not Opened : " + exception);
		}
	}
	
	public static void keyboardEvents(int firstKey, int  SecondKey) {
		try {
			Robot robot = new Robot();
			robot.keyPress(firstKey);
			robot.keyPress(SecondKey);
			robot.keyRelease(SecondKey);
			robot.keyPress(SecondKey);
			robot.keyRelease(SecondKey);
			Thread.sleep(THREE_HUNDREAD_MILLI);
			robot.keyRelease(firstKey);
			Thread.sleep(500);
			robot.keyPress(firstKey);
			robot.keyPress(SecondKey);
			robot.keyRelease(SecondKey);
			robot.keyRelease(firstKey);
			logger.info("Keyboard Events is Performed : ");
		} catch (Exception exception) {
			logger.error("Keyboard Events is not Performed : " + exception);
		}
	}

	public static String toastMessage() {
		try {
			String message = driver.findElement(By.xpath("//(android.widget.Toast)[1]")).getAttribute("name");
			return message;
		} catch (Exception exception) {
			logger.error("Clear all button is not available : " + exception);
			test.log(Status.FAIL, "Exception Occured" + exception);
		}
		return null;
	}
	
	
}