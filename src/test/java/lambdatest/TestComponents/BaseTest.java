package lambdatest.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import lambdatest.PageObjectModel.SeleniumPlaygroundPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    public SeleniumPlaygroundPage seleniumPlaygroundPage;

    public void intialize_driver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeTest(alwaysRun = true)
    public void setup(){
        intialize_driver();
        seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.goTo();
    }
    @AfterTest(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

}
