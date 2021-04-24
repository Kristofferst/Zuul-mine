
/**
 * Write a description of class NPC - NonPlayerCharacter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC extends Character
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class NPC
     */
    public NPC(Room currentRoom, String name)
    {
        super(currentRoom, name);
        currentRoom.addCharacterToRoom(this);
    }
}
