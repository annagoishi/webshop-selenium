import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "gender-male")
    private WebElement genderMale;
    @FindBy (id = "FirstName")
    private WebElement firstNameField;
    @FindBy (id = "LastName")
    private WebElement lastNameField;
    @FindBy (id = "Email")
    private WebElement emailField;
    @FindBy(id = "Password")
    private WebElement passwordInputField;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInputField;
    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy (xpath = "//span[@class='field-validation-error']/span")
    private WebElement fieldValidationError;
    public String getValidationErrorText (){
        return fieldValidationError.getText();
    }

    public void choseGenderMale(){
        genderMale.click();
    }
    public void enterFirstName(String firstNameValue){
        firstNameField.sendKeys(firstNameValue);
    }
    public void enterLastName (String lastNameValue){
        lastNameField.sendKeys(lastNameValue);
    }
    public void enterEmail (String emailValue){
        emailField.sendKeys(emailValue);
    }
    public void enterPassword (String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }
    public void enterConfirmPassword (String confirmPasswordValue){
        confirmPasswordInputField.sendKeys(confirmPasswordValue);
    }
    public void clickOnRegisterButton(){
        registerButton.click();
    }
    public String registerUser(User user) {
        choseGenderMale();
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        String uniqueEmail = user.generateUniqueEmail();
        enterEmail(uniqueEmail);
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
        clickOnRegisterButton();
        return uniqueEmail;
    }
}
