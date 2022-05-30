package bddProj.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginDefinition {
	 
    WebDriver driver;
 
    @SuppressWarnings("deprecation")
	@Before
    public void setUp() {
    	//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver_100.exe"); 
		//WebDriverManager.chromedriver().setup();
		
    	System.out.println(WebDriverManager.chromedriver().getDriverVersions());
    	
    	WebDriverManager.chromedriver().clearDriverCache();
    	WebDriverManager.chromedriver().driverVersion("102.0.5005.27").setup();
    	driver=new ChromeDriver();
 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
 
    @Given("User is on Home page")
    public void userOnHomePage() {
 
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @When("User enters username as {string}")
    public void entersUsername(String userName) throws InterruptedException {
 
        System.out.println("Username Entered");
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
 
    }
 
    @When("User enters password as {string}")
    public void entersPassword(String passWord) throws InterruptedException {
 
        System.out.println("Password Entered");
        driver.findElement(By.name("txtPassword")).sendKeys(passWord);
 
        driver.findElement(By.id("btnLogin")).submit();
    }
 
    @Then("User should be able to login sucessfully")
    public void sucessfullLogin() throws InterruptedException {
 
        String newPageText = driver.findElement(By.id("welcome")).getText();
        System.out.println("newPageText :" + newPageText);
        assertThat(newPageText, containsString("Welcome"));
 
    }
 
    @After
    public void teardown() {
 
        driver.quit();
    }
 
}
