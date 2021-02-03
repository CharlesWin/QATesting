package com.galaykovskiy.testRail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingDetailsPage {
    private WebDriver driver;

    @FindBy(xpath = "//table[contains(style)]")
    private WebElement table;

    public PricingDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeCurrency() {
        Select currencyList = new Select(driver.findElement(By.xpath("//select[contains(@class,'selectpicker')]")));

        if (currencyList.getFirstSelectedOption().getText().equals("usd"))
            currencyList.selectByVisibleText("US Dollar");
        else
            currencyList.selectByVisibleText("Euros");
    }

    public List<Map<String, String>> getCurrency() {
        List<Map<String, String>> currencyInfo = new ArrayList<>();

            List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            Map<String, String> currencyRow = new HashMap<>();

            for (WebElement col : cols) {
                if (col.getAttribute("class").equals("gk-currency"))
                    currencyRow.put("price", col.getText());
                else
                    currencyRow.put("subscription", col.getText());
            }
            currencyInfo.add(currencyRow);
        }
        return currencyInfo;
    }
}
