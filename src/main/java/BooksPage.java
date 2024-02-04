import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BooksPage extends BasePage {
    public BooksPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "products-pagesize")
    private WebElement quantityDropdown;
    @FindBy(css = "[value='https://demowebshop.tricentis.com/books?pagesize=4']")
    private WebElement quantity4;
    @FindBy(css = "[value='https://demowebshop.tricentis.com/books?pagesize=8']")
    private WebElement quantity8;
    @FindBy(css = "[value='https://demowebshop.tricentis.com/books?pagesize=12']")
    private WebElement quantity12;
    @FindBy(css = "[value='https://demowebshop.tricentis.com/books?pagesize=20']")
    private WebElement quantity20;
    @FindBy (className = "product-item")
    private List<WebElement> quantityOfBooks;
    public boolean isOptionSelected(String optionValue) {
        By optionSelector = By.cssSelector("option[value='" + optionValue + "'][selected='selected']");
        WebElement selectedOption = driver.findElement(optionSelector);
        return selectedOption.isSelected();
    }
    public void clickOnDropdown(){
        clickOnElement(quantityDropdown);
    }
    public int checkQuantityOfBooks(){
        return quantityOfBooks.size();
    }
    public boolean checkVisibilityOfBooks(){
        boolean allBooksAreVisible = true;
        for (WebElement book :quantityOfBooks) {
            if (!book.isDisplayed()) {
                allBooksAreVisible = false;
            }
        }
        return allBooksAreVisible;
    }
    public void clickOn4FromDropdown(){
        clickOnElement(quantity4);
    }
    public void clickOn8FromDropdown(){
        clickOnElement(quantity8);
    }
    public void clickOn12FromDropdown(){
        clickOnElement(quantity12);
    }
    public void clickOn20FromDropdown(){
        clickOnElement(quantity20);
    }
}
