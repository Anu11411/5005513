public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockUpdate) {
        System.out.println(name + " received stock update: " + stockUpdate);
    }
}
