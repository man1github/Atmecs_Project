package com.qa.emulator.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;


public class HomePage {
	
	public static final By DOWNLOAD_FOLDER = AppiumBy.id("com.ai.gallery.android:id/dir_thumbnail");
	public static final By SELECT_TEMPLE_PHOTO = AppiumBy.id("com.ai.gallery.android:id/medium_thumbnail");
	public static final By INTERACT_TEMPLE_PHOTO = AppiumBy.id("com.ai.gallery.android:id/gestures_view");
	
//	public static final By ALERT_CONFIRM = AppiumBy.id("com.android.packageinstaller:id/permission_allow_button");
	public static final By DOWNLOAD_ALBUM = AppiumBy.id("gallery.hidepictures.photovault.lockgallery:id/dir_thumbnail");
	public static final By TEMPLE_PHOTO = AppiumBy.id("gallery.hidepictures.photovault.lockgallery:id/medium_thumbnail");
	public static final By INTERACT_TEMPLE_PHOTO_1 = AppiumBy.id("gallery.hidepictures.photovault.lockgallery:id/gestures_view");
	

}
