
/**
 * Enumeration class CommandWord - write a description of the enum class here
 *
 *
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum CommandWord
{
    //Value for each command word with user interface string. 
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"), BACK("back"), TAKE("take"), DROP("drop"), INVENTORY("inventory"), UNKNOWN("?");
    
    //Command string
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
