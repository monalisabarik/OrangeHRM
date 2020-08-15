package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.utilities.Log;

public class LoginPage {
	@FindBy(id="txtUsername")
	private WebElement txtboxUserName;
	
	@FindBy(id="txtPassword")
	private WebElement txtboxPassword;

	@FindBy(id="btnLogin")
	private WebElement btnLogin;
  
	@FindBy(partialLinkText="Welcome")
	private WebElement linkWelcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement linkLogout;
	
	@FindBy(id="spanMessage")
	private WebElement msgLoginError;
	
	@FindBy(id="spanCopyright")
	private WebElement msgFooter;
	
	@FindBy(xpath="//img[@src=\"/webres_5ebd1457b45137.49759927/themes/default/images/logo.png\"]")
	private WebElement Logo;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	public void login(String uName,String pwd) {
		try {
			txtboxUserName.sendKeys(uName);
			Log.info("Entered username: " +uName );
			txtboxPassword.sendKeys(pwd);
			Log.info("Entered Password: " + pwd);
			
			 
			btnLogin.click();
			Log.info("Click on Login");
		}catch(Exception e) {
			Log.error("Failed to Login:"+e.getMessage());
		}
		
	}
	
	public String getHomePageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getWelComeMsg(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(linkWelcome));
		
		return linkWelcome.getText();  
	}
	
	public void logout() {
		linkWelcome.click();
		linkLogout.click();
	}
	
	public String getLoginErrorMsg() {
		return msgLoginError.getText();
	}
	
	public String getFooterMsg() {
		return msgFooter.getText();
	}

    public boolean validateLogoImage() {
		return Logo.isDisplayed();
    	
    }
}
