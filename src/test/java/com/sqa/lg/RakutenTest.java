/**
 *   File Name: RakutenTest.java<br>
 *
 *   Green, Lorne<br>
 *   Java <br>
 *   <br>
 *   Created: Nov 10, 2016
 *
 */

package com.sqa.lg;

import java.io.*;
import java.util.*;

import org.testng.annotations.*;

import com.sqa.lg.helpers.*;

/**
 * RakutenTest //ADDD (description of class)
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

public class RakutenTest extends BasicAutoTest {

	/**
	 * @throws FileNotFoundExceptio
	 * @throws IOException
	 */
	private static String evalBaseURL() throws FileNotFoundException, IOException {
		String env = AutoBasics.evalProperty("env");
		if (env.equalsIgnoreCase("pro")) {
			return AutoBasics.evalProperty("pro.url");
		} else {
			return AutoBasics.evalProperty("dev.url");
		}
	}

	/**
	 * @param baseURL
	 * @throws IOException
	 */
	public RakutenTest() throws IOException {
		super(evalBaseURL());
	}

	@Test(enabled = false)
	public void testRakutenRead() throws InterruptedException, IOException {
		// Create properties
		Properties props = new Properties();
		// Create a File with passed fileLocation details
		File file = new File("src/main/resources/config.properties");
		// Create a FileInputStream based File object
		FileInputStream fis = new FileInputStream(file);
		// Load Properties based on FileInputStream
		props.load(fis);
		// Logged info from properties file
		getLog().info("username is " + props.getProperty("username"));
		getLog().info("password is " + props.getProperty("password"));
		getLog().info("dev baseURL is " + props.getProperty("dev.url"));
		getLog().info("pro baseURL is " + props.getProperty("pro.url"));

	}

	@Test(enabled = true)
	public void testRakutentWrite() throws InterruptedException, IOException {

		// // Create properties Object Properties props = new Properties();
		// // Create a File with passed fileLocation details
		// File file = new File("src/main/resources/config.properties");
		// // Create a FileInputStream based File object
		// FileInputStream fileInputStream = new FileInputStream(file);
		// // Logged info from properties file
		// props.load(fileInputStream);
		// // Set an New Property name projectStatus to "passed"
		// props.setProperty("projectStatus", "PASSED");
		// // Write the new Properties file to file location
		// File saveFile = new File("src/main/resources/saved.properties");
		// // src/main/resources/saved.properties
		// FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
		// props.store(fileOutputStream, "Saved Config Details");

		Properties props = AutoBasics.evalProperties();
		AutoBasics.writeProperties(props, "projectStatus", "FAILED");
	}

}
