package com.org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.org.util.ElementUtil;

public class SearchResultPage {
	
	WebDriver driver;
	ElementUtil elementutil;
	
	private By resultPageHeader = By.xpath("//p[@class='font24 blackFont whiteText appendBottom20']");
	private By filterOptionList = By.xpath("//p[text()='Popular Filters']/following-sibling::div/label//span[@class='filterName']");
	private By bookNowBtn = By.xpath("//button[text()='Book Now']");
	private By fareHeader = By.xpath("//div[@class='multifareHead']");
	private By continueBtn = By.xpath("//button[text()='Continue']");
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	
	public boolean validateSearchResultHeader(String fromCity, String toCity) {
		elementutil.waitTillDisplay(resultPageHeader, 20);
		String actuHeader = elementutil.getReqText(resultPageHeader);
		String expHeader = "Flights from "+fromCity+" to "+toCity+", and back";
		if(actuHeader.equalsIgnoreCase(expHeader))
			return true;
		else
			return false;
	}
	
	public void selectRequiredFilterOption(String reqOption) {
		elementutil.selectItemInElementList(filterOptionList, reqOption);
	}

	public void clickOnBookNowBtn() {
		elementutil.doClick(bookNowBtn);
	}
	
	public boolean validateFareDetailsSection() {
		if(elementutil.getDisplayStatus(fareHeader) && elementutil.getDisplayStatus(continueBtn))
			return true;
		else
			return false;
	}
	
	public BookingPage clickOnContinueBtn() {
		String currentwindow = driver.getWindowHandle();
		elementutil.doClick(continueBtn);
		return new BookingPage(driver);
	}
}
