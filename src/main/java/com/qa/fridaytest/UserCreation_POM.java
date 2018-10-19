package com.qa.fridaytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCreation_POM {
	@FindBy(id="username")
	private WebElement usernameInput;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordInput;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPasswordInput;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullNameInput;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement emailInput;
	
	@FindBy(id="yui-gen2-button")
	private WebElement submitButton;
			
	public void enterUsername(String name)
	{
		usernameInput.sendKeys(name);
	}
	
	public void enterPassword(String pass)
	{
		passwordInput.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String pass)
	{
		confirmPasswordInput.sendKeys(pass);
	}
	
	public void enterFullName(String fullName)
	{
		fullNameInput.sendKeys(fullName);
	}
	
	public void enterEmail(String e)
	{
		emailInput.sendKeys(e);
	}
	
	public void submitForm()
	{
		submitButton.click();
	}
}
