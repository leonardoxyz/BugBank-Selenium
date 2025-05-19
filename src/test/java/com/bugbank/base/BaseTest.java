package com.bugbank.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bugbank.pages.LoginPage;
import com.bugbank.pages.RegisterPage;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String email;
    protected String senha;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        System.out.println("Driver: " + driver);
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app");

        email = "test" + System.currentTimeMillis() + "@mail.com";
        senha = "123";

        RegisterPage register = new RegisterPage(driver);
        register.openRegisterForms();
        register.fillRegisterForm("Test User", email, senha);
        register.closeModal();
        
        LoginPage login = new LoginPage(driver);
        login.login(email, senha);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    
    public void takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "screenshot_" + timestamp + ".png";

        File destFile = new File("screenshots/" + filename);

        try {
            destFile.getParentFile().mkdirs();

            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot salva em: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public WebElement waitForSelector(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}