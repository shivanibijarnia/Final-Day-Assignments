package com.cg.redbus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedBusStepDef {

	WebDriver driver = null;

	@Before
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^user navigates to redbus$")
	public void user_navigates_to_redbus(){
		driver.get("https://www.redbus.in/bus-tickets/");
	}

	@When("^user enters details and press Search Buses$")
	public void user_enters_details_and_press_Search_Buses() throws InterruptedException  {
	   driver.findElement(By.id("txtSource")).sendKeys("Pune");
	   Thread.sleep(1000);	   
	   driver.findElement(By.id("txtSource")).sendKeys(Keys.ENTER);
	   
	   driver.findElement(By.id("txtDestination")).sendKeys("Delhi");
	   Thread.sleep(1000);
	   driver.findElement(By.id("txtDestination")).sendKeys(Keys.ENTER);
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath("//*[@id=\"txtOnwardCalendar\"]")).click();
	   driver.findElement(By.xpath("//*[@id=\"rb-calmiddle\"]/ul[2]/li[12]/span")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("/html/body/div[1]/div[4]/button")).click();
	   Thread.sleep(20000);
	   
	  
	}

	@Then("^user is navigated to next page$")
	public void user_is_navigated_to_next_page() throws InterruptedException {
	   driver.findElement(By.xpath("//*[@id=\"10683609\"]/div/div[2]/div[1]")).click();
	   Thread.sleep(20000);
	   driver.findElement(By.xpath("//*[@id=\"10683609\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/li[1]/span[2]")).click();
	   driver.findElement(By.xpath("//*[@id=\"10683609\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/ul/li[1]/span[2]")).click();
	   driver.findElement(By.xpath("//*[@id=\"10683609\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[6]/button")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("//*[@id=\"seatno-04\"]")).sendKeys("Shivani");
	   driver.findElement(By.xpath("//*[@id=\"23_0\"]")).click();
	   driver.findElement(By.xpath("//*[@id=\"seatno-01\"]")).sendKeys("21");
	   driver.findElement(By.xpath("//*[@id=\"seatno-05\"]")).sendKeys("abc@gmail.com");
	   driver.findElement(By.xpath("//*[@id=\"seatno-06\"]")).sendKeys("9900000000");
	   driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div[5]/div/div[2]/div/label[2]/span")).click();
	   driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[2]/input")).click();
	}

}




















/*((JavascriptExecutor)driver).executeScript ("document.getElementById('onward_cal').setAttribute('data-caleng','"+onward_cal+"');"); // Enables the from date box
Thread.sleep(1000);
//driver.findElement(By.id("txtOnwardCalendar")).click();
//WebElement selectElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("rb-monthTable")));
Select select = new Select(selectElement);
select.selectByValue("2018");
Thread.sleep(6000);
WebElement dateWidget = driver.findElement(By.id("rb-calendar_onward_cal"));
List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
for (WebElement cell: columns){
//Select  Month
	   System.out.println(cell.getText());
if (cell.getText().equals("Sept 2018")){
cell.findElement(By.linkText("Sept 2018")).click();
System.out.println(cell.getText());
homepage.date.click();
break;
}
}
 WebElement fromDateBox= driver.findElement(By.id("fromDate"));
fromDateBox.clear();
fromDateBox.sendKeys("8-Dec-2014"); //Enter date in required format
	  
*/