package com.cg.forms_excel;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTest {

	private static final String FILE_NAME ="registration.xlsx";
	
	WebDriver driver = null;

	@Before
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
	}
	
	@Test
	public void readFromExcel() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		// Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(RegistrationTest.class.getResourceAsStream(FILE_NAME));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // Iterating over all the sheets in the workbook. You can use a for-each loop
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }


        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        boolean flag = false;
        for (Row row: sheet) {
        	
			String firstName = dataFormatter.formatCellValue(row.getCell(0));
			String lastName = dataFormatter.formatCellValue(row.getCell(1));
			String email = dataFormatter.formatCellValue(row.getCell(2));
			System.out.println(firstName+"  "+lastName+"  "+email);
			if(flag) {
				driver = new ChromeDriver();
				driver.get("http://localhost:8085/Forms_Excel/");
            	Register1Page page1 = PageFactory.initElements(driver, Register1Page.class);
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			page1.firstname.sendKeys(firstName);
    			page1.lastname.sendKeys(lastName);
    			page1.email.sendKeys(email);
    			page1.submit.click();
            	
            }
            flag = true;
            System.out.println();
        }


        // Closing the workbook
        workbook.close();
    }
	
	
}
