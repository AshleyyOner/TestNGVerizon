package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.SmartPhonePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.utilities.Constants;


	public class SmartPhoneTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	SmartPhonePage smartPhonePage; 
	
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		verizonMainPage = new VerizonMainPage(driver);
	    smartPhonePage=verizonMainPage.hover();
	}	
	
	@Test(priority=1,description="Get home page title")
	public void getTitle(){
		String title=smartPhonePage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.VERIZON_SMARTPHONEPAGE_TITLE);
	}
	
	@Test(priority=2,description="Click on selected Phone")
	public void selectIphone11(){
		smartPhonePage.clickIphone11();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}



