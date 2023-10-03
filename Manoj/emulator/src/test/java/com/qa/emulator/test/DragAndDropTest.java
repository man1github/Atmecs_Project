package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.DragAndDropActions;

public class DragAndDropTest {
	
	DragAndDropActions dragAndDropActions = new DragAndDropActions();
	
	@Test
	public void dragAndDropTest() {
		dragAndDropActions.dragAndDropGesture();
		dragAndDropActions.handleNotifications();
	}

}
