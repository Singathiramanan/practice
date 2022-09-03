package com.Remote;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteConnection {
	@Test
	public void RC1_Test() throws MalformedURLException{
		URL url = new URL("http://Localhost:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
		driver.get("https://www.gmail.com");
		
	}
}
