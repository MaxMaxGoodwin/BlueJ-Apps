import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Max Goodwin
 * @version V2.0    02/12/2021
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList() //{ stock - new ArrayList<Product>(); }
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item) // { stock.add(item); }
    {
        stock.add(item);
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID) // { buyProduct(productID, amount 1); }
    { //, int amount)
        buyProduct(productID, 1); //Product product = findProduct(productID);
    }
    
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        if(product != null) 
        {
            if(product.getQuantity() < 500)
            {
                product.increaseQuantity(amount);
                System.out.println("Successfully bought " + amount + 
                                        " of " + product.getName());
            }
            else
            {
                System.out.println("Not enough storage space for: "
                     + product.getName() + " - Please sell current stock");
                                            
            }
        }
        else
        {
            System.out.println("Couldn't find product");
        }
    } 

    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        {
            if(product.getID() == productID)
                return product;
        }
        return null;
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID)
    {
        sellProduct(productID, 1);
    }
    
    /**
     * Sell multiple of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() > amount)
            {
                product.decreaseQuantity(amount);
                System.out.println("Successfully sold " + amount + 
                                        " of "+ product.getName());
            }
            else if(product.getQuantity() == 0)
            {
                System.out.println("The product" + product.getName() +
                                            "is out of stock");
            }
            else
            {
                System.out.println("Can't sell " + amount +" of " + product.getName() 
                + "- only " + product.getQuantity() + " in stock");
            }
        }
        else
        {
            System.out.println("Couldn't find product");
        }
    }    

    /**
     * A method to search a particular term/phrase in all products.
     */
    public void searchProduct(String productPhrase)
    {
        int count = 0;
        System.out.println("Searching for products with term: '" + productPhrase + "'");
        
        for (Product product : stock) 
            if(product.getName().contains(productPhrase))
            {
                count++;
                System.out.println("There are " + count + " products containing term");
                System.out.println(product);
            }
            else
            {
                System.out.println("No products found containing search term");
            }
        
        
    }
    
    
    /**
     * Method to remove a product from stock list.
     */
    public void removeProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null)
        {
            stock.remove(product);
            System.out.println("Product " + productID + " has been removed");
        }   
        else
        {
            System.out.println("Couldn't find product");
        }
        
    }
    
    /**
     * Method that asks user for a minimum stock then checks all stock levels
     * to see which products are below minimum and restocks them to minimum.
    */
    /**
    public void restockLow(int minStock)
    {
        ArrayList<Product> lowStock = printLowStock(minStock);
        System.out.println("Restocking products...");
        
        for(Product product : lowStock)
        {
            product.increaseQuantity(minimum - product.getQuantity());
        }
    }
    */
   
   /**
    * Method that asks user for a minimum then checks stock levels and prints
    * the number of products below that stock level (doesn't restock).
    */
   public void printLowStock(int minStock)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int count = 0;
        System.out.println("These products are at a low stock: ");
        for(Product product : stock)
        {
            if(product.getQuantity() <= minStock)
            {
                //product.getID() = productID;
                count++;
                lowStock.add(product);
                System.out.println(product);
            }
        }
        
        System.out.println("There are " + count + " products at a low stock");
        //System.out.println("These products are: " + productID);
    }
    
    
   
   
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    /**
     * Method to print a heading for stock list.
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Max's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}