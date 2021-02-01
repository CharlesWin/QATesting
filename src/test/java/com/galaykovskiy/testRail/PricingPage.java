package com.galaykovskiy.testRail;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class PricingPage {
    private WebDriver driver;

    public PricingPage(WebDriver driver) {
        this.driver = driver;
    }
}
