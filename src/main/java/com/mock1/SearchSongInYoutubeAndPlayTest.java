package com.mock1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSongInYoutubeAndPlayTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com");
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("chola chola");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		driver.findElement(By.xpath("//img[@src='https://i.ytimg.com/vi/55Kc0mIyeXM/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBHTja0dS2wTrAk_kMCPgk873UpRA']")).click();
		driver.findElement(By.xpath("//div[.='Skip Ads' and @id='ad-text:6']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
