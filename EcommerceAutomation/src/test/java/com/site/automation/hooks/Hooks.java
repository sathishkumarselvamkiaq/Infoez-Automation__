/*Hooks is to implement before and after execution of test*/

package com.site.automation.hooks;

import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

import com.site.automation.driver.DriverFactory;

import io.cucumber.java.After;

public class Hooks 
{
    @Before
    public void setUp() 
    {
    	DriverFactory.initDriver();
    }

    @After
    public void tearDown() 
    {
        DriverFactory.quitDriver();
    }
}

