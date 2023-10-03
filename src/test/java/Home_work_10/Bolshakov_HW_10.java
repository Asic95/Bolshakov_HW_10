package Home_work_10;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Bolshakov_HW_10 extends BaseTestClass {

    @DataProvider
    public Object[][] frameNames() {
        return new Object[][]{{"LEFT"}, {"MIDDLE"}, {"RIGHT"}, {"BOTTOM"}};
    }


    @Test(priority = 1, dataProvider = "frameNames", testName = "Left frame")
    public void frameLeft(String frameName) {

        frameSwitcher("left");
        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, frameName, "Can`t find frame with parameter " + frameName + ". ");
    }

    @Test(priority = 2, dataProvider = "frameNames", testName = "Middle frame")
    public void frameMiddle(String frameName) {

        frameSwitcher("middle");
        String body = driver.findElement(By.xpath("//body")).getText();
        //Assert.assertEquals(body, frameName);
        Assert.assertEquals(body, frameName, "can`t find frame with parameter " + frameName + ". ");
    }

    @Test(priority = 3, dataProvider = "frameNames", testName = "Right frame")
    public void frameRight(String frameName) {

        frameSwitcher("right");
        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, frameName, "can`t find frame with parameter " + frameName + ". ");
    }

    @Test(priority = 4, dataProvider = "frameNames", testName = "Bottom frame")
    public void frameBottom(String frameName) {

        frameSwitcher("bottom");
        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, frameName, "can`t find frame with parameter " + frameName + ". ");
    }
}
