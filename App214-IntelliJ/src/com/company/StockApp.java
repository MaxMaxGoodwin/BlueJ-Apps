package com.company;
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Max Goodwin
 * @version v5.0 10/12/2021
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice: ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }

    /**
     * A method to execute the input of the user - quit/print/add
     */
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("buy"))
        {
            int productID = reader.getInt("Enter a product ID: ");
            int amount = reader.getInt("Enter an amount to buy: " );
            stock.buyProduct(productID, amount);
        }
        else if(choice.equals("sell"))
        {
            int productID = reader.getInt("Enter a product ID to sell: ");
            int amount = reader.getInt("Enter an amount to sell: ");
            stock.sellProduct(productID, amount);
        }
        else if(choice.equals("remove"))
        {
            int productID = reader.getInt("Enter a productID here to remove: ");
            stock.removeProduct(productID);
        }

        else if(choice.equals("search"))
        {
            String productPhrase = reader.getString("Enter a search string here: ");
            stock.searchProduct(productPhrase);
        }

        else if(choice.equals("lowstock"))
        {
            int minStock = reader.getInt("Enter a minimum stock here: ");
            stock.printLowStock(minStock);
        }


        else if(choice.equals("restock"))
        {
            int minStock = reader.getInt("Enter a minimum stock to restock here: ");
            stock.restockLow(minStock);
        }

        return false;
    }



    /**
     * A method called in executeChoice that adds a new product to stock.
     * Asks for a new ID + Name.
     */
    private void addProduct()
    {
        //System.out.println("Adding a new product");
        //System.out.println();
        
        int id = reader.getInt("Please enter a product id: ");
        String name = reader.getString("Please enter a product name: ");
        Product product = new Product(id, name);
        stock.add(product);
        System.out.println("Product " + product.getID()
                + ", " + product.getName() + " has been added.");
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Buy:        Buy an amount of a certain product");
        System.out.println("    Sell:       Selll an amount of a certain product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Search:     Search for a product");
        System.out.println("    LowStock:   Search for low stock products");
        System.out.println("    Restock:    Restock a product");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Max Goodwin");
        System.out.println("********************************");
    }
}