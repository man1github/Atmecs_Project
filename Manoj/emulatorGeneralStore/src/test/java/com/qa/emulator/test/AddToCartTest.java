package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.AddToCartActions;
import com.qa.emulator.basetest.BaseTest;

public class AddToCartTest {
	
	AddToCartActions addToCartActions = new AddToCartActions();

	@Test()
	public void productAddedToCartTest() {
		addToCartActions.productAddedToCart();
	}

}
