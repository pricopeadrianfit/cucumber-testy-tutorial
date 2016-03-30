package org.fasttrackit.Example;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordView {


    private WebLocator title = new WebLocator().setText("Change Password");
    private WebLocator win = new WebLocator().setClasses("in", "modal").setChildNodes(title);


    private WebLocator currentPasswordField = new WebLocator(win).setName("password");
    private WebLocator newPasswordField = new WebLocator(win).setName("newPassword");
    private WebLocator repeatNewPasswordField = new WebLocator(win).setName("newPasswordRepeat");
    private WebLocator saveButton = new WebLocator(win).setText("Save");
    private WebLocator statusMsg = new WebLocator(win).setClasses("status-msg");
    private WebLocator closeButton = new WebLocator(win).setText("Close");


    public void changePassword(String currentPass, String newPass) {

        currentPasswordField.sendKeys(currentPass);
        newPasswordField.sendKeys(newPass);
        repeatNewPasswordField.sendKeys(newPass);
        saveButton.click();
        closeButton.click();
    }

    public String getStatusMessage() {
        return statusMsg.getHtmlText();

    }

}



