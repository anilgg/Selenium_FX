package com.fxinnovation.seleniumqa.test.page;

import java.util.Properties;
import com.fxinnovation.seleniumqa.test.common.CommonOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fxinnovation.seleniumqa.util.ConfigReader;

public class LunchPage {
	private WebDriver driver;
	private ConfigReader configReader = ConfigReader.getInstance();
	private Properties objectRepository;
	CommonOperations common= new CommonOperations(driver); 
	
	public LunchPage(WebDriver driver){
		this.driver=driver;
		
		objectRepository = configReader.getProperties("or.properties");
		//CommonOperations common= new CommonOperations(driver); 
	}
	
	public void clickOnLunch() {
		driver.findElement(By.id("lst-ib")).sendKeys("anil");
		//driver.findElement(By.id(objectRepository.getProperty("lunchButton"))).click();
		//common.clickElementByID(objectRepository.getProperty(lunchButton));
	}
	
}
