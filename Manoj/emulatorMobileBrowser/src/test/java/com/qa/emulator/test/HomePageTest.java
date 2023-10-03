package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.HomePageActions;
import com.qa.emulator.basetest.BaseTest;


public class HomePageTest extends BaseTest{
	HomePageActions homePageActions = new HomePageActions();

	@Test()
	public void fillTheFormTest() {
		homePageActions.fillTheForm();
	}

}
