package com.cg.forms_excel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Register1Page {
	@FindBy(how = How.ID, using = "firstname")
	WebElement firstname;
	
	@FindBy(how = How.ID, using = "lastname")
	WebElement lastname;
	
	@FindBy(how = How.ID, using = "email")
	WebElement email;
	
	@FindBy(how = How.ID, using = "submit")
	WebElement submit;
}
