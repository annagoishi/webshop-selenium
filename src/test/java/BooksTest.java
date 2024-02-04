import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BooksTest extends BaseTest{
    @Test
    public void selecting4BooksIsCorrect() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Categories categories = new Categories(driver);
        categories.clickOnBooksButton();
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnDropdown();
        booksPage.clickOn4FromDropdown();
        assertEquals(4, booksPage.checkQuantityOfBooks());
        assertTrue(booksPage.checkVisibilityOfBooks());
    }
    @Test
    public void selecting8BooksIsCorrect() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        //assertEquals
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Categories categories = new Categories(driver);
        categories.clickOnBooksButton();
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnDropdown();
        booksPage.clickOn8FromDropdown();
        assertEquals(8, booksPage.checkQuantityOfBooks());
        assertTrue(booksPage.checkVisibilityOfBooks());
    }
    @Test
    public void selecting12BooksIsCorrect() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        //assertEquals
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Categories categories = new Categories(driver);
        categories.clickOnBooksButton();
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnDropdown();
        booksPage.clickOn12FromDropdown();
        assertEquals(12, booksPage.checkQuantityOfBooks());
        assertTrue(booksPage.checkVisibilityOfBooks());
    }
    @Test
    public void selecting20BooksIsCorrect() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        //assertEquals
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Categories categories = new Categories(driver);
        categories.clickOnBooksButton();
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnDropdown();
        booksPage.clickOn20FromDropdown();
        assertEquals(20, booksPage.checkQuantityOfBooks());
        assertTrue(booksPage.checkVisibilityOfBooks());
    }
    @Test
    public void checkSettingsAfterRefresh() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String generatedEmail = registrationPage.registerUser(newUser);
        //assertEquals
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Your registration completed", confirmationPage.getSuccessLoginText());
        Categories categories = new Categories(driver);
        categories.clickOnBooksButton();
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnDropdown();
        booksPage.clickOn4FromDropdown();
        assertEquals(4, booksPage.checkQuantityOfBooks());
        assertTrue(booksPage.checkVisibilityOfBooks());
        driver.navigate().refresh();
        assertTrue(booksPage.isOptionSelected("https://demowebshop.tricentis.com/books?pagesize=4"));
        assertEquals(4, booksPage.checkQuantityOfBooks());
        assertTrue(booksPage.checkVisibilityOfBooks());
    }
}
