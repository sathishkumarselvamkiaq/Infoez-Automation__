/*Reusable class is to reuse the repeated codes like validations, logical implementations, etc*/
package com.site.automation.reusable;

import org.testng.Assert;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.site.automation.base.BaseClass;

public class Reusable extends BaseClass
{	
	public Reusable(WebDriver driver) 
	{
		super(driver);
	}

	public static void softAssert(String falseMessage, String xpath)
	{
		WebElement verificationElement = driver.findElement(By.xpath(xpath));

		Assert.assertTrue(verificationElement.isDisplayed() || verificationElement.isEnabled(),falseMessage);
		
		//softAssert.assertAll();
	}
	
	public static String generateRandomText(int length) 
	{
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder text = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) 
        {
            int index = random.nextInt(characters.length());
            text.append(characters.charAt(index));
        }

        return text.toString();
    }
	
	public static String generateRandomNumber(int length) 
	{
        String characters = "12345";
        StringBuilder text = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) 
        {
            int index = random.nextInt(characters.length());
            text.append(characters.charAt(index));
        }

        return text.toString();
    }
}
