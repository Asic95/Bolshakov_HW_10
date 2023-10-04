package Home_work_10;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Bolshakov_HW_10 extends BaseTestClass {

    @DataProvider
    public Object[][] frameNames() {
        return new Object[][]{{"frame-left","LEFT"}, {"frame-middle","MIDDLE"}, {"frame-right","RIGHT"}, {"frame-bottom","BOTTOM"}};
    }

    @Test(priority = 1, dataProvider = "frameNames")
    public void checkTextInFrames(String framesPath, String framesName) {

        for (int i=0; i < frameNames().length; i++) {
            frameSwitcher(framesPath, framesName);
            String body = driver.findElement(By.xpath("//body")).getText();
            Assert.assertEquals(body, framesName, "Can`t find frame with parameter " + framesName + ". ");
        }
    }
}
