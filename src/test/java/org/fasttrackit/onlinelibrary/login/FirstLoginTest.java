package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.Example.LoginView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FirstLoginTest extends TestBase {

    private LoginView loginPage = new LoginView();// nu am schimbat numele loginPage in loginView pt a nu mai schimba mai jos la toate testele



    @Test
    public void whenEnterValidCredentialsSuccesfulLogin() {

        openLoginPage();//folosim functiile create mai jos
        loginPage.doLogin("eu@fast.com", "eu.pass");
        WebLink logoutBtn = new WebLink().setText("Logout");
      //  logoutBtn.assertClick();

//        doLogin("eu@fast.com", "eu.pass");

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
//        try {                                                                   //cand e posibil sa nu gasim butonlu de logout(logarea nu a fost posibila -parol/user gresite) trebuie sa facem cu try &catch exception.
//            WebElement logOutBtn = driver.findElement(By.linkText("Logout"));
//            logOutBtn.click();
//        } catch (NoSuchElementException exception) {
//            Assert.fail("could not find logout button");
//        }
    }

//    @Test
//    public void whenEnterInvalidPasswordIGetErrorMessage() {
//        openLoginPage();
//        loginPage.doLogin("eu@fast.com", "eu.passx");
//        loginPage.assertThatErrorIs("Invalid user or password!");

//        WebElement errorMsg = driver.findElement(By.className("error-msg"));//cauta in browser error message
//        System.out.println(errorMsg.getText());//listeaza in consola error message
//        assertThat(errorMsg.getText(), is ("Invalid user or password!"));

//        try {
//            WebElement logOutBtn = driver.findElement(By.linkText("Logout"));
//            logOutBtn.click();
//        } catch (NoSuchElementException exception) {
//            Assert.fail("could not find logout button");
//        }
//    }
    @DataProvider
    public static Object[][] invalidLogin(){
        return new Object[][] {
                {"eu@fast.com","eu.passx","Invalid user or password!",true},
                {"",           "eu.pass", "Please enter your email!",false},
                {"eu@fast.com","",        "Please enter your password!",false},
                {"",           "",        "Please enter your email!",false}
        };

    }

    @Test(dataProvider = "invalidLogin")
    public void invalidLoginTest(String email, String password,String errorMsg, boolean hasCredentials){
        System.out.println("invalid login test"+ email+"_"+password+"_"+errorMsg);
        openLoginPage();
        loginPage.doLogin(email,password);
        loginPage.assertThatErrorIs(errorMsg);
    }

//    @Test
//    public void whenNoEnterCredentialsIGetErrorMessage() {
//        openLoginPage();
//        loginPage.doLogin("", "");
//        loginPage.assertThatErrorIs("Please enter your email!");
//
//    }

//    @Test
//    public void whenEnterOnlyPasswordGetErrorMessage() {
//        openLoginPage();
//        loginPage.doLogin("", "eu.pass");
//        loginPage.assertThatErrorIs("Please enter your email!");
//
//    }
//
//
//    @Test
//    public void whenEnterOnlyEmailIGetErrorMessage() {
//        openLoginPage();
//        loginPage.doLogin("eu@fast.com", "");
//        loginPage.assertThatErrorIs("Please enter your password!");


        //initial Selenium test
//        WebElement errorMsg = driver.findElement(By.className("error-msg"));//cauta in browser error message
//        System.out.println(errorMsg.getText());//listeaza in consola error message
//        assertThat(errorMsg.getText(), is ("Please enter your password!"));

//    }


//  initial version -
//  private void changePassword(String currentPass, String newPass) {
////        WebElement preferenceButton = driver.findElement(By.xpath("//nav//button"));
////        preferenceButton.click();
////        Utils.sleep(300);
////
////        WebElement currentPasswordField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='password']"));
////        currentPasswordField.sendKeys(currentPass);
////
////
////        WebElement newPasswordField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='newPassword']"));
////        newPasswordField.sendKeys(newPass);
////
////        WebElement repeatNewPasswordField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='newPasswordRepeat']"));
////        repeatNewPasswordField.sendKeys(newPass);
////
////        WebElement saveButton = driver.findElement(By.cssSelector("#preferences-win button.btn-warning"));
////        saveButton.click();
//    }


    private void openLoginPage() {
        System.out.println("open Login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

    }

    // homework
    @Test
    public void enterYahooMailAccountEmptySpamaAndTrashFolder() {

        openYahooLoginPage();
        doYahooLogin("", "");
        emptySpamAndTrash();

        try {
            WebElement logOutBtn = driver.findElement(By.linkText("Sign Out"));
            logOutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("could not find logout button");
        }
    }


    private void emptySpamAndTrash() {

        WebElement emptySpamFolder = driver.findElement(By.linkText("[Empty]"));
        emptySpamFolder.click();

    }

    private void doYahooLogin(String yahoousername, String yahoopassword) {
        WebElement emailField = driver.findElement(By.id("login-username"));
        emailField.sendKeys(yahoousername);

        WebElement continueBtn = driver.findElement(By.id("login-signin"));
        continueBtn.click();
        Utils.sleep(2000);

        WebElement passwordField = driver.findElement(By.id("login-passwd"));
        passwordField.sendKeys(yahoopassword);


        WebElement autentificareBtn = driver.findElement(By.id("login-signin"));
        autentificareBtn.click();
        Utils.sleep(2000);

    }

    private void openYahooLoginPage() {
        System.out.println("open Yahoo Login page");
        driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");
    }
}
