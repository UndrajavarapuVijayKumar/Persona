package JPac;

import org.openqa.selenium.WebElement;

public class Jmains {

	public static void main(String[] args) {
		
		String s1 = m2();
		System.out.println(s1);
		
//		Jmains j1 = new Jmains();
//		j1.m2();
	}
	public static void m1() {
		System.out.println("m1 method: no need to creating object bcos we declared it as a static method!");
	}
	public static  String m2() {
		System.out.println("m2");
		String element = "vjns";
		return element;
	}

}
