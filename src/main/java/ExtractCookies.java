import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtractCookies {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(
                "https://www.udemy.com/join/login-popup/?skip_suggest=1&locale=en_US&next=https%3A%2F%2Fwww.udemy.com%2Flogout%2F&response_type=html");
        // driver.findElement(By.xpath("//a[@data-purpose='header-login']")).click();
        driver.findElement(By.xpath("//input[@id='email--1']")).sendKeys("prajwalmszidane@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Rooneymails5*");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(5000);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of the cookies: " + cookies.size());

        for (Cookie cookie : cookies) {
            System.out.println("Name of the Cookie: " + cookie.getName());
            System.out.println("Value of the Cookie: " + cookie.getValue());
            System.out.println("Domain of the Cookie: " + cookie.getDomain());
            System.out.println("Expiry of the Cookie: " + cookie.getExpiry());
        }

        driver.close();
    }

}