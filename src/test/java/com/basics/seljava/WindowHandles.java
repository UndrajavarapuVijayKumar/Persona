package com.basics.seljava;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.xpath("//*[@id='newTabsBtn']")).click();
	
		Set<String>set = driver.getWindowHandles();
		Iterator<String> i1 = set.iterator();
		
		String Parent = i1.next();
		System.out.println("Parent Window:" +Parent +"*******"+ driver.getTitle() );
		
		String child1 = i1.next();
		System.out.println("Child1___:"+child1);
		driver.switchTo().window(child1);
		System.out.println(driver.getTitle());
		
		String child2 = i1.next();
		System.out.println("CHild__2  :" + child2);
		driver.switchTo().window(child2);
		System.out.println(driver.getTitle());
	}
}
