package com.orangehrm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.utilities.Log;

public class DeleteEmployee {

	
		
		@FindBy(xpath="//table[@id=\"resultTable\"]/tbody/tr/td[2]")
		private WebElement webTableColumnForId;
		
		@FindBy(xpath="//input[@id=\"ohrmList_chkSelectAll\"]")
		private WebElement webTableColumnForChkBox;
		
		@FindBy(xpath="//input[@id=\"empsearch_id\"]")
		private WebElement txtEmpId; // in employee details pageindBy
		
		@FindBy(id = "menu_pim_viewEmployeeList")
		private WebElement linkEmployeeList; // employeelist page link

		@FindBy(xpath = "//input[@id='empsearch_id']")
		private WebElement txtEmpIdForSearch; // in employeelist page

		@FindBy(id = "searchBtn")
		private WebElement btnSearch; // in employeelist page

		@FindBy(id = "dialogDeleteBtn")
		private WebElement btnOkDialogueDelete; // in employeelist page

		@FindBy(id = "btnDelete")
		private WebElement btnDelete; // in employeelist page
		
		public DeleteEmployee(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		
		public void search(String empId,WebDriver driver) {
			
			linkEmployeeList.click();
			Log.info("Emplyoee id is" +empId);
			
			
			WebDriverWait wait= new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(txtEmpIdForSearch ));
			
			txtEmpIdForSearch.clear();
			
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value=" + empId + "';", txtEmpIdForSearch);//to input the value in search field
			
			js.executeScript("arguments[0].click(),", btnSearch); //click on a button
			
				}
		
		public boolean verifyEmployee(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.visibilityOf(webTableColumnForId));
			String id_WebTable = webTableColumnForId.getText();
			if (txtEmpIdForSearch.getText() == id_WebTable) {
				Log.info("Record Found and matched");
			} else {
				Log.warn("data mismatched");
			}
			return true;

		}
		
		public void deleteEmployee(WebDriver driver) {
			if (verifyEmployee(driver)) {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				webTableColumnForChkBox = wait.until(ExpectedConditions.visibilityOf(webTableColumnForChkBox));
				webTableColumnForChkBox.click();
				btnDelete.click();
				btnOkDialogueDelete.click();
				Log.info("data Deleted Successfully");
			}
		}
	}	


