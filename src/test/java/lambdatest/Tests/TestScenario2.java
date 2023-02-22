package lambdatest.Tests;

import lambdatest.PageObjectModel.DragAndDropSlider;
import lambdatest.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario2 extends BaseTest {

    @Test
    public void dragAndDrop(){
        DragAndDropSlider dragAndDropSlider = seleniumPlaygroundPage.openDragAndDrop();
        int value = 95;
        dragAndDropSlider.setValue(value);
        int getValue = dragAndDropSlider.getValue();
        Assert.assertEquals(getValue,value);
    }
}
