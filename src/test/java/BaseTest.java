import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver = new ChromeDriver();
    String BASE_URL = "https://demowebshop.tricentis.com/register";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/annganzha/Documents/chromedriver-mac-x64/chromedriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    User newUser = new User("Jack", "Jonson", "", "Jack1234!");
}
