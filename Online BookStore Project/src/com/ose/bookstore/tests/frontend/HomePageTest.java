package com.ose.bookstore.tests.frontend;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePageTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
	  //driver = new HtmlUnitDriver();    
    baseUrl = "http://localhost:9090/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHomePage() throws Exception {
    driver.get(baseUrl + "/Online_BookStore_Project/faces/webpages/home.xhtml");
    try {
      assertTrue(isElementPresent(By.id("j_idt49:j_idt50")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    try {
      assertTrue(isElementPresent(By.id("j_idt49:table")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String searchStr = "java";
    driver.findElement(By.id("j_idt49:search")).sendKeys(searchStr);
    driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
    driver.findElement(By.cssSelector("#j_idt36 > span.ui-menuitem-text")).click();
    driver.findElement(By.cssSelector("#j_idt36 > span.ui-menuitem-text")).click();
    driver.findElement(By.id("j_idt35")).click();
    driver.findElement(By.cssSelector("#j_idt38 > span.ui-menuitem-text")).click();
    driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
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
