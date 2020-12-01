package se.lexicon.negar;

public class Candy extends Product
{
    //an enum for different tastes
    public enum CandyTaste
    {
        SWEET, SALTY, SOUR, BITTER
    }
    private CandyTaste taste;

    //constructor
    public Candy(String name, int price, double calories, CandyTaste taste)
    {
        super(name, price, calories);
        this.taste = taste;
    }

    //show the info
    public String examine()
    {
        String result = getInfo() + " This candy is ";
        if (taste == CandyTaste.SWEET)
            result += "sweet";
        else if (taste == CandyTaste.SALTY)
            result += "salty";
        else if (taste == CandyTaste.SOUR)
            result += "sour";
        else
            result += "bitter";
        result += ".";
        return result;
    }
}

