package se.lexicon.negar;

public class Drink extends Product
{
    private boolean is_alcoholic;

    //constructor
    public Drink(String name, int price, double calories, boolean is_alcoholic)
    {
        super(name, price, calories);
        this.is_alcoholic = is_alcoholic;
    }

    //show the info
    public String examine()
    {
        String result = getInfo() + " This drink is ";
        if (!is_alcoholic)
            result += "not ";
        result += "alcoholic.";
        return result;
    }
}

