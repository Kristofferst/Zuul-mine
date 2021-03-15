/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Kristoffer Stokkeland, 
 * @version 2021.03.06
 */
import java.util.Random;
public class Game 
{
    private Parser parser;
    private Room startRoom;
    private Random randomizer;
    private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        randomizer = new Random();
        createRooms();
        player = new Player(startRoom);
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, upstairs, office;
        
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        upstairs = new Room("upstairs in the computing lab");
        office = new Room("in the computing admin office");      
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("up", upstairs);
        office.setExit("west", lab);
        upstairs.setExit("down", lab);
        
        // add items. Will need rework. Just done this way to get something and showing use of randomizer.
        outside.addNewItem("Book", 5.0, "Book");
        if(randomizer.nextBoolean()==true){
            outside.addNewItem("Rock", 20.0, "Rock");
        }
                if(randomizer.nextBoolean()==true){
            theater.addNewItem("Rock", 20.0, "Rock");
        }
                if(randomizer.nextBoolean()==true){
            pub.addNewItem("Rock", 20.0, "Rock");
        }
        
        startRoom = outside; // start game outside
    }
    

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
        System.out.println();
    }

    /**
     * Print out location info.
     */
    private void printLocationInfo()
    {
       System.out.println(player.getCurrentRoom().getLongDescription());
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        
        CommandWord commandWord = command.getCommandWord();
        
        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;
            
            case HELP:
                printHelp();
                break;
            
            case GO:
                goRoom(command);
                break;
                
            case LOOK:
                look();
                break;
            
            case EAT:
                eat(command);
                break;
            
            case BACK:
                back();
                break;
            
            case TAKE:
                take(command);
                break;
            
            case DROP:
                drop(command);
                break;
            
            case INVENTORY:
                inventory();
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
         
        }
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommandList());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            player.moveRoom(nextRoom);
            printLocationInfo();
            System.out.println();
        }
    }
    
    /**
     * Will be used to go back first one room and then mulitible rooms using a stack
     */
    private void back()
    {
        if(player.backPossible()==true){
            System.out.println("You have nowhere to go back to.");
        }
        else{
            System.out.println("You go back.");
            player.moveBack();
            printLocationInfo();
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * Looks around the room.
     */
    private void look()
    {
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
    
    //Not done
    /**
     * Eat something. Will add player with need to eat in time.
     */
    private void eat(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("You can't figure out what you want to eat.");
            return;
        }
        else{
            System.out.println("You have eaten and are not hungry any more.");
        }
    }
    
    private void drop(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("You can't figure out what you want to drop.");
            return;
        }
        
        String itemAsString = command.getSecondWord();
        System.out.println(player.dropItem(itemAsString));
    }
    private void take(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("You can't figure out what you want to take.");
            return;
        }
        
        String itemAsString = command.getSecondWord();
        System.out.println(player.addItem(itemAsString));
        
    }
    private void inventory(){
        String inventory = player.getInventory();
        if(inventory.length()>0)
            System.out.println(inventory);
        else{
            System.out.println("Your inventory is empty.");
        }
    }
}
