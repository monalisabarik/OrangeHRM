package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	
	@FindBy(partialLinkText="Welcome")
	private WebElement linkWelcome;
	
	@FindBy(id="spanMessage")
	private WebElement msgLoginError;
	
	@FindBy(id="spanCopyright")
	private WebElement msgFooter;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getWelComeMsg() {
		return linkWelcome.getText();  
	}
	public String getLoginErrorMsg() {
		return msgLoginError.getText();
	}
	
	public String getFooterMsg() {
		return msgFooter.getText();
	}
}
