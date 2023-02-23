package lambdatest.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropSlider {

    RemoteWebDriver driver;

    //public WebDriver driver;
    public DragAndDropSlider(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "slider3")
    WebElement sliderElement;

    public void setValue(int value){
        WebElement input_slide = sliderElement.findElement(By.tagName("input"));
        for (int i = 1; i <= value - 15 ; i++) {
            input_slide.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public Integer getValue(){
        WebElement valueElement = sliderElement.findElement(By.tagName("output"));
        return Integer.valueOf(valueElement.getText());
    }

}
