package lambdatest.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    RemoteWebDriver driver;
    //public WebDriver driver;

    public AbstractComponent(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUp( Duration duration){
        WebDriverWait wait = new WebDriverWait(driver,duration);
        //wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span#exit_popup_close"))));
    }

}
