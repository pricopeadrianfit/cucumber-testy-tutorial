package org.fasttrackit.Example;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBarPage {

    @FindBy(how = How.XPATH, using = "//nav//button")
    private WebElement preferenceButton;

    @FindBy(how = How.XPATH, using = "//nav//logout")
    private WebElement logOutButton;

    public void openPreferences() {
        preferenceButton.click();
        Utils.sleep(300);
    }

    public void logout() {
        logOutButton.click();

    }
}


