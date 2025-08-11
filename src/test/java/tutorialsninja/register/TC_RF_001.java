package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public void verifyRegisterWithMandatoryFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");

		//xpath of My account button - //span[text()='My Account']
		WebElement myAccountBtn = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountBtn.click();


		//xpath of Register button - //a[text()='Register'] or //a[contains(text(),'Register')] or use the locator linktext like below example
		WebElement registerBtn = driver.findElement(By.linkText("Register"));
		registerBtn.click();

		//xpath of all details 
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("John");	

		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Doe");

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys(generateDynamicEmail());
		
		WebElement telephone = driver.findElement(By.cssSelector("#input-telephone"));
		telephone.sendKeys("1234567890");	

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("password123");		

		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys("password123");		

		//xpath of Privacy Policy checkbox - //input[@name='agree'] - added @ because name is an attribute (or) //input[contains(@name,'agree')] (or) //input[@type='checkbox'] (or) //input[@type='checkbox' and @name='agree']
		WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));
		privacyPolicyCheckbox.click();	
		
		//xpath of Continue button - //input[@value='Continue'] (or) //input[contains(@value,'Continue')]
		WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueBtn.click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "user is not looged in successfully");
		
		String expectedHeading = "Your Account Has Been Created!";
		String actualHeading = driver.findElement(By.xpath("//div/h1[contains(text(),'Created!')]")).getText();
		Assert.assertEquals(actualHeading, expectedHeading);

		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[2]/a[contains(text(),'Account')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'My Account')]")).isDisplayed(), "My Account page is not displayed");
		
		driver.quit();
	}

	public static String generateDynamicEmail(){
    return new Date().toString().replace(" ","").replace(":","")+"@gmail.com"; //create date object using new Date() , convert date to string & replace all spaces with empty string & replace all ":" to empty string & append to email domain  
	}
}
