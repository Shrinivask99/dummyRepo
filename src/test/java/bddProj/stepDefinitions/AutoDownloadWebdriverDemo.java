package bddProj.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoDownloadWebdriverDemo {

	@Test
	public void method() {
		//https://chromedriver.chromium.org/downloads
		
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * chromeOptions.addArguments("--whitelist-ip *");
		 * chromeOptions.addArguments("--proxy-server='direct://'");
		 * chromeOptions.addArguments("--proxy-bypass-list=*");
		 */
		
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().driverVersion("100.0.4896.20").setup();
//		WebDriverManager.chromedriver().browserVersion("100.0.4896.20").setup();
		WebDriverManager.chromedriver().clearDriverCache();
		//WebDriverManager.chromedriver().driverVersion("101.0.4951.15").setup();
		WebDriverManager.chromedriver().driverVersion("100.0.4896.20").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
