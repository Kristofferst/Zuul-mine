
/**
 * Class to represent items found in the game. 
 *
 * @author Kristoffer Stokkeland
 * @version 2021.03.11
 */
public class Item
{
    // instance variables
    private String name;//colloquial name
    private String trueName;//fullname for artifacts
    private double weight;//in kg
    private String description;
    private boolean isHidden;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, double weight, String description)
    {
        this.name = name;
        this.weight = weight;
        this.description = description;
    }
    
    //Getters
    public double getWeight(){return weight;}
    public String getDescription(){return description;}
    public String getName(){return name;}
    
    //Setters
    public void setWeight(double weight){this.weight = weight;}
    public void setDescription(String description){this.description = description;}
    public void setName(String name){this.name = name;}
}
