package testcases.nopcommerce.account;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Account_01_Register {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Register_01_Empty_Data() {

    }

    @Test
    public void Register_02_Invalid_Email() {

    }

    @AfterClass
    public void afterClass(){

    }

}
