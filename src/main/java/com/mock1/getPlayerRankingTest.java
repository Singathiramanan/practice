package com.mock1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getPlayerRankingTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com");
		driver.findElement(By.xpath("//a[@href='https://www.icc-cricket.com/rankings/mens/overview']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()){
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if(title.equals("ICC Men's Cricket Rankings Overview | ICC")){
				break;
			}
		}
		System.out.println(driver.getTitle());
		Actions act=new Actions(driver);
		//WebElement teams = driver.findElement(By.xpath("//nav[@class='main-navigation__desktop-list js-desktop-nav']/descendant::button[contains(.,'Teams')]"));
		WebElement ranking = driver.findElement(By.xpath("//nav[@class='main-navigation__desktop-list js-desktop-nav']/descendant::button[contains(.,'Ranking')]"));
		act.moveToElement(ranking).perform();
		driver.findElement(By.xpath("//nav[@class='main-navigation__desktop-list js-desktop-nav']/descendant::button[contains(.,'Women')]/following-sibling::ul[@role='group']/descendant::a[contains(.,'Player Rankings')]")).click();
		driver.quit();
	}

}
