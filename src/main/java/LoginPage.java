import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "login-button")
    private WebElement loginButton;
    @FindBy (xpath = "//div[@class='message-error']//span")
    private WebElement massageError;
    @FindBy (xpath = "//span[@class='field-validation-error']//span")
    private WebElement fieldError;
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String getMessageError (){
        return massageError.getText();
    }
    public String getFieldError (){
        return fieldError.getText();
    }
}
