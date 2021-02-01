package com.galaykovskiy.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class TestWebSite {
    @BeforeClass
    public void openDriver() {
        log.trace("Open chrome driver");
    }

    @Test (priority = 1)
    public void testLogin(){
        String str = "asd";
        log.info("Login was successfully!");
    }

    @Test
    public void testConnWebSite() {
        log.info("Connection was successfully!");
    }

    @Test (priority = 2)
    public void testDoSmth(){
        log.info("Do something;)");
    }

    @Test
    public void testLogout(){
        log.error("Failed to log out");
    }

    @AfterClass
    public void closeDriver() {
        log.trace("Close chrome driver");
    }
}
