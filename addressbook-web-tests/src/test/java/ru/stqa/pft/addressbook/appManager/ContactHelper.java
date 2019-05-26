package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.models.addressData;

public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super(wd);

    }

    public void submitNewAddress() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillAddressForm(addressData addressData) {
      type(By.name("firstname"), addressData.getFirstName());
      type(By.name("lastname"),addressData.getLastName());
      type(By.name("home"),addressData.getPhone());
      type(By.name("email"),addressData.getEmail());
    }



    public void initAddressModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    }

    public void submitAddressModification() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td/input"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }
}
