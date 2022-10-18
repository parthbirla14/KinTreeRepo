package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignupPage {
    // username -//input[@id='f_name']
    //$x("//input[@id='l_name']")
    //$x("//input[@id='user_email']")
    //$x("//input[@name='username']")
    //id=password
    //conf_pass
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://kintree.com/register");
        driver.findElement(By.name("f_name")).sendKeys("parth");
        driver.findElement(By.id("l_name")).sendKeys("birla");
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("Qwerty123@yopmail.com");
        driver.findElement(By.name("username")).sendKeys("parth14");
        driver.findElement(By.id("password")).sendKeys("Qwerty@123");
        driver.findElement(By.id("conf_pass")).sendKeys("Qwerty@123");
        WebElement dateDropdown= driver.findElement(By.id("birth_day"));
        Select dropdown1 =new Select(dateDropdown);
        dropdown1.selectByIndex(14);
        System.out.println(dropdown1.getFirstSelectedOption().getText());
        WebElement monthDropdown= driver.findElement(By.id("birth_month"));
        Select dropdown2 =new Select(monthDropdown);
        dropdown2.selectByIndex(9);
        System.out.println(dropdown2.getFirstSelectedOption().getText());

        WebElement yearDropdown= driver.findElement(By.xpath("//select[@id='birth_year']"));
       // yearDropdown.click();
      //  Thread.sleep(3000);
      //  Select dropdown3 =new Select(yearDropdown);

      //  dropdown2.selectByValue("1990");
      //  System.out.println(dropdown2.getFirstSelectedOption().getText());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='1990'", yearDropdown);


     WebElement genderDropdown= driver.findElement(By.xpath("//select[@id='gender']"));
     Select gender =new Select(genderDropdown);
        gender.selectByVisibleText("Male");
        System.out.println(gender.getFirstSelectedOption().getText());

    driver.findElement(By.xpath("//button[@id='signup']")).click();

    }

}
