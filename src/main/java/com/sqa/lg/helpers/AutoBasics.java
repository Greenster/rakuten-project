/**
 *   File Name: AutoBasics.java<br>
 *
 *   Green, Lorne<br>
 *   Java <br>
 *   <br>
 *   Created: Nov 2, 2016
 *
 */

package com.sqa.lg.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * AutoBasics //ADDD (description of class)
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
public class AutoBasics {
	public static final String DEFAULT_SCREENSHOT_FILENAME = "screenshots/";
	public static final String DEFAULT_SCREENSHOT_SAVE_LOCATION = "screenshot/";
	public static final String FILE_EXTENSION = ".jpg";
	private static final String DEFAULT_CONFIG_PROPERTIES_LOCATION = "src/main/resources/config.properties";
	private static final String DEFAULT_CONFIG_SAVE_LOCATION = "src/main/resources/saved.properties";

	public static Properties evalProperties() throws IOException {
		return evalProperties(DEFAULT_CONFIG_PROPERTIES_LOCATION);
	}

	public static Properties evalProperties(String fileLocation) throws IOException {
		// Create properties
		Properties props = new Properties();
		// Create a File with passed fileLocation details
		File file = new File("src/main/resources/config.properties");
		// Create a FileInputStream based File object
		FileInputStream fis = new FileInputStream(file);
		// Load Properties based on FileInputStream
		props.load(fis);
		// Return loadedProperties object
		return props;
	}

	public static String evalProperty(Properties props, String propKey) {
		// Create a variable and set its value to the value of the propKey from
		// Properties file
		String value = props.getProperty(propKey);
		// Return the stored String value
		return value;
	}

	// Overload
	public static String evalProperty(String propKey) throws IOException {
		return evalProperty(DEFAULT_CONFIG_PROPERTIES_LOCATION, propKey);
	}

	public static String evalProperty(String fileLocation, String propKey) throws IOException {
		Properties props = evalProperties(fileLocation);
		String value = evalProperty(props, propKey);
		return value;
	}

	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		return elements;
	}

	public static List<WebElement> getCSSPropertyBasedElements(WebDriver driver, By locator, String prop,
			String value) {
		List<WebElement> elements = driver.findElements(locator);
		List<WebElement> matchingElements = new ArrayList<WebElement>();
		for (int i = 0; i < elements.size(); i++) {
			String elementValue = elements.get(i).getCssValue(prop);
			if (elementValue.equalsIgnoreCase(value)) {
				matchingElements.add(elements.get(i));
			}
		}
		return elements;
	}

	public static List<WebElement> getLinks(WebDriver driver) {
		List<WebElement> elements = getByTagName(driver, "a");
		return elements;
	}

	public static List<WebElement> getPictures(WebDriver driver) {
		List<WebElement> elements = getByTagName(driver, "img");
		return elements;
	}

	public static List<String> getTextContents(WebDriver driver, By locator) {
		List<WebElement> elements = driver.findElements(locator);
		List<String> elementTexts = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			String text = elements.get(i).getText();
			if (!text.equals("")) {
				elementTexts.add(text);
			}

		}
		return elementTexts;
		// *.getText()
	}

	public static boolean takeScreenshot(WebDriver driver) {
		return takeScreenshot(driver, DEFAULT_SCREENSHOT_FILENAME, DEFAULT_SCREENSHOT_SAVE_LOCATION, null);
	}

	public static boolean takeScreenshot(WebDriver driver, String location, String filename) {
		return takeScreenshot(driver, location, filename, null);
	}

	public static boolean takeScreenshot(WebDriver driver, String location, String filename, Logger logger) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(location + filename + FILE_EXTENSION));
		} catch (IOException e) {
			if (logger != null) {
				logger.error("failed to save screenshot at " + location + filename + FILE_EXTENSION);
			}
			return false;
		}
		return true;
	}

	public static boolean writeProperties(Properties props, String key, String value) {
		return writeProperties(props, DEFAULT_CONFIG_SAVE_LOCATION, key, value);
	}

	public static boolean writeProperties(Properties props, String fileLocation, String key, String value) {
		props.setProperty(key, value);
		try {
			File saveFile = new File(fileLocation);
			FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
			props.store(fileOutputStream, "Saved Config Details");
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
