package com.bugbank.pages;

import com.bugbank.base.BaseTest;
import com.bugbank.pages.locators.LoginPageLocators;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseTest{
    private WebDriver driver;
    LoginPageLocators locators = new LoginPageLocators();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String senha) {
        driver.findElement(locators.inputEmail).sendKeys(email);
        driver.findElement(locators.inputPassword).sendKeys(senha);
        driver.findElement(locators.accessButton).click();
    }

    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.welcomeMessage));
        return element.getText();
    }
}
