package se.lexicon.negar;

public class Machine implements VendingMachine
{
    private static final int[] VALID_COINS = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    private int deposit_pool;
    private Product[] products;

    //constructor
    public Machine()
    {
        Product.resetALL(); //reset the first ID of products
        deposit_pool = 0;
        products = new Product[10];
        //setting 10 products
        products[0] = new Fruit("Apple", 10, 1.5, "England");
        products[1] = new Candy("Kit Kat", 20, 5, Candy.CandyTaste.SWEET);
        products[2] = new Fruit("Lemon", 8, 0.6, "Brazil");
        products[3] = new Drink("Tea", 2, 0.1, false);
        products[4] = new Fruit("Banana", 12, 2.7, "France");
        products[5] = new Candy("Skittles", 18, 3.4, Candy.CandyTaste.SOUR);
        products[6] = new Drink("Wine", 30, 0.4, true);
        products[7] = new Candy("Charms", 45, 20.8, Candy.CandyTaste.BITTER);
        products[8] = new Fruit("Mango", 14, 3.2, "Argentina");
        products[9] = new Fruit("Orange", 8, 1.2, "India");
    }

    //add money to the deposit pool
    @Override
    public void addCurrency(int amount)
    {
        boolean is_valid = false;
        for (int i = 0; i < VALID_COINS.length; i++)
            if (VALID_COINS[i] == amount) //check if it is valid
            {
                is_valid = true;
                break;
            }
        if (is_valid)
            deposit_pool += amount;
    }

    //buy a product
    @Override
    public Product request(int productNumber)
    {
        Product result = null;
        for (int i = 0; i < products.length; i++)
            if (products[i].getId() == productNumber) //check the product ID
            {
                if (deposit_pool >= products[i].getPrice()) //check if there is enough money
                {
                    result = products[i];
                    deposit_pool -= products[i].getPrice();
                }
                break;
            }
        if (result != null)
            System.out.println(result.use());
        return result;
    }

    //ending the session
    @Override
    public int endSession()
    {
        int temp = deposit_pool;
        deposit_pool = 0;
        return temp;
    }

    //returning a product information
    @Override
    public String getDescription(int productNumber)
    {
        String result = "";
        for (int i = 0; i < products.length; i++)
            if (products[i].getId() == productNumber) //check the product ID
            {
                result = products[i].examine();
                break;
            }
        return result;
    }

    //returning the balance
    @Override
    public int getBalance()
    {
        return deposit_pool;
    }

    //returning an array of all products names and IDs
    @Override
    public String[] getProducts()
    {
        String[] result = new String[products.length];
        for (int i = 0; i < products.length; i++)
            result[i] = products[i].getName();
        return result;
    }
}

