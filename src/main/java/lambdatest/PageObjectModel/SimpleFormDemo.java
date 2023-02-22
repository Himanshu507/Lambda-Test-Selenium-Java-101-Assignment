package lambdatest.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemo {


    public WebDriver driver;

    public SimpleFormDemo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-message")
    WebElement msgElement;

    @FindBy(xpath = "//button[text()='Get Checked value']")
    WebElement checkMsgButton;

    @FindBy(id = "message")
    WebElement displayedMsgElement;


    public boolean validateFormDemoUrl(){
        return driver.getCurrentUrl().contains("simple-form-demo");
    }

    public void setMsg(String msg){
        msgElement.sendKeys(msg);
    }

    public void clickMsgButton(){
        checkMsgButton.click();
    }

    public String displayedMessage(){
        String msg = displayedMsgElement.getText();
        return msg;
    }


}
