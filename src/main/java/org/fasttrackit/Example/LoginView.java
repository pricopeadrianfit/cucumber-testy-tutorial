package org.fasttrackit.Example;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {

    private WebLocator emailField = new WebLocator().setId("email");
    private WebLocator passwordField = new WebLocator().setName("password");
    private WebLocator pushLoginBtn = new WebLocator().setClasses("btn");
    private WebLocator errorMsg = new WebLocator().setClasses("error-msg"); // sau new WebLocator("error-msg")

    public static void main(String[] args) {   // folosim pentru a genera xpathul cand ne e prea greu sa-l gasim,prea complex pathul
        LoginView view = new LoginView();
        System.out.println(view.emailField.getXPath());
    }


    public void doLogin(String userName, String password) {
        emailField.sendKeys(userName);
        passwordField.sendKeys(password);
        pushLoginBtn.click();

    }

    public void assertThatErrorIs(String message) {// CTrl+Alt+M- creare metoda assertThatIs pentru a putea fi folosita de restul testelor referitoare la error message
        System.out.println(errorMsg.getHtmlText());//listeaza in consola error message
        assertThat(errorMsg.getHtmlText(), is(message));
    }
}
