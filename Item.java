
/**
 * Class to represent items found in the game. For now weight and description.
 *
 * @author Kristoffer Stokkeland
 * @version 2021.03.11
 */
public class Item
{
    // instance variables - replace the example below with your own
    private double weight;
    private String description;

    /**
     * Constructor for objects of class Item
     */
    public Item(double weight, String description)
    {
        // initialise instance variables
        this.weight = weight;
        this.description = description;
    }

    /**
     * Getter for Weight
     * @return    Weight of item
     */
    public double getWeight()
    {
        // put your code here
        return weight;
    }
    
    /**
     * Getter for Description
     * @return    Description of item
     */
    public String getDescription()
    {
        // put your code here
        return description;
    }
}
