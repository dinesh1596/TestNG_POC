package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement txtAuthErrMsg;
	@FindBy(id = "username")
	private WebElement txtusername;
	@FindBy(id = "password")
	private WebElement txtpassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(id="username_show")
	private WebElement txtWelcomeMsg;
	@FindBy(xpath="//span[text()='Enter Username']")
	private WebElement usernameErrorMsg;
	@FindBy(xpath="//span[text()='Enter Password']")
	private WebElement passwordErrorMsg;
	
	public WebElement getUsernameErrorMsg() {
		return usernameErrorMsg;
	}
	public WebElement getPasswordErrorMsg() {
		return passwordErrorMsg;
	}
	public WebElement getTxtAuthErrMsg() {
		return txtAuthErrMsg;
	}
	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}
	public WebElement getTxtloginerrormsg() {
		return txtAuthErrMsg;
	}
	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}



}
