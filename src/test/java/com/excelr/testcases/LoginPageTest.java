package com.excelr.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excelr.base.OHRMBase;
import com.excelr.pages.DashboardPage;
import com.excelr.pages.LoginPage;

public class LoginPageTest extends OHRMBase {

	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new LoginPage();
	}

	@Test
	public void validateTitleTest() {
		String expTitle = "OrangeHRM";
		String actTitle = lp.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	@Test
	public void validateLoginTest() {
		dp = lp.login();
		Assert.assertTrue(dp.dashboardLeftMenu());
	}

	@Test(dataProvider = "Users")
	public void validateMultipleUserRole() {
	}

	@DataProvider(name = "Users")
	public void getUserData() {

	}

	@AfterMethod
	public void closeSetup() {
		tearDown();
	}

}
