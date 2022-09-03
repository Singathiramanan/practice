package com.Github;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricbuzz {

	@Test 
	public void CricBuzz(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/51222/ind-vs-hk-4th-match-group-a-asia-cup-2022");
		List<WebElement> wickets = driver.findElements(By.xpath("//div[@id='innings_2']/descendant::div[.='Bowler']/../following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms ']/child::div[@class='cb-col cb-col-8 text-right text-bold']"));
		List<WebElement> names = driver.findElements(By.xpath("//div[@id='innings_2']/descendant::div[.='Bowler']/../following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms ']/child::div[@class='cb-col cb-col-40']/a"));
		ArrayList<String> key=new ArrayList<String>();
		for(WebElement w1:names){
			key.add(w1.getText());
		}
		ArrayList<String> value=new ArrayList<String>();
		for(WebElement w2:wickets){
			value.add(w2.getText());
		}
		TreeMap<String, String> taken=new TreeMap<String, String>();
		for(int i=0;i<key.size();i++){
			taken.put(key.get(i),value.get(i));
		}
		int no,max=0;
		
		for(Entry<?, ?> e1:taken.entrySet()){
			String str1 = e1.getValue().toString();
			no=Integer.parseInt(str1);
			if(no>max){
				max=no;
			}
		}
		for(Entry<?, ?> e2:taken.entrySet()){
			if(Integer.parseInt(e2.getValue().toString())==max){
				System.out.println(e2.getKey()+" "+e2.getValue());
			}
		}
		
	}
}
