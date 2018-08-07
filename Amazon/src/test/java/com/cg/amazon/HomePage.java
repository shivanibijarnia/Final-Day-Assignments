package com.cg.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	@FindBy(how = How.LINK_TEXT, using = "See all deals")
	WebElement seeAll;
}
