package tests;

import org.testng.annotations.Test;
import page.*;
public class TestRun extends BaseTest{


    @Test(priority = 0)
    public void goHomePage () throws Exception{

        setUp("FİREFOX");

        HomePage homePage = new HomePage(driver);
        homePage.goToTestGittigidiyor(); //www.gittigidiyor.com sitesi açılır.
        logTest.info("Anasayfaya girildi:");
    }

    @Test(priority = 1)
    public void searchItem () throws Exception {
        setUp("FİREFOX");
        HomePage homePage = new HomePage(driver);
        homePage.goToTestGittigidiyor();
        ProductSearchingPage productSearchingPage = new ProductSearchingPage(driver);
        productSearchingPage.searchProduct("bilgisayar"); //Arama kutucuğuna bilgisayar kelimesi girilir.
        productSearchingPage.verifyItemName("bilgisayar"); //verify computer
        productSearchingPage.goTo2ndPage();//Arama sonuçları sayfasından 2.sayfa açılır.
        productSearchingPage.verify2ndPage("2");//2.sayfanın açıldığı kontrol edilir.
        Thread.sleep(2000);
    }

        @Test(priority = 2)
        public void randomLink () throws Exception {
            searchItem(); //bir önceki süreçlerin çalışması için
            RandomItem randomItem = new RandomItem(driver);
            randomItem.randomItem(); //Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        }
         @Test(priority = 3)
        public void productManagement () throws Exception {
        randomLink();//üstteki tüm süreçlerin çalışması için.
        ShopPage shop = new ShopPage(driver);
        shop.shopPrice();
        logTest.info("Ürünün ilk fiyatı:" + shop.shopPrice());
        shop.shopProductName();
        logTest.info("Ürünün açıklaması:" + shop.shopProductName().readText(shop.shopProductElement));

    }

    @Test(priority = 4)
    public void basketManagement () throws Exception {
        productManagement(); //tüm senaryoların sırayla çalışması için.
        ProductPage productPage = new ProductPage(driver);
        ShopPage shop = new ShopPage(driver);
        shop.addProduct();
        productPage.productPrice();
        logTest.info("Ürünün sepetteki fiyatı:" + productPage.productPrice());
        BasketPage basketPage = new BasketPage(driver);
        basketPage.verifyProductPrices();
        basketPage.basketCountIncrease("2");
        basketPage.verifyProductCount("Sepet Tutarı (2 Adet)");
        basketPage.deleteBasket();
        basketPage.verifyEmptyBasket("Sepetinizde ürün bulunmamaktadır.");
    }


}
