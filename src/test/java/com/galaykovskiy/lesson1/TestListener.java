package com.galaykovskiy.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

@Slf4j
public class TestListener implements ITestListener {
    private int testsCount;
    private int highQualityCount;

    @Override
    public void onTestStart(ITestResult result) {
        testsCount++;
        log.info("Tests count:\t" + testsCount);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (Arrays.asList(result.getMethod().getGroups()).contains("iphone"))
            log.info("High quality count:\t" + ++highQualityCount);
    }
}
