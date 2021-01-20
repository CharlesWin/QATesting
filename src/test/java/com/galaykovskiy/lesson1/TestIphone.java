package com.galaykovskiy.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@Slf4j
@Listeners(TestListener.class)
public class TestIphone {
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

    @BeforeGroups(groups = "iphone")
    public void beforeGroup() {
        log.info("Before group 1");
    }

    @Test(groups = "iphone", enabled = false)
    public void testI3() {
        log.info("Test Iphone 3");
    }

    @Test(groups = "iphone")
    public void testI11() {
        log.info("Test Iphone 11");
    }

    @Test(groups = "iphone")
    public void testI12() {
        log.info("Test Iphone 12");
    }

    @Test(groups = "iphone", description = "Future model")
    public void testI13() {
        log.error("Test Iphone 13. Current model is not exist");
    }

    @Test
    public void testIOS(){
        log.info("Test IOS");
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

    @AfterGroups(groups = "car")
    public void afterGroups() {
        log.info("After Group. Charge Iphone");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        log.trace("After Method 1");
    }
}
