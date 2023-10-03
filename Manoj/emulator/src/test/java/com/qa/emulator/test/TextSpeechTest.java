package com.qa.emulator.test;

import org.testng.annotations.Test;

import com.qa.emulator.actions.TextSpeechActions;

public class TextSpeechTest {
	TextSpeechActions textSpeechActions = new TextSpeechActions();

	@Test()
	public void textSpeechTest() {
		textSpeechActions.textSpeech();
	}
}
