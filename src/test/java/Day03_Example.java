import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Example {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // 1. DropDown'da Books kategorisini seçelim.
// 2. Arama kutusuna JAVA yazalım.
// 3. Toplam sonuç sayısını ekrana yazdıralım.
// 4. İlk sıradaki ürüne tıklayalım.
// 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
    //      pass        fail

    @Test
    public void amazonDropdownTest(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");
        WebElement bookSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        bookSearchBox.sendKeys("Java");
        bookSearchBox.submit();
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Toplam cikan sonuc: "+result.getText());

        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
        WebElement backToResultLinki = driver.findElement(By.partialLinkText("Back to results"));
        boolean varMi = backToResultLinki.isDisplayed();
        Assert.assertTrue(varMi); // TRUE gelirse, TESTİM başarılı


    }

}
