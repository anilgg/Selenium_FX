package com.fxinnovation.seleniumqa.test.common;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

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

	
	public String login(String ElementID, String username_data, String password_data)
	{
		try
		{
	    	String SS1 = configRepository1.getProperty(username_data);
	    	if(ElementID.endsWith("id"))
	    	{
	    		driver.switchTo().frame("gsft_main").findElement(By.id(objectRepository.getProperty(ElementID))).sendKeys(SS1);
	    		login_iFrametab(password_data);
	    	}
	    	else if(ElementID.endsWith("path"))
	    	{
	    		driver.switchTo().frame("gsft_main").findElement(By.xpath(objectRepository.getProperty(ElementID))).sendKeys(SS1);
	    		login_iFrametab(password_data);
	    	}
	    	else if(ElementID.endsWith("name"))
	    	{
	    		driver.switchTo().frame("gsft_main").findElement(By.name(objectRepository.getProperty(ElementID))).sendKeys(SS1);
	    		login_iFrametab(password_data);
	    	}
	    	else
	    	{
	    		driver.switchTo().frame("gsft_main").findElement(By.xpath(objectRepository.getProperty(ElementID))).sendKeys(SS1);
	    		login_iFrametab(password_data);	    	
	        }
		}
	    catch(Exception e){
	        return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();
	    }
	    return Constants.KEYWORD_PASS;
	}
		
	
	// Input to the text box
	
	public String writeInput(String ElementID, String data )
	{    
		// APP_LOGS.debug("Writing in text box");
    try{
    	String SS1 = configRepository1.getProperty(data);
    	if(ElementID.endsWith("id"))
    		driver.findElement(By.id(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    		else if(ElementID.endsWith("path"))
    		driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    	else if(ElementID.endsWith("name"))
    		driver.findElement(By.name(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    	else if(ElementID.endsWith("css"))
    		driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).sendKeys(SS1);
    	else
    		driver.findElement((By.linkText(objectRepository.getProperty(ElementID)))).sendKeys(SS1);
    	
        }
    catch(Exception e){
        return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();
    }
    return Constants.KEYWORD_PASS;
	}
	
	// Tab key for Iframe	
	
	public void login_iFrametab(String data)
	{
		WebElement element = driver.findElement(By.id("user_password"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(configRepository1.getProperty(data));
		element.sendKeys(Keys.ENTER);
	}
	
	
	// To click the link
	public String clickLink(String ElementID)
	{
      //APP_LOGS.debug("Clicking on link ");
		try{
	    	if(ElementID.endsWith("id"))
	    		driver.findElement(By.id(objectRepository.getProperty(ElementID))).click();
	    		else if(ElementID.endsWith("path"))
	    		driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).click();
	    	else if(ElementID.endsWith("name"))
	    		driver.findElement(By.name(objectRepository.getProperty(ElementID))).click();
	    	else if(ElementID.endsWith("css"))
	    		driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).click();
	    	else
	    		driver.findElement((By.linkText(objectRepository.getProperty(ElementID)))).click();	    	
	        }
	    catch(Exception e){
	        return Constants.KEYWORD_FAIL+" Unable to click on link "+e.getMessage();
	    }
	    return Constants.KEYWORD_PASS;
	}

	
	public  String verifyLinkText(String ElementID,String data)
	{
      //APP_LOGS.debug("Verifying link Text");
		String actual = "";
		String expected = "";
      try{
    	  if(ElementID.endsWith("id"))
    	  {
    		  actual=driver.findElement(By.id(objectRepository.getProperty(ElementID))).getText();
              expected=data;
    	  }  
    	  else if(ElementID.endsWith("xpath"))
    	  {
    		  actual=driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).getText();
              expected=data;
    	  }
    	  else if(ElementID.endsWith("name"))
    	  {
    		  actual=driver.findElement(By.name(objectRepository.getProperty(ElementID))).getText();
              expected=data;
    	  }
    	  else if(ElementID.endsWith("css"))
    	  {
    		  actual=driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).getText();
              expected=data;
    	  }
    	  if(actual.equals(expected))
              return Constants.KEYWORD_PASS;
          else
              return Constants.KEYWORD_FAIL+" -- Link text not verified";
      	}
      catch(Exception e){
          return Constants.KEYWORD_FAIL+" -- Link text not verified"+e.getMessage();

      	}

	}
	
	
	// Click the button
	
	
	public  String clickButton(String ElementID,String data)
	{
      //APP_LOGS.debug("Clicking on Button");
		try{
	    	if(ElementID.endsWith("id"))
	    		driver.findElement(By.id(objectRepository.getProperty(ElementID))).click();
	    		else if(ElementID.endsWith("path"))
	    		driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).click();
	    	else if(ElementID.endsWith("name"))
	    		driver.findElement(By.name(objectRepository.getProperty(ElementID))).click();
	    	else if(ElementID.endsWith("css"))
	    		driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).click();
	    	else
	    		driver.findElement((By.linkText(objectRepository.getProperty(ElementID)))).click();	    	
	        }
	    catch(Exception e){
	        return Constants.KEYWORD_FAIL+" Unable to click on button "+e.getMessage();
	    }
	    return Constants.KEYWORD_PASS;
	}
	
	
	// To verify the button text
	
	public  String verifyButtonText(String ElementID,String data){
				// APP_LOGS.debug("Verifying the button text");
		
				String actual = "";
				String expected = "";
		      try{
		    	  if(ElementID.endsWith("id"))
		    	  {
		    		  actual=driver.findElement(By.id(objectRepository.getProperty(ElementID))).getText();
		              expected=data;
		    	  }  
		    	  else if(ElementID.endsWith("xpath"))
		    	  {
		    		  actual=driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).getText();
		              expected=data;
		    	  }
		    	  else if(ElementID.endsWith("name"))
		    	  {
		    		  actual=driver.findElement(By.name(objectRepository.getProperty(ElementID))).getText();
		              expected=data;
		    	  }
		    	  else if(ElementID.endsWith("css"))
		    	  {
		    		  actual=driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).getText();
		              expected=data;
		    	  }          if(actual.equals(expected))
              return Constants.KEYWORD_PASS;
          else
              return Constants.KEYWORD_FAIL+" -- Button text not verified "+actual+" -- "+expected;
      }catch(Exception e){
          return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
      }

  }
  
	// to verify the elements of the list (need to work)
	public  String selectList(String object, String data){
			// APP_LOGS.debug("Selecting from list");
      try{
          if(!data.equals(Constants.RANDOM_VALUE)){
              driver.findElement(By.xpath(objectRepository.getProperty(object))).sendKeys(data);
          }else{
              // logic to find a random value in list
              WebElement droplist= driver.findElement(By.xpath(objectRepository.getProperty(object)));
              List<WebElement> droplist_contents = droplist.findElements(By.tagName("option"));
              Random num = new Random();
              int index=num.nextInt(droplist_contents.size());
              String selectedVal=droplist_contents.get(index).getText();

              driver.findElement(By.xpath(objectRepository.getProperty(object))).sendKeys(selectedVal);
          }
      }catch(Exception e){
          return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();

      }

      return Constants.KEYWORD_PASS;
  }
	
	// To select the radio button
	public  String selectRadio(String ElementID, String data){
			//  APP_LOGS.debug("Selecting a radio button");
      try{
          if(ElementID.endsWith("xpath"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          driver.findElement(By.xpath(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).click();
          }
          else if(ElementID.endsWith("id"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          driver.findElement(By.id(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).click();
          }
          else if(ElementID.endsWith("name"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          driver.findElement(By.name(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).click();
          }
          else if(ElementID.endsWith("css"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          driver.findElement(By.cssSelector(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).click();
          }
      }catch(Exception e){
          return Constants.KEYWORD_FAIL +"- Not able to find radio button";
      }

      return Constants.KEYWORD_PASS;
  }

	
	// To verify if radio button is selected
  public  String verifyRadioSelected(String ElementID, String data){
	  			// APP_LOGS.debug("Verify Radio Selected");
      String checked = "";
	  try{
          if(ElementID.endsWith("xpath"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          checked=driver.findElement(By.xpath(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).getAttribute("checked");
          }
          else if(ElementID.endsWith("id"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          checked=driver.findElement(By.id(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).getAttribute("checked");
          }
          else if(ElementID.endsWith("name"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          checked=driver.findElement(By.name(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).getAttribute("checked");
          }
          else if(ElementID.endsWith("css"))
          {
    	  String temp[]=ElementID.split(Constants.DATA_SPLIT);
          checked=driver.findElement(By.cssSelector(objectRepository.getProperty(temp[0])+data+objectRepository.getProperty(temp[1]))).getAttribute("checked");
          }
          if(checked==null)
              return Constants.KEYWORD_FAIL+"- Radio not selected";
      }catch(Exception e){
        return Constants.KEYWORD_FAIL +"- Not able to find radio button";

      }
      return Constants.KEYWORD_PASS;
	}

  /**
  * The CheckCheckBox is a method that simply verifies if the check box is selected.
  *
  * @author  Anil Ganesh
  * @version 1.0
  * @since   2017-01-18 
  */
  public  String checkCheckBox(String ElementID){
	  		// APP_LOGS.debug("Checking checkbox");
	  try{
		  if(ElementID.endsWith("xpath"))
		  {
		  String checked=driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked==null)// checkbox is unchecked
			  driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).click();
		  }
		  else if(ElementID.endsWith("name"))
		  {
		  String checked=driver.findElement(By.name(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked==null)// checkbox is unchecked
			  driver.findElement(By.name(objectRepository.getProperty(ElementID))).click();
		  }
		  else if(ElementID.endsWith("id"))
		  {
		  String checked=driver.findElement(By.id(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked==null)// checkbox is unchecked
			  driver.findElement(By.id(objectRepository.getProperty(ElementID))).click();
		  }
		  else if(ElementID.endsWith("css"))
		  {
		  String checked=driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked==null)// checkbox is unchecked
			  driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).click();
		  }
	  }catch(Exception e){
		  return Constants.KEYWORD_FAIL+" - Could not find checkbox";
	  }
	  return Constants.KEYWORD_PASS;

  }

  /**
  * The unCheckCheckBox is a method that helps to uncheck the check box if selected.
  *@param
  *
  */
  public String unCheckCheckBox(String ElementID){
	  	//	APP_LOGS.debug("Unchecking checkBox");
	  try{
		  if(ElementID.endsWith("xpath"))
		  {
		  String checked=driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked!=null)
			  driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).click();
		  }
		  else if(ElementID.endsWith("name"))
		  {
		  String checked=driver.findElement(By.name(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked!=null)
			  driver.findElement(By.name(objectRepository.getProperty(ElementID))).click();
		  }
		  else if(ElementID.endsWith("id"))
		  {
		  String checked=driver.findElement(By.id(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked!=null)
			  driver.findElement(By.id(objectRepository.getProperty(ElementID))).click();
		  }
		  else if(ElementID.endsWith("css"))
		  {
		  String checked=driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked!=null)
			  driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).click();
		  }
	  }catch(Exception e){
		  return Constants.KEYWORD_FAIL+" - Could not find checkbox";
	  }
	  return Constants.KEYWORD_PASS;

  }


  /**
  * The verifyCheckBoxSelected is a method that simply verifies if the check box is selected.
  *
  * @author  Anil Ganesh
  * @version 1.0
  * @since   2017-01-19 
  */
  public  String verifyCheckBoxSelected(String ElementID){
	  		// APP_LOGS.debug("Verifying checkbox selected");
	  String checked = "";
	  try{
		  if(ElementID.endsWith("xpath"))		  
			  checked=driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  else if(ElementID.endsWith("id"))
			  checked=driver.findElement(By.id(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  else if(ElementID.endsWith("name"))
			  checked=driver.findElement(By.name(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  else if(ElementID.endsWith("css"))
			  checked=driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).getAttribute("checked");
		  if(checked!=null)
			  return Constants.KEYWORD_PASS;
		  else
			  return Constants.KEYWORD_FAIL + " - Not selected";

	  }catch(Exception e){
		  return Constants.KEYWORD_FAIL+" - Could not find checkbox";

	  }


  }
	
  /**
   * The verifyText is a method that verifies if the test data and the text received are same.
   *
   * @author  Anil Ganesh
   * @version 1.0
   * @since   2017-01-19 
   */
	public String verifyText(String ElementID, String data) {
			// APP_LOGS.debug("Verifying the text");
		String actual = "";
		String expected = "";
		try {
			if(ElementID.endsWith("xpath"))
			{
				actual = driver.findElement(By.xpath(objectRepository.getProperty(ElementID))).getText();
				expected = data;
			}
			else if(ElementID.endsWith("id"))
			{
				actual = driver.findElement(By.id(objectRepository.getProperty(ElementID))).getText();
				expected = data;
			}
			else if(ElementID.endsWith("name"))
			{
				actual = driver.findElement(By.name(objectRepository.getProperty(ElementID))).getText();
				expected = data;
			}
			else if(ElementID.endsWith("css"))
			{
				actual = driver.findElement(By.cssSelector(objectRepository.getProperty(ElementID))).getText();
				expected = data;
			}
			if (actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified " + actual + " -- " + expected;
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " Object not found " + e.getMessage();
		}

	}
	
	
}