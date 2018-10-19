package com.qa.fridaytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Config_POM {
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement fullNameInput;
	
	@FindBy(xpath="//*[@id=\"yui-gen3-button\"]")
	private WebElement submitForm;
	
	public void inputFullName(String name)
	{
		fullNameInput.clear();
		fullNameInput.sendKeys(name);
	}
	
	public void submitForm()
	{
		submitForm.click();
	}
}
