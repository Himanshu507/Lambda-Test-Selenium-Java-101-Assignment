package lambdatest.Tests;

import lambdatest.PageObjectModel.DragAndDropSlider;
import lambdatest.TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario2 extends BaseTest {

    @Test(timeOut = 20000)
    public void dragAndDrop(){
        DragAndDropSlider dragAndDropSlider = seleniumPlaygroundPage.openDragAndDrop();
        int value = 95;
        dragAndDropSlider.setValue(value);
        int getValue = dragAndDropSlider.getValue();
        if (value == getValue){
            status = true;
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }else {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }

        Assert.assertEquals(getValue,value);
    }
}
