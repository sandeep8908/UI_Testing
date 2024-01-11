package testing.test;

import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.UploadPage;

public class UploadAndDownloadTest extends BaseClass {
    @Test
    public void uploadTest() {
        UploadPage uploadPage = new UploadPage(driver);

        uploadPage.uploadFile();

        uploadPage.clickOnTermsAndCondition();

        uploadPage.clickOnSubmitButton();

    }
    @Test
    public void downloadTest(){

    }
}
