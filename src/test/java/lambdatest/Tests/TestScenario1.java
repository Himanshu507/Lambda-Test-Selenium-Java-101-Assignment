package lambdatest.Tests;
import lambdatest.PageObjectModel.SimpleFormDemo;
import lambdatest.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1 extends BaseTest {

    SimpleFormDemo simpleFormDemo;
    @Test(timeOut = 20000)
    public void validateUrl(){
        simpleFormDemo = seleniumPlaygroundPage.openSimpleFormDemo();
        boolean contains = simpleFormDemo.validateFormDemoUrl();
        Assert.assertTrue(contains);
    }

    @Test(dependsOnMethods = {"validateUrl"},timeOut = 20000)
    public void validateMessage(){
        String msg = "Welcome To LambdaTest";
        simpleFormDemo.setMsg(msg);
        simpleFormDemo.clickMsgButton();
        Assert.assertEquals(simpleFormDemo.displayedMessage(),msg);
    }

}
