package com.galaykovskiy.testRail;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class testUI {
    private WebDriver driver;
    private HomePage homePage;
    private PricingPage pricingPage;
    private PricingDetailsPage pricingDetailsPage;

    @BeforeClass
    public void init() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setMainPage() {
        driver.get("https://www.gurock.com/testrail/");
    }

    @Test
    public void testServerPrice() {
        driver.get("https://www.gurock.com/testrail/");
        homePage = new HomePage(driver);
        pricingPage = homePage.clickOnPricingPage();
        pricingDetailsPage = pricingPage.clickOnPricingServerDetailsPage();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        pricingDetailsPage.changeCurrency();

        List<Map<String, String>> currencyInfo = pricingDetailsPage.getCurrency();
        for (Map<String, String> row : currencyInfo) {
            log.info(row.get("subscription") + "\t" + row.get("price"));
        }
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
