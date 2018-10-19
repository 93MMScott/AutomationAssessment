package com.qa.fridaytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurityRealm {
	@FindBy(id="yui-gen2-button")
	private WebElement confirmButton;
	
	public void pressConfirm()
	{
		confirmButton.click();
	}
}
