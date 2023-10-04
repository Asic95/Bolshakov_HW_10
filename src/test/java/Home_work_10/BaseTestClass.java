package Home_work_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTestClass {

    private static final String URL = "https://the-internet.herokuapp.com/nested_frames";

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterMethod
    public void pauseBetweenTests() throws InterruptedException {
        Thread.sleep(250); // пауза перед виконанням наступного тесту
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public void frameSwitcher(String framesPath, String framesName) {
        switch (framesName) {
            case "LEFT", "MIDDLE", "RIGHT" -> {
                driver.switchTo().defaultContent();
                driver.switchTo().frame("frame-top");
                driver.switchTo().frame(framesPath);
            }
            case "BOTTOM" -> {
                driver.switchTo().defaultContent();
                driver.switchTo().frame(framesPath);
            }
        }

    }

}
