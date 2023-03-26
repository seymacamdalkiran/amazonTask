package amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListemPage extends BasePage{
    @FindBy(xpath = "//span[.='1 ürün şuraya eklendi:']")
    public WebElement urunSurayaEklendi;
    @FindBy(xpath = "//span[text()='Bu ürün zaten şurada mevcut:']")
    public WebElement urunZatenMevcut;
    @FindBy(id = "itemAddedDate_IDGW4XTQTPC3E")
    public WebElement urunEklendi;
    @FindBy(xpath = "//button[@data-action='a-popover-close']")
    public WebElement listeyiKapat;
    @FindBy(xpath = "//a[.='Listenizi Görüntüleyin']")
    public WebElement listeniziGoruntuleyin;
    @FindBy(id = "profile-list-name")
    public WebElement alisverisListesiSayfasiYazisi;
    @FindBy(xpath = "//input[@name='submit.deleteItem']")
    public WebElement kaldir;
    @FindBy(id = "editYourList")
    public WebElement listeyiYonet;
    //@FindBy(xpath = "//span[text()='Listeyi sil']")
    @FindBy(xpath = "(//input[@class=\"a-button-input\"][./ancestor::div[@id=\"list-settings-container\"]])[3]")
    public WebElement listeyiSil;
    @FindBy(xpath = "//input[@name='submit.save']")
    public WebElement popupEvet;
    @FindBy(xpath = "//div[contains(text(),'Listelerim')][@role='heading']")
    public WebElement listelerim;
    @FindBy(xpath = "//div[@class='aok-inline-block aok-align-center']")
    public WebElement dahaFazlasi;

}
