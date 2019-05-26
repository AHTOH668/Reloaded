package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.models.addressData;

public class ContactHelper {
    private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;

    }

    public void submitNewAddress() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillAddressForm(addressData addressData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).sendKeys(addressData.getFirstName());
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(addressData.getLastName());
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(addressData.getPhone());
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(addressData.getEmail());
    }

}
