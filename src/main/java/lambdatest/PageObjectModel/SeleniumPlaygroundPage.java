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
    WebElement simple_form_demo;

    @FindBy(xpath = "//a[contains(text(),'Drag & Drop Sliders')]")
    WebElement dragAndDropElement;


    public void goTo(){
        driver.get("https://www.lambdatest.com/selenium-playground");
    }

    public SimpleFormDemo openSimpleFormDemo(){
        simple_form_demo.click();
        return new SimpleFormDemo(driver);
    }

    public DragAndDropSlider openDragAndDrop(){
        dragAndDropElement.click();
        return new DragAndDropSlider(driver);
    }
}
