import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
/**
 * Player
 *
 * @author  Kristoffer Stokkeland
 * @version 2021.03.11
 */

public class Player
{
    private double weightLimit;
    private HashMap<String, Item> inventory;
    private String name; //Need to add rest of logic
    private Room currentRoom;
    private Stack<Room> roomHistory;
    

    /**
     * Constructor for objects of class Player
     */
    public Player(Room startRoom)
    {
        // Item logic
        weightLimit = 15000.00; //What unit is this in? Who knows?
        inventory = new HashMap<String, Item>();       
        
        // Room logic
        roomHistory = new Stack<Room>();
        currentRoom = startRoom;
        roomHistory.push(currentRoom);
    }

    /**
     * Method for adding item to inventory. Will in time check for weight. 
     * @param item Item that will be added to inventory.
     */
    public String addItem(String itemAsString)
    {
        Item item = currentRoom.getItem(itemAsString);
        String returnString = "";
        //check if item exists
        if(item==null){
            returnString = "You look to pick up "+itemAsString+", but can't fint it.";
        }
        //check weight if over return 
        if(getTotaltWeight()+item.getWeight()>weightLimit){
            returnString = "You can't pick up";    
            return returnString;
        }
        else{
            inventory.put(itemAsString, item);
            currentRoom.removeItem(itemAsString);
            returnString = "You pick up "+item.getDescription();
            return returnString;
        }
    }
    
    public Item getItem(String itemToGet){
        return inventory.get(itemToGet);
    }
    
    public String dropItem(String itemAsString)
    {
        Item item = getItem(itemAsString);
        if(item==null){
            return "You look to drop "+itemAsString+", but can't fint it." ;
        }
        else{
            currentRoom.addItem(itemAsString, item);
            inventory.remove(itemAsString);
            return "You dropped "+itemAsString+".";
        }
        
    }
    
    public double getTotaltWeight()
    {
        double totalWeight = 0.0;
        for(Item item : inventory.values()){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    public String getInventory()
    {
        String inventoryString = "";
        for(Item item : inventory.values()){
            inventoryString += item.getDescription() + " Weight: " + item.getWeight() + "\r\n";
        }
        return inventoryString;
    }
    
    //Movement    
    /**
     * Change room
     */
    public void moveRoom(Room nextRoom)
    {
        currentRoom = nextRoom;
        roomHistory.push(currentRoom);
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    //Going back
    /**
     * Is moving back possible? 
     * @return true/false Is roomHistory empty?
     */
    public boolean backPossible()
    {
        return roomHistory.empty();
    }
    
    public void moveBack()
    {
        currentRoom = roomHistory.pop();
    }
   
    
    
}
