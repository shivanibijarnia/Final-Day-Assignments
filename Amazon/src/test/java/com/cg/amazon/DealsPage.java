package com.cg.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DealsPage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"dealImage\"]")
	WebElement deal1;
	
	@FindBy(how = How.ID, using = "add-to-cart-button")
	WebElement add;
	
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	WebElement input;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"result_2\"]/div/div[3]/div[1]/a")
	WebElement deal2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"result_0\"]/div/div/div/div[2]/div[2]/div[1]/a/h2")
	WebElement deal3;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"nav-cart-count\"]")
	WebElement cart;
	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
	WebElement proceed;
	
}
