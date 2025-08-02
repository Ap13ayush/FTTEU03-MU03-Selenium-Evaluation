package com.flightbooking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open practice page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);

        // Test static dropdown - Currency
        WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(currencyDropdown);
        dropdown.selectByVisibleText("INR");
        System.out.println("Selected currency: " + dropdown.getFirstSelectedOption().getText());

        // Test dynamic dropdown - From city
        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        from.click();
        Thread.sleep(1000);
        
        WebElement delhi = driver.findElement(By.xpath("//a[@value='DEL']"));
        delhi.click();
        System.out.println("Selected From city: Delhi");

        // Test dynamic dropdown - To city
        Thread.sleep(1000);
        WebElement bangalore = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"));
        bangalore.click();
        System.out.println("Selected To city: Bangalore");

        Thread.sleep(2000);
        driver.quit();
    }
}
