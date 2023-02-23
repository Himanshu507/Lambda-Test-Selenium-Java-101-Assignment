package lambdatest.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropSlider {

    RemoteWebDriver driver;

    //public WebDriver driver;
    public DragAndDropSlider(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "slider3")
    WebElement sliderElement;

    public void setValue(int value) {
        WebElement input_slide = sliderElement.findElement(By.tagName("input"));
        // Get the slider dimensions
        int sliderWidth = input_slide.getSize().getWidth();
        int sliderHeight = input_slide.getSize().getHeight();

        // Calculate the desired slider position
        int targetValue = value - 2;
        int pixelsToMove = (int) Math.round((targetValue - 1) * (sliderWidth - 1) / (double) (99));
        int xOffset = pixelsToMove - sliderWidth / 2;
        int yOffset = sliderHeight / 2;

        // Use the Actions class to create a drag-and-drop action
        Actions sliderAction = new Actions(driver);
        sliderAction.clickAndHold(input_slide)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build()
                .perform();
    }

    public Integer getValue() {
        WebElement valueElement = sliderElement.findElement(By.tagName("output"));
        return Integer.valueOf(valueElement.getText());
    }

}
