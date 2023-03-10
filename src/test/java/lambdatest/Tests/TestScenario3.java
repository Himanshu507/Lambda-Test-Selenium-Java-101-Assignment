package lambdatest.Tests;

import lambdatest.PageObjectModel.InputFormSubmit;
import lambdatest.TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScenario3 extends BaseTest {

    InputFormSubmit inputFormSubmit;

    @Test(timeOut = 20000)
    public void checkFieldsMsg() throws InterruptedException {
        inputFormSubmit = seleniumPlaygroundPage.openInputFormSubmit();
        //SoftAssert softassert = new SoftAssert();
        //softassert.assertEquals(inputFormSubmit.clickBlankSubmitButton(),"Please fill in the fields"); //Please fill in this field.
        String getMsg = inputFormSubmit.clickBlankSubmitButton();
        if (getMsg.equals("Please fill in the fields")){
            status = true;
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }else{
            status = false;
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }
        Assert.assertEquals(getMsg,"Please fill in the fields"); //Please fill in this field.

    }

    @Test(dependsOnMethods = {"checkFieldsMsg"},timeOut = 20000)
    public void SubmitData(){
        //InputFormSubmit inputFormSubmit = seleniumPlaygroundPage.openInputFormSubmit();
        String name = "Himanshu";
        String email = "h123p@gmail.com";
        String pass = "abc123";
        String company = "StudyExperts";
        String website = "Studyexperts.in";
        String country = "United States";
        String city = "New York";
        String add1 = "135 Park Avenue Block";
        String add2 = "135 Park Avenue Block";
        String state = "New York";
        String zip = "10001";
        String expected_success = "Thanks for contacting us, we will get back to you shortly.";
        String confirmationMsg = inputFormSubmit.setData(name,email,pass,company,website,country,city,add1,add2,state,zip);
        if (confirmationMsg.equals(expected_success)){
            status = true;
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }else{
            status = false;
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }
        Assert.assertEquals(confirmationMsg,expected_success);
    }


}
