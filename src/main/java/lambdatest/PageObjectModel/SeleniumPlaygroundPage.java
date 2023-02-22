package lambdatest.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class SeleniumPlaygroundPage {

    WebDriver driver;

    public SeleniumPlaygroundPage(WebDriver driver) {
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
