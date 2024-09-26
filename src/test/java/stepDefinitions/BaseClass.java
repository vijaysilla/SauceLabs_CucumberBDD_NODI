package stepDefinitions;

import org.openqa.selenium.WebDriver;

import managers.WebDriverManager;

public class BaseClass 
{
	WebDriver driver;
	
	public BaseClass()
	{
		this.driver = WebDriverManager.getInstance().getWebDriver();
	}
}
