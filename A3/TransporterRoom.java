import java.util.ArrayList;
import java.util.Random;

public class TransporterRoom extends Room {
    private Random randomGenerator;
    private ArrayList<Room> allRooms;

    public TransporterRoom(String description) {
        super(description);
        randomGenerator = new Random();
    }

    // Setter to give access to all rooms from the Game
    public void setAllRooms(ArrayList<Room> allRooms) {
        this.allRooms = allRooms;
    }

    public Room getRandomRoom() {
        if (allRooms == null || allRooms.isEmpty()) {
            return this; // Fallback if list not set
        }

        int index = randomGenerator.nextInt(allRooms.size());
        return allRooms.get(index);
    }
}
