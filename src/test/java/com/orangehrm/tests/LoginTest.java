package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.reports.ExtentReportUtil;
import com.orangehrm.utilities.Log;
import com.orangehrm.utilities.PropertyUtil;

public class LoginTest extends BaseTest {

	LoginPage loginPage;

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() throws InterruptedException {

		loginPage = new LoginPage(getDriver());
		// loginPage.login(PropertyUtil.readProperty("userName"),PropertyUtil.readProperty("password"));
		// loginPage.login(PropertyUtil.readProperty("userName"),PropertyUtil.readProperty("password"));
		loginPage.login("Admin", "admin123");
		
		
		String actualMsg = loginPage.getWelComeMsg(getDriver());
		Assert.assertEquals(actualMsg, "Welcome Admin", "Verify Welcome Message");
		ExtentReportUtil.logStep(Status.INFO, "Successfully logged into the application");

	}

	@Test(priority = 2)
	public void getHomePageTitleTest() {
		login();
		String title = loginPage.getHomePageTitle(getDriver()); // due to inheritance we can call getDriver() method directly
																 
		Assert.assertEquals(title, "OrangeHRM");
		Log.info("Home page title is :" + title);
		ExtentReportUtil.logStep(Status.INFO, "HomePage title verified");
	}

	@Test(priority = 3)
	public void logoImageTest() {
		login(); //due to inheritance we can directly call method from baseTest class. else we have to use obj.method() for nonstatic methods.
		boolean flag = loginPage.validateLogoImage();
		// loginPage.login(Property);
		Assert.assertTrue(flag);
		Log.info("Logo is getting displayed");
		ExtentReportUtil.logStep(Status.INFO, "Logo is displaying properly");
	}
}
