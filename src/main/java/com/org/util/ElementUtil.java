package com.org.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/***
 * This class contains all the Selenium wrapper method to do page actions.
 * @author lipsa
 *
 */
public class ElementUtil {
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void switchWindow(String windID) {
		driver.switchTo().window(windID);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doClickIfPresent(By locator) {
		try {
			WebElement wb = getElement(locator);
			wb.click();
		} catch (Exception e) {
		}
	}

	public void doClick(By locator) {
		WebElement wb = getElement(locator);
		wb.click();
	}

	public void doSendKeys(By locator, String input) {
		WebElement wb = getElement(locator);
		wb.sendKeys(input);
	}

	public void doClear(By locator) {
		WebElement wb = getElement(locator);
		wb.clear();
	}

	public String getReqText(By locator) {
		WebElement wb = getElement(locator);
		return wb.getText();
	}

	public WebElement waitTillDisplay(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean getDisplayStatus(By locator) {
		return waitTillDisplay(locator, 30).isDisplayed();
	}

	public void selectItemInElementList(By locator, String itemName) {
		List<WebElement> filterOption = getElements(locator);
		for (WebElement option : filterOption) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(itemName)) {
				option.click();
				break;
			}
		}
	}

	public void selectItemWhenContainsInElementList(By locator, String itemName) {
		List<WebElement> filterOption = getElements(locator);
		for (WebElement option : filterOption) {
			System.out.println(option.getText());
			if (option.getText().contains(itemName)) {
				option.click();
				break;
			}
		}
	}

}
