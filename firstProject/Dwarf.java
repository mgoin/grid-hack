import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Dwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dwarf extends Monster
{
    private boolean moved = false; 
    private int hp, lvl;
    private String text = "";
    private Message msgbox = ActorWorld.getMessageBox(); // getting the messagebox object  
    
    public Dwarf()
    {
        hp = 5;
        lvl = 1;
    }
    
    public void attack(GridActor target)
    {
        double prob = Math.random();
        int dmg = (int) (Math.random() * 3);
        
        // 60% chance to hit attack
        if((prob > 0.4) && (target instanceof Player))
        {
            text = "The dwarf throws booze at your face, dealing " + dmg + " damage";
            Player.takeDamage(dmg);
        }
        // 40% chance to miss attack
        if((prob <= 0.4) && (target instanceof Player))
        {
            text = "The dwarf's booze splatters the floor as you dodge it.";
        }
        
        msgbox.setText(text); // calling the method that changes the text of the message  
        getWorld().addObject(msgbox, 23, 40); // display at coordinates of your choice 
    }
}