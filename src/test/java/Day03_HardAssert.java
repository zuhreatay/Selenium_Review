import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void HardAssert(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();

        // contains - bir string ifadenin içerisinde diğer bir string ifadenin
        //        //            geçip geçmediğini kontrol ediyordu.
        //        // "Merhaba Dünya !" -> contains("Dünya") TRUE FALSE

        if(title.contains("Car")){
            System.out.println("GECIYOR "+ title);
        }else{
            System.out.println("GEÇMİYOR : " +title);
        }


        boolean IceriyorMu= title.contains("Car");
        Assert.assertTrue(IceriyorMu);
    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();
        // Sayfa başlığında Google kelimesinin geçmemesi durumunu kontrol ediyor.
        // Eğer GOOGLE kelimesi yoksa TEST BAŞARILI.
        // Eğer GOOGLE kelimesi varsa TEST BAŞARISIZ.

        Assert.assertFalse(title.contains("Google"));//false

    }
    @Test
    public void test3(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();

        // iki farklı değeri karşılaştırıyorsunuz
        // String, boolean, int, long, float


        Assert.assertEquals("Amazon.com",title);

        // Bizim beklentimiz : Amazon.com
        // Gerçek Durum      : Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

    }


}
