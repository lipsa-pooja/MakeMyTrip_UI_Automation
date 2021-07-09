package appHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.org.driverFactory.DriverFactory;
import com.org.util.ConfigPropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHook {
	

	ConfigPropertyReader config;
	Properties prop;
	DriverFactory driverfactory;
	WebDriver driver;
	
	@Before(order=0)
	public void setUpConfig()
	{
		config=new ConfigPropertyReader();
		 prop=config.getProperty();
	}
	@Before(order=1)
	public void setUpWebDriver()
	{
		 driverfactory=new DriverFactory();
		 driver=driverfactory.init_Driver(prop);
	}
	
	@After(order=1)
	public void captureScreenshot(Scenario sc) throws IOException
	{
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replace(" ", "_");
			 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		     sc.attach(screenshot, "image/png", screenshotName); 
		}
		
	}
	
	@After(order = 0)
	public void tearDown() {
		driver.quit();
		
	}



}
