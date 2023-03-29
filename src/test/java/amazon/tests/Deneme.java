package amazon.tests;

import amazon.pages.*;
import amazon.utilities.BrowserUtils;
import amazon.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Deneme extends TestBase{
    @Test
    public void test() {
        LoginPage loginPage=new LoginPage();
        MsiPage msiPage=new MsiPage();
        SetCardPage setCardPage=new SetCardPage();
        ListemPage listemPage=new ListemPage();
        extentLogger=report.createTest("amazon login ol");

        extentLogger.info("https://www.amazon.com.tr/ sitesi açılır.");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr/");

        extentLogger.info("Çerez tercihlerinden Çerezleri kabul et seçilir.");
        try {
            listemPage.cerezleriKabulEt.click();
        } catch (Exception e) {}

        extentLogger.info("Siteye login olunur.");
        loginPage.loginOl(ConfigurationReader.get("telefon"),ConfigurationReader.get("sifre"));

        extentLogger.info("Login işlemi kontrol edilir.");
//        Assert.assertEquals(basePage.hesapVeListeler.getText(),ConfigurationReader.get("name"));

        extentLogger.info("Hesabım bölümünden “SetCard Liste” isimli yeni bir liste oluşturulur.");
        actions.moveToElement(listemPage.hesapVeListeler).perform();
        BrowserUtils.waitFor(3);
        int firstListNumber = listemPage.listelerinListesi.size();
        loginPage.listeOlustur.click();
        try {
            setCardPage.birListeOlustur.click();
        } catch (Exception e) {
        }
        setCardPage.alisverisListesi.clear();
        setCardPage.alisverisListesi.sendKeys("SetCard Liste");
        BrowserUtils.waitForClickablility(setCardPage.listeOlustur,3);
        setCardPage.listeOlustur.click();

        extentLogger.info("Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.");
        BrowserUtils.waitFor(1);        //clinkible ya da visible işe yaramıyor
        listemPage.tumKategorilerTab.click();
        listemPage.tumKategorilerdenSec("Bilgisayarlar");

        extentLogger.info("Bilgisayar kategorisi seçildiği kontrol edilir.");
        Select select=new Select(listemPage.tumKategorilerTab);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Bilgisayarlar");

        extentLogger.info("Arama alanına msi yazılır ve arama yapılır.");
        listemPage.aramaCubugu.sendKeys("msi");
        listemPage.searchButton.click();

        extentLogger.info("Arama yapıldığı kontrol edilir.");
        Assert.assertTrue(msiPage.msiAra.isDisplayed());

        extentLogger.info("Arama sonuçları sayfasından 2. sayfa açılır.");
        //BrowserUtils.waitForClickablility(msiPage.ikinciSayfayiSec,5);
        //msiPage.ikinciSayfayiSec.click();
        msiPage.sayfaSec(2);

        extentLogger.info("2. sayfanın açıldığı kontrol edilir.");
        Assert.assertTrue(msiPage.ikinciSayfaYazisi.isDisplayed());

        extentLogger.info("Sayfadaki 2. ürün oluşturulan “SetCard Liste” listesine eklenir.");
        // BrowserUtils.waitForClickablility(msiPage.ikinciUrun,3);
        //msiPage.ikinciUrun.click();
        msiPage.urunSec(2);
        listemPage.scrolDown(300);
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
        listemPage.scrolDown(-400);
        BrowserUtils.waitFor(1);

        extentLogger.info("Hesabım - Alışveriş Listesi sayfasına gidilir.");

        actions.moveToElement(listemPage.hesapVeListeler).perform();
        BrowserUtils.waitFor(3);
        int secondListNumber = listemPage.listelerinListesi.size();
        BrowserUtils.waitForClickablility(listemPage.hesaplardakiListemBolumu,3);
        listemPage.hesaplardakiListemBolumu.click();

        extentLogger.info("“Alışveriş Listesi” sayfası açıldığı kontrol edilir.");
        Assert.assertTrue(listemPage.listelerim.isDisplayed());

        extentLogger.info("Eklenen ürün SetCard Liste’sinden silinir.");
        listemPage.kaldir.click();

        extentLogger.info("Oluşturulan SetCard Listesi silinir.");
   /*     BrowserUtils.waitForVisibility(listemPage.dahaFazlasi,3);
        listemPage.dahaFazlasi.click();
        BrowserUtils.waitForVisibility(listemPage.listeyiYonet,3);
        listemPage.listeyiYonet.click();
        BrowserUtils.waitForVisibility(listemPage.listeyiSil,3);
        listemPage.listeyiSil.click();
        BrowserUtils.waitFor(1);
//        BrowserUtils.waitForVisibility(listemPage.popupEvet,3);
//        BrowserUtils.waitForClickablility(listemPage.popupEvet,3);
        listemPage.popupEvet.click();
    */
        System.out.println("firstListNumber = " + firstListNumber);
        System.out.println("secondListNumber = " + secondListNumber);

        System.out.println("setCardPage.listelerim.size = " + setCardPage.listelerim.size());
        BrowserUtils.waitFor(2);
        setCardPage.listeleriSil();
        BrowserUtils.waitFor(2);
        System.out.println("setCardPage.listelerim.size = " + setCardPage.listelerim.size());

    }
}
