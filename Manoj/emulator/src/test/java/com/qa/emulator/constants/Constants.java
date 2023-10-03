package com.qa.emulator.constants;

public class Constants {
	public static final String USER_DIRECTORY = System.getProperty("user.dir");
	public static final String CONFIG_PATH = USER_DIRECTORY + "/src/test/resources/config.properties";		
	public static final String PIXEL_4 = USER_DIRECTORY + "/src/test/resources/Devices/Pixel_4.bat"; // Incase you use different machine, you have to replacing existing bat file in devices folder, create bat file which has correct emulator path location and device name in your machine.
	public static final String Pixel_5_API_33 = USER_DIRECTORY + "/src/test/resources/Devices/Pixel_4.bat"; // Incase you use different machine, you have to replacing existing bat file in devices folder, create bat file which has correct emulator path location and device name in your machine.
}
