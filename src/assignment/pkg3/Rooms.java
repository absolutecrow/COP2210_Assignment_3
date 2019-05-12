/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

import javax.swing.ImageIcon;
import static assignment.pkg3.Game.playerIndicator;
import static assignment.pkg3.Game.backpack;
import static assignment.pkg3.Game.itemsInRoomList;


/**
 *
 * @author AbsoluteCrow
 */
public class Rooms
{
    private String currentLocation;
    private static final int NUMBER_OF_ITEMS = 2;
    private final String[] itemsInRoom;
    
    public Rooms()
    {
        itemsInRoom = new String[NUMBER_OF_ITEMS];
        currentLocation = "front_door";
    }
    
    //Currently useless till backtracking is implemented.
    public void front_door()
    {
        currentLocation = "front_door";
        clearAllItems(itemsInRoom);
        addItemsToList(itemsInRoom);
    }
    
    //List of all room methods to be called on player movement.
    //Each method will replace the currentLocation string. playerIndicator background and items.
    public void living_room()
    {
        currentLocation = "living_room";
        playerIndicator.setIcon(new ImageIcon("/assignment/pkg3/locations/livingroom.png"));
        itemsInRoom[0] = "Chest";
        addItemsToList(itemsInRoom);
        Game.addToDiary("I'm starting to hear whispers. I feel a spook nearby.");
    }
    
    public void dining_room()
    {
        currentLocation = "dining_room";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/diningroom.png")));
        itemsInRoom[0] = "Candelabra";
        addItemsToList(itemsInRoom);
        Game.addToDiary("There are some leftovers around the dining table being lit by a Candelabra.");
    }
    
    public void bathroom()
    {
        currentLocation = "bathroom";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/bathroom.png")));
        itemsInRoom[0] = "Mirror";
        itemsInRoom[1] = "Shower";
        addItemsToList(itemsInRoom);
        Game.addToDiary("The door has closed behind me. The spook has outsmarted me. I will use one of these items to escape!");
    }
    
    public void kitchen()
    {
        currentLocation = "kitchen";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/kitchen.png")));
        itemsInRoom[0] = "Refrigerator";
        itemsInRoom[1] = "Cabinet";
        addItemsToList(itemsInRoom);
        Game.addToDiary("The refrigerator seems to be eating something.");
    }
    
    public void pantry()
    {
        currentLocation = "pantry";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/pantry.png")));
        itemsInRoom[0] = "Dusty recipe box";
        itemsInRoom[1] = "Broom";
        addItemsToList(itemsInRoom);
        Game.addToDiary("The door has disappeared. Maybe I can fly out of here using this broom?");
    }
    
    public void floor2()
    {
        currentLocation = "floor2";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/floor2_beginning.png")));
        clearAllItems(itemsInRoom);
        addItemsToList(itemsInRoom);
        Game.addToDiary("I hear creaking nearby. Sounds like someone is using a rocking chair.");
    }
    
    public void bedroom_1()
    {
        currentLocation = "bedroom_1";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/bedroom1.png")));
        itemsInRoom[0] = "Rocking chair";
        itemsInRoom[1] = "Window";
        addItemsToList(itemsInRoom);
        Game.addToDiary("The chair is now empty. A spook must be nearby.");
    }
    
    public void floor2_bathroom()
    {
        currentLocation = "floor2_bathroom";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/floor2_bathroom.png")));
        itemsInRoom[0] = "Mirror";
        itemsInRoom[1] = "Shower";
        addItemsToList(itemsInRoom);
        Game.addToDiary("Nothing to out of the ordinary in here.");
    }
    
    public void bedroom_2()
    {
        currentLocation = "bedroom_2";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/bedroom2.png")));
        itemsInRoom[0] = "Doll House";
        itemsInRoom[1] = "Dresser";
        addItemsToList(itemsInRoom);
        Game.addToDiary("What cute dolls! They are even playing with each other!");
    }
    
    public void master_bedroom()
    {
        currentLocation = "master_bedroom";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/masterbedroom.png")));
        itemsInRoom[0] = "Jewelry Box";
        addItemsToList(itemsInRoom);
        Game.addToDiary("I can sell some of these jewelry, not like anyone is using them.");
    }
    
    public void master_bathroom()
    {
        currentLocation = "master_bathroom";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/masterbathroom.png")));
        itemsInRoom[0] = "Intricate Oil Lamp";
        itemsInRoom[1] = "Shower";
        addItemsToList(itemsInRoom);
        Game.addToDiary("I feel the urge to live in this house from now on. Might as well see what items are in here then.");
    }
    
    //Used for player movement in the player class to check current location.
    public String getLocation()
    {
        return currentLocation;
    }
    
    //Set all conditions back to initial conditions. A restart function.
    public void restart()
    {
        currentLocation = "front_door";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/frontdoor.png")));
        itemsInRoomList.clear();
        backpack.setText(null);
        clearAllItems(itemsInRoom);
    }
    
    //Used to add items to the list from items that belong in the room.
    //Items are found in the rooms individual method. 
    //If the game had more items, It will be easier to create a class for the items.
    private void addItemsToList(String[] item)
    {
        itemsInRoomList.clear();
        for (int i = 0; i < NUMBER_OF_ITEMS; i++)
        {
            if (item[i] != null)
                itemsInRoomList.addElement(item[i]);
        }       
    }
    
    private void clearAllItems(String[] item)
    {
        for (int i = 0; i < NUMBER_OF_ITEMS; i++)
            item[i] = null;
    }
    
}
