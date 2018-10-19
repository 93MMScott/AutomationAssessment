package com.qa.fridaytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagement_POM {
	@FindBy(xpath="//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserButton;
	
	public void clickCreateUserButton() {
		createUserButton.click();
	}
	
}
