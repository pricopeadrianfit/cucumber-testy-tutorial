package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.Example.ChangePasswordPage;
import org.fasttrackit.Example.LoginPage;
import org.fasttrackit.Example.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;
    private NavigationBarPage navigationBarPage;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navigationBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
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
        changePasswordPage.changePassword("eu.pass", "eu.pass2");
        changePasswordPage.AssertThatStatusIs("Your password has been successfully changed.");
        navigationBarPage.logout();
    }

    private void openLoginPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

    }
}
