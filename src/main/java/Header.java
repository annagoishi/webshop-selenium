import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage{
    public Header (WebDriver driver) {
        super(driver);
    }
    @FindBy (className = "ico-logout")
    private WebElement logoutButton;
    @FindBy (className = "ico-login")
    private WebElement loginButton;
    @FindBy (className = "account")
    private WebElement existUserEmail;
    public void clickOnLogoutButton(){
        clickOnElement(logoutButton);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String getExistUserEmail (){
        return existUserEmail.getText();
    }
}
