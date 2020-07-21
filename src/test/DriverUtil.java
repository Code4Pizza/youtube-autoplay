package test;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {

	private static WebDriver driver;

	public static WebDriver getInstance() {
		if (driver == null) {
			driver = initChrome();
		}
		return driver;
	}

	public static WebDriver initChrome() {
		System.setProperty("webdriver.chrome.driver", "/Users/theanh/Downloads/chromedriver75");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		return new ChromeDriver(options);
	}

	public static WebDriver initFirefox() {
		System.setProperty("webdriver.gecko.driver", "/Users/theanh/Downloads/geckodriver");
		return new FirefoxDriver();
	}

	public static void close() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		if (driver != null) {
			driver.close();
		}
	}

}
