package com.qa.emulator.actions;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.qa.emulator.pages.AddToCartPage;
import com.qa.emulator.pages.HomePage;
import com.qa.emulator.properties.PropertiesFiles;
import com.qa.emulator.utils.ReusableMethods;

public class AddToCartActions extends ReusableMethods{

	public static Logger logger = Logger.getLogger(AddToCartActions.class);
	public static String firstProduct;
	public static String secondProduct;
	public static String thirdProduct;

	public void productAddedToCart() {
		try {
			test = extent.createTest("Add the Product to the cart");
			click(AddToCartPage.ADD_TO_CART_PRODUCT_1);
			firstProduct =  getText(AddToCartPage.PRODUCT_1);
			click(AddToCartPage.ADD_TO_CART_PRODUCT_2);
			secondProduct =  getText(AddToCartPage.PRODUCT_2);
			scrollableAndClick(PropertiesFiles.readTestData("ShoeModel"));
			click(AddToCartPage.ADD_TO_CART_PRODUCT_3);
			thirdProduct =  getText(AddToCartPage.PRODUCT_3);
			click(AddToCartPage.CART_ICON);
			test.log(Status.PASS, "Add the Product to the cart Method is performed");
			logger.info("Add the Product to the cart Method is performed");
		} catch (Exception exception) {
			test.log(Status.FAIL, "Exception Occured" + exception);
			logger.error("Add the Product to the cart Method is not performed : " + exception);
			assert false;
		}
	}
}
