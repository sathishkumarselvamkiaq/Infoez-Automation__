/*Here Base class is to maintain initiate driver and implicit wait*/
package com.site.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	protected static WebDriver driver;
    protected WebDriverWait wait;

    public BaseClass(WebDriver driver) 
    {
        BaseClass.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
