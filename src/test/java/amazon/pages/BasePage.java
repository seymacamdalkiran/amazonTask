package amazon.pages;

import amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cerezleriKabulEt;
    @FindBy(id = "sp-cc-rejectall-link")
    public WebElement cerezleriKabulEtmedenDevam;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement merhabaGirisYapin;
    @FindBy(xpath = "//a[@rel='nofollow']//span[@class=\"nav-action-inner\"]")
    public WebElement girisYap;
    @FindBy(id = "ap_email")
    public WebElement telefonNoYaz;
    @FindBy(id = "continue")
    public WebElement devamEt;
    @FindBy(id = "ap_password")
    public WebElement sifre;
    @FindBy(id = "signInSubmit")
    public WebElement sifreGirisYap;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement hesapVeListeler;
    @FindBy(xpath = "//span[.='Çıkış Yap']")
    public WebElement cikisYap;
    @FindBy(id = "searchDropdownBox")
    public WebElement tumKategorilerTab;
    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaCubugu;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy(xpath = "//a[contains(@class,'  nav-item')]//span[@class=\"nav-text\"]")
    public WebElement hesaplardakiListemBolumu;
    public void tumKategorilerdenSec(String tab){
        WebElement searchDropdownBox = Driver.get().findElement(By.id("searchDropdownBox"));
        Select select=new Select(searchDropdownBox);
        select.selectByVisibleText(tab);
        select.getFirstSelectedOption().click();
    }
    public void scrolDown(int down){
        JavascriptExecutor js= (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,"+down+")");
    }

}
