package game;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;
    
    public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {

      
    	
    	final String RED = "\u001B[31m";
    	final String RESET = "\u001B[0m";
    	final String BLUE = "\u001B[34m";
    	
    	
    	
    
        Room[] rooms = new Room[5];
        for (int i = 0; i < rooms.length; i++)
            rooms[i] = new Room("room "+i);
        rooms[0].setExit("room 1", new NormalExit(rooms[1]));
        rooms[1].setExit("room 0", new NormalExit(rooms[0]));//from room 1 back to room 0
        rooms[1].addItem("dynamic map",new DynamicMap());
        rooms[1].setExit("room 2", new NormalExit(rooms[2]));
        rooms[2].setExit("room 1", new NormalExit(rooms[1]));//from room 2 back to room 1
        rooms[1].setExit("room 3", new NormalExit(rooms[3]));
        rooms[3].setExit("room 2", new NormalExit(rooms[1]));//from room 3 back to room 1
        rooms[3].setExit("room 4", new NormalExit(rooms[4]));
        rooms[4].setExit("room 3", new NormalExit(rooms[3]));//from room 4 back to room 3
        rooms[4].setExit("to infinity and beyond", null);

        
        
        
        over = false;
        currentRoom = rooms[0];
        

    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    /**
     * Indicate that the game is now over.
     */
    public void finishGame() { over = true; }
    
}
