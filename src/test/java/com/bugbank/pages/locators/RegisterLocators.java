package com.bugbank.pages.locators;

import org.openqa.selenium.By;

public class RegisterLocators {
    public final By registerNewUser = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]");
    public final By email = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input");
    public final By name = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input");
    public final By password = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input");
    public final By confirmPassword = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input");
    public final By registerButton = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button");
    public final By closeModal = By.xpath("//*[@id=\"btnCloseModal\"]");
}
