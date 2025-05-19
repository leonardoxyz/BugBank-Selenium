package com.bugbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bugbank.pages.locators.RegisterLocators;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    RegisterLocators registerLocators = new RegisterLocators();
    
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegisterForms() {
        driver.findElement(registerLocators.registerNewUser).click();
    }

    public void fillRegisterForm(String nameVal, String emailVal, String passVal) {
        driver.findElement(registerLocators.name).sendKeys(nameVal);
        driver.findElement(registerLocators.email).sendKeys(emailVal);
        driver.findElement(registerLocators.password).sendKeys(passVal);
        driver.findElement(registerLocators.confirmPassword).sendKeys(passVal);
        driver.findElement(registerLocators.registerButton).click();
    }

    public void closeModal() {
    	WebElement closeButton = waitForSelector(driver, registerLocators.closeModal, 10);
        driver.findElement(registerLocators.closeModal).click();
    }
    
    public WebElement waitForSelector(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
