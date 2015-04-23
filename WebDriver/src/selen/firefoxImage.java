package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirefoxImage {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.se/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFirefoxImage() throws Exception {
    driver.get(baseUrl + "about:home");
    driver.findElement(By.id("searchText")).clear();
    driver.findElement(By.id("searchText")).sendKeys("pluralsight");
    driver.findElement(By.id("searchSubmit")).click();
    driver.findElement(By.linkText("Bilder")).click();
    driver.findElement(By.name("lzwP3sWCMtluuM:")).click();
    driver.findElement(By.name("lzwP3sWCMtluuM:")).click();
    driver.findElement(By.name("lzwP3sWCMtluuM:")).click();
    driver.findElement(By.name("Mg6e7VB4ypk3AM:")).click();
    driver.findElement(By.name("nVV1rUftvSMTNM:")).click();
    driver.findElement(By.name("nVV1rUftvSMTNM:")).click();
    driver.findElement(By.name("nVV1rUftvSMTNM:")).click();
    driver.findElement(By.name("nVV1rUftvSMTNM:")).click();
    driver.findElement(By.name("_hxRgFXxpjxdUM:")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
