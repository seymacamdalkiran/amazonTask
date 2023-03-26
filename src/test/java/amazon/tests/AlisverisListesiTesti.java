package amazon.tests;

import amazon.pages.*;
import amazon.utilities.BrowserUtils;
import amazon.utilities.ConfigurationReader;
import amazon.utilities.ExcelUtil;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AlisverisListesiTesti extends TestBase{
    LoginPage loginPage=new LoginPage();
    MsiPage msiPage=new MsiPage();
    SetCardPage setCardPage=new SetCardPage();
    ListemPage listemPage=new ListemPage();

    @Test
    public void test1() {
        basePage=new BasePage();
        extentLogger=report.createTest("amazon login ol");

        extentLogger.info("https://www.amazon.com.tr/ sitesi açılır.");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr/");

        extentLogger.info("Çerez tercihlerinden Çerezleri kabul et seçilir.");
        try {
            basePage.cerezleriKabulEt.click();
        } catch (Exception e) {}

        extentLogger.info("Siteye login olunur.");
        loginPage.loginOl(ConfigurationReader.get("telefon"),ConfigurationReader.get("sifre"));


        extentLogger.info("Login işlemi kontrol edilir.");
        Assert.assertEquals(basePage.hesapVeListeler.getText(),ConfigurationReader.get("name"));

        extentLogger.info("Hesabım bölümünden “SetCard Liste” isimli yeni bir liste oluşturulur.");
        actions.moveToElement(basePage.hesapVeListeler).perform();
        BrowserUtils.clickWithJS(loginPage.listeOlustur);
        try {
            setCardPage.birListeOlustur.click();
        } catch (Exception e) {
        }
        setCardPage.alisverisListesi.clear();
        setCardPage.alisverisListesi.sendKeys("SetCard Liste");
        BrowserUtils.waitForClickablility(setCardPage.listeOlustur,3);
        setCardPage.listeOlustur.click();

        extentLogger.info("Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.");
BrowserUtils.waitFor(2);        //clinkible ya da visible işe yaramıyor
        basePage.tumKategorilerTab.click();
        basePage.tumKategorilerdenSec("Bilgisayarlar");

        extentLogger.info("Bilgisayar kategorisi seçildiği kontrol edilir.");
        Select select=new Select(basePage.tumKategorilerTab);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Bilgisayarlar");

        extentLogger.info("Arama alanına msi yazılır ve arama yapılır.");
        basePage.aramaCubugu.sendKeys("msi");
        basePage.searchButton.click();

        extentLogger.info("Arama yapıldığı kontrol edilir.");
        Assert.assertTrue(msiPage.msiAra.isDisplayed());

        extentLogger.info("Arama sonuçları sayfasından 2. sayfa açılır.");
        BrowserUtils.waitForClickablility(msiPage.ikinciSayfayiSec,5);
        msiPage.ikinciSayfayiSec.click();

        extentLogger.info("2. sayfanın açıldığı kontrol edilir.");
        Assert.assertTrue(msiPage.ikinciSayfaYazisi.isDisplayed());

        extentLogger.info("Sayfadaki 2. ürün oluşturulan “SetCard Liste” listesine eklenir.");
        BrowserUtils.waitForClickablility(msiPage.ikinciUrun,3);
        msiPage.ikinciUrun.click();
        basePage.scrolDown(300);
        BrowserUtils.waitForClickablility(msiPage.listeyeEkle,3);
        msiPage.listeyeEkle.click();

        extentLogger.info("2. Ürünün listeye eklendiği kontrol edilir.");
        try {
            BrowserUtils.waitForVisibility(listemPage.urunSurayaEklendi,3);
            Assert.assertTrue(listemPage.urunSurayaEklendi.isDisplayed());
        } catch (Exception e) {
            BrowserUtils.waitForVisibility(listemPage.urunZatenMevcut,3);
            Assert.assertTrue(listemPage.urunZatenMevcut.isDisplayed());
        }
        listemPage.listeyiKapat.click();
        basePage.scrolDown(-400);
BrowserUtils.waitFor(1);

        extentLogger.info("Hesabım - Alışveriş Listesi sayfasına gidilir.");
        actions.moveToElement(basePage.hesapVeListeler).perform();
        BrowserUtils.waitForClickablility(basePage.hesaplardakiListemBolumu,3);
        basePage.hesaplardakiListemBolumu.click();

        extentLogger.info("“Alışveriş Listesi” sayfası açıldığı kontrol edilir.");
        Assert.assertTrue(listemPage.listelerim.isDisplayed());

        extentLogger.info("Eklenen ürün SetCard Liste’sinden silinir.");
        listemPage.kaldir.click();

        extentLogger.info("Oluşturulan SetCard Listesi silinir.");
        BrowserUtils.waitForVisibility(listemPage.dahaFazlasi,3);
        listemPage.dahaFazlasi.click();
        BrowserUtils.waitForVisibility(listemPage.listeyiYonet,3);
        listemPage.listeyiYonet.click();
        BrowserUtils.waitForVisibility(listemPage.listeyiSil,3);
        listemPage.listeyiSil.click();
BrowserUtils.waitFor(1);
//        BrowserUtils.waitForVisibility(listemPage.popupEvet,3);
//        BrowserUtils.waitForClickablility(listemPage.popupEvet,3);
        listemPage.popupEvet.click();

        extentLogger.info("Silme işleminin gerçekleştiği kontrol edilir.");
        //actions.moveToElement(basePage.hesapVeListeler).perform();
        //nasıl assert edilir?

        extentLogger.info("Üye çıkış işlemi yapılır.");
BrowserUtils.waitFor(2);
//        BrowserUtils.waitForClickablility(basePage.hesapVeListeler,3);
        actions.moveToElement(basePage.hesapVeListeler).perform();
        basePage.cikisYap.click();
//        BrowserUtils.clickWithJS(basePage.cikisYap);

        extentLogger.info("Çıkış işleminin yapıldığı kontrol edilir.");
        Assert.assertTrue(loginPage.telefonNoYaz.isEnabled());
    }
    /*
    Amazon Senaryosu

o https://www.amazon.com.tr/ sitesi açılır.
o Ana sayfanın açıldığı kontrol edilir.
o Çerez tercihlerinden Çerezleri kabul et seçilir.
o Siteye login olunur.
o Login işlemi kontrol edilir.
o Hesabım bölümünden “SetCard Liste” isimli yeni bir liste oluşturulur.

o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
o Bilgisayar kategorisi seçildiği kontrol edilir.
o Arama alanına msi yazılır ve arama yapılır.
o Arama yapıldığı kontrol edilir.
o Arama sonuçları sayfasından 2. sayfa açılır.
o 2. sayfanın açıldığı kontrol edilir.
o Sayfadaki 2. ürün oluşturulan “SetCard Liste” listesine eklenir.
o 2. Ürünün listeye eklendiği kontrol edilir.
o Hesabım - Alışveriş Listesi sayfasına gidilir.
o “Alışveriş Listesi” sayfası açıldığı kontrol edilir.
o Eklenen ürün SetCard Liste’sinden silinir.
o Oluşturulan SetCard Listesi silinir.
o Silme işleminin gerçekleştiği kontrol edilir.
o Üye çıkış işlemi yapılır.
o Çıkış işleminin yapıldığı kontrol edilir.
     */
}
