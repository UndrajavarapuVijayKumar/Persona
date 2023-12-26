package com.basics.seljava;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentHtmlReporter htmlrReport;
	public static ExtentReports report;
	
	public static ExtentReports getInstance() {
		if(htmlrReport==null) {
			htmlrReport=	new ExtentHtmlReporter("C:\\Users\\lenovo\\eclipse-workspace\\OctsBasics\\src\\test\\resources\\report.html");
			htmlrReport.config().setDocumentTitle("Automation Report");
			htmlrReport.config().setReportName("Functional Report");
			htmlrReport.config().setTheme(Theme.DARK);
			
			report = new ExtentReports();
			report.attachReporter(htmlrReport);
			report.setSystemInfo("OS", "Windows11");
			report.setSystemInfo("TesterName","Vijay");
			report.setSystemInfo("Browser", "chrome");
		}
		return report;
	}
	
}
