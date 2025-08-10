package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest {

    @Test
    public void IncorrectUserNameTest(){
        //Test case 2: Negative username test
        //Open page
        //System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //Type username incorrectUser into Username field
        WebElement IncorrectUserName= driver.findElement(By.id("username"));
        IncorrectUserName.sendKeys("Incorrectstudent");
        //Type password Password123 into Password field
        WebElement InputPassword= driver.findElement(By.id("password"));
        InputPassword.sendKeys("Password123");
        //Push Submit button
        WebElement ClickSubmit= driver.findElement(By.id("submit"));
        ClickSubmit.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
       //Test case 3: Negative password test
        //Open page
        WebDriver driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //Type username student into Username field
        WebElement InputUserName= driver.findElement(By.id("username"));
        InputUserName.sendKeys("student");
        //Type password incorrectPassword into Password field
        WebElement InputPassword= driver.findElement(By.id("password"));
        InputPassword.sendKeys("IncorrectPWD");
        //Push Submit button
        WebElement SubmitButton=driver.findElement(By.id("submit"));
        SubmitButton.click();
        //Verify error message is displayed
        WebElement ErrorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(ErrorMessage.isDisplayed());
        //Verify error message text is Your password is invalid!
        String ExpectedErrorMessage="Your password is invalid!";
        String actualMessage= ErrorMessage.getText();
        Assert.assertEquals(actualMessage, ExpectedErrorMessage );

        driver.quit();
    }
}
