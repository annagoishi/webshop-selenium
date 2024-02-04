import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Categories extends BasePage{
    public Categories (WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[href='/books']")
    private WebElement booksButton;
    public WebElement getBooksButton() {
        return booksButton;
    }
    public void clickOnBooksButton(){
        clickOnElement(booksButton);
    }
}
