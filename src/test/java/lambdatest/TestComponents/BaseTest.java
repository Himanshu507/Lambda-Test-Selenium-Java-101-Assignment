package lambdatest.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import lambdatest.PageObjectModel.SeleniumPlaygroundPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    //public WebDriver driver;
    public SeleniumPlaygroundPage seleniumPlaygroundPage;

    public String username = "h1235p";
    public String accesskey = "DionVbI11pwVpHEyyXHNiXjWmZNPDsyAHOCvchdzE0hmEISlOE";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;


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
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "SeleniumJava101Assignment");
        capabilities.setCapability("name", "SeleniumJava101Assignment");

        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.goTo();
    }
    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

}
