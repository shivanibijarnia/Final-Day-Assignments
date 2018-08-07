package com.cg.csv_forms;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import au.com.bytecode.opencsv.CSVReader;

public class RegistrationTest {

	private static final String FILE_PATH="D:\\Text files\\registration.csv";
	
	WebDriver driver = null;

	@Before
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
	}
	
	@Test
	public void readFromCSV() throws IOException {
		
		CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
		String [] cell;
		
		
		while ((cell = reader.readNext()) != null) {
			driver = new ChromeDriver();
			driver.get("http://localhost:8085/csv_forms/");
			
			String firstName = cell[0];
			String lastName = cell[1];
			String email = cell[2];
		
			Register1Page page1 = PageFactory.initElements(driver, Register1Page.class);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			page1.firstname.sendKeys(firstName);
			page1.lastname.sendKeys(lastName);
			page1.email.sendKeys(email);
			page1.submit.click();
		}
	}
	
}
