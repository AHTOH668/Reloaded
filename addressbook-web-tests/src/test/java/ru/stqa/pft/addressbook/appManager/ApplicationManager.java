package ru.stqa.pft.addressbook.appManager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    FirefoxDriver wd;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;


    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.findElement(By.linkText("Logout")).click();
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
