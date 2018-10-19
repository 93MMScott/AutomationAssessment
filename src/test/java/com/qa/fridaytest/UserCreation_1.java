package com.qa.fridaytest;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UserCreation_1 {
	public static WebDriver driver = null;
	static ExtentReports report = new ExtentReports("src\\reports\\jenkees.html",true);
	ExtentTest test;	
	public String username = "newUser";
	public static int count;

///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// TASK 1
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();

		test = report.startTest("Task 1 ("+count+")");
		LoginPage_POM login = PageFactory.initElements(driver, LoginPage_POM.class);
		test.log(LogStatus.INFO, "Navigating to http://localhost:8080/ ..");
		driver.get("http://localhost:8080/");
		
		test.log(LogStatus.INFO, "Entering admin login details..");
		try{ login.enterAdminUsername("admin");
		login.enterAdminPassword("7e5f4b02ffce46e9bec402ac690b6568");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Failed to login (data input).");
			fail();
		}
		
		test.log(LogStatus.INFO, "Logging in..");
		try{ 
			login.clickLogin();
		} catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to login (button click).");
			fail();
		}
		
		// Home Page
		LandingPage_POM homePage = PageFactory.initElements(driver, LandingPage_POM.class);
		
		test.log(LogStatus.INFO, "Navigating to user management page..");
		try {
			homePage.navToManagePage();
		} catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to management page.");
			fail();
		}
		
		// Management Page
		Management_POM managePage = PageFactory.initElements(driver, Management_POM.class);
		
		test.log(LogStatus.INFO, "Navigating to user management page..");
		try { 
			managePage.clickManageUsers();
		} catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to user management page.");
			fail();
		}
		
		UserManagement_POM userManagePage = PageFactory.initElements(driver, UserManagement_POM.class);
		test.log(LogStatus.INFO, "Navigating to user creation page..");
		try { 
			userManagePage.clickCreateUserButton();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to user creation page.");
			fail(); 
		}
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
				
		UserCreation_POM userCreatePage = PageFactory.initElements(driver, UserCreation_POM.class);
		
		test.log(LogStatus.INFO, "Entering a new user's details..");
		try { userCreatePage.enterUsername("newUser"); } 
		catch(Exception e) { test.log(LogStatus.FAIL, "Failed to enter username."); fail(); }

		try { userCreatePage.enterPassword("elephant"); } 
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter password."); fail(); }

		try { userCreatePage.enterConfirmPassword("elephant"); }
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter confirmed password."); fail(); }

		try { userCreatePage.enterFullName("Jim Jones"); }
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter full name."); fail(); }

		try { userCreatePage.enterEmail("help@creativity.com"); }
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter email."); fail(); }
		
		test.log(LogStatus.PASS, "Details entered.");
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		
		UserCreation_POM userCreatePage = PageFactory.initElements(driver, UserCreation_POM.class);
		
		test.log(LogStatus.INFO, "Submitting details..");
		try { userCreatePage.submitForm(); } 
		catch(Exception e) { test.log(LogStatus.FAIL, "Failed to submit form."); fail(); } // getting failures here?
		test.log(LogStatus.PASS, "Details submitted.");
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		// Check name is in the list
		test.log(LogStatus.INFO, "Searching for the new user in the list..");
		
		UserList_POM userListPage = PageFactory.initElements(driver, UserList_POM.class);
		if(userListPage.findUsernameExist(driver, "newUser"))
		{
			test.log(LogStatus.PASS, "New User was found in the user list.");

			//Cleanup - delete the test user
//		 	userListPage.userCleanup(driver, "newUser");
//			SecurityRealm securityPage = PageFactory.initElements(driver, SecurityRealm.class);
//			securityPage.pressConfirm();
		}
		else 
		{
			test.log(LogStatus.FAIL, "New user was not found in the user list.");
			fail();
		}
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Email and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Email_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		UserCreation_POM userCreatePage = PageFactory.initElements(driver, UserCreation_POM.class);

		test.log(LogStatus.INFO, "Entering a new user's details..");
		try { userCreatePage.enterUsername(arg1); username = arg1; } 
		catch(Exception e) { test.log(LogStatus.FAIL, "Failed to enter username."); fail(); }

		try { userCreatePage.enterPassword(arg2); } 
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter password."); fail(); }

		try { userCreatePage.enterConfirmPassword(arg3); }
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter confirmed password."); fail(); }

		try { userCreatePage.enterFullName(arg5); }
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter full name."); fail(); }

		try { userCreatePage.enterEmail(arg4); }
		catch(Exception e ) { test.log(LogStatus.FAIL, "Failed to enter email."); fail(); }
		
		test.log(LogStatus.PASS, "Details entered.");
		
		test.log(LogStatus.INFO, "Submitting details..");
		try { userCreatePage.submitForm(); } 
		catch(Exception e) { test.log(LogStatus.FAIL, "Failed to submit form."); fail(); }
		test.log(LogStatus.PASS, "Details submitted.");
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		// Check name is in the list
		test.log(LogStatus.INFO, "Searching for the new user in the list..");
		
		UserList_POM userListPage = PageFactory.initElements(driver, UserList_POM.class);
		if(userListPage.findUsernameExist(driver, username))
		{
			test.log(LogStatus.PASS, "New User was found in the user list.");
			
			// Cleanup - delete the test user
//		 	userListPage.userCleanup(driver, "newUser");
//			SecurityRealm securityPage = PageFactory.initElements(driver, SecurityRealm.class);
//			securityPage.pressConfirm();
		}
		else {
			test.log(LogStatus.FAIL, "New user was not found in the user list.");
			fail();
		}
		test.log(LogStatus.PASS, "Username visible!");
		
		if(count==3)
		{
			report.endTest(test);
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////

	// TASK 2
	WebElement userLink = null;
	
	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test = report.startTest("Task 2("+count+")");
		driver = new ChromeDriver();

		LoginPage_POM login = PageFactory.initElements(driver, LoginPage_POM.class);
		test.log(LogStatus.INFO, "Navigating to http://localhost:8080/ ..");
		driver.get("http://localhost:8080/");
		
		test.log(LogStatus.INFO, "Entering admin login details..");
		try{ login.enterAdminUsername("admin");
		login.enterAdminPassword("7e5f4b02ffce46e9bec402ac690b6568");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Failed to login (data input).");
			fail();
		}
		
		test.log(LogStatus.INFO, "Logging in..");
		try{ 
			login.clickLogin();
		} catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to login (button click).");
			fail();
		}
		
		test.log(LogStatus.INFO, "Navigating to security realm..");
		try { driver.get("http://localhost:8080/securityRealm/"); }
		catch(Exception e) { 		test.log(LogStatus.FAIL, "Could not navigate to security realm."); fail(); }
		
		test.log(LogStatus.INFO, "Checking the username is on the screen..");
		try { userLink = driver.findElement(By.linkText(arg1)); }
		catch(Exception e) { 		test.log(LogStatus.FAIL, "Could not find username on the page."); fail(); }

		test.log(LogStatus.PASS, "Username visible!");

		// This still clicks the wrong Matthew
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Clicking the user link..");
		try { userLink.click(); }
		catch(Exception e) { 		test.log(LogStatus.FAIL, "Failed to click the user link."); fail(); }
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		User_POM userPage = PageFactory.initElements(driver, User_POM.class);
	
		test.log(LogStatus.INFO, "Trying to find the username on the page..");
		try
		{
			userPage.checkUsername(driver, arg1);
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to find the username on the page."); fail();
		}
		test.log(LogStatus.PASS, "Found user!");
		
		if(count == 7)
		{
			report.endTest(test);
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////


	// TASK 3
	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {

		driver = new ChromeDriver();
		test = report.startTest("Task 3("+count+")");
		LoginPage_POM login = PageFactory.initElements(driver, LoginPage_POM.class);
		test.log(LogStatus.INFO, "Navigating to http://localhost:8080/ ..");
		driver.get("http://localhost:8080/");
		
		test.log(LogStatus.INFO, "Entering admin login details..");
		try{ login.enterAdminUsername("admin");
		login.enterAdminPassword("7e5f4b02ffce46e9bec402ac690b6568");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Failed to login (data input).");
			fail();
		}
		
		test.log(LogStatus.INFO, "Logging in..");
		try{ 
			login.clickLogin();
		} catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to login (button click).");
			fail();
		}
		
		test.log(LogStatus.INFO, "Navigating to " +arg1+ "'s profile..");
		try { driver.get("http://localhost:8080/securityRealm/user/" +arg1); }
		catch(Exception e) { 		test.log(LogStatus.FAIL, "Could not navigate to profile."); fail(); }
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		User_POM userPage = PageFactory.initElements(driver, User_POM.class);

		test.log(LogStatus.INFO, "Clicking user config button...");

		try { userPage.clickConfig(); }
		catch(Exception e) {  		test.log(LogStatus.FAIL, "Could not click config button on user profile."); fail(); }
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
		User_Config_POM userConfigPage = PageFactory.initElements(driver, User_Config_POM.class);

		test.log(LogStatus.INFO, "Inputting new full name...");
		try { userConfigPage.inputFullName(arg1); }
		catch(Exception e) {  		test.log(LogStatus.FAIL, "Could not input new full name."); fail(); }
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		User_Config_POM userConfigPage = PageFactory.initElements(driver, User_Config_POM.class);

		test.log(LogStatus.INFO, "Submitting new full name...");
		try { userConfigPage.submitForm(); }
		catch(Exception e) {  		test.log(LogStatus.FAIL, "Could not submit new full name."); fail(); }

	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		
		User_POM userPage = PageFactory.initElements(driver, User_POM.class);
		test.log(LogStatus.INFO, "Checking new full name..");

		try { userPage.checkUsername(driver, arg1); }
		catch(Exception e) {   		test.log(LogStatus.FAIL, "Could not find new full name."); fail(); }
		
		if(count==10)
		{
			report.endTest(test);
			report.close();
			report.flush();
		}
	}
	
	@After
	public void teardown() {
		count++;
		driver.close();
	}
}
