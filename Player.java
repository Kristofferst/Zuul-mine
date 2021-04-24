import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
/**
 * Class of player. Moves around game.
 *
 * @author  Kristoffer Stokkeland
 * @version 2021.03.11
 */

public class Player extends Character
{
    private double weightLimit; // Move to Actor?
    private Stack<Room> roomHistory;

    /**
     * Constructor for objects of class Player
     */
    public Player(Room startRoom)
    {   
        super(startRoom, "Kristoffer");
        // Item logic
        weightLimit = 50.00; //kg
        
        // Room logic
        roomHistory = new Stack<Room>();
        roomHistory.push(startRoom);
    }

    /**
     * Method for adding item to inventory. Will in time check for weight. 
     * @param item Item that will be added to inventory.
     */
    public String addItem(String itemAsString)
    {
        Item item = getCurrentRoom().getItem(itemAsString);
        String returnString = "";
        //check if item exists
        if(item==null)
        {
            return returnString = "You look to pick up "+itemAsString+", but can't fint it.";
        }
        //check weight if over return 
        if(getTotaltWeight()+item.getWeight()>weightLimit){
            returnString = "You can't pick up";    
            return returnString;
        }
        else{
            addItem(itemAsString, item);
            getCurrentRoom().removeItem(itemAsString);
            returnString = "You pick up "+item.getDescription();
            return returnString;
        }
    }
    
    public String dropItem(String itemAsString)
    {
        Item item = getItem(itemAsString);
        if(item==null){
            return "You look to drop "+itemAsString+", but can't fint it." ;
        }
        else{
            getCurrentRoom().addItem(itemAsString, item);
            removeItem(itemAsString);
            return "You dropped "+itemAsString+".";
        }
        
    }
    
    public String getInventory()
    {
        return getItemsWithWeight();
    }
    
    //Movement    
    public String moveRoom(String direction)
    {
        if(super.move(direction)==false)
        {
            return "There is no door!";
        }
        else
        {
            roomHistory.push(getCurrentRoom());
            return getCurrentRoom().getLongDescription();
        }
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
        setCurrentRoom(roomHistory.pop());
    }
}
