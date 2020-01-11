package com.VTiger.ObjectResposetaryLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	@FindBy(xpath="//img[src='themes/softed/images/user.PNG']")
	private WebElement administratorLogo;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement homeLogo;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactButtonClick;

	
	
	/*Getters method*/
	
	
	public WebElement getAdministratorLogo() {
		return administratorLogo;
	}



	public WebElement getSignOut() {
		return signOut;
	}
	
	


public WebElement getHomeLogo() {
		return homeLogo;
	}





	public WebElement getContactButtonClick() {
	return contactButtonClick;
}

/*Contact Button Click*/
	public void clickContact()
	{
		contactButtonClick.click();
	}
	
	

	/*Logout app*/
	public void logOutToApp()
	{
		signOut.click();
	}



	




}
