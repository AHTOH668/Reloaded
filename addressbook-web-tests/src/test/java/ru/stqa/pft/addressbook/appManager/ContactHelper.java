package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
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



    public void initAddressModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void submitAddressModification() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContact(int index) {
        wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td/input")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void createContact(addressData contact) {
        fillAddressForm(contact);
        submitNewAddress();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<addressData> getContactList() {
        List<addressData> contacts = new ArrayList<addressData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstName = element.getText();
            addressData contact = new addressData(firstName, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
