package com.qa.fridaytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_POM {
	@FindBy(xpath="//*[@id=\"main-panel\"]/h1")
	private WebElement header;
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configButton;
	
	public boolean checkUsername(WebDriver driver, String userID)
	{
		if(header.getText().trim() == userID)
		{
			return true;
		}
		return false;
	}
	
	public void clickConfig()
	{
		configButton.click();
	}
}
