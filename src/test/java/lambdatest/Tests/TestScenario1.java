package lambdatest.Tests;
import lambdatest.PageObjectModel.SimpleFormDemo;
import lambdatest.TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1 extends BaseTest {

    SimpleFormDemo simpleFormDemo;
    @Test(timeOut = 20000)
    public void validateUrl(){
        simpleFormDemo = seleniumPlaygroundPage.openSimpleFormDemo();
        boolean contains = simpleFormDemo.validateFormDemoUrl();
        if (contains){
            status = true;
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }else{
            status = false;
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }
        Assert.assertTrue(contains);
    }

    @Test(dependsOnMethods = {"validateUrl"},timeOut = 20000)
    public void validateMessage(){
        String msg = "Welcome To LambdaTest";
        simpleFormDemo.setMsg(msg);
        simpleFormDemo.clickMsgButton();
        String getMsg = simpleFormDemo.displayedMessage();
        if (getMsg.equals(msg)){
            status = true;
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }else{
            status = false;
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }

        Assert.assertEquals(getMsg,msg);

    }

}
