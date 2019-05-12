/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

import static assignment.pkg3.Game.backpack;
import static assignment.pkg3.Game.endingTextBag;
import static assignment.pkg3.Game.endingTextEffect;
import static assignment.pkg3.Game.itemsGUI;
import javax.swing.JOptionPane;

/**
 * 
 * @author AbsoluteCrow
 */
public class Player
{
    private final Rooms player = new Rooms();   
    private static String playerName = new String();
    private boolean beenToBedroom1 = false;
    private boolean beenToBedroom2 = false;
    
    /**
     * Will store the player name entered into the playerName var.
     * @param playerName
     */
    public void setPlayerName(String playerName)
    {
        Player.playerName = playerName;
    }
    
    public static String getPlayerName()
    {
        return playerName; 
    }
    
    public void move_left()
    {
        if (player.getLocation().equals("front_door"))
        {
            player.living_room();
        }       
        else if (player.getLocation().equals("dining_room"))
        {
            player.kitchen();
        }
        else if (player.getLocation().equals("bedroom_1") && beenToBedroom1 && !beenToBedroom2)
        {
            player.floor2_bathroom();
        }
        else if (player.getLocation().equals("floor2_bathroom") && beenToBedroom1)
        {
            player.bedroom_2();
            beenToBedroom2 = true;
        }
        else if (player.getLocation().equals("floor2") && !beenToBedroom2)
        {
            player.bedroom_2();
            beenToBedroom2 = true;
        }
        
        //These two statements can be combined but are seperated for readiblity.
        //If the player stated from bedroom 2. Any attempts to go back will issue a closed door statement.
        else if ((player.getLocation().equals("floor2_bathroom") || player.getLocation().equals("bedroom_1")) && beenToBedroom2)
        {
            JOptionPane.showMessageDialog(null, "The door has been closed behind you by a Spook.");
        }
        //When the player is back in the hallway after going through both bedroom, give a closed door statement if attempting to go back into the bedrooms.
        else if (player.getLocation().equals("floor2") && beenToBedroom1 && beenToBedroom2)
        {
            JOptionPane.showMessageDialog(null, "The door has been closed behind you by a Spook.");
        }
    }
    
    public void move_down()
    {
        if (player.getLocation().equals("front_door"))
        {
            player.dining_room();
        }        
        else if (player.getLocation().equals("living_room"))
        {
            player.bathroom();
        }        
        else if (player.getLocation().equals("floor2") && !beenToBedroom1)
        {
            player.bedroom_1();
            beenToBedroom1 = true;
        }
        
        //When the player is back in the hallway after going through both bedroom, give a closed door statement if attempting to go back into the bedrooms.
        else if (player.getLocation().equals("floor2") && beenToBedroom1 && beenToBedroom2)
        {
            JOptionPane.showMessageDialog(null, "The door has been closed behind you by a Spook.");
        }
    }
    
    public void move_up()
    {
        if (player.getLocation().equals("kitchen"))
        {
            player.pantry();
        }
        else if (player.getLocation().equals("bedroom_2") && beenToBedroom1)
        {
            player.floor2();
        }
        else if (player.getLocation().equals("floor2"))
        {
            player.master_bedroom();
        }
        else if (player.getLocation().equals("bedroom_1") && beenToBedroom2)
        {
            player.floor2();
        }
        
        //If in either bedroom 1 or 2. Any attempt to go backwards will result in a closed door statement.
        else if ((player.getLocation().equals("bedroom_1") || player.getLocation().equals("bedroom_2")) && (beenToBedroom1 || beenToBedroom2))
        {
            JOptionPane.showMessageDialog(null, "The door has been closed behind you by a Spook.");
        }
    }
    
    public void move_right()
    {
        if (player.getLocation().equals("front_door"))
        {
            player.floor2();
        }
        else if (player.getLocation().equals("master_bedroom"))
        {
            player.master_bathroom();
        }
        else if (player.getLocation().equals("bedroom_2") && beenToBedroom2 && !beenToBedroom1)
        {
            player.floor2_bathroom();
        }
        else if (player.getLocation().equals("floor2_bathroom") && beenToBedroom2)
        {
            player.bedroom_1();
            beenToBedroom1 = true;
        }
        
        //If the player stated from bedroom 1. Any attempts to go back will issue a closed door statement.
        else if ((player.getLocation().equals("floor2_bathroom") || player.getLocation().equals("bedroom_2")) && beenToBedroom1)
        {
            JOptionPane.showMessageDialog(null, "The door has been closed behind you by a Spook.");
        }
    }
    
    //Long list of if-else statements checking for the effect of each item.
    //Alternatively, a seperate class can be used if the game had a lot more items and if they were found in multiple rooms.
    public void explore_items()
    {
        backpack.append(itemsGUI.getSelectedValue() + "\n"); 
        endingTextBag.setText("You put a " + itemsGUI.getSelectedValue() + " in your bag and carefully examined it.");
        
        if (itemsGUI.getSelectedValue().equals("Chest"))
        {           
            endingTextEffect.setText("A ghost escapes and scares you to death.");
        }     
        else if (itemsGUI.getSelectedValue().equals("Candelabra"))
        {
            endingTextEffect.setText("They light up by themselves and see a death shadow.");
        }
        else if (itemsGUI.getSelectedValue().equals("Refrigerator"))
        {
            endingTextEffect.setText("You open it and find some delicious soul food.");
        }
        else if (itemsGUI.getSelectedValue().equals("Cabinet"))
        {
            endingTextEffect.setText("The dishes and glasses start flying at you as soon as you open the door. You get hit in the head and feel yourself start moving towards a light.");
        }
        else if (itemsGUI.getSelectedValue().equals("Dusty recipe box"))
        {
            endingTextEffect.setText("You open it up and a recipe for chocolate devils food cake appears our of no where.");
        }
        else if (itemsGUI.getSelectedValue().equals("Broom"))
        {
            endingTextEffect.setText("It flies up in the air as soon as you touch it.");
        }
        else if (itemsGUI.getSelectedValue().equals("Mirror"))
        {
            endingTextEffect.setText("You see a bloody face looking back at you.");
        }
        else if (itemsGUI.getSelectedValue().equals("Shower") && !(player.getLocation().equals("master_bathroom")))
        {
            endingTextEffect.setText("The room suddenly steams up and you feel fingers touching the back of your neck.");
        }
        else if (itemsGUI.getSelectedValue().equals("Rocking chair"))
        {
            endingTextEffect.setText("The chair starts rocking by itself with no one on it.");
        }
        else if (itemsGUI.getSelectedValue().equals("Window"))
        {
            endingTextEffect.setText("You see a child outside on a swing who suddenly disappears.");
        }
        else if (itemsGUI.getSelectedValue().equals("Doll House"))
        {
            endingTextEffect.setText("The dolls start dancing on their own.");
        }
        else if (itemsGUI.getSelectedValue().equals("Dresser"))
        {
            endingTextEffect.setText("A ghost flies out of the dresser as soon as you open it and goes right though your body.");
        }
        else if (itemsGUI.getSelectedValue().equals("Jewelry Box"))
        {
            endingTextEffect.setText("You find the cursed Hope Diamond and feel your doom.");
        }
        else if (itemsGUI.getSelectedValue().equals("Intricate Oil Lamp"))
        {
            endingTextEffect.setText("Rub the lamp and a genie pops out who says he’ll grant you 3 wishes.");
        }
        else if (itemsGUI.getSelectedValue().equals("Shower") && player.getLocation().equals("master_bathroom"))
        {
            endingTextEffect.setText("Suddenly hear singing in the shower, but no one is there.");
        }
    }
    
    public void execute_restart()
    {
        player.restart();
        beenToBedroom1 = false;
        beenToBedroom2 = false;
    }

}
