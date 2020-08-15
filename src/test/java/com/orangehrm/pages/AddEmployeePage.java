package com.orangehrm.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.Log;

public class AddEmployeePage {
	 
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement LinkPIM;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement linkAddEmployee;
	
	@FindBy(id="firstName")
	private WebElement txtFirstName;
	
	@FindBy(id="lastName")
	private WebElement txtLastName;
	
	@FindBy(id="employeeId")
	private WebElement txtEmployeeId;
	
	@FindBy(id="btnSave")
	private WebElement btnSave;

	public AddEmployeePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToPim(WebDriver driver) {
		Actions action=new Actions(driver);
		action.moveToElement(LinkPIM).build().perform();
		Log.info("Successfully navigate to PIM");
		
	}
	
	public void navigateToAddEmployee(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(linkAddEmployee).build().perform();
	     linkAddEmployee.click();
		Log.info("Successfully navigate to Add Employee page");
	}
	
	public String addEmployeeDetails(String Fname,String Lname ) {
		
		txtFirstName.sendKeys(Fname);
		txtLastName.sendKeys(Lname);
		String expectedEmpId=txtEmployeeId.getAttribute("value");
		btnSave.click();
		Log.info("Successfully added emplyoee details");
		return expectedEmpId;
		
		
		
	}
	
	
}
