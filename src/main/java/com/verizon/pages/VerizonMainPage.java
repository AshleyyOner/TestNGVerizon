package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.verizon.base.BasePage;
import com.verizon.utilities.Constants;
import com.verizon.utilities.ElementUtil;

public class VerizonMainPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By phone=By.xpath("//button[contains(text(),'Phones list')]");
	By smartphone=By.id("thirdLevel00");
	
	public VerizonMainPage(WebDriver driver ){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);	
	}
	public String getVerizonTitle(){
		return elementUtil.waitForGetPageTitle(Constants.VERIZON_HOMEPAGE_TITLE);	
	}
	public SmartPhonePage hover(){
		elementUtil.action(phone);
		elementUtil.doClick(smartphone);
		return  new SmartPhonePage(driver);
	}
}
	
	

