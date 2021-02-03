package com.galaykovskiy.testRail;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'gk-header-sticky-main-menu-link')][contains(text(),'Pricing')]")
    private WebElement pricingLink;

    @FindBy(xpath = "//a[@class='gk-header-sticky-main-menu-link'][contains(.,'Webinars')]")
    private WebElement webinarLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingPage clickOnPricingPage() {
        pricingLink.click();
        return new PricingPage(driver);
    }
}
