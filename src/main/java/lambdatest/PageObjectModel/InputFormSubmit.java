package lambdatest.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InputFormSubmit {

    WebDriver driver;

    public InputFormSubmit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtnElement;

    @FindBy(id = "name")
    WebElement nameElement;

    @FindBy(id = "inputEmail4")
    WebElement emailElement;

    @FindBy(id = "inputPassword4")
    WebElement passElement;

    @FindBy(id = "company")
    WebElement companyElement;

    @FindBy(id = "websitename")
    WebElement websiteElement;

    @FindBy(xpath = "//select[@name='country']")
    WebElement countryElement;

    @FindBy(id = "inputCity")
    WebElement cityElement;

    @FindBy(id = "inputAddress1")
    WebElement addressElement1;

    @FindBy(id="inputAddress2")
    WebElement addressElement2;

    @FindBy(id="inputState")
    WebElement stateElement;

    @FindBy(id="inputZip")
    WebElement zipcodeElement;

    @FindBy(css = "p.success-msg")
    WebElement successElement;

    public String clickBlankSubmitButton(){
        submitBtnElement.click();
        String msg = nameElement.getAttribute("validationMessage");
        return msg;
    }


    public String setData(String name, String email, String pass, String company, String website, String country, String city, String add1, String add2, String state, String zip){
        nameElement.clear();
        nameElement.sendKeys(name);
        emailElement.clear();
        emailElement.sendKeys(email);
        passElement.clear();
        passElement.sendKeys(pass);
        companyElement.clear();
        companyElement.sendKeys(company);
        websiteElement.clear();
        websiteElement.sendKeys(website);

        Select select = new Select(countryElement);
        select.selectByVisibleText(country);
        cityElement.clear();
        cityElement.sendKeys(city);
        addressElement1.clear();
        addressElement1.sendKeys(add1);
        addressElement2.clear();
        addressElement2.sendKeys(add2);
        stateElement.clear();
        stateElement.sendKeys(state);
        zipcodeElement.clear();
        zipcodeElement.sendKeys(zip);
        submitBtnElement.click();

        return successElement.getText();
    }


}
