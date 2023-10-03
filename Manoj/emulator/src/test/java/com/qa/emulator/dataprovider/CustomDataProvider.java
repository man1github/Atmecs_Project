package com.qa.emulator.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "TestData")
	public Object[][] getData() {
		Object[][] data = { { "Norway" }, { "Afghanistan" }, { "Albania" } };
		return data;
	}
}
