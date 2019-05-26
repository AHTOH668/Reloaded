package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    public void gotoGroup () {
        wd.findElement(By.linkText("groups")).click();
    }

    public void goToNewAddress () {
        wd.findElement(By.linkText("add new")).click();
    }
}
