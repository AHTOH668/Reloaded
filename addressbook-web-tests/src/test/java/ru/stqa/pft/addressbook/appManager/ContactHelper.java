package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void initAddressModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id +  "']")).click();
    }

    public void submitAddressModification() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +  "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void create(addressData contact) {
        fillAddressForm(contact);
        submitNewAddress();
    }

    public void modify(addressData contact) {
        initAddressModificationById(contact.getId());
        fillAddressForm (contact);
        submitAddressModification ();
    }

    public void remove(addressData contact) {
        selectContactById(contact.getId());
        deleteContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Set<addressData> all() {
        Set<addressData> contacts = new HashSet<addressData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = element.findElement(By.xpath("./td[3]")).getText();
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            contacts.add(new addressData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

}
