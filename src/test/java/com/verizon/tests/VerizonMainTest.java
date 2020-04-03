package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.utilities.Constants;

public class VerizonMainTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		verizonMainPage=new VerizonMainPage(driver);	
	}
	@Test(priority=1,description="Get Verizon Home Page Title")
	public void verifyTitle(){
		String title=verizonMainPage.getVerizonTitle();
		System.out.println(title);
		Assert.assertEquals(title,Constants.VERIZON_HOMEPAGE_TITLE);
	}
	@Test(priority=2,description="Hover in Verizon Home Page")
	public void moveToSmartPhone(){
		verizonMainPage.hover();	
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();	
	}	
}