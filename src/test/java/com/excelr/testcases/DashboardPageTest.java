package com.excelr.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excelr.base.OHRMBase;
import com.excelr.pages.DashboardPage;
import com.excelr.pages.LoginPage;

public class DashboardPageTest extends OHRMBase {

	WebDriver driver;
	LoginPage lp;
	DashboardPage dp;
	
	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test
	public void validateQuickLaunchSection() {
		dp = lp.login();
		Assert.assertTrue(dp.quickLaunchSection());
	}
	
	@Test
	public void validateMyActionsSection() {
		dp = lp.login();
		Assert.assertTrue(dp.myActionSection());
	}
	
	//wrtie 4 TC's
	
	@AfterMethod
	public void closeSetup() {
		tearDown();
	}
}
