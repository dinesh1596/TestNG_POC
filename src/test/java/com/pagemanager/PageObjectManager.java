package com.pagemanager;

import com.pages.LoginPage;


public class PageObjectManager {
	private  LoginPage loginPage;
	

	public LoginPage getLoginPage() {
		return (loginPage==null)?loginPage=new LoginPage():loginPage;
	}
	

}
