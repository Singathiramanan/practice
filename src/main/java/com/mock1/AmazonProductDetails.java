package com.mock1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProductDetails {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("washing machine");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-index='2']")).click();
		Set<String> ids = driver.getWindowHandles();
		String proTitle="Amazon Basics 6.5 Kg Fully Automatic Top Loading Washing Machine (Grey, LED panel, Memory Feature) : Amazon.in: Home & Kitchen";
		for(String win:ids){
			driver.switchTo().window(win);
			//System.out.println(driver.getTitle());
			if(driver.getTitle().equals(proTitle)){
				break;
			}
		}
		String brand="Amazon Basics";
		String dimentions="52.5D x 57.1W x 92.9H Centimeters";
		String capacity="6.5 Kilograms";
		String location="Top Load";
		String colour="Grey";
		//String cycleOptions="Eco, Tub Clean, Quick Wash, Bulky";
		
		driver.findElement(By.xpath("//input[@id='mbb-offeringID-1']")).click();
		 WebElement ele1 = driver.findElement(By.xpath("//span[.='Brand']/../following-sibling::td/span"));
		 WebElement ele2 = driver.findElement(By.xpath("//span[.='Product Dimensions']/../following-sibling::td/span"));
		 WebElement ele3 = driver.findElement(By.xpath("//span[.='Capacity']/../following-sibling::td/span"));
		 WebElement ele4 = driver.findElement(By.xpath("//span[.='Access Location']/../following-sibling::td/span"));
		 WebElement ele5 = driver.findElement(By.xpath("//span[.='Colour']/../following-sibling::td/span"));
		// WebElement ele6 = driver.findElement(By.xpath("//span[.='Cycle Options']/../following-sibling::td/span"));

		 SoftAssert sf=new SoftAssert();
		 sf.assertEquals(brand, ele1.getText());
		 sf.assertEquals(dimentions, ele2.getText());
		 sf.assertEquals(capacity, ele3.getText());
		 sf.assertEquals(location, ele4.getText());
		 sf.assertEquals(colour, ele5.getText());
		// sf.assertEquals(cycleOptions, ele6.getText());
		 System.out.println("product Details are same");
		 sf.assertAll();
		 driver.quit();
	}

}
