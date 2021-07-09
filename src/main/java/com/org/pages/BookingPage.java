package com.org.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.util.ElementUtil;

public class BookingPage {
	WebDriver driver;
	ElementUtil elementutil;
	
	//private By reviewBookingHeader = By.xpath("//h4[text()='Review your booking']");
	private By fareSummarySection = By.xpath("//p[text()='Fare Summary']/following-sibling::div");
	
	public BookingPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	
	public boolean verifyBookPageOpenInNewtab(){
		Set<String> winList = driver.getWindowHandles();
		String currentwindow = driver.getWindowHandle();
		for(String ids : winList) {
			if (!ids.equalsIgnoreCase(currentwindow)) {
				elementutil.switchWindow(ids);
				return elementutil.getDisplayStatus(fareSummarySection);
			}
		}
		return false;
	}

	public boolean validateFareSummarySection() {
		return elementutil.getDisplayStatus(fareSummarySection);
	}
}
