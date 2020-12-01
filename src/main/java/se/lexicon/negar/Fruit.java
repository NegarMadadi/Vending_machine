package se.lexicon.negar;

public class Fruit extends Product
{
    private String region;

    //constructor
    public Fruit(String name, int price, double calories, String region)
    {
        super(name, price, calories);
        this.region = region;
    }

    //show the info
    public String examine()
    {
        return getInfo() + " This fruit region is " + region + ".";
    }
}

