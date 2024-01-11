package testing.test;

import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.HomePage;
import testing.page.SignInPage;

import static org.testng.Assert.assertTrue;

public class SignInPageTest extends BaseClass {

    @Test
    public void signInTestWithValidCredentials() {
        HomePage homePage = new HomePage(driver);

        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);

        assertTrue(signInPage.isPageOpened());
        signInPage.signIn("sandeep.birla@liseinfotech.com", "Sandeep@6485");
    }

    @Test
    public void testSignInWithInvalidPassword() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);

        assertTrue(signInPage.isPageOpened());
        signInPage.signIn("sandeep.birla@liseinfotech.com", "Sandeep@");

        assertTrue(signInPage.errorMessageIsVisible());
    }
}
