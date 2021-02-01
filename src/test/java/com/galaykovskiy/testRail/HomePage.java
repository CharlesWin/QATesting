package com.galaykovskiy.testRail;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

@Slf4j
public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'gk-header-sticky-main-menu-link')][contains(text(),'Pricing')]")
    private WebElement pricingLink;

    @FindBy(xpath = "//a[@class='gk-header-sticky-main-menu-link '][contains(.,'Webinars')]")
    private WebElement webinarLink;

    @FindBy(xpath = "//button[@id='searchsubmit']")
    private WebElement searchBtn;

    @BeforeClass
    public void init() {
        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();

        PageFactory.initElements(driver, this);
    }

    public PricingPage clickOnPricingPage() {
        pricingLink.click();
        return new PricingPage(driver);
    }

    @Test
    public void simpleTest() {
        driver.manage().window().maximize();
        driver.get("https://www.gurock.com/testrail/");
//        driver.findElement(By.linkText("Pricing")).click();
        searchBtn.click();
//        driver.findElement(By.xpath("//button[@id='searchsubmit']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(price));
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
