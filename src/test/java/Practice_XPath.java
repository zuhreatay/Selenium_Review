import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice_XPath {
   static  WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test01(){

        driver.get("http://a.testaddressbook.com/");

        WebElement signIn= driver.findElement(By.linkText("Sign in"));
        signIn.click();

        //tagname'i a olan webelementler linktir

        List<WebElement> allLinkText= driver.findElements(By.tagName("a"));
        for (WebElement t : allLinkText)
        System.out.println("Linkler: "+ t.getText());

        WebElement emailTestBox = driver.findElement(By.cssSelector("#session_email"));
        emailTestBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordTestBox= driver.findElement(By.cssSelector("#session_password"));
        passwordTestBox.sendKeys("Test1234!");
        WebElement signInTest= driver.findElement(By.cssSelector(".btn.btn-primary"));
        signInTest.click();

        WebElement tumYazilar = driver.findElement(By.tagName("body"));
        System.out.println(tumYazilar.getText());

//        List<WebElement> list = driver.findElements(By.xpath("//*"));
//        for(WebElement w : list){
//            System.out.println(w.getText()); bu yontem tum hepsini yazar, tercih edilmez
//        }

    }
    @AfterClass
    public static void tearDown(){
       driver.quit();
    }
}
