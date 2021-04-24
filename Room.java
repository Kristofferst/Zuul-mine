/**
 * Class Room - a room in an adventure game.
 *
 * @author  Kristoffer Stokkeland
 * @version 2021.03.11
 */
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Room extends Container
{
    private String description;
    private HashMap<String, Room> exits;
    private List<Character> charactersInRoom;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        super();
        this.description = description;
        exits = new HashMap<>();
        charactersInRoom = new ArrayList();
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
        return "You are " + description + ".\n" + getItems() + "\n" + listCharactersInRoom() + "\n" + getExitString();
    }
    
    // Exits
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
    
    public String listCharactersInRoom()
    {   
        if (charactersInRoom.isEmpty()==true)
        {
            return "";
        }
        String returnString = "People: ";
        for(Character character : charactersInRoom)
        {
            returnString += " " + character.getName();
        }
        return returnString;
    }
    
    public boolean addCharacterToRoom(Character character)
    {
        charactersInRoom.add(character);
        return true;
    }
    
    public boolean removeCharacterFromRoom(int index, Character character)
    {
        if (charactersInRoom.get(index)==character)
        {
            charactersInRoom.remove(index);
            return true;
        }
        else
        {
            return false;
        }
    }
}
