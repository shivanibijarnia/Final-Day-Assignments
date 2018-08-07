package com.cg.amazon;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStepDef {

	WebDriver driver = null;

	@Before
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^user navigates to amazon$")
	public void user_navigates_to_amazon() throws InterruptedException {
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
	}

	@When("^user adds (\\d+) items to cart$")
	public void user_adds_items_to_cart(int arg1) throws InterruptedException {
	    HomePage home = PageFactory.initElements(driver, HomePage.class);
	    home.seeAll.click();
	    String winHandleBefore = driver.getWindowHandle();
	    for(String winHandle: driver.getWindowHandles()) {
	    	driver.switchTo().window(winHandle);
	    }
	    driver.close();
	    driver.switchTo().window(winHandleBefore);
	    driver.get("https://www.amazon.in/gp/goldbox");
	   
	    DealsPage page = PageFactory.initElements(driver, DealsPage.class);
	    page.deal1.click();
	    String winHandleBefore1 = driver.getWindowHandle();
	    for(String winHandle: driver.getWindowHandles()) {
	    	driver.switchTo().window(winHandle);
	    }
	    driver.close();
	    driver.switchTo().window(winHandleBefore1);
	    driver.get("https://www.amazon.in/Vivo-Y71-Matte-Black-Offers/dp/B07D84PTVF/ref=gbph_img_s-3_e90e_d2ce8549?smid=A14CZOWI0VEHLG&pf_rd_p=55012d7a-1479-419a-9c4f-11e92245e90e&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_r=C9MAD4YYZR7W2X0HTHKA");
	    page.add.submit();
	    
	    driver.get("https://www.amazon.in/gp/goldbox");
	    
	   
	    page.input.sendKeys("euphoria perfume for women");
	    page.input.sendKeys(Keys.ENTER);
	    page.deal2.click();
	    String winHandleBefore2 = driver.getWindowHandle();
	    for(String winHandle: driver.getWindowHandles()) {
	    	driver.switchTo().window(winHandle);
	    }
	    driver.close();
	    driver.switchTo().window(winHandleBefore2);
	    driver.get("https://www.amazon.in/Calvin-Klein-Euphoria-Women-100ml/dp/B000XE1TUI/ref=sr_1_3?s=beauty&ie=UTF8&qid=1533621731&sr=1-3&keywords=euphoria%2Bperfume%2Bfor%2Bwomen&th=1");
	    page.add.submit();	    
	   
	    page.input.sendKeys("books");
	    page.input.sendKeys(Keys.ENTER);
	    page.deal3.click();
	    page.add.submit();
	  
	}

	@When("^user goes to cart and proceeds tpo checkout$")
	public void user_goes_to_cart_and_proceeds_tpo_checkout() {
		DealsPage page = PageFactory.initElements(driver, DealsPage.class);
		page.cart.click();
		page.proceed.click();
	}

	@Then("^user is navigated to payment page$")
	public void user_is_navigated_to_payment_page() {
	  String title ="Amazon Sign In";
	  assertEquals(driver.getTitle(), title);
	}


}
