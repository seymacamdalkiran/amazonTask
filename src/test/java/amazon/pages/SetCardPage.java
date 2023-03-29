package amazon.pages;

import amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SetCardPage extends BasePage{

    @FindBy(xpath = "//input[@class=\"a-button-input\"]")
    public WebElement birListeOlustur;
    @FindBy(id = "list-name")
    public WebElement alisverisListesi;
    @FindBy(xpath = "//span[.='Liste Oluştur']//span/input")
    public WebElement listeOlustur;
    @FindBy(id = "wl-list-entry-title-2BUSFYFJGZYNU")
    public WebElement setCardListe;
    @FindBy(xpath = "//span[@class=\"a-color-base\"]")
    public List<WebElement> listelerim;
    public void listeleriSil(){
        ListemPage listemPage=new ListemPage();
        while(listelerim.size()>3){
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForVisibility(listemPage.dahaFazlasi,3);
            listemPage.dahaFazlasi.click();
            BrowserUtils.waitForVisibility(listemPage.listeyiYonet,3);
            listemPage.listeyiYonet.click();
            BrowserUtils.waitForVisibility(listemPage.listeyiSil,3);
            listemPage.listeyiSil.click();
            BrowserUtils.waitFor(1);
            listemPage.popupEvet.click();
        }
    }
}
