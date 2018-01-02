package simple;

public class Chocolate extends Sweet {

    public  Chocolate(String name)
    {
        super(name);
    }

    public Chocolate(String name, double price, double weight, int unNum)
    {
        super(name, price, weight, unNum);
    }

    //  @Override
    public String description()
    {
        return "№ " + unNum + " Молочная шоколадка с орешками   " + name + " весом " + weight + " г. по цене " + price + " р. за шт.";

    }
}
