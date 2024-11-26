package org.fitpeo.automation;

import org.fitpeo.automation.common.FitpeoAutomationConst;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitpeoUIAutomation {

	private static WebDriver driver;
	private static Actions action;
	
	/**
	 * main method to start application
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		initialize();
		WebElement value = driver.findElement(By.xpath(FitpeoAutomationConst.REVENUE_CALCULATOR_PAGE_X_PATH));
		value.click();
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.xpath(FitpeoAutomationConst.SLIDER_X_PATH));
		Thread.sleep(2000);
		int desiredValue = 820;
		WebElement patientsInputElement = driver.findElement(By.id(FitpeoAutomationConst.SLIDER_INPUT_ID));
		int currentValue = 0;
		boolean isCompleted = false;
		int offset = 10;
		while (!isCompleted) {
			currentValue = Integer.parseInt(patientsInputElement.getAttribute("value"));
			if (desiredValue - currentValue < 100) {
				offset = 2;
			}
			if (currentValue <= desiredValue) {
				action.dragAndDropBy(slider, offset, 0).perform();
			} else {
				action.dragAndDropBy(slider, -1, 0).perform();
				isCompleted = true;
				break;
			}
		}
		action.release(slider);
		Thread.sleep(2000);
		action.scrollToElement(patientsInputElement).perform();
		patientsInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "560");
		Thread.sleep(2000);
		patientsInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "820");
		Thread.sleep(1000);
		tickCheckBoxByXPath(FitpeoAutomationConst.CHECKBOX_ONE_X_PATH);
		Thread.sleep(1000);
		tickCheckBoxByXPath(FitpeoAutomationConst.CHECKBOX_TWO_X_PATH);
		Thread.sleep(1000);
		tickCheckBoxByXPath(FitpeoAutomationConst.CHECKBOX_THREE_X_PATH);
		Thread.sleep(1000);
		tickCheckBoxByXPath(FitpeoAutomationConst.CHECKBOX_FOUR_X_PATH);

	}
	
	/**
	 * method to initialize driver
	 * 
	 */
	private static void initialize() {
		driver =  new ChromeDriver();
		action = new Actions(driver);
		driver.get("https://fitpeo.com/");
		driver.manage().window().maximize();
	}
	
	/**
	 * method to tick check-box based on x path
	 * 
	 * @param xPath
	 * @throws InterruptedException
	 */
	private static void tickCheckBoxByXPath(String xPath) throws InterruptedException {
		try {
			WebElement checkbox = driver
					.findElement(By.xpath(xPath));
			action.scrollToElement(checkbox).perform();
			checkbox.click();
		} catch (NoSuchElementException e) {
			System.out.println("Re check for element");
			Thread.sleep(1000);
			tickCheckBoxByXPath(xPath);
		}
	}

}
