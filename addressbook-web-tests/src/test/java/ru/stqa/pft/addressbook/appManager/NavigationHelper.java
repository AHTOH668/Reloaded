package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }


    public void gotoGroup () {
        click(By.linkText("groups"));
    }

    public void goToNewAddress () {
        click(By.linkText("add new"));
    }
}
