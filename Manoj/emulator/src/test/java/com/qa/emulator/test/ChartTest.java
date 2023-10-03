package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.ChartActions;

public class ChartTest {
	
	ChartActions chartActions = new ChartActions();
	
	@Test
	public void name() {
		chartActions.handleLongPress();
	}

}
