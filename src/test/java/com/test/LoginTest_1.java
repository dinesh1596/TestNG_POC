package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

public class LoginTest_1 extends BaseClass {
	@Test(dataProvider = "credentials")
	public void login(String user,String pass) throws FileNotFoundException, IOException, InterruptedException {
		getDriver(getPropertyFileValue("browser"));
		enterURL(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWaits(10);
		PageObjectManager  pom = new PageObjectManager();
		elementSendkeys(pom.getLoginPage().getTxtusername(), user);
		elementSendkeys(pom.getLoginPage().getTxtpassword(), pass);
		Thread.sleep(5000);
		elementClick(pom.getLoginPage().getBtnLogin());
		quit();
	}
	@DataProvider(name="credentials")
	public Object[][] data(){
		return new  Object[][] {
			{"Shanmathi22","AM29JB"},
			{"Shanmathi22","AM2"},
			{"Shanma","AM29JB"},
			{"Shanma","AM2"}
			
		};

}
}
