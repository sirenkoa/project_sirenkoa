import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class test {
    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\MY\\QA ITEA\\QA automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        By callBackBtyn = By.cssSelector(".callback-btn");

        wait.until(ExpectedConditions.elementToBeClickable(callBackBtyn));
        driver.findElement(By.cssSelector(".callback-btn")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("b-contacte__full-name")));
        driver.findElement(By.id("b-contacte__full-name")).sendKeys("testAndrii");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("b-contacte-phone-tel")));
        driver.findElement(By.id("b-contacte-phone-tel")).click();
        driver.findElement(By.id("b-contacte-phone-tel")).sendKeys("0501112233");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Надіслати']")));
        driver.findElement(By.xpath("//input[@value='Надіслати']")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='b-header-contacte-phone-thank']")));
        String masseges = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank']")).getText();
        //System.out.println(masseges);
        assertEquals(masseges, "Дякуємо!\n Наш менеджер зв'яжеться з Вами." , "Дякуємо!\n Наш менеджер зв'яжеться з Вами.");
        driver.quit();




    }

}
