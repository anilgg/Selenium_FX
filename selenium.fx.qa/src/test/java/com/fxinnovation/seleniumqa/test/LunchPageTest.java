package com.fxinnovation.seleniumqa.test;

import org.junit.Before;
import org.junit.Test;
import com.fxinnovation.seleniumqa.test.common.TestBaseSetup;


public class LunchPageTest extends TestBaseSetup 
{
	
	@Before
	public void setUp() 
	{

		super.setup();
	}

	@Test
	public void luchApp() {
		try {

			getCommon().login("login_username_id", "user_name", "password");

		} catch (Exception e)

		{
			System.out.println("check here");
			System.out.println(e);
		}

	}
}