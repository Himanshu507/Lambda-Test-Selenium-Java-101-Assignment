package lambdatest.Tests;
import lambdatest.PageObjectModel.SimpleFormDemo;
import lambdatest.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1 extends BaseTest {

    SimpleFormDemo simpleFormDemo;
    @Test
    public void validateUrl(){
        simpleFormDemo = seleniumPlaygroundPage.openSimpleFormDemo();
        boolean contains = simpleFormDemo.validateFormDemoUrl();
        Assert.assertTrue(contains);
    }

    @Test(dependsOnMethods = {"validateUrl"})
    public void validateMessage(){
        String msg = "Welcome To LambdaTest";
        simpleFormDemo.setMsg(msg);
        simpleFormDemo.clickMsgButton();
        Assert.assertEquals(simpleFormDemo.displayedMessage(),msg);
    }

}
