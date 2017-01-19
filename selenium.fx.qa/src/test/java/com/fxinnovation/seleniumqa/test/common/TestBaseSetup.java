package com.fxinnovation.seleniumqa.test.common;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import com.fxinnovation.seleniumqa.util.ConfigReader;
import org.openqa.selenium.UnexpectedAlertBehaviour;

public class TestBaseSetup {

	private ConfigReader configReader = ConfigReader.getInstance();
	Properties config = configReader.getProperties("config.properties");
	private CommonOperations common;
	
	public CommonOperations getCommon()
	{
		return common;
	}
	
	protected WebDriver driver;


	public void setup() {
		initializeWebDriver();
		common = new CommonOperations(getWebDriver());

	}

	public void initializeWebDriver() {

		String browserType = config.getProperty("browserType");

		System.out.println("browserType: " + browserType);

		try {
			if (config.getProperty("browserType").equals("firefox")) {
				driver = initFirefoxDriver(config.getProperty("testsiteBaseURL"));
			} else if (config.getProperty("browserType").equals("IE")) {
				driver = initIEDriver(config.getProperty("testsiteBaseURL"));
			} else if (config.getProperty("browserType").equals("Chrome")) {
				driver = initChromeDriver(config.getProperty("testsiteBaseURL"));
			} else {
				 driver = initSafariDriver(config.getProperty("testsiteBaseURL"));
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", config.getProperty("ChromeDriver"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", config.getProperty("GeckoDriver"));
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	private WebDriver initIEDriver(String appURL) {
		System.out.println("Launching IE browser..");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver", config.getProperty("IEDriver"));
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	 private WebDriver initSafariDriver(String appURL) {
	 System.out.println("Launching Safari browser..");
	 DesiredCapabilities capabilities = DesiredCapabilities.safari();
	 System.setProperty("webdriver.safari.driver", config.getProperty("SafariDriver"));
	 WebDriver driver = new SafariDriver(capabilities);
	 capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
	 driver.get(appURL);
	 return driver;
	 }
	
/*
	@After
	public void tearDown() {
		driver.quit();
	}
*/
	public WebDriver getWebDriver() {
		return driver;
	}

}
