package com.basics.seljava;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 * Actions, dropdowns, Alerts, Waits, window handlings, broken Links, iframes, log4j
 * All verification commands
 * All validation commands
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class scrap {
	
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
//		selectlass();
//		Alerts();
		WindowHandles2();
			
	}
	public static void selectlass() throws Exception{
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement We = driver.findElement(By.xpath("//*[@name='continents']"));
		System.out.println("**************Select***************");
		Select s1 = new Select(We);
		s1.selectByVisibleText("Australia");
		List<WebElement> l1 = s1.getOptions();
		for (WebElement dds : l1) {
			System.out.println(dds.getText());
		}
		System.out.println("****" +s1.getFirstSelectedOption().getText());
		
	}
	public static void Alerts() throws Exception{
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("**************Alerts***************");
		driver.findElement(By.xpath("//*[@name='submit']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	public static void WindowHandles() throws Exception{
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("**************Window_Handlings***************");
		driver.findElement(By.xpath("//*[@id='newTabsBtn']")).click();
		String ParentWindow = driver.getWindowHandle();
		System.out.println("__Parent Window:" + ParentWindow);
		Set<String> AllHandles = driver.getWindowHandles();
		for (String AllWinds : AllHandles) {
			System.out.println(AllWinds); 
		}
	}
	public static void WindowHandles2() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.xpath("//*[@id='newTabsBtn']")).click();
		
		Set<String> jingidi=driver.getWindowHandles();
		Iterator<String> dingidi = jingidi.iterator();
		
		String parentWindowID = dingidi.next();
		System.out.println(parentWindowID);
		
		String childWindowID = dingidi.next();
		System.out.println(childWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());
		Thread.sleep(100000);
		driver.close();
	}
}
