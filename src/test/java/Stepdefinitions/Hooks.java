package Stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Utilities.CommonActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonActions {

	@Before
	public void beforeScenarioChrome() {
		

		try {
			if (Get_Environment_Property("Browser").equalsIgnoreCase("chrome")) {
				Log.info("Loading chrome Driver");
				System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
				driver = new ChromeDriver();

			} else if (Get_Environment_Property("Browser").equalsIgnoreCase("firefox")) {
				Log.info("Loading Firefox Driver");
				System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (Get_Environment_Property("Browser").equalsIgnoreCase("ie")) {
				Log.info("Loading Internet Explorer Driver");
				System.setProperty("webdriver.ie.driver", ".//drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else {
				Log.info("Path of Driver Executable is not Set for any Browser");
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void aftertest(Scenario scenario) throws IOException {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName() + "_Screenshot");
		driver.close();
	}

}
