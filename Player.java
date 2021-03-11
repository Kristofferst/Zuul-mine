import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class Player here.
 *
 * @author Kristoffer Stokkeland
 * @version 0.0.1
 */

public class Player
{
    // instance variables - replace the example below with your own
    private double weightLimit;
    private ArrayList<Item> inventory;
  
    private Room currentRoom;
    private Stack<Room> roomHistory;
    

    /**
     * Constructor for objects of class Player
     */
    public Player(Room startRoom)
    {
        // Item logic
        weightLimit = 15000.00;
        inventory = new ArrayList<Item>();       
        
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
        // put your code here
        Item item = currentRoom.getItem(itemAsString);
        String returnString = "";
        //check weight if over return 
        if(getTotaltWeight()+item.getWeight()>weightLimit){
            returnString = "You can't pick up";    
            return returnString;
        }
        else{
            inventory.add(item);
            currentRoom.removeItem(itemAsString);
            returnString = "You pick up "+item.getDescription();
            return returnString;
        }
    }
    
    public double getTotaltWeight()
    {
        double totalWeight = 0.0;
        for(Item item : inventory){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    public String getInventory()
    {
        String inventoryString = "";
        for(Item item : inventory){
            inventoryString += item.getDescription() + " Weight: " + item.getWeight() + "\r\n";
        }
        return inventoryString;
    }
    
    /**
     * Change room
     */
    public void moveRoom(Room nextRoom)
    {
        currentRoom = nextRoom;
        roomHistory.push(currentRoom);
    }
   
    
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
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    
}
