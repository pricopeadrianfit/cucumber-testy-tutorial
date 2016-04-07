package org.fasttrackit.Elements;


import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.WebLocator;
import org.fasttrackit.Example.ChangePasswordView;
import org.fasttrackit.Example.DropDownList;
import org.fasttrackit.Example.LoginPage;
import org.fasttrackit.Example.NavigationBarPage;
import org.fasttrackit.Forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTest extends TestBase {


    @Test
    public void checkBoxtext() {
        openPage();
        FirstFormView form = new FirstFormView();
        form.stopProcessCheckbox.assertClick();
        form.enterCheckbox.assertClick();

    }

    @Test
    public void checkLabel() {
        openPage();
        FirstFormView form = new FirstFormView();
        form.stopProcessLabel.assertClick();
        form.enterLabel.assertClick();

    }

    @Test
    public void selectTest () {
        openPage();
        SelectPicker picker = new SelectPicker().setLabel("Tech:");

        String v = picker.getValue();
        Assert.assertEquals(v,"Auto");

        picker.select("Manual");
        v = picker.getValue();
        Assert.assertEquals(v,"Manual");

    }

    @Test
    public void dropDownTest() {

        openPage();
        DropDownList downList = new DropDownList().setLabel("Tech:");
        System.out.println(">"+ downList.getValue() + "<" );
        downList.select("Manual");
        System.out.println(">"+ downList.getValue() + "<" );

        DropDownList executeDownList = new DropDownList().setLabel("Execute");
        downList.select("No");

    }


    private void openPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");

    }
}
