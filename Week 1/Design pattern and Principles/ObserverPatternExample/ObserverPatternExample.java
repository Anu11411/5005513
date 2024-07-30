public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockUpdate("AAPL price increased by 2%");
        stockMarket.setStockUpdate("GOOG price decreased by 1.5%");

        stockMarket.deregister(mobileApp);

        stockMarket.setStockUpdate("MSFT price increased by 3%");
    }
}
