package com.flightbooking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RoundTripTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open practice page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);

        // Select Round Trip
        WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
        roundTrip.click();

        // Select 'From' city
        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        from.click();
        WebElement delhi = driver.findElement(By.xpath("//a[@value='DEL']"));
        delhi.click();

        // Select 'To' city
        WebElement bangalore = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"));
        bangalore.click();

        // Select departure date
        WebElement departureDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
        departureDate.click();

        // Check 'Senior Citizen'
        WebElement seniorCitizenCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
        if (!seniorCitizenCheckbox.isSelected()) {
            seniorCitizenCheckbox.click();
        }

        // Search flights
        WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
        searchButton.click();

        Thread.sleep(2000);
        driver.quit();
    }
}

