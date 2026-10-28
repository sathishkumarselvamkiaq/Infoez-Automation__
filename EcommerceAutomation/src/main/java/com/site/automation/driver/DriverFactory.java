package com.site.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory 
{

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {}

    public static void initDriver() 
    {
        DRIVER.set(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() 
    {
      
		WebDriver driver = DRIVER.get();

        if (driver == null) 
        {
            throw new IllegalStateException("WebDriver has not been initialized");
        }

        return driver;
    }

    public static void quitDriver() 
    {
        WebDriver driver = DRIVER.get();

        if (driver != null) 
        {
            try 
            {
                driver.quit();
            } 
            finally 
            {
                DRIVER.remove();
            }
        }
    }
}

