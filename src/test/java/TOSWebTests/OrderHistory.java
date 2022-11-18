package TOSWebTests;

import AbstarctComponents.Abstracts;
import AbstarctComponents.Browsers;
import AbstarctComponents.Retry;
import LocatorsAndMethods.OrderHistoryElements;
import LocatorsAndMethods.TOSWebLoginElementsAndMethods;
import LocatorsAndMethods.TOSWebTradeElementsAndMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class OrderHistory {

    public WebDriver driver;
    public String[] description;

    @Parameters({"URL","user","password","Instrument"})
    @Test(retryAnalyzer = Retry.class)
    public void loginInstrumentInit(String url,String user, String password,  String instrument) throws IOException, InterruptedException {

        Browsers browsers = new Browsers();
        driver = browsers.browserInitialization(url);
        TOSWebLoginElementsAndMethods elementsLogin = new TOSWebLoginElementsAndMethods(driver);
        TOSWebTradeElementsAndMethods elementsTrading = new TOSWebTradeElementsAndMethods(driver);
        Abstracts abstracts = new Abstracts(driver);

        Thread.sleep(200);
        elementsLogin.Login(user, password);
        abstracts.waitForElement(elementsLogin.Accept);
        elementsLogin.pressAcceptButton();

        abstracts.waitForElement(elementsTrading.logo);
        elementsTrading.pressLogo();
        Thread.sleep(1000);
        abstracts.waitForElement(elementsTrading.activityTab);
        elementsTrading.pressActivityTab();
        elementsTrading.pressTimeOrder();


        abstracts.waitForElement(elementsTrading.sarchBar);
        elementsTrading.sendKeyToSearchBar(instrument);

    }

    @Parameters({"BuyPrice"})
    @Test(retryAnalyzer = Retry.class)
    public void orderLimit(int BuyPrice) throws InterruptedException, IOException {


        Abstracts abstracts = new Abstracts(driver);
        TOSWebTradeElementsAndMethods elementsTrading = new TOSWebTradeElementsAndMethods(driver);
        OrderHistoryElements orderHistory = new OrderHistoryElements(driver);

        abstracts.waitForElement(elementsTrading.buyButton);
        elementsTrading.pressBUYButton();
        elementsTrading.pressOrderType();

        Thread.sleep(1000);
        elementsTrading.pressOrderTypeLIMIT();

        Thread.sleep(1000);
        elementsTrading.insertPriceValue(BuyPrice);
        Thread.sleep(1000);
        elementsTrading.pressReviewButton();

        orderHistory.getDescriptionPrint();

        description = orderHistory.getDescription();

        Assert.assertEquals(elementsTrading.getText(),"LIMIT");
        elementsTrading.pressSendButton();

        Thread.sleep(1000);
        elementsTrading.pressLogo();
        Thread.sleep(2000);
        orderHistory.getTextOrderRowHistory();
        System.out.println();
        Assert.assertEquals(orderHistory.getTextOrderRow_SIDE().toLowerCase(),description[0].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_QNT().toLowerCase(),description[1].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_SYMBOL().toLowerCase(),description[2].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TYPE().toLowerCase(),description[3].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TIME_FORCE().toLowerCase(),description[4].toLowerCase());
        elementsTrading.pressAllOrdersCheck();
        abstracts.waitForElementToDisappear(elementsTrading.notification);
        Thread.sleep(1000);
        elementsTrading.pressCancelSelected();
        driver.navigate().back();
        Thread.sleep(1000);


    }

    @Parameters({"Instrument"})
    @Test(retryAnalyzer = Retry.class)
    public void orderStop() throws InterruptedException, IOException {
        Abstracts abstracts = new Abstracts(driver);
        TOSWebTradeElementsAndMethods elementsTrading = new TOSWebTradeElementsAndMethods(driver);
        OrderHistoryElements orderHistory = new OrderHistoryElements(driver);

        abstracts.waitForElement(elementsTrading.buyButton);
        elementsTrading.pressBUYButton();
        elementsTrading.pressOrderType();

        Thread.sleep(1000);
        elementsTrading.pressOrderTypeSTOP();

        Thread.sleep(1000);
        elementsTrading.pressReviewButton();

        orderHistory.getDescriptionPrint();

        description = orderHistory.getDescription();
        Assert.assertEquals(elementsTrading.getText(),"STOP");

        elementsTrading.pressSendButton();

        Thread.sleep(1000);
        elementsTrading.pressLogo();
        Thread.sleep(2000);
        orderHistory.getTextOrderRowHistory();
        System.out.println();
        Assert.assertEquals(orderHistory.getTextOrderRow_SIDE().toLowerCase(),description[0].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_QNT().toLowerCase(),description[1].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_SYMBOL().toLowerCase(),description[2].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TYPE().toLowerCase(),description[3].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TIME_FORCE().toLowerCase(),description[4].toLowerCase());
        elementsTrading.pressAllOrdersCheck();
        abstracts.waitForElementToDisappear(elementsTrading.notification);
        Thread.sleep(1000);
        elementsTrading.pressCancelSelected();
        driver.navigate().back();
        Thread.sleep(1000);

    }

    @Parameters({"Instrument"})
    @Test(retryAnalyzer = Retry.class)
    public void orderLoc() throws InterruptedException, IOException {
        Abstracts abstracts = new Abstracts(driver);
        TOSWebTradeElementsAndMethods elementsTrading = new TOSWebTradeElementsAndMethods(driver);
        OrderHistoryElements orderHistory = new OrderHistoryElements(driver);

        abstracts.waitForElement(elementsTrading.buyButton);
        elementsTrading.pressBUYButton();
        elementsTrading.pressOrderType();

        Thread.sleep(1000);
        elementsTrading.pressOrderTypeLOC();

        Thread.sleep(1000);
        elementsTrading.pressReviewButton();

        orderHistory.getDescriptionPrint();

        description = orderHistory.getDescription();
        Assert.assertEquals(elementsTrading.getText(),"LOC");

        elementsTrading.pressSendButton();

        Thread.sleep(1000);
        elementsTrading.pressLogo();
        Thread.sleep(2000);
        orderHistory.getTextOrderRowHistory();
        System.out.println();
        Assert.assertEquals(orderHistory.getTextOrderRow_SIDE().toLowerCase(),description[0].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_QNT().toLowerCase(),description[1].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_SYMBOL().toLowerCase(),description[2].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TYPE().toLowerCase(),description[3].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TIME_FORCE().toLowerCase(),description[4].toLowerCase());
        elementsTrading.pressAllOrdersCheck();
        abstracts.waitForElementToDisappear(elementsTrading.notification);
        Thread.sleep(1000);
        elementsTrading.pressCancelSelected();
        driver.navigate().back();
        Thread.sleep(1000);


    }

    @Parameters({"SellPrice"})
    @Test(retryAnalyzer = Retry.class)
    public void orderStopLimit(int SellPrice) throws InterruptedException, IOException {

        TOSWebTradeElementsAndMethods elementsTrading = new TOSWebTradeElementsAndMethods(driver);
        Abstracts abstracts = new Abstracts(driver);
        OrderHistoryElements orderHistory = new OrderHistoryElements(driver);


        abstracts.waitForElement(elementsTrading.buyButton);
        elementsTrading.pressBUYButton();
        elementsTrading.pressOrderType();

        Thread.sleep(1000);
        elementsTrading.pressOrderTypeSTOPLIMIT();

        Thread.sleep(1000);
        elementsTrading.insertPriceValue(SellPrice);
        Thread.sleep(1000);
        elementsTrading.pressReviewButton();

        orderHistory.getDescriptionPrint();

        description = orderHistory.getDescription();
        Assert.assertEquals(elementsTrading.getText(),"STOPLIMIT");

        elementsTrading.pressSendButton();


        Thread.sleep(1000);
        elementsTrading.pressLogo();
        Thread.sleep(2000);
        orderHistory.getTextOrderRowHistory();
        System.out.println();
        Assert.assertEquals(orderHistory.getTextOrderRow_SIDE().toLowerCase(),description[0].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_QNT().toLowerCase(),description[1].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_SYMBOL().toLowerCase(),description[2].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TYPE().toLowerCase(),description[3].toLowerCase());
        Assert.assertEquals(orderHistory.getTextOrderRow_TIME_FORCE().toLowerCase(),description[4].toLowerCase());
        elementsTrading.pressAllOrdersCheck();
        abstracts.waitForElementToDisappear(elementsTrading.notification);
        Thread.sleep(1000);
        elementsTrading.pressCancelSelected();
        driver.navigate().back();
        Thread.sleep(1000);


    }




    @AfterClass(alwaysRun = true)
    public void orderCancellation() throws InterruptedException, IOException {

        driver.quit();

    }

}
