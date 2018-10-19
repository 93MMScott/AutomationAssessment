package com.qa.fridaytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserList_POM {
	@FindBy(xpath="//*[@id=\"people\"]/tbody")
	private WebElement UserList;
	
	public boolean findUsernameExist(WebDriver driver, String username)
	{
		try
		{
			new WebDriverWait(driver, 8).until(ExpectedConditions.presenceOfElementLocated(By.linkText(username)));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public void userCleanup(WebDriver driver, String username)
	{
		WebElement deleteButton = driver.findElement(By.linkText("user/" +username+ "/delete/"));
		
//		for(int i = 0; i < deleteButton.size(); i++)
//		{
//			if(array.get(i).href.equals("user/" +username+ "/delete"))
//			{
//				deleteButton = array[i];
//				break;
//			}
//		}
//		if(deleteButton == null)
//		{
//			return;
//		}
//		else
//		{
//			deleteButton.click();
//		}
		deleteButton.click();
	}
}