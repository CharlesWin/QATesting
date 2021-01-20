package com.galaykovskiy.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
public class TestCalculation {
    @DataProvider(name = "numbers-test")
    public Object[][] numbersTest(){
        return new Object[][]{
                {4, 3, new int[]{7, 1, 12}},
                {5, 5, new int[]{10, 0, 25}},
                {6, 10, new int[]{16, -4, 60}}
        };
    }

    @Test(dataProvider = "numbers-test")
    public void testSum(int a, int b, int[] expected) {
        Assert.assertEquals(a + b, expected[0]);
        log.info(expected[0] + " was expected, and actual: " + (a + b));
    }

    @Test(dataProvider = "numbers-test")
    public void testMinus(int a, int b, int[] expected){
        Assert.assertEquals(a - b, expected[1]);
        log.info(expected[1] + " was expected, and actual: " + (a - b));
    }

    @Test(dataProvider = "numbers-test")
    public void testMultiplied(int a, int b, int[] expected){
        Assert.assertEquals(a * b, expected[2]);
        log.info(expected[2] + " was expected, and actual: " + (a * b));
    }
}
