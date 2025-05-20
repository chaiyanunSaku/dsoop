

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
import java.util.Map;
import java.util.Set;

public class Room
{
    private String description;
    private Map<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getShortDescription() {
        return description;
    }

    public String getExitString() {
        StringBuilder exitString = new StringBuilder("Exits:");
        for (String dir : exits.keySet()) {
            exitString.append(" ").append(dir);
        }
        return exitString.toString();
    }

    public Set<String> getExits() {
        return exits.keySet();
    }
}
