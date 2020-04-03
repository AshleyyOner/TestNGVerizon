package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.FeaturePhone;
import com.verizon.pages.SmartPhonePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.utilities.Constants;


public class FeaturePhoneTest {
	
		WebDriver driver;
		Properties prop;
		BasePage basePage;
		VerizonMainPage verizonMainPage;
		SmartPhonePage smartPhonePage;
		FeaturePhone featuresPhone;
		
		@BeforeMethod
		public void setUp(){
			basePage=new BasePage();
			prop=basePage.initialize_properties();
			driver=basePage.initialize_driver(prop);
			verizonMainPage=new VerizonMainPage(driver);
			smartPhonePage= verizonMainPage.hover();
			featuresPhone=	smartPhonePage.clickIphone11();				
		}
		
		@Test(priority=1,description="Verify The Title")
		public void verifyTitle(){
			String title=	featuresPhone.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, Constants.APPLE_IPHONE11_TITLE);
		}	
		
		@Test(priority=2,description= "Checking Selected Features")
		public void features(){
			featuresPhone.selectColor();
			featuresPhone.selectCapasity();
			featuresPhone.selectPrice();
		}
		
		@Test(priority=3,description="Confirm ZipCode")
		public void featuresInOne(){
			features();
			featuresPhone.clickOnContinue();
			featuresPhone.waitForZipPopUp(prop.getProperty("zip"));
			featuresPhone.confirmLocation();
			featuresPhone.clickOnNewCustomer();
		}
		
		@Test(priority=4,description="Verify The Selected Phone Price ")
		public void verifyPrice(){
			featuresInOne();
			String retailprice=featuresPhone.getLastPrice();
			String price=prop.getProperty("price");
			Assert.assertEquals(retailprice, price);
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}	
	}


