package com.bugbank.pages.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public final By inputEmail = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input");
    public final By inputPassword = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input");
    public final By accessButton = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]");
    public final By welcomeMessage = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/p[2]");
}
