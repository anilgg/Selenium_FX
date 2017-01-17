package com.fxinnovation.seleniumqa.test.common;

import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.fxinnovation.seleniumqa.test.Constants;
import com.fxinnovation.seleniumqa.util.ConfigReader;

public class CommonOperations 
{

	private WebDriver driver;
	private ConfigReader configReader = ConfigReader.getInstance();
	private Properties objectRepository;
	private Properties configRepository1;
	
	
	public CommonOperations(WebDriver driver)
	{
		this.driver=driver;		
		objectRepository = configReader.getProperties("or.properties");
		configRepository1 = configReader.getProperties("config.properties");
	}

	public String writeInInput(String ElementID, String data )
	{    
		// APP_LOGS.debug("Writing in text box");
    try{
    	String SS1 = configRepository1.getProperty(data);
    	if(ElementID.endsWith("id"))
    		driver.switchTo().frame("gsft_main").findElement(By.id(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    		else if(ElementID.endsWith("path"))
    		driver.switchTo().frame("gsft_main").findElement(By.xpath(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    	else if(ElementID.endsWith("name"))
    		driver.switchTo().frame("gsft_main").findElement(By.name(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    	else
    		driver.switchTo().frame("gsft_main").findElement(By.xpath(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    	
        }
    catch(Exception e){
        return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();
    }
    return Constants.KEYWORD_PASS;
	}
	
	public void login_tab()
	{
		WebElement element = driver.findElement(By.id("user_password"));
		element.sendKeys(Keys.TAB);
		element.sendKeys("selenium01");
		element.sendKeys(Keys.ENTER);
	}
	
	
}