/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

import java.util.HashMap;
import java.util.Set;

public class CommandWords {
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        validCommands = new HashMap<>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("look", CommandWord.LOOK); // add LOOK support
        validCommands.put("back", CommandWord.BACK); // add BACK support
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("bye", CommandWord.QUIT); // optional
    }

    /**
     * Return the CommandWord enum value for a given string.
     * Returns UNKNOWN if the string is not a valid command.
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        return (command != null) ? command : CommandWord.UNKNOWN;
    }

    /**
     * Check whether a given String is a valid command word.
     * @return true if it is, false otherwise.
     */
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    /**
     * Return a list of valid command words (e.g. for printing help).
     */
    public String getCommandList() {
        Set<String> keys = validCommands.keySet();
        return String.join(" ", keys);
    }
}
