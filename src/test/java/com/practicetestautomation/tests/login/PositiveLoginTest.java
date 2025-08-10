package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest {

    @Test
    public void TestLoginFunctionality(){
        //Open page
        WebDriver driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //Type username student into Username field
        WebElement InputUserName=driver.findElement(By.id("username"));
        InputUserName.sendKeys("student");
        //Type password Password123 into Password field
        WebElement InputPassword= driver.findElement(By.id("password"));
        InputPassword.sendKeys("Password123");
        //Push Submit button
        WebElement SubmitButton= driver.findElement(By.id("submit"));
        SubmitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/

        String ExpectedUrl="https://practicetestautomation.com/logged-in-successfully/";
        String ActualURL= driver.getCurrentUrl();

        Assert.assertEquals(ActualURL, ExpectedUrl);//first Actual  then Expected
        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String ExpectedMessage="Congratulations student. You successfully logged in!";
        String pageSource= driver.getPageSource();
        Assert.assertTrue(pageSource.contains(ExpectedMessage));
        //Verify button Log out is displayed on the new page
        WebElement logOutButton= driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        driver.quit();
    }
}
