package com.allTestPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.DataHelper.ExcelFileReader;
import com.allPages.NextPage;
import com.allPages.RootPage;

import basePack.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPageByMultipleData extends BaseClass{
	
	static String filePath="E:\\FacebookData.xlsx";
	static String sheetName="Data1";

	@Test(dataProvider = "ABC")
	public void BNSPageTest(String fn, String LN, String EM, String PW, String Ph,
			String MN, String DY, String YR, String Gender, String message ) throws InterruptedException {
		
		test=report.createTest("BNSPage Test");
		
		driver.get("file:///E:/BNS.html");
		
		RootPage rp=new RootPage(driver);
		rp.enterFirstname(fn);
		rp.enterLastname(LN);
		
		rp.enterEmail(EM);
		rp.enterPassword(PW);
		rp.phoneNumber(Ph);
		rp.selectMonth(MN);
		rp.selectDay(DY);
		rp.selectYear(YR);
		
		if(Gender.equalsIgnoreCase("Male")) {
		rp.clickOnMale();
		}
		else if(Gender.equalsIgnoreCase("Female")) {
			rp.clickOnfemale();
		}
		Thread.sleep(3000);
		//NextPage np=rp.submitButton();
		//np.verifyText(Message);
		rp.submitButton();
		
		rp.verifyText(message);
		
	}
	
	
	@DataProvider(name="ABC")
	public Object[][] getData() throws IOException{
		return ExcelFileReader.dataReader(filePath, sheetName);
	}
}
