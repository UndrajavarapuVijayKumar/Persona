package com.parabank.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties p;
	public static Properties MainP;
	public static Properties ChildP;
	public static Properties OrProp;
	public static String userDirectory =  System.getProperty("user.dir");
	
	public static void init() throws IOException {
		System.out.println(System.getProperty("user.dir"));
			//data.properties
		fis = new FileInputStream(userDirectory +"\\src\\test\\resources\\data.properties");
		p = new Properties();
		p.load(fis);
		System.out.println(p.getProperty("browser"));
			//environment.properties
		fis = new FileInputStream(userDirectory + "\\src\\test\\resources\\environment.properties");
		MainP = new Properties();
		MainP.load(fis);
		String S1= MainP.getProperty("environment");
			//test.properties & uat.properties
		fis = new FileInputStream(userDirectory + "\\src\\test\\resources\\" +S1+ ".properties");
		ChildP = new Properties();
		ChildP.load(fis);
		System.out.println(ChildP.getProperty("url"));
		
		fis = new FileInputStream(userDirectory + "\\src\\test\\resources\\or.properties");
		OrProp = new Properties();
		OrProp.load(fis);
		System.out.println(OrProp.getProperty("OrProperties"));
	}
	
	//LaunchBrowser
	public static void launchBrowser() {
		if(p.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Opening Chrome Browser!");
		}else if (p.getProperty("browser").equals("firefox")) {
			driver=new FirefoxDriver();
			System.out.println("Opening Firefox Browser!");
		}else if (p.getProperty("browser").equals("edge")) {
			driver=new EdgeDriver();
			System.out.println("Opening Edge Browser!");
		}
	}
	public static void NavigateURL() {
		driver.navigate().to(ChildP.getProperty("url"));
		System.out.println("Opening Web page!");
	}
	public static void sleep(long value) throws Exception {
		Thread.sleep(value);
	}
	public static void pageTitle() {
		System.out.println(driver.getTitle());
	}
	
	
}
