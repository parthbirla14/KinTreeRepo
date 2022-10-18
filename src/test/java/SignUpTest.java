import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {
public WebDriver driver;
    @BeforeMethod
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://kintree.com/register");

    }
    @AfterMethod
    public void Close(){
        driver.quit();

    }
    @Test
    public void signUp(){
        // Text Field component
        driver.findElement(By.name("f_name")).sendKeys("parth");
        driver.findElement(By.id("l_name")).sendKeys("birla");
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("Qwerty123@yopmail.com");
        driver.findElement(By.name("username")).sendKeys("parth14");
        driver.findElement(By.id("password")).sendKeys("Qwerty@123");
        driver.findElement(By.id("conf_pass")).sendKeys("Qwerty@123");
        // Dropdown for DOB
        WebElement dateDropdown= driver.findElement(By.id("birth_day"));
        Select dropdown1 =new Select(dateDropdown);
        dropdown1.selectByIndex(14);
        System.out.println(dropdown1.getFirstSelectedOption().getText());
        WebElement monthDropdown= driver.findElement(By.id("birth_month"));
        Select dropdown2 =new Select(monthDropdown);
        dropdown2.selectByIndex(9);
        System.out.println(dropdown2.getFirstSelectedOption().getText());
        WebElement yearDropdown= driver.findElement(By.xpath("//select[@id='birth_year']"));
        Select dropdown3 =new Select(yearDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].value='1990'", yearDropdown);

        //Gender
        WebElement genderDropdown= driver.findElement(By.xpath("//select[@id='gender']"));
        Select gender =new Select(genderDropdown);
        gender.selectByVisibleText("Male");
        System.out.println(gender.getFirstSelectedOption().getText());
           //Click on Signup
        driver.findElement(By.xpath("//button[@id='signup']")).click();
        Assert.assertEquals("Verification","Verification");

    }
    }


