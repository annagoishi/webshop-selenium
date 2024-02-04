import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest{
    @Test
    public void successLoginWithExistUser() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Header header = new Header(driver);
        header.clickOnLogoutButton();
        header.clickOnLoginButton();
        registrationPage.enterEmail(generatedEmail);
        registrationPage.enterPassword(newUser.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        assertEquals(generatedEmail, header.getExistUserEmail());
    }
    @Test
    public void loginWithUppercasePassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Header header = new Header(driver);
        header.clickOnLogoutButton();
        header.clickOnLoginButton();
        registrationPage.enterEmail(generatedEmail);
        registrationPage.enterPassword(newUser.getPassword().toUpperCase());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        assertEquals("Login was unsuccessful. Please correct the errors and try again.", loginPage.getMessageError());
    }
    @Test
    public void loginWithWrongEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Header header = new Header(driver);
        header.clickOnLogoutButton();
        header.clickOnLoginButton();
        String emailWithoutAtSymbol = generatedEmail.replace("@", "");
        registrationPage.enterEmail(emailWithoutAtSymbol);
        registrationPage.enterPassword(newUser.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        assertEquals("Please enter a valid email address.", loginPage.getFieldError());
    }
    @Test
    public void loginWithEmptyFields(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Header header = new Header(driver);
        header.clickOnLogoutButton();
        header.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        assertEquals("Login was unsuccessful. Please correct the errors and try again.", loginPage.getMessageError());
    }
}
