package com.basics.seljava;

import org.openqa.selenium.By;

public class SadBasics extends BaseTest {

	public static void main(String[] args) throws Exception {
		init();
		launchBrowser();
		NavigateURL();		
//		ClickElement("register_xpath");
//		TypeText("firstname_id", "vijayKumar");
//		TypeText("lastname_id", "undrajavarapu");
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Register')]")).getLocation());
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Register')]")).isDisplayed());
		sleep(3000);
		ClickElement("register_xpath");
		System.out.println(driver.getCurrentUrl());
	}

}
