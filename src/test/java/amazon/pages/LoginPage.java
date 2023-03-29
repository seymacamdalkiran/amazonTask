package amazon.pages;

import amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    Actions actions=new Actions(Driver.get());
    @FindBy(xpath = "//span[.='Liste Oluşturun']")
    public WebElement listeOlustur;
    @FindBy(xpath = "//input[@class=\"a-button-input\"]")
    public WebElement birListeOlusturun;
    @FindBy(id = "ap_email")
    public WebElement telefonNoYaz;
    @FindBy(id = "continue")
    public WebElement devamEt;
    @FindBy(id = "ap_password")
    public WebElement sifre;
    @FindBy(id = "signInSubmit")
    public WebElement sifreGirisYap;
    public void loginOl(String telefon,String sifree){
        actions.moveToElement(merhabaGirisYapin).perform();
        girisYap.click();
        telefonNoYaz.sendKeys(telefon);
        devamEt.click();
        sifre.sendKeys(sifree);
        sifreGirisYap.click();
    }
}
