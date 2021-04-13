package week5.day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public  ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void precondition(String url,String uname,String password) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}
	@AfterMethod
	public void postcondition() {
driver.close();
	}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	package week5.day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAssign extends BaseClass{

	@Test(invocationCount = 3)
	public void runCreateLead()  {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Venba");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("T");
		driver.findElement(By.name("submitButton")).click();
		
}

}
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
<parameter name="url" value="http://leaftaps.com/opentaps"></parameter>
<parameter name="username" value="DemoSalesManager"></parameter>
<parameter name="password" value="crmsfa"></parameter>
  <test thread-count="5" name="Test" verbose="5">
    <classes>
      <class name="week5.day2.CreateLeadAssign"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
