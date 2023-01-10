import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

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
   * Note: The logic of this method is similar to Ghosts.get_valid_moves()
   * 
   * Method by adhetzer
  */ 
  public ArrayList<Location> get_valid_moves() {
    Location currentLoc = this.myLoc;
    ArrayList<Location> validMoves;
    validMoves = new ArrayList<Location>();

    // There are eight locations surrounding PacMan's current location
    // So, we will check if any of these locations are a Map.Type.WALL.
    // The outer for loop will be used to adjust the x-coordinate 
    // to be checked. The inner for loop will be used to adjust the
    // y-coordinate to be checked.
    for (int x = -1; x < 2; x++) {
      for (int y = -1; y < 2; y++) {
        Location testLocation = currentLoc.shift(currentLoc.x + x, currentLoc.y + y);

        // The only non-valid move for PacMan is going through a WALL
        if (!(this.myMap.getLoc(testLocation).contains(Map.Type.WALL))) {
          validMoves.add(testLocation);
        }
      }
    }
    
    return validMoves;
  }

  public boolean move() {
    ArrayList<Location> smove = get_valid_moves();
    
    // PacMan not able to move
    if (smove.isEmpty())
    {
    	return false;
    }
    else
    {
    	// Choose a random valid move
    	Random rand = new Random();
    	int getRanNum = rand.nextInt(smove.size());
    	Location des = smove.get(getRanNum); 
    	
    	//Implement moving
    	myLoc = des;
    	myMap.move(myName, des, Map.Type.PACMAN);
    	
    	return true;
    }
  }

  public boolean is_ghost_in_range() {

    int tempX = myLoc.x;
    int tempY = myLoc.y;

    // Scrolls through all the X values
    for(int i = tempX - 1; i <= tempX + 1; i++){

	// Scrolls through all the Y values
        for(int j = tempY - 1; j <= tempY + 1; j++){
            Location tempLoc = new Location(i, j);
	    
	    // Checks if the current location is a ghost
	    if(myMap.getLoc(tempLoc).contains(Map.Type.GHOST)){
	        return true;
	    }
	}
    }

    return false;
  }

  public JComponent consume() {
  JComponent cookie = myMap.eatCookie(myLoc);
  if (cookie != null) {
    return cookie;
  }
  return null;
  }
}
