package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.verizon.base.BasePage;
import com.verizon.utilities.Constants;
import com.verizon.utilities.ElementUtil;
public class FeaturePhone extends BasePage{

		WebDriver driver;
		ElementUtil elementUtil;
		
		By purpleColor= By.xpath("//div[contains(@style,'rgb(204, 197, 215)')]");
		By capasity= By.xpath("//div[@class='sizePad']//p[contains(text(),'256GB')]");
		By retailPrice=	By.xpath("//div/div[contains(text(),'Retail price')]");
		By continueBtn=	By.xpath("//div/button[@id='ATC-Btn']");
		By zipCode=	By.xpath("//div/input[@id='zipcode']");
		By confirmLocation=	By.xpath("//button[contains(text(),'Confirm Location')]");
		By newCustomer=	By.xpath("//button[@aria-label='New Customer']");
		By lastPrice= By.xpath("//p/span[contains(text(),'$849.99')]");
		
		  public FeaturePhone(WebDriver driver){
			this.driver=driver;
			elementUtil=new ElementUtil(driver);
		  }
		  public String getTitle(){
			return elementUtil.waitForGetPageTitle(Constants.APPLE_IPHONE11_TITLE);
		  }
		  public void selectColor(){
			elementUtil.waitForElementPresent(purpleColor);
			elementUtil.doClick(purpleColor);
		  }
		  public void selectCapasity(){
			elementUtil.doClick(capasity);
		  }
		  public void selectPrice(){
			elementUtil.doClick(retailPrice);
		  }
		  public void clickOnContinue(){
			elementUtil.doClick(continueBtn);
		  }
		  public void waitForZipPopUp(String zip){
			elementUtil.waitForElementPresent(zipCode);
			elementUtil.doSendKeys(zipCode, zip);
		  }
		  public void confirmLocation(){
			elementUtil.doClick(confirmLocation);
		  }
		  public void clickOnNewCustomer(){
			elementUtil.doClick(newCustomer);
		  }
		  public String getLastPrice(){
			return elementUtil.getElement(lastPrice).getText();
		  }	
	}


