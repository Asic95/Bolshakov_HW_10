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
        frameSwitcher("default"); //повернення до дефолтного фрейму
        Thread.sleep(200); // пауза перед виконанням наступного тесту
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public void frameSwitcher(String framesName) {
        switch (framesName) {
            case "left": {
                driver.switchTo().frame("frame-top");
                driver.switchTo().frame("frame-left");
                break;
            }
            case "middle": {
                driver.switchTo().frame("frame-top");
                driver.switchTo().frame("frame-middle");
                break;
            }
            case "right": {
                driver.switchTo().frame("frame-top");
                driver.switchTo().frame("frame-right");
                break;
            }
            case "bottom": {
                driver.switchTo().frame("frame-bottom");
                break;
            }
            case "default": {
                driver.switchTo().defaultContent();
                break;
            }

        }

    }

}
