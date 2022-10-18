package com.mock1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleNotificationPopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<String, Object>();
		//prefs.put("profile.default_content_setting_values.media_stream", 2);
		prefs.put("profile.managed_default_content_settings.media_stream", 1);
		//prefs.put("credentials_enable_services", false);
		//prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		//options.addArguments("--disable-notificatons");
		//options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");
		//options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
		
	}

}
