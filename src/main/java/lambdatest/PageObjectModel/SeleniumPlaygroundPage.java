package lambdatest.PageObjectModel;

import lambdatest.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import java.time.Duration;

public class SeleniumPlaygroundPage extends AbstractComponent {

    RemoteWebDriver driver;

    //public WebDriver driver;
    public SeleniumPlaygroundPage(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//a[contains(text(),'Simple Form Demo')]")
    WebElement simpleFormDemoElement;

    @FindBy(xpath = "//a[contains(text(),'Drag & Drop Sliders')]")
    WebElement dragAndDropElement;

    @FindBy(xpath = "//a[contains(text(),'Input Form Submit')]")
    WebElement inputFormSubmitElement;


    public void goTo(){
        driver.get("https://www.lambdatest.com/selenium-playground");
        popUpClose();
    }

    public void popUpClose() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("var event = new MouseEvent('mouseleave', {view: window, bubbles: true, cancelable: true}); document.body.dispatchEvent(event);");
        js.executeScript("setTimeout(function() { var event = new MouseEvent('mouseleave', {view: window, bubbles: true, cancelable: true}); document.body.dispatchEvent(event); }, 1000);");

        Actions action = new Actions(driver);
        waitForPopUp(Duration.ofSeconds(10));
        action.moveToElement(driver.findElement(By.cssSelector("span#exit_popup_close"))).click().perform();
    }

    public SimpleFormDemo openSimpleFormDemo(){
        simpleFormDemoElement.click();
        return new SimpleFormDemo(driver);
    }

    public DragAndDropSlider openDragAndDrop(){
        dragAndDropElement.click();
        return new DragAndDropSlider(driver);
    }

    public InputFormSubmit openInputFormSubmit(){
        inputFormSubmitElement.click();
        return new InputFormSubmit(driver);
    }
}
