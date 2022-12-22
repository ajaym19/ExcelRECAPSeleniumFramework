package com.excelr.pages;

import org.openqa.selenium.By;

import com.excelr.base.OHRMBase;

public class DashboardPage extends OHRMBase {

	public boolean dashboardLeftMenu() {
		captureScreenshot("dashboardLeftMenu");
		return driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
	}
	
	public boolean quickLaunchSection() {
		return driver.findElement(By.xpath("//p[text()='Quick Launch']")).isDisplayed();
	}
	
	public boolean myActionSection() {
		return driver.findElement(By.xpath("//p[text()='My Actions']")).isDisplayed();
	}
}
