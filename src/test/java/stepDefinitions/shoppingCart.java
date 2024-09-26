package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SwagLabsHomePage;

public class shoppingCart extends BaseClass
{
//	public WebDriver driver;
	public LoginPage loginPage;
	public SwagLabsHomePage homePage;
	
	public shoppingCart()
	{
		super();
		loginPage = new LoginPage(driver);
	}
	@Given("Log into sauce labs application with credentials {string} and password {string}")
	public void applicationLogin(String uname, String pwd) 
	{
		loginPage.insertUserName(uname);
		loginPage.insertPassword(pwd);
		loginPage.clickLoginButton();
		System.out.println(loginPage.getErrorMessageExistence());
		if (loginPage.getErrorMessageExistence())
		{
			Assert.fail("Login failed due to wrong credentials - "+uname+" and "+pwd);
		}
	}

	@Given("User at home page or not")
	public void user_at_home_page_or_not() 
	{

	}

	@Then("validate each item in home page haveing Add to cart button")
	public void validate_each_item_in_home_page_haveing_add_to_cart_button() 
	{

	}
}
