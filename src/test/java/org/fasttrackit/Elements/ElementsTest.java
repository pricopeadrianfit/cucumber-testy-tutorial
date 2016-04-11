package org.fasttrackit.Elements;


import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.bootstrap.form.TextField;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.PropertiesReader;
import org.fasttrackit.Example.ChangePasswordView;
import org.fasttrackit.Example.DropDownList;
import org.fasttrackit.Example.LoginPage;
import org.fasttrackit.Example.NavigationBarPage;
import org.fasttrackit.Forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.Keys;
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

    private Form form = new Form("Form Title");
    private UploadFile uploadBtn = new UploadFile(form).setLabel("TPT Test:");
    @Test
    public void uploadTest() {

        openPage();
        String resourcesPath = PropertiesReader.RESOURCES_DIRECTORY_PATH;
        System.out .println(resourcesPath);
        uploadBtn.upload(resourcesPath + "\\feature\\login\\login.feature");

    }

    private void openPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");

    }


    @Test
    public void gmailtesting(){
        driver.get("https://gmail.com");
        com.sdl.selenium.web.form.TextField emailField = new com.sdl.selenium.web.form.TextField().setPlaceholder("Enter your email");
        emailField.setValue("adrianno986");

        emailField.sendKeys(Keys.ENTER); //apasarea unei taste

    }
}
