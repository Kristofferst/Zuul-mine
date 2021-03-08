/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> itemsInRoom;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        itemsInRoom = new ArrayList<Item>();
    }

    /**
     * Define a exit of this room. 
     * @param direction The direction of the exit.
     * @param neighboor The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * Getter for description of room.
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Getter for long description of room.
     * @return The description + exits of the room.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getItems() + "\n" + getExitString();
    }
    
    public String getItems()
    {
        if(itemsInRoom.isEmpty() == false){
            String itemString = "Items: ";
            for(Item item : itemsInRoom){
                itemString += " " + item.getDescription();
            }
            itemString +=".";
            return itemString;
        }
        return "";
    }
    
    public void addItem(double weight, String description)
    {
        itemsInRoom.add(new Item(weight, description));
    }
    
    /**
     * Getter for exit in given direction. 
     * @return the exit
     * @param direction the desired direction of the exit. 
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    /**
     * Return a description of the room's exits, for example "Exits: north west".
     * @return A description of the available exits. 
     * 
     */
    public String getExitString()
    {
        String exitString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            exitString += " " + exit;
        } 
        return exitString;
    }
    

}
