import java.util.ArrayList;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  /**  
   * This method returns all the valid moves that a Ghost can 
   * make given its current position. 
   * 
   * It is valid for a Ghost to move into a Cookie, Ghost, Empty
   * or PacMan. 
   * It is not valid for a Ghost to move into a Wall.
   * 
   * Note: This logic is similar to PacMan.get_valid_moves()
   * 
   * Method by adhetzer
  */
  public ArrayList<Location> get_valid_moves() {
    Location currentLoc = this.myLoc;
    ArrayList<Location> validMoves;
    validMoves = new ArrayList<Location>();

    // There are eight locations surrounding a Ghost's current location
    // So, we will check if any of these locations are a Map.Type.WALL.
    // The outer for loop will be used to adjust the x-coordinate 
    // to be checked. The inner for loop will be used to adjust the
    // y-coordinate to be checked.
    for (int x = -1; x < 2; x++) {
      for (int y = -1; y < 2; y++) {
        Location testLocation = currentLoc.shift(currentLoc.x + x, currentLoc.y + y);

        // The only non-valid move for a Ghost is going through a WALL
        if (!(this.myMap.getLoc(testLocation).contains(Map.Type.WALL))) {
          validMoves.add(testLocation);
        }
      }
    }
    
    return validMoves;
  }

  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}
