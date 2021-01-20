package com.galaykovskiy.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@Slf4j
public class TestSamsung {
    @BeforeClass
    public void beforeClass() {
        log.trace("Before Class 1");
    }

    @BeforeSuite
    public void beforeSuite() {
        log.info("Before Suite 1");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        log.info("Before Method 1");
    }

    @BeforeTest
    public void beforeTest() {
        log.info("Before Test 1");
    }

    @BeforeGroups(groups = "samsung")
    public void beforeGroup() {
        log.info("Before group 1");
    }

    @Test(groups = "samsung")
    public void testS20() {
        log.info("Test S20");
    }

    @Test(groups = "samsung")
    public void testS21() {
        log.info("Test S21");
    }

    @Test(groups = "samsung")
    public void testA5() {
        log.warn("Test A5, deprecated model");
    }

    @Test
    public void testAndroid() {
        log.info("Test android system");
    }

    @Test (dependsOnGroups = {"iphone", "samsung"})
    public void testChineseCopy() {
        log.info("Made in China");
    }

    @AfterClass
    public void afterClass() {
        log.info("After Class 1");
    }

    @AfterTest
    public void afterTest() {
        log.info("After Test 1");
    }

    @AfterSuite(description = "Test description")
    public void afterSuite() {
        log.info("After Suite 1");
    }

    @AfterGroups(groups = "samsung")
    public void afterGroups() {
        log.info("After group. Charge samsung");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        log.trace("After Method 1");
    }
}
