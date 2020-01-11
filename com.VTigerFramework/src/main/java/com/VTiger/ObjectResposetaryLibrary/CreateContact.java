package com.VTiger.ObjectResposetaryLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContact {
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input [@type='radio' and @value='U']")
	private WebElement radioUser;
	
	@FindBy(xpath="//input [@type='radio' and @value='U']")
	private WebElement radioGroup;
	
	@FindBy(name="salutationtype")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInfoText;

	/*getters methods*/
	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getRadioUser() {
		return radioUser;
	}

	public WebElement getRadioGroup() {
		return radioGroup;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getContactInfoText() {
		return contactInfoText;
	}
	
	

	
	

}
