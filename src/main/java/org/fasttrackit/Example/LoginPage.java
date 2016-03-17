package org.fasttrackit.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPage {
    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "btn")
    private WebElement pushLoginBtn;

    @FindBy(how = How.CLASS_NAME, using = "error-msg")
    private WebElement errorMsg;

    public void doLogin(String userName, String password) {
        emailField.sendKeys(userName);
        passwordField.sendKeys(password);
        pushLoginBtn.click();

    }

    public void assertThatErrorIs(String message) {// CTrl+Alt+M- creare metoda assertThatIs pentru a putea fi folosita de restul testelor referitoare la error message
        System.out.println(errorMsg.getText());//listeaza in consola error message
        assertThat(errorMsg.getText(), is(message));
    }
}
