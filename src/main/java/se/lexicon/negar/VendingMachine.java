package se.lexicon.negar;

//an interface for Machine class
public interface VendingMachine
{
    public void addCurrency(int amount);
    public Product request(int productNumber);
    public int endSession();
    public String getDescription(int productNumber);
    public int getBalance();
    public String[] getProducts();
}

