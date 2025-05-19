package com.bugbank.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bugbank.base.BaseTest;
import com.bugbank.pages.locators.HomePageLocators;

public class HomePage extends BaseTest{
    private WebDriver driver;
    HomePageLocators locators = new HomePageLocators();
	
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnExitButton() {
    	waitForSelector(driver, locators.exitButton, 5);
    	driver.findElement(locators.exitButton).click();
    	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
    
    public void clickOnExtractButton() {
    	waitForSelector(driver, locators.extractButton, 5);
        driver.findElement(locators.extractButton).click();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
    
    public void clickOnTransferenceButton() {
    	waitForSelector(driver, locators.transferenceButton, 5);
    	driver.findElement(locators.transferenceButton).click();
    	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
    
    public String getAccountNumber() {
        WebElement modal = driver.findElement(By.cssSelector(".modal"));
        String text = modal.getText();
        String accountNumber = text.replaceAll("[^0-9-]", "");
        return accountNumber;
    }
}