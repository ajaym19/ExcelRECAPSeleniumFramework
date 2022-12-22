package com.excelr.pages;

import org.openqa.selenium.By;

import com.excelr.base.OHRMBase;

public class LoginPage extends OHRMBase {

	public String getTitle() {
		return driver.getTitle();
	}

	public DashboardPage login() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		captureScreenshot("login");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new DashboardPage();
	}
}
