package com.VTiger.GenericLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.VTiger.ObjectResposetaryLibrary.Home;
import com.VTiger.ObjectResposetaryLibrary.Login;
/**
 *Used to perform common operations like open browser,login,logout&close the browser 
 * @author Subha 
 */
@Listeners(com.VTiger.GenericLibrary.LisImpClass.class)
public class BaseClass {
	

	public static WebDriver driver;
	/*Create object of FileLib*/
	public FileLib flb=new FileLib();
	
	/**
	 * Used To open Browser
	 * @throws Throwable
	 */
	
	@BeforeClass
	public void lunchBroser() throws Throwable
	{
		
		
String BROWSER=flb.getPropertyValue("browser");
		
		/*Open the given browser*/
         
      
      if(BROWSER .equals("firefox")) {
    	      	  driver=new FirefoxDriver();}
      else if(BROWSER.equals("chrome"))
      {
    	  System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();}
		else if(BROWSER.equals("ie"))
			driver=new InternetExplorerDriver();
		else
			driver=new ChromeDriver();
      
		CommonUtils.implicitelyWait();
	}
		
	
	
	/**
	 * used to login in to the application
	 * @throws Throwable
	 */
@BeforeMethod
public void login() throws Throwable
{
	CommonUtils.implicitelyWait();//Implicitly Wait
	
	/*Create object of FileLib*/
	FileLib flib=new FileLib();
	/*Fetch the data from Property file*/
	String URL=flib.getPropertyValue("url");
	String USERNAME=flib.getPropertyValue("username");
	String PASSWORD=flib.getPropertyValue("password");
	
	/*Put url*/
	driver.get(URL);
	
	 /*Login validation*/
		String exptPage=("vtiger CRM 5 - Commercial Open Source CRM");
			String actPage=driver.getTitle();
			Assert.assertEquals(exptPage, actPage);
			Reporter.log("Login Validation Successfully", true);
			
	/*Login to app by using pagefactory Login class*/
	Login lp=PageFactory.initElements(driver, Login.class);
	lp.loginToApp(USERNAME, PASSWORD);
	
	CommonUtils.implicitelyWait();

	
	
	
}



/**
 * Logout the app
 * @Subha
 * @throws InterruptedException
 */

@AfterMethod
public void logoutAM() throws InterruptedException{
	 
	 /*Explicitly wait used for administartor logo*/
	Home home=PageFactory.initElements(driver, Home.class);
	
	CommonUtils.explicitlyWait(home.getAdministratorLogo());
	
	/*Move to element to administartor logo*/
	CommonUtils.action(home.getAdministratorLogo());
	Reporter.log("Move to administrator logo", true);
   
	
	
	/*Explicitlywait used for  logout*/
	CommonUtils.explicitlyWait(home.getSignOut());
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a [text()='Sign Out']")));
	
	/*Click on logout*/
	home.logOutToApp();
	Reporter.log("Logout succesfully", true);
	//driver.findElement(By.xpath("//a [text()='Sign Out']")).click();
}



/**
 * Used to close the browser
 */
@AfterClass
public void closeBrowserAC() 
{
	
	/*Close the driver*/
	driver.close();
}
	
}


	
      


	
		


