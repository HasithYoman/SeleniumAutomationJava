package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest {

    @Test
    public void IncorrectUserNameTest(){
        //Test case 2: Negative username test
        //Open page
        WebDriver driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //Type username incorrectUser into Username field
        WebElement IncorrectUserName= driver.findElement(By.id("username"));
        IncorrectUserName.sendKeys("INCstudent");
        //Type password Password123 into Password field
        WebElement InputPassword= driver.findElement(By.id("password"));
        InputPassword.sendKeys("Password123");
        //Push Submit button
        WebElement ClickSubmit= driver.findElement(By.id("submit"));
        ClickSubmit.click();
        //Verify error message is displayed
        WebElement ErrorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(ErrorMessage.isDisplayed());//error meg actually disply(true /false)
        //Verify error message text is Your username is invalid!
        String expectedMessage="Your username is invalid!";
        String actualMessage=ErrorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();

    }
    @Test
    public void IncorrectPasswordTest(){

    }
}
