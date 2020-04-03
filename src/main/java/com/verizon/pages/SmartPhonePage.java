package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.verizon.base.BasePage;
import com.verizon.utilities.Constants;
import com.verizon.utilities.ElementUtil;

public class SmartPhonePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	By Iphone11=By.xpath("//a[@aria-label='Apple iPhone 11']");
	
	public SmartPhonePage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	public String getTitle(){
		return elementUtil.waitForGetPageTitle(Constants.VERIZON_SMARTPHONEPAGE_TITLE);
	}
	public FeaturePhone clickIphone11(){
		elementUtil.waitForElementPresent(Iphone11);
		elementUtil.doClick(Iphone11);
		return new FeaturePhone(driver);
	}	
}
