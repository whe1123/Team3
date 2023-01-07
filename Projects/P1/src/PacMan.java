import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  /**  
   * This method returns all the valid moves that PacMan can 
   * make given his current position. 
   * 
   * It is valid for PacMan to move into a Cookie, Ghost, or Empty. 
   * It is not valid for PacMan to move into a Wall.
   * 
   * Method by adhetzer
  */ 
  public ArrayList<Location> get_valid_moves() {
    currentLoc = self.myLoc
    ArrayList<Location> validMoves = null

    // There are eight locations surrounding PacMan's current location
    // So, we will check if any of these locations are a Map.Type.WALL.
    // The outer for loop will be used to adjust the x-coordinate 
    // to be checked. The inner for loop will be used to adjust the
    // y-coordinate to be checked.
    for (x = -1; x < 2; x++) {
      for (y = -1; y < 2; y++) {
        testLocation = currentLoc.shift(currentLoc + x, currentLoc + y)

        // The only non-valid move for PacMan is going through a WALL
        if (map.getLocation(testLocation) != Map.Type.WALL) {
          validMoves.add(testLocation)
        }
      }
    }
    
    return validMoves;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
