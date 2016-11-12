/**
 *   File Name: BasicAutoTest.java<br>
 *
 *   Green, Lorne<br>
 *   Java <br>
 *   <br>
 *   Created: Nov 2, 2016
 *
 */

package com.sqa.lg;

import java.util.concurrent.*;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.opera.*;
import org.testng.annotations.*;

import com.sqa.lg.helpers.*;

/**
 * BasicAutoTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Green, Lorne
 * @version 1.0.0
 * @since 1.0
 *
 */
public class BasicAutoTest {

	private String baseURL;

	private WebDriver driver;

	private Logger log = Logger.getLogger(BasicAutoTest.class);

	/**
	 * @param baseURL
	 * @param driver
	 */
	public BasicAutoTest(String baseURL) {
		this.baseURL = baseURL;

	}

	/**
	 * @return the baseURL
	 */
	public String getBaseURL() {
		return this.baseURL;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * @return the log
	 */
	public Logger getLog() {
		return this.log;
	}

	@BeforeClass(enabled = true, groups = { "chrome-setup" })
	public void setupChrome() {
		// Setup test
		getLog().info("Setting Chrome driver system property");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		getLog().info("Setting up Chrome driver");
		this.driver = new ChromeDriver();
		getLog().trace("Setting implicit wait 30 secounds.");
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getLog().trace("Setting window to fullscreen");
		this.driver.manage().window().maximize();
		getLog().info("Going to baseURL " + this.baseURL);
		this.driver.get(this.baseURL);
		getLog().debug("Clearing cookies.");
		this.driver.manage().deleteAllCookies();
	}

	@BeforeClass(enabled = true, groups = { "firefox-setup" })
	public void setupFirefox() {
		// Setup test
		getLog().info("Setting up Firefox driver");
		this.driver = new FirefoxDriver();
		getLog().trace("Setting implicit wait 30 secounds.");
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getLog().trace("Setting window to fullscreen");
		this.driver.manage().window().maximize();
		getLog().info("Going to baseURL " + this.baseURL);
		this.driver.get(this.baseURL);
		getLog().debug("Clearing cookies.");
		this.driver.manage().deleteAllCookies();
	}

	@BeforeClass(enabled = true, groups = { "ie-setup" })
	public void setupIExplorer() {
		// Setup test
		getLog().info("Setting up IExplorer driver system property");
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		getLog().info("Setting up IExplorer driver");
		this.driver = new InternetExplorerDriver();
		getLog().trace("Setting implicit wait 30 secounds.");
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getLog().trace("Setting window to fullscreen");
		this.driver.manage().window().maximize();
		getLog().info("Going to baseURL " + this.baseURL);
		this.driver.get(this.baseURL);
		getLog().debug("Clearing cookies.");
		this.driver.manage().deleteAllCookies();
	}

	@BeforeClass(enabled = false, groups = { "opera-setup" })
	public void setupOpera() {
		// Setup test
		getLog().info("Setting up Opera driver");
		this.driver = new OperaDriver();
		getLog().trace("Setting implicit wait 30 secounds.");
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getLog().trace("Setting window to fullscreen");
		this.driver.manage().window().maximize();
		getLog().info("Going to baseURL " + this.baseURL);
		this.driver.get(this.baseURL);
		getLog().debug("Clearing cookies.");
		this.driver.manage().deleteAllCookies();
	}

	public boolean takeScreenshot(String filename) {
		return AutoBasics.takeScreenshot(getDriver(), "screenshots/", filename, getLog());
	}

	@AfterClass
	public void tearDown() {
		// Close test
		getLog().info("Closing all driver windows.");
		this.driver.quit();
	}

}
