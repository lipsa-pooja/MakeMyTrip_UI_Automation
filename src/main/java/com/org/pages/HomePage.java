package com.org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.org.util.CommonUtility;
import com.org.util.ElementUtil;

public class HomePage {
	WebDriver driver;
	ElementUtil elementutil;
	
	 private By loginAccountLoc=By.xpath("//li[@data-cy='account']");
	 private By usernameloc=By.id("username");
	 private By continuebtn=By.xpath("//span[text()='Continue']");
	 private By passwordloc=By.id("password");
	 private By loginbtnloc=By.xpath("//button[@data-cy='login']");
	 private By outsideModelloc = By.xpath("//div[@data-cy='outsideModal']");
	 private By tripListloc=By.xpath("//ul[@class='fswTabs latoBlack greyText']/li");
	 private By fromcityloc=By.xpath("//label[@for='fromCity']/span");
	 private By fromCityInputloc = By.xpath("//input[@placeholder='From']");
	 private By suggestionlistboxforfromcityloc=By.xpath("//ul[@role='listbox']/li");
	 private By tocityloc=By.id("toCity");
	 private By toCityInputloc = By.xpath("//input[@placeholder='To']");
	 private By suggestionlistboxfortocityloc=By.xpath("//ul[@role='listbox']/li");
	 
	 private By travellersandclassloc=By.xpath("//label[@for='travellers']");
	 private By adultlistloc=By.xpath("//div[p[@data-cy='adultRange']]/ul/li");
	 private By childrenlistloc=By.xpath("//div[p[@data-cy='childrenRange']]/ul/li");
	 private By tavellerapplybtnloc= By.xpath("//button[@data-cy='travellerApplyBtn']");
	 private By searchbtnloc=By.xpath("//a[text()='Search']");
	 
	 private By DatePickerrange = By.xpath("//div[@class='DayPicker Selectable Range']//div[@class='DayPicker-Caption']/div");
	 private By nextMonthBtn = By.xpath("//div[@class='DayPicker-NavBar']/span[@class='DayPicker-NavButton DayPicker-NavButton--next']");
	 private By adultList = By.xpath("//div[p[@data-cy='adultRange']]/ul/li");
	 private By childList = By.xpath("//div[p[@data-cy='childrenRange']]/ul/li");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
 
	public void  lauchAppUrl(String url)
	{
		elementutil.launchUrl(url);
	}
	
	public void clickOnLoginAccountBtn()
	{
		elementutil.doClick(loginAccountLoc);
	}
	
	public void loginToHomepage(String username,String password)
	{
		elementutil.doSendKeys(usernameloc, username);
		elementutil.doClick(continuebtn);
		elementutil.doSendKeys(passwordloc, password);
		elementutil.doClick(loginbtnloc);
	}
	
	public void clickOnRoundTripBtn(String reqTrip)
	{
		elementutil.doClickIfPresent(outsideModelloc);
		
		elementutil.selectItemInElementList(tripListloc, reqTrip);
		/*
		 * List<WebElement> listofbtn=driver.findElements(radiobtnloc);
		 * 
		 * for(WebElement Btn:listofbtn) { String BtnName=Btn.getText();
		 * if(BtnName.equalsIgnoreCase(roundtripbtn)) { Btn.click(); } }
		 */
	}
	
	public void enterFlightFromAndTo(String fromcity,String tocity)
	{
		elementutil.doClick(fromcityloc);
		elementutil.doSendKeys(fromCityInputloc, fromcity);
		elementutil.selectItemWhenContainsInElementList(suggestionlistboxforfromcityloc, fromcity);
		
		/*
		 * List<WebElement>
		 * listofsuggestion=driver.findElements(suggestionlistboxforfromcityloc);
		 * for(WebElement fromCity:listofsuggestion) { String
		 * suggestioncityname=fromCity.getText();
		 * if(suggestioncityname.contains(fromcity)) { fromCity.click(); break; } }
		 */
		
		
	//	elementutil.doClick(tocityloc);
		elementutil.doSendKeys(toCityInputloc, tocity);
		elementutil.selectItemWhenContainsInElementList(suggestionlistboxfortocityloc, tocity);
		
		/*
		 * List<WebElement>
		 * listofsuggestions=driver.findElements(suggestionlistboxfortocityloc);
		 * for(WebElement toCity:listofsuggestions) { String
		 * suggestioncityname=toCity.getText(); if(suggestioncityname.contains(tocity))
		 * { toCity.click(); break; } }
		 */
		 
	}
	
	public void SelectFromAndToDate(String reqDate) {
		String formatDate;
		
		if(reqDate.equalsIgnoreCase("Today") || reqDate.equalsIgnoreCase("Tomorrow")) {
			formatDate = CommonUtility.getDate(reqDate);
		}else {
			formatDate = reqDate;
		}

		String[] reqdate = formatDate.split("\\/");
		boolean flag = false;
		int i = 1;
		while (!flag) {
			i = 1;
			List<WebElement> months = elementutil.getElements(DatePickerrange);
			for (WebElement ele : months) {
				System.out.println(ele.getText());
				if (ele.getText().contains(reqdate[1] + reqdate[2])) {
					System.out.println("Found Month");
					flag = true;
					break;
				}
				i = i + 1;
			}
			if (!flag)
				nextMonth(driver);
		}
		List<WebElement> dwb = driver
				.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div[@class='DayPicker-Month'][" + i
						+ "]//div[@class='DayPicker-Week']/div[@aria-disabled!=\"true\"]/div/p"));
		for (WebElement w : dwb) {
			System.out.println(w.getText());
			if (w.getText().equalsIgnoreCase(reqdate[0])) {
				w.click();
				break;
			}
		}
		
	}
	public void nextMonth(WebDriver driver) {
		/*
		 * driver.findElement(By
		 * .xpath("//div[@class='DayPicker-NavBar']/span[@class='DayPicker-NavButton DayPicker-NavButton--next']"
		 * )) .click();
		 */
		elementutil.doClick(nextMonthBtn);
	}

	public void SelectTravellerInfo(String noOfAdult,String noOfChild) {
		elementutil.doClick(travellersandclassloc);
		elementutil.selectItemInElementList(adultList, noOfAdult);
		/*
		 * List<WebElement> listofadult=driver.findElements(By.xpath(
		 * "//div[p[@data-cy='adultRange']]/ul/li")); for(WebElement
		 * adultno:listofadult) { String adultnotext=adultno.getText();
		 * if(adultnotext.equalsIgnoreCase(noOfAdult)) { adultno.click(); break; } }
		 */
		
		elementutil.selectItemInElementList(childList, noOfChild);
		/*
		 * List<WebElement> listofchildren=driver.findElements(By.xpath(
		 * "//div[p[@data-cy='childrenRange']]/ul/li")); for(WebElement
		 * childrenno:listofchildren) { String childrennotext=childrenno.getText();
		 * if(childrennotext.equalsIgnoreCase(noOfChild)) { childrenno.click(); break; }
		 * }
		 */
		
	}
	
	public void travellerApplyBtn()
	{
		elementutil.doClick(tavellerapplybtnloc);
	}
	
	public SearchResultPage clickOnSearchBtn()
	{
		elementutil.doClick(searchbtnloc);
		return new SearchResultPage(driver);
	}
}
