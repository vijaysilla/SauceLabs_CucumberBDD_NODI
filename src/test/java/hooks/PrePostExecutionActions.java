package hooks;

import io.cucumber.java.*;
import managers.WebDriverManager;
import utilities.GenericActions;
import utilities.Log4jLoggers;


public class PrePostExecutionActions 
{	
	@Before
	public void preExecutionSetup(Scenario scenario)
	{
		Log4jLoggers.getLogInstance().startTestCase(scenario.getName());
	}
	
	@After(order=1)
	public void evidenceCapture(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			GenericActions.CaptureScreenShot(WebDriverManager.getInstance().getWebDriver(), scenario.getName(), scenario);
			Log4jLoggers.getLogInstance().info(scenario.getName()+" - failed and captured screen shot at screenshots folder");
		}		
	}
	
	@After(order=0)
	public void tearDown()
	{
		if (WebDriverManager.getInstance().getWebDriver() != null)
			WebDriverManager.getInstance().getWebDriver().close();
	}
	
}
