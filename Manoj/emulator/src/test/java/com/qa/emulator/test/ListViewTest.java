package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.ListViewActions;
import com.qa.emulator.dataprovider.CustomDataProvider;

public class ListViewTest {
	
	ListViewActions listViewActions = new ListViewActions();
	
	@Test(priority = 0)
	public void doubleTapAndFlingTest() {
		listViewActions.doubleTapAndFling();
	}
	
	@Test(dataProvider = "TestData", dataProviderClass = CustomDataProvider.class, priority = 1)
	public void scrollAndClickTest(String country) {
		listViewActions.barScrollindAndClicking(country);
	}

}
