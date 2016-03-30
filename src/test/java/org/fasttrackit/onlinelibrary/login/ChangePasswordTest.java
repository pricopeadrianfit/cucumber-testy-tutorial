package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.Example.ChangePasswordPage;
import org.fasttrackit.Example.ChangePasswordView;
import org.fasttrackit.Example.LoginPage;
import org.fasttrackit.Example.NavigationBarPage;
import org.fasttrackit.Forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordView changePasswordView;
    private NavigationBarPage navigationBarPage;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordView = PageFactory.initElements(driver, ChangePasswordView.class);
        navigationBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
    }

    @Test
    public void changeDateTest() {
        openLoginPage();//folosim functiile create mai jos
        loginPage.doLogin("eu@fast.com", "eu.pass");
        FirstFormView form = new FirstFormView();
        form.selectCalendar.assertClick();
        form.datePicker.select("25/09/2013");

    }

    @Test
    public void whenEnterValidCredentialsSuccesfulLogin() {

        openLoginPage();//folosim functiile create mai jos
        loginPage.doLogin("eu@fast.com", "eu.pass");

    }

    @Test
    public void succesChangePassword() {
        whenEnterValidCredentialsSuccesfulLogin();
        navigationBarPage.openPreferences();
        changePasswordView.changePassword("eu.pass", "eu.pass2");
     //   changePasswordView.getStatusMessage("Your password has been successfully changed.");
       // navigationBarPage.logout();
    }

    private void openLoginPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

    }
}
