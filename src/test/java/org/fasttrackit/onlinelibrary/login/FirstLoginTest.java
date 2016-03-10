package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstLoginTest extends TestBase {

    @Test
    public void whenEnterValidCredentialsSuccesfulLogin() {

        openLoginPage();//folosim functiile create mai jos
        doLogin("eu@fast.com","eu.pass");

        //Cauta un element dupa un atribut(id,div,buton,type, etc) si interactioneaza cu el (scrie in ele, da click pe el)

//        driver.findElement(By.id("email")).sendKeys("eu@fast.com");//nerecomandat-  de fiecare data cand interactionam trebuie sa caute elementul in browser-> time consuming.
//        driver.findElement(By.id("password")).sendKeys("eu.pass");
//
//
//        WebElement emailField = driver.findElement(By.id("email"));// RECOMANDAT- cauta elementul in browser doar o data dupa care putem interactiona cu acel element elimitat
//        emailField.sendKeys("eu@fast.com");// sendkeys -scrie in fieldul cautat.
////        Utils.sleep(2000);
////        emailField.clear();
//
//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("eu.pass");
//
//        WebElement loginBtn = driver.findElement(By.className("btn"));
//        loginBtn.click();

//        driver.findElement(By.id("loginButton")).);
        try {                                                                   //cand e posibil sa nu gasim butonlu de logout(logarea nu a fost posibila -parol/user gresite) trebuie sa facem cu try &catch exception.
            WebElement logOutBtn = driver.findElement(By.linkText("Logout"));
            logOutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("could not find logout button");
        }
    }

    @Test (dependsOnMethods = "whenEnterValidCredentialsSuccesfulLogin", alwaysRun = true)
    public void whenEnterInvalidPasswordIGetErrorMessage() {
        openLoginPage();
        doLogin("eu@fast.com", "eu.passx");


//        try {
//            WebElement logOutBtn = driver.findElement(By.linkText("Logout"));
//            logOutBtn.click();
//        } catch (NoSuchElementException exception) {
//            Assert.fail("could not find logout button");
//        }

    }

    private void doLogin(String userName, String password) {

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(userName);


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();

    }

    private void openLoginPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

    }

    @Test
    public void enterYahooMailAccountEmptySpamFolder() {

        System.out.println("open Yahoo Login page");
        driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");


        WebElement emailField = driver.findElement(By.id("login-username"));
        emailField.sendKeys("");

        WebElement continueBtn = driver.findElement(By.id("login-signin"));
        continueBtn.click();
        Utils.sleep(2000);

        WebElement passwordField = driver.findElement(By.id("login-passwd"));
        passwordField.sendKeys("");


        WebElement autentificareBtn = driver.findElement(By.id("login-signin"));
        autentificareBtn.click();
        Utils.sleep(2000);
        WebElement emptySpamFolder = driver.findElement(By.tagName("Empty all the messages from the Spam folder"));
        emptySpamFolder.click();

        try {
            WebElement logOutBtn = driver.findElement(By.linkText("Sign Out"));
            logOutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("could not find logout button");
        }
    }
}