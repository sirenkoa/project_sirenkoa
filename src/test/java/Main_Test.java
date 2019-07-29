import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Main_Test {
    By callBackBtyn = By.cssSelector(".callback-btn");
    By full_name = By.id("b-contacte__full-name");
    By phone = By.id("b-contacte-phone-tel");
    By send = By.xpath("//input[@value='Надіслати']");
    By masseges_wi = By.xpath("//div[@class='b-header-contacte-phone-thank']");



    @Test
    public void main_test_Positive() {
       System.setProperty("webdriver.chrome.driver",
                    "D:\\MY\\QA ITEA\\QA automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://iteaua-develop.demo.gns-it.com/");


        wait.until(ExpectedConditions.elementToBeClickable(callBackBtyn));
        driver.findElement(By.cssSelector(".callback-btn")).click();

        wait.until(ExpectedConditions.elementToBeClickable(full_name));
        driver.findElement(full_name).sendKeys("testAndrii");

        wait.until(ExpectedConditions.elementToBeClickable(phone));
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys("0501112233");

        wait.until(ExpectedConditions.elementToBeClickable(send));
        driver.findElement(send).click();


        wait.until(ExpectedConditions.elementToBeClickable(masseges_wi));
        String masseges = driver.findElement(masseges_wi).getText();

        assertEquals(masseges, "Дякуємо!\n Наш менеджер зв'яжеться з Вами.", "Дякуємо!\n Наш менеджер зв'яжеться з Вами.");
        driver.quit();
    }
    @Test
    public void main_test_Negative () {
        System.setProperty("webdriver.chrome.driver",
                "D:\\MY\\QA ITEA\\QA automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://iteaua-develop.demo.gns-it.com/");


        wait.until(ExpectedConditions.elementToBeClickable(callBackBtyn));
        driver.findElement(By.cssSelector(".callback-btn")).click();

        wait.until(ExpectedConditions.elementToBeClickable(send));
        driver.findElement(send).click();

        String style = driver.findElement(By.id("b-contacte__full-name")).getAttribute("style");
        assertEquals(style, "border-color: red;", "border-color: red;");
        driver.quit();

    }


}