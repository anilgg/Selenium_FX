package com.fxinnovation.seleniumqa.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fxinnovation.seleniumqa.test.common.TestBaseSetup;
import com.fxinnovation.seleniumqa.test.page.LunchPage;
import com.fxinnovation.seleniumqa.util.ConfigReader;
import com.fxinnovation.seleniumqa.test.common.CommonOperations;

public class LunchPageTest extends TestBaseSetup {
	private ConfigReader configReader = ConfigReader.getInstance();
	private CommonOperations common;
	@Before
public void setUp(){
	
	common	= new CommonOperations(getWebDriver());
}
	@Test
	public void luchApp(){
	try{
		common.writeInInput("login_username_id","user_name");
		common.login_tab();
		
	} catch (Exception e)
	
	{
		System.out.println("check here");
		System.out.println(e);	
	}

}
}