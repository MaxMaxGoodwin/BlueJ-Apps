package com.company;
/**
 * Write a description of class Program here.
 *
 * @author (Max Goodwin)
 * @version v5.0   10/12/2021
 */
public class Program
{
    private static StockApp app;
    
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
