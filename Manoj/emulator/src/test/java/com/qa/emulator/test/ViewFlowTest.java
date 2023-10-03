package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.ViewFlowActions;

public class ViewFlowTest {

	ViewFlowActions viewFlowActions = new ViewFlowActions();

	@Test()
	public void viewFlowTest() {
		viewFlowActions.tabSwiping();
	}
}
