import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     * 
     * 
     */
    public void addItem(Item item)
    {
        // put your code here
        inventory.add(item);
    }
    
    /**
     * Change room
     */
    public void moveRoom(){
    
    }
    
}
