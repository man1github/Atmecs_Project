package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.CartActions;

public class CartTest {

	CartActions cartActions = new CartActions();

	@Test(priority = 0)
	public void validateCartProductDetails() {
		cartActions.validateTheItemsName();
		cartActions.validateTheItemsPrice();
	}
	
	@Test(priority = 1)
	public void navigateWebViewTest() {
		cartActions.validateLongPressAndNavigateToWebView();
	}

}
