package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.EmployeelistPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.Log;
import com.orangehrm.utilities.PropertyUtil;

public class AddEmployeeTest extends BaseTest {



	@Test
	
	public void verifyAddEmployee() throws InterruptedException {
	LoginPage loginpage= new LoginPage(getDriver());
	loginpage.login("Admin","admin123");
	//loginpage.login(PropertyUtil.readProperty("userName"), PropertyUtil.readProperty("password"));
	//ExtentReportUtil.logStep(Status.INFO, "Successfully logged in to the Application");
	AddEmployeePage addemployeepage= new AddEmployeePage(getDriver());
	addemployeepage.navigateToPim(getDriver());
	Thread.sleep(3000);
	addemployeepage.navigateToAddEmployee(getDriver());
	//addemployeepage.navigateToAddEmployee(getDriver());
	Thread.sleep(3000);
	String expectedID=addemployeepage.addEmployeeDetails("Monalisa", "Mama");
	EmployeelistPage employeelistpage= new EmployeelistPage(getDriver());
	Thread.sleep(3000);
	employeelistpage.navigateToEmployeeList();
	String actualEmpId = employeelistpage.getEmpRecord(expectedID);
	Assert.assertEquals(actualEmpId, expectedID);
	Log.info("Emplyoee added successfully and verified successfully");
}
}