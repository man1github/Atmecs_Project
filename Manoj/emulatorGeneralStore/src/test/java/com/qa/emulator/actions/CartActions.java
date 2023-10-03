package com.qa.emulator.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.AddToCartPage;
import com.qa.emulator.pages.CartPage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

public class CartActions extends ReusableMethods{

	public static Logger logger = Logger.getLogger(CartActions.class);
	public String price;

	public void validateTheItemsName() {
		try {
			test = extent.createTest("Validate The Items Name");
			String cartProductA =  getText(CartPage.CART_SHOE_1);
			Assert.assertTrue(AddToCartActions.firstProduct.equals(cartProductA));
			String cartProductB =  getText(CartPage.CART_SHOE_2);
			Assert.assertTrue(AddToCartActions.secondProduct.equals(cartProductB));
			swipeAction(CartPage.CART_SHOE_3, PropertiesFiles.readTestData("UpDirection"));
			String cartProductC =  getText(CartPage.CART_SHOE_3);
			Assert.assertTrue(AddToCartActions.thirdProduct.equals(cartProductC));
			test.log(Status.PASS, "Validate The Items Name Method is performed");
			logger.info("Validate The Items Name Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Validate The Items Name Method is not performed : " + exception);
			assert false;
		}
	}
	
	public void validateTheItemsPrice() {
		try {
			Double priceDouble = null;
			test = extent.createTest("Validate The Items Price");
			List<WebElement> indvidualProductPrice = driver.findElements(CartPage.CART_PRODUCT_PRICE);
			for (int i = 0; i < indvidualProductPrice.size(); i++) {
				price = indvidualProductPrice.get(i).getAttribute("text");
				priceDouble =  Double.parseDouble(price.substring(1));
				priceDouble += priceDouble;
			}
			Double totalPrice = Double.parseDouble(getText(CartPage.CART_TOTAL_PRICE).substring(1));
			Assert.assertTrue(priceDouble.equals(totalPrice));
			test.log(Status.PASS, "Validate The Items Price Method is performed");
			logger.info("Validate The Items Price Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Validate The Items Price Method is not performed : " + exception);
			assert false;
		}
	}
	
	public void validateLongPressAndNavigateToWebView() {
		try {
			test = extent.createTest("Validate LongPress And Navigate To WebView");
			click(CartPage.CHECK_BOX);
			longPress(CartPage.TERMS_CONDITIONS);
			alert();
			click(CartPage.VISIT_WEBSITE);
			test.log(Status.PASS, "Validate LongPress And Navigate To WebView Method is performed");
			logger.info("Validate LongPress And Navigate To WebView Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Validate LongPress And Navigate To WebView Method is not performed : " + exception);
			assert false;
		}
	}
}
