package com.Remote;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteConnection {
	@Test
	public void RC1_Test() throws MalformedURLException, InterruptedException{
		URL url = new URL("http://13.233.116.234:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
