import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest{
    @Test
    public void successRegistration(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Jack");
        registrationPage.enterLastName("Jackson");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Jack12345!");
        registrationPage.enterConfirmPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
    }
    @Test
    public void registrationWithoutConfirmPassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Jack");
        registrationPage.enterLastName("Jackson");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        assertEquals("Password is required.", registrationPage.getValidationErrorText());
    }
    @Test
    public void registrationWithoutEmail(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Jack");
        registrationPage.enterLastName("Jackson");
        registrationPage.enterPassword("Jack12345!");
        registrationPage.enterConfirmPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        assertEquals("Email is required.", registrationPage.getValidationErrorText());
    }
    @Test
    public void registrationWithoutFirstName(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterLastName("Jackson");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Jack12345!");
        registrationPage.enterConfirmPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        assertEquals("First name is required.", registrationPage.getValidationErrorText());
    }
    @Test
    public void registrationWithoutLastName(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Jack");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Jack12345!");
        registrationPage.enterConfirmPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        assertEquals("Last name is required.", registrationPage.getValidationErrorText());
    }
    @Test
    public void registrationWithoutPassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Jack");
        registrationPage.enterLastName("Jackson");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterConfirmPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        assertEquals("Password is required.", registrationPage.getValidationErrorText());
    }
    @Test
    public void registrationWithWrongPassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.choseGenderMale();
        registrationPage.enterFirstName("Jack");
        registrationPage.enterLastName("Jackson");
        String uniqueEmail = "user_" + UUID.randomUUID();
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Jack12345!");
        registrationPage.enterConfirmPassword("Jack12345!");
        registrationPage.clickOnRegisterButton();
        assertEquals("Wrong email", registrationPage.getValidationErrorText());
    }

}
