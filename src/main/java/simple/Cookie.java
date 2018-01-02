package simple;

public class Cookie extends Sweet {

    public Cookie(String name) {
        super(name);
    }

    public Cookie(String name, double price, double weight, int unNum) {
        super(name, price, weight, unNum);
    }
    @Override
    public String description()
    {
        return "№ " + unNum + " Вкусненькое печенье с шоколадом " + name + " весом " + weight + " г. по цене " + price + " р. за шт. ";
    }
}
