package se.lexicon.negar;

public abstract class Product
{
    private static int ALL = 0;
    protected int id;
    protected String name;
    protected int price;
    protected double calories;

    //constructor
    public Product(String name, int price, double calories)
    {
        ALL++;
        id = ALL;
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    //set the value of ALL to zero
    public static void resetALL()
    {
        ALL = 0;
    }

    //get product ID
    public int getId()
    {
        return id;
    }

    //get product price
    public int getPrice()
    {
        return price;
    }

    //get product ID and name as a string
    public String getName()
    {
        String result = "[";
        result += Integer.toString(id);
        result += "] ";
        result += name;
        return result;
    }

    //get a description of the product and complete it in the child classes
    public String getInfo()
    {
        return getName() + " price is " + Integer.toString(price) + " kr. It has " + Double.toString(calories) + " calories.";
    }

    //show a message to buy a product
    public String use()
    {
        return "You bought " + getName() + ". Enjoy it!";
    }

    //a method to show a full description of the product
    public abstract String examine();
}
