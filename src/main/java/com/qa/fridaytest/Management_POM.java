package com.qa.fridaytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Management_POM {
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div[15]/a")
	private WebElement manageUsersButton;
	
	public void clickManageUsers() {
		manageUsersButton.click();
	}
}
