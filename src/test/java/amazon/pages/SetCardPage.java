package amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetCardPage extends BasePage{

    @FindBy(xpath = "//input[@class=\"a-button-input\"]")
    public WebElement birListeOlustur;
    @FindBy(id = "list-name")
    public WebElement alisverisListesi;
    @FindBy(xpath = "//span[.='Liste Oluştur']//span/input")
    public WebElement listeOlustur;
}
