package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }


    public void gotoGroup () {
        click(By.linkText("groups"));
    }

    public void goToNewAddress () {
        click(By.linkText("add new"));
    }

    public void goToHome () {
        click(By.linkText("home"));
    }

}
