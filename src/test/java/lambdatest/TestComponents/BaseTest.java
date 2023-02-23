package lambdatest.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import lambdatest.PageObjectModel.SeleniumPlaygroundPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {

    //public WebDriver driver;
    public SeleniumPlaygroundPage seleniumPlaygroundPage;

    public String username = "h1235p";
    public String accesskey = "DionVbI11pwVpHEyyXHNiXjWmZNPDsyAHOCvchdzE0hmEISlOE";
    public RemoteWebDriver driver = null;
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
    /**
     * @param browser
     * @param version
     * @param platform
     */
    @Parameters({ "browser", "version", "platform"})
    @BeforeClass(alwaysRun = true)
    public void setup(String browser, String version, String platform){
        String browserName = browser;//"chrome";
//        if(System.getProperty("browser")!=null){
//            browserName = System.getProperty("browser");
//        }

        String browserVersion = version;//"88.0";
//        if(System.getProperty("browserVersion")!=null){
//            browserVersion = System.getProperty("browserVersion");
//        }

        String platformName = platform;//"win10";
//        if(System.getProperty("platform")!=null){
//            platformName = System.getProperty("platform");
//        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", platformName); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "SeleniumJava101Assignment");
        capabilities.setCapability("name", "SeleniumJava101Assignment");
        capabilities.setCapability("network",true);
        capabilities.setCapability("selenium_version", "4.0.0");
        capabilities.setCapability("visual",true);
        capabilities.setCapability("video",true);
        capabilities.setCapability("console",true);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver.manage().window().maximize();
        seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.goTo();
    }
    @AfterClass(alwaysRun = true)
    public void teardown(){
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }

}
