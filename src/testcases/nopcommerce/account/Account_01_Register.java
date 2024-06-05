package testcases.nopcommerce.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Account_01_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phat");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("abc@gmail@");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Invalid_Confirm_Password() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phat");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1234");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");

    }


    @Test
    public void Register_04_Success() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phat");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailRandom());
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "abc" + rand.nextInt(999) + "@gmail.com";
    }
}
