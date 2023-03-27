package amazon.pages;

import amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MsiPage extends BasePage {
    @FindBy(xpath = "//a[@aria-label='2 sayfasına git']")
    public WebElement ikinciSayfayiSec;

    @FindBy(xpath = "//span[text()='6.000 üzeri sonuç arasından 25-48 arası gösteriliyor. Aranan ürün:']")

    public WebElement ikinciSayfaYazisi;

    @FindBy(xpath = "//span[.='MSI GE75 GP75 GL75 WE75 GE63 GP63 GL63 GV63 GE73 GL73VR için Notebook CPU GPU Soğutma Fanı, CPU GPU Soğutma Fanı Değiştirme.(CPU fanı)']")
    public WebElement ikinciUrun;

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement listeyeEkle;
    @FindBy(xpath = "//span[text()='6.000 üzeri sonuç arasından 1-24 arası gösteriliyor. Aranan ürün:']")
    public WebElement msiAra;
    
    public void sayfaSec(int sayfaSayisi){
        for (int i = 1; i <sayfaSayisi ; i++) {
            Driver.get().findElement(By.xpath("//a[.='Sonraki']")).click();
        }
    }
    public void urunSec(int urunSirasi){
        List<WebElement> urunler = Driver.get().findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        urunler.get(urunSirasi-1).click();
    }
}