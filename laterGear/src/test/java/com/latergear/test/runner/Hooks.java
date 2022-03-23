package com.latergear.test.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        driver =  getDriver();
    }

    public WebDriver getDriver()
    {
//        setupChromeDriver();
        return  driver;
    }

    public void setupChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
//        driver.set(new ChromeDriver(chromeOptions));
    }
//    @After
//    public void cleanUp(){
//        driver.close();
//    }
}
