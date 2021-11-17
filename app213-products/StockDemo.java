
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Max Goodwin
 * @version V2.0  17/11/2021
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo()
    {
        this.stock = new StockList();
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(660, "Halo: Combat Evolved"));
        stock.add(new Product(661, "Halo 1"));
        stock.add(new Product(662, "Halo 2"));
        stock.add(new Product(663, "Halo 3"));
        stock.add(new Product(664, "Farcry 3"));
        stock.add(new Product(665, "Skyrim"));
        stock.add(new Product(666, "Elden Ring"));
        stock.add(new Product(667, "Halo Infinite"));
        stock.add(new Product(668, "Farcry 6"));
        stock.add(new Product(669, "Assasin's Creed Valhalla"));
        
        runDemo();
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(660, 500);
    }

    private void sellProducts()
    {
        stock.sellProduct(660, 150);
    }    
}