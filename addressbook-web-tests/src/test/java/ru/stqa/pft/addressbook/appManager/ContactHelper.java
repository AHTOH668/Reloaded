package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewAddress() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillAddressForm(addressData addressData) {
        type(By.name("firstname"), addressData.getFirstName());
        type(By.name("lastname"), addressData.getLastName());
        type(By.name("home"), addressData.getHome());
        type(By.name("email"), addressData.getEmail());
        type(By.name("mobile"), addressData.getMobile());
        type(By.name("work"), addressData.getWork());
    }

    public void initAddressModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void submitAddressModification() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void create(addressData contact) {
        fillAddressForm(contact);
        submitNewAddress();
        contactCache = null;
    }

    public void modify(addressData contact) {
        initAddressModificationById(contact.getId());
        fillAddressForm(contact);
        submitAddressModification();
        contactCache = null;
    }

    public void remove(addressData contact) {
        selectContactById(contact.getId());
        contactCache = null;
        deleteContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = element.findElement(By.xpath("./td[3]")).getText();
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            String[] phones = element.findElement(By.xpath("./td[6]")).getText().split("\n");
            contactCache.add(new addressData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .withHome(phones[0]).withMobile(phones[1]).withWork(phones[2]));
        }
        return new Contacts(contactCache);
    }

    public addressData infoFromEditFrom(addressData contact) {
        initAddressModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new addressData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHome(home).withMobile(mobile).withWork(work);
    }

}
