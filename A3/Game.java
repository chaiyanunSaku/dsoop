import java.util.ArrayList;

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
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    private ArrayList<Room> allRooms;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        allRooms = new ArrayList<>();
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, cafe, restroom, upstairs, basement, transporter;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        cafe = new Room("in the ORO cafe, very cozy");
        restroom = new Room("in the restroom for personal business provided by cafe");
        upstairs = new Room("on the second floor of the university");
        basement = new Room("in the basement... there could be truth inside... a family picture?");

        // create transporter
        transporter = new TransporterRoom("we movin");
        ((TransporterRoom)transporter).setAllRooms(allRooms);

        // Add all rooms to the list before setting exits
        allRooms.add(outside);
        allRooms.add(theater);
        allRooms.add(pub);
        allRooms.add(lab);
        allRooms.add(office);
        allRooms.add(cafe);
        allRooms.add(restroom);
        allRooms.add(upstairs);
        allRooms.add(basement);

        // set exits using map
        outside.setExit("north", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("east", cafe);

        cafe.setExit("west", outside);
        cafe.setExit("south", restroom);

        restroom.setExit("north", cafe);

        theater.setExit("west", outside);
        theater.setExit("up", upstairs);

        upstairs.setExit("down", theater);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("down", basement);

        basement.setExit("up", lab);
        basement.setExit("magic", transporter);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
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
    }


    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        CommandWord commandWord = command.getCommandWord();  // now using enum
        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.LOOK) {
            look();
        }
        else if (commandWord == CommandWord.BACK) {
            back();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
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
        System.out.println("   go quit bye help look back");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            previousRoom = currentRoom;  // save current room before moving
            currentRoom = nextRoom;

            if (currentRoom instanceof TransporterRoom) {
                TransporterRoom tRoom = (TransporterRoom) currentRoom;
                currentRoom = tRoom.getRandomRoom();  // teleport to random room
                System.out.println("You feel dizzy... You've been magically teleported!");
            }

            printLocationInfo();
        }
    }

    /*
    * Return details of the current exits.
    * Code duplication.
     */

    private String getLocationInfo() {
        return "You are " + currentRoom.getShortDescription() + "\n" + currentRoom.getExitString();
    }

    private void printLocationInfo() {
        System.out.println(getLocationInfo());
    }

    private void look() {
        printLocationInfo();
    }

    private void back() {
        if (previousRoom == null) {
            System.out.println("You can not go back from this point!");
        } else {
            Room temp = currentRoom;   // create temp room to store currentRoom
            currentRoom = previousRoom;
            previousRoom = temp;   // so we can do back to back
            printLocationInfo();
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
}
