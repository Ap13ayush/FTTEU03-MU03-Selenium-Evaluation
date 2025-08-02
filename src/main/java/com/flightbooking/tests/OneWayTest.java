package com.flightbooking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OneWayTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open practice page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);

        // Select 'From' city
        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        from.click();
        WebElement mumbai = driver.findElement(By.xpath("//a[@value='BOM']"));
        mumbai.click();

        // Select 'To' city
        WebElement chennai = driver.findElement(By.id("id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\""));
        chennai.click();

        // Select departure date
        WebElement departureDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
        departureDate.click();

        // Search flights
        WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
        searchButton.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
// 