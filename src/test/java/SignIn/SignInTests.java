package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTests {
    private WebDriver driver;
    @BeforeClass
    public void setUp () throws InterruptedException {
        //import chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //input the webpage url
        driver.get ("https://www.opinionworld.com/login");
        //wait for 5 seconds
        Thread.sleep(5000);
        //maximize the window
        driver.manage ().window ().maximize ();
        System.out.println (driver.getTitle ());
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("opeyemirabiatt@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Opeyemi@6");
        //locate button field
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/div[5]/input")).click();
    }
    @Test(priority = 0)
    public void testSuccessfulLogin() {
        if (driver.getCurrentUrl ().contains ("https://www.opinionworld.com/auth/dashboard"))
            //Pass
            System.out.println ("The Page URL contains dashboard");
        else
            //Fail
            System.out.println ("The Page URL does not contains dashboard");
    }
    public static void main (String[] args) throws InterruptedException {
        SignIn.SignInTests test = new SignIn.SignInTests();
        test.setUp();
    }
    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the profile button
        driver.findElement(By.xpath ("//*[@id=\"accountLabel\"]/span[2]")).click();
        Thread.sleep (2000);
        //click on the logout button
        driver.findElement(By.xpath("/html/body/div[3]/header[1]/div/div[3]/div/div[3]/a[5]"));
        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://www.opinionworld.com/index"))
            //Pass
            System.out.println ("The Login page passed ");
        else
            //Fail
            System.out.println ("The login page failed ");
    }
    @AfterClass
    public void tearDown() {
        driver.quit ();
    }
}