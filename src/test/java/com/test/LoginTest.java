package com.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

public class LoginTest extends BaseClass{
	
	@Parameters({"username","password"})
	@Test(priority = 0)
	public void loginWithValidUsernameAndPassword(String user, String pass) throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtusername(), user);
		elementSendkeys(pom.getLoginPage().getTxtpassword(), pass);
		elementClick(pom.getLoginPage().getBtnLogin());
		String text = elementGetAttributeValue(pom.getLoginPage().getTxtWelcomeMsg());
	    Assert.assertEquals(text,"Hello Shanmathi22!","Verify login success message ");
		quit();
	}
	@Parameters({"username1","password1"})
	@Test(priority = 1)
	public void loginWithInValidUsernameAndPassword(String user1, String pass1) throws FileNotFoundException, IOException, AWTException, InterruptedException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtusername(), user1);
	    elementSendkeys(pom.getLoginPage().getTxtpassword(), pass1);
	    elementClick(pom.getLoginPage().getBtnLogin());
		String text = getText(pom.getLoginPage().getTxtloginerrormsg());
	    Assert.assertEquals(text,"Invalid Login details or Your Password might have expired. Click here to reset your password","verifying login error message");
		quit();
	}
	@Parameters({"username2","password2"})
	@Test(priority = 2)
	public void loginWithValidUsernameAndInvalidPassword(String user2, String pass2) throws FileNotFoundException, IOException, AWTException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtusername(), user2);
		elementSendkeys(pom.getLoginPage().getTxtpassword(), pass2);
		elementClick(pom.getLoginPage().getBtnLogin());
		String text = getText(pom.getLoginPage().getTxtloginerrormsg());
	    Assert.assertEquals(text,"Invalid Login details or Your Password might have expired. Click here to reset your password","verifying login error message");
		quit();
	}
	@Parameters({"username3","password3"})
	@Test(priority = 3)
	public void loginWithInValidUsernameAndInvalidPassword(String user3, String pass3) throws FileNotFoundException, IOException, AWTException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtusername(), user3);
		elementSendkeys(pom.getLoginPage().getTxtpassword(), pass3);
		elementClick(pom.getLoginPage().getBtnLogin());
		String text = getText(pom.getLoginPage().getTxtloginerrormsg());
	    Assert.assertEquals(text,"Invalid Login details or Your Password might have expired. Click here to reset your password","verifying login error message");
		quit();
	}
	@Test(priority = 4)
	public void withOutUsernameAndPassword() throws FileNotFoundException, IOException, AWTException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementClick(pom.getLoginPage().getBtnLogin());
		String text = getText(pom.getLoginPage().getUsernameErrorMsg());
	    Assert.assertEquals(text,"Enter Username","verifying username error message");
		quit();
	}
	@Parameters({"username4"})
	@Test(priority = 5)
	public void clickingLoginButtonWithoutPassword(String user4) throws FileNotFoundException, IOException, AWTException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtusername(), user4);
		elementClick(pom.getLoginPage().getBtnLogin());
		String text = getText(pom.getLoginPage().getPasswordErrorMsg());
	    Assert.assertEquals(text,"Enter Password","verifying password error message");
		quit();
	}
	@Parameters({"password4"})
	@Test(priority = 6)
	public void clickingLoginButtonWithoutUsername(String pass4) throws FileNotFoundException, IOException, AWTException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtpassword(), pass4);
		elementClick(pom.getLoginPage().getBtnLogin());
		String text = getText(pom.getLoginPage().getUsernameErrorMsg());
	    Assert.assertEquals(text,"Enter Username","verifying password error message");
		quit();
	}
	
	

}
