package org.fasttrackit.Example;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordPage {



    @FindBy(how = How.XPATH, using = "//div[@id='preferences-win']//input[@name='password']")
    private WebElement currentPasswordField;


    @FindBy(how = How.XPATH, using = "//div[@id='preferences-win']//input[@name='newPassword']")
    private WebElement newPasswordField;

    @FindBy(how = How.XPATH, using = "//div[@id='preferences-win']//input[@name='newPasswordRepeat']")
    private WebElement repeatNewPasswordField;

    @FindBy(how = How.CSS, using = "#preferences-win button.btn-warning")
    private WebElement saveButton;

    @FindBy(how = How.CSS, using = "#preferences-win .status-msg")
    private WebElement statusMsg;

    @FindBy(how = How.XPATH, using = "#preferences-win button.btn-default")
    private WebElement closeButton;


    public void changePassword(String currentPass, String newPass) {

        currentPasswordField.sendKeys(currentPass);
        newPasswordField.sendKeys(newPass);
        repeatNewPasswordField.sendKeys(newPass);
        saveButton.click();
        closeButton.click();
    }

    public void AssertThatStatusIs(String message) {
        System.out.println(statusMsg.getText());//listeaza in consola error message
        assertThat(statusMsg.getText(), is(message));


    }


}



