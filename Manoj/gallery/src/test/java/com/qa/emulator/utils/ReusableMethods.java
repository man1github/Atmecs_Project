package com.qa.emulator.utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

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

import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.qa.emulator.basetest.BaseTest;
import com.qa.emulator.properties.PropertiesFiles;
import io.appium.java_client.AppiumBy;

public class ReusableMethods extends BaseTest {

	public static WebDriverWait wait;
	static Duration THOUSAND_MILLI = Duration.ofMillis(1000);
	static Duration THREE_HUNDREAD_MILLI = Duration.ofMillis(300);
	static Duration TWO_SEC = Duration.ofSeconds(2);

	public static void click(By locator) {
		try {
			driver.findElement(locator).click();
			logger.info("Click is performed");
		} catch (Exception exception) {
			logger.error("Click is not performed : " + exception);
		}
	}

	public static WebElement clickButton(By locator) {
		try {
			WebElement clickButton = driver.findElement(locator);
			return clickButton;
		} catch (Exception exception) {
			logger.error("Clear all button is not available : " + exception);
		}
		return null;
	}

	public static void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			logger.info("Implicitly Wait is applied");
		} catch (Exception exception) {
			logger.error("Implicitly Wait is not applied : " + exception);
		}
	}

	public void waitForClickable(By locator) {
		try {
			wait = new WebDriverWait(driver,
					Duration.ofSeconds(Integer.parseInt(PropertiesFiles.readTestData("Seconds"))));
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			logger.info("using elementToBeClickable Wait,  Element is clicked");
		} catch (Exception exception) {
			logger.error("using elementToBeClickable Wait,  Element is not clicked : " + exception);
		}
	}

	public void waitForElementLocated(By locator) {
		try {
			wait = new WebDriverWait(driver,
					Duration.ofSeconds(Integer.parseInt(PropertiesFiles.readTestData("Seconds"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logger.info("using elementToBeClickable Wait,  Element is clicked");
		} catch (Exception exception) {
			logger.error("using elementToBeClickable Wait,  Element is not clicked : " + exception);
		}
	}

	public static void alert() {
		try {
			driver.switchTo().alert().accept();
			test.log(Status.INFO, "Alert is Handled");
			logger.info("Alert is Handled");
		} catch (Exception exception) {
			logger.error("Alert is not Handled : " + exception);
		}
	}

	public static void sendkeys(By locator, String text) {
		try {
			driver.findElement(locator).sendKeys(text);
			logger.info("Text passing is achieved");
		} catch (Exception exception) {
			logger.error("Text passing is not achieved : " + exception);
		}
	}

	public static void scrollableAndClick(String country) {
		try {
			driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
					+ ".scrollIntoView(new UiSelector().textContains(\"" + country + "\"))")).click();
			logger.info("Using Scroll action, click Operation is Performed");
		} catch (Exception exception) {
			logger.error("Using Scroll action, click Operation is not Performed : " + exception);
		}
	}

	public static void previousPage() {
		try {
			driver.navigate().back();
			logger.info("Back to the Previous Page");
		} catch (Exception exception) {
			logger.error("Back to the Previous Page is not performed: " + exception);
		}
	}

	public void swipeAction(By locator, String swipeDirection) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) element).getId(), "direction", swipeDirection, "percent", 0.75));
			logger.info("Swipe Action is achieved");
		} catch (Exception exception) {
			logger.error("Swipe Action is not achieved : " + exception);
		}
	}

	public static void isDisplayedAssert(By locators) {
		Assert.assertTrue(driver.findElement(locators).isDisplayed());
	}

//	public void screenOrientation(String modeType) {
//		try {
//			Rotatable rotatable = (Rotatable) driver;
//			rotatable.getOrientation();
//			if (modeType.equalsIgnoreCase("LANDSCAPE")) {
//				rotatable.rotate(ScreenOrientation.LANDSCAPE);
//				logger.info("LANDSCAPE - Screen Orientation is performed");
//			} else if (modeType.equalsIgnoreCase("PORTRAIT")) {
//				rotatable.rotate(ScreenOrientation.PORTRAIT);
//				logger.info("PORTRAIT - Screen Orientation is performed");
//			}
//			logger.info("Screen Orientation is performed");
//		} catch (Exception exception) {
//			logger.error("Screen Orientation is not performed : " + exception);
//		}
//	}

	public static Point getCenterOfElement(By element) {
		try {
			WebElement element1 = driver.findElement(element);
			Point location = element1.getLocation();
			Dimension size = element1.getSize();
			return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
		} catch (Exception exception) {
			logger.error("Drag and Drop is not performed : - 1 " + exception);
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
			assert false;
		}
	}

	public static void dragAndDrop(By source, By target) {
		try {
			Point sourceElement = getCenterOfElement(source);
			Point targetElement = getCenterOfElement(target);
			dragAndDrop(sourceElement, targetElement, THOUSAND_MILLI);
			logger.info("Drag and Drop is performed ");
		} catch (Exception exception) {
			logger.error("Drag and Drop is not performed: " + exception);
		}
	}

	public static void longPress(By element) {
		try {
			Point point = getCenterOfElement(element);
			longPress(point, TWO_SEC);
			logger.info("Long Press is performed ");
		} catch (Exception exception) {
			logger.error("Long Press is not performed: " + exception);
		}
	}

	public static void longPress(Point point, Duration duration) {

		try {
			PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			Sequence sequence = new Sequence(input, 0);
			sequence.addAction(
					input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y));
			sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			sequence.addAction(new Pause(input, duration));
			// Adjust the duration as needed
			sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(ImmutableList.of(sequence));
		} catch (Exception exception) {
			logger.error("Long Press is not performed " + exception);
		}
	}

	public static void doubleTap(By element) {
		try {
			Point point = getCenterOfElement(element);
			doubleTap(point, THREE_HUNDREAD_MILLI);
			logger.info("Double Tap is performed");
		} catch (Exception exception) {
			logger.error("Double Tap is not performed : " + exception);
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
			assert false;
		}
	}

	public static void pinchIn(By element) { // working
		try {
			Point point = getCenterOfElement(element);
			pinchIn(point);
			logger.info("pinchIn is performed ");
		} catch (Exception exception) {
			logger.error("pinchIn is not performed: " + exception);
		}
	}

	public static void pinchIn(Point point) {
		try {
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
			Sequence sequence = new Sequence(finger1, 1)
					.addAction(
							finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y))
					.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger1, Duration.ofMillis(500)))
					.addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
							point.getX() + 500, point.getY() - 500))
					// Adjust the duration as needed
					.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence sequence1 = new Sequence(finger2, 1)
					.addAction(
							finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y))
					.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger2, Duration.ofMillis(500)))
					.addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
							point.getX() - 500, point.getY() + 500))
					// Adjust the duration as needed
					.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(Arrays.asList(sequence, sequence1));
		} catch (Exception exception) {
			logger.error("pinchIn is not performed " + exception);
		}
	}

	public static void pinchOut(By element) {
		try {
			Point point = getCenterOfElement(element);
			pinchOut(point);
			logger.info("pinchOut is performed ");
		} catch (Exception exception) {
			logger.error("pinchOut is not performed: " + exception);
		}
	}

	public static void pinchOut(Point point) {
		try {
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
			Sequence sequence = new Sequence(finger1, 1)
					.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x + 400,
							point.y - 400))
					.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger1, Duration.ofMillis(200)))
					.addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
							point.getX(), point.getY()))
					// Adjust the duration as needed
					.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence sequence1 = new Sequence(finger2, 1)
					.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x - 400,
							point.y + 400))
					.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger2, Duration.ofMillis(200)))
					.addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
							point.getX(), point.getY()))
					// Adjust the duration as needed
					.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(Arrays.asList(sequence, sequence1));
		} catch (Exception exception) {
			logger.error("pinchOut is not performed " + exception);
		}
	}

	public void flingAction(By locator, String swipeDirection) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) element).getId(), "direction", swipeDirection, "speed", 500));
			logger.info("Swipe Action is achieved");
		} catch (Exception exception) {
			logger.error("Swipe Action is not achieved : " + exception);
		}
	}

	public static void angleRotation(By element) { // working
		try {
			Point point = getCenterOfElement(element);
			angleRotation(point);
			logger.info("Angle Rotation is performed ");
		} catch (Exception exception) {
			logger.error("Angle Rotation is not performed: " + exception);
		}
	}

	public static void angleRotation(Point point) {
		try {
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

			// Simulate a pinch gesture with two fingers (rotate)
			Sequence sequence = new Sequence(finger1, 1)
					.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y))
					.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger1, Duration.ofMillis(1500)));

			Sequence sequence1 = new Sequence(finger2, 1)
					  .addAction(finger2.createPointerMove(Duration.ZERO,
					  PointerInput.Origin.viewport(), point.x , point.y - 1000))
					  .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					  .addAction(new Pause(finger2, Duration.ofMillis(500)))
					  .addAction(finger2.createPointerMove(Duration.ofMillis(1000),
					  PointerInput.Origin.viewport(), point.x + 800, point.y - 1000)) 
					  .addAction(new
					  Pause(finger2, Duration.ofMillis(500)))
					  .addAction(finger2.createPointerMove(Duration.ofMillis(1000),
					  PointerInput.Origin.viewport(), point.x + 800, point.y + 1000))
					  .addAction(new
					  Pause(finger2, Duration.ofMillis(500)))
					  .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(Arrays.asList(sequence, sequence1));
		} catch (Exception exception) {
			logger.error("Angle Rotation is not performed " + exception);
			assert false;
		}
	}
}

/*
 * public static void angleRotation(Point point) { try { PointerInput finger1 =
 * new PointerInput(PointerInput.Kind.TOUCH, "finger1"); PointerInput finger2 =
 * new PointerInput(PointerInput.Kind.TOUCH, "finger2"); Sequence sequence = new
 * Sequence(finger1, 1) .addAction(finger1.createPointerMove(Duration.ZERO,
 * PointerInput.Origin.viewport(), point.x, point.y))
 * .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
 * .addAction(new Pause(finger1, Duration.ofMillis(3000)));
 * 
 * Sequence sequence1 = new Sequence(finger2, 1)
 * .addAction(finger2.createPointerMove(Duration.ZERO,
 * PointerInput.Origin.viewport(), point.getX() - 1000, point.getY() - 1000))
 * .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
 * .addAction(new Pause(finger2, Duration.ofMillis(500)))
 * .addAction(finger2.createPointerMove(Duration.ofMillis(1000),
 * PointerInput.Origin.viewport(), point.getX() + 1000, point.getY())) // Adjust
 * the duration as needed
 * .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
 * 
 * 
 * driver.perform(Arrays.asList(sequence, sequence1)); } catch (Exception
 * exception) { logger.error("Angle Rotation is not performed " + exception);
 * assert false; } }
 * 
 */

/*
 *  //half square code
 * 
 * Sequence sequence1 = new Sequence(finger2, 1)
 * .addAction(finger2.createPointerMove(Duration.ZERO,
 * PointerInput.Origin.viewport(), point.x, point.y))
 * .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
 * .addAction(new Pause(finger2, Duration.ofMillis(500)))
 * .addAction(finger2.createPointerMove(Duration.ofMillis(1000),
 * PointerInput.Origin.viewport(), point.x + 200, point.y)) .addAction(new
 * Pause(finger2, Duration.ofMillis(500)))
 * .addAction(finger2.createPointerMove(Duration.ofMillis(1000),
 * PointerInput.Origin.viewport(), point.x + 200, point.y + 200)) .addAction(new
 * Pause(finger2, Duration.ofMillis(500)))
 * .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
 * 
 * 
 */

/*
 *  //left side straight line
 * 
 * Sequence sequence1 = new Sequence(finger2, 1)
.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
		point.getX() - 500, point.getY() - 500))
.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
.addAction(new Pause(finger2, Duration.ofMillis(500)))
.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
		point.getX() - 500, point.getY()))
// Adjust the duration as needed
.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
 * 
 * */

