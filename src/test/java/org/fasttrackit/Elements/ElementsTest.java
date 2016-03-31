package org.fasttrackit.Elements;


import org.fasttrackit.Example.ChangePasswordView;
import org.fasttrackit.Example.LoginPage;
import org.fasttrackit.Example.NavigationBarPage;
import org.fasttrackit.Forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ElementsTest extends TestBase {


    @Test
    public void checkBoxtext() {
        openPage();
        FirstFormView form = new FirstFormView();
        form.stopProcessCheckbox.assertClick();
        form.enterCheckbox.assertClick();

    }


    private void openPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");

    }
}
