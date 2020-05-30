package com.allTestPages;

import org.testng.annotations.Test;

import com.allPages.RootPage;

import basePack.BaseClass;

public class TestPage extends BaseClass{
	
	@Test
	public void rootPageTest() {
		test=report.createTest("RootPage Test");
		driver.get("file:///E:/BNS.html");
		
		RootPage rp=new RootPage(driver);
		rp.enterFirstname("Zahangir");
		rp.enterLastname("bhoo");
		rp.enterEmail("abc123@gmail.com");
		rp.enterPassword("12345");
		rp.phoneNumber("1234567890");
		rp.selectMonth("May");
		rp.selectDay("18");
		rp.selectYear("2003");
		rp.clickOnMale();
		//NextPage np=rp.submitButton();
		rp.verifyText("Submitted Form Data");
		
		
		System.out.println("Pass");
	}
	
}
