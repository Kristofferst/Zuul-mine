import java.util.HashMap;
/**
 * Class to simulate collections of items as a inventory
 *
 * @author Kristoffer
 * @version 27.03.2021
 */
abstract public class Container
{
    // instance variables - replace the example below with your own
    protected HashMap<String, Item> items;

    /**
     * Constructor for objects of class Container
     */
    public Container()
    {
        items = new HashMap<String, Item>();
    }
    
    /**
     * Getter for item in collection. 
     */
    public Item getItem(String itemToGet)
    {
        return items.get(itemToGet);
    }
    
    /**
     * Get strings of all items in collection.
     */    
    public String getItems()
    {
        if(items.isEmpty() == false)
        {
            String itemsString = "Items: ";
            for(Item item : items.values()){
                itemsString += " " + item.getDescription();
            }
            itemsString +=".";
            return itemsString;
        }
        return "";
    }
    
    /**
     * Get strings of all items in collection.
     */    
    public String getItemsWithWeight()
    {
        if(items.isEmpty() == false)
        {
            String itemsString = "Items: ";
            for(Item item : items.values())
            {
                itemsString += " " + item.getDescription()+" Weight: " + item.getWeight();
            }
            itemsString +=".";
            return itemsString;
        }
        return "";
    }
    
    public void addNewItem(String name, double weight, String description)
    {
        items.put(name, new Item(name, weight, description));
    }
    
    public void removeItem(String itemToRemove)
    {
        items.remove(itemToRemove);
    }
    
    public void addItem(String name, Item item)
    {
        items.put(name, item);
    }
    
    public double getTotaltWeight()
    {
        double totalWeight = 0.0;
        for(Item item : items.values())
        {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
}
