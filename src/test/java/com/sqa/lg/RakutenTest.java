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

import org.testng.annotations.*;

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
@Test(groups = { "rakuten-tests" })
public class RakutenTest extends BasicAutoTest {

	/**
	 * @param baseURL
	 */
	public RakutenTest() {

		super("http://rakuten.com");

	}

	@Test()
	public void testRakuten() throws InterruptedException {

		Thread.sleep(1000);
	}

}
