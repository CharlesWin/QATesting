package com.galaykovskiy.testRail;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class PricingPage {
    private WebDriver driver;

    public PricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingDetailsPage clickOnPricingServerDetailsPage() {
        driver.findElement(By.xpath("(//a[@href='/testrail/pricing/server'])")).click();
        return new PricingDetailsPage(driver);
    }

    public PricingDetailsPage clickOnPricingCloudDetailsPage() {
        driver.findElement(By.xpath("(//a[@href='/testrail/pricing/cloud'])")).click();
        return new PricingDetailsPage(driver);
    }
}
