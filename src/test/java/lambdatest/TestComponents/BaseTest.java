package lambdatest.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import lambdatest.PageObjectModel.SeleniumPlaygroundPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    public SeleniumPlaygroundPage seleniumPlaygroundPage;

    public void intialize_driver(){

        String browser = "chrome";
        if(System.getProperty("browser")!=null){
            browser = System.getProperty("browser");
        }
        if (browser.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browser.equalsIgnoreCase("chromeheadless")){
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browser.contains("firefox")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    //@BeforeTest(alwaysRun = true)
    @BeforeClass(alwaysRun = true)
    public void setup(){
        intialize_driver();
        seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.goTo();
    }
    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

}
