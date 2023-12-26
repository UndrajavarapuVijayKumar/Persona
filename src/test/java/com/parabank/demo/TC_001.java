package com.parabank.demo;

import java.io.IOException;

public class TC_001 extends BaseTest{
	public static void main(String[] args) throws Exception {
		init();
		launchBrowser();
		NavigateURL();
		sleep(3000);
		pageTitle();
		driver.close();
	}
}
