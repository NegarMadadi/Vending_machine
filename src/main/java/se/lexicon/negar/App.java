package se.lexicon.negar;

import java.util.Scanner;

//a class to use Machine class
public class App
{
    public static void main(String[] args)
    {
        Machine machine = new Machine();
        int input = 0;
        int i = 0;
        int deposit = 0;
        String[] info;
        String data;
        Scanner s = new Scanner(System.in);
        while (true) //a loop to show the menu everytime
        {
            //showing the menu
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Enter one of these:");
            System.out.println("     1 for adding coin");
            System.out.println("     2 for buying a product");
            System.out.println("     3 for getting your balance");
            System.out.println("     4 for getting product info");
            System.out.println("     5 for printing your balance");
            System.out.println("     6 for printing all the products");
            System.out.println("     7 for exiting the program");
            System.out.print(">>> ");
            input = s.nextInt(); //getting the selected item
            if (input == 1) //add currency
            {
                System.out.println("Enter the coin:");
                System.out.print(">>> ");
                input = s.nextInt();
                deposit = machine.getBalance();
                machine.addCurrency(input);
                if (machine.getBalance() == deposit)
                    System.out.println("Failed!");
                else
                    System.out.println("Done!");
            }
            else if (input == 2) //buy
            {
                System.out.println("Enter the product number:");
                System.out.print(">>> ");
                input = s.nextInt();
                Product p = machine.request(input);
                if (p == null)
                    System.out.println("Failed!");
            }

            else if (input == 3) //end session
            {
                deposit = machine.endSession();
                System.out.println("Here is your remained coins: " + Integer.toString(deposit) + " kr");
            }
            else if (input == 4) //show description
            {
                System.out.println("Enter the product number:");
                System.out.print(">>> ");
                input = s.nextInt();
                data = machine.getDescription(input);
                System.out.println(data);
            }
            else if (input == 5) //show balance
            {
                deposit = machine.getBalance();
                System.out.println("Your balance is " + Integer.toString(deposit) + " kr");
            }
            else if (input == 6) //show all the products
            {
                info = machine.getProducts();
                for (i = 0; i < info.length; i++)
                    System.out.println(info[i]);
            }
            else if (input == 7) //exit
                break;
            else //invalid command
                System.out.println("Invalid option!");
        }
    }
}

