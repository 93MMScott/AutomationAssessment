package com.qa.fridaytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_POM {
	@FindBy(id="j_username")
	private WebElement usernameInput;

	@FindBy(xpath="/html/body/div/div/form/div[2]/input")
	private WebElement passwordInput;
	
	@FindBy(xpath="/html/body/div/div/form/div[3]/input")
	private WebElement loginButton;
	
	public void enterAdminUsername(String name)
	{
		usernameInput.sendKeys(name);
	}
	
	public void enterAdminPassword(String password)
	{
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
}
