import java.util.ArrayList;
import java.util.Random;

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
	    	myMap.move(myName, des, Map.Type.GHOST);
	    	
	    	return true;
	    }
  }

  public boolean is_pacman_in_range() {
    
    int tempX = myLoc.x;
    int tempY = myLoc.y;

    // Scrolls through all the X values
    for(int i = tempX - 1; i <= tempX + 1; i++){
        
	//Scrolls through all the Y values
	for(int j = tempY - 1; j <= tempY + 1; j++){
	    Location tempLoc = new Location(i, j);

	    // Checks if the current location is a pacman
	    if(myMap.getLoc(tempLoc).contains(Map.Type.PACMAN)){
	        return true;
	    }
	}
    }

    return false;
  }

  public boolean attack() {
    // Based on Dan Xu's method for is_pacman_in_range
    if (!is_pacman_in_range()) {
      return false;
    }
    else{
      int v1 = myLoc.x;
      int v2 = myLoc.y;
  
      // Scrolls through all the X values
      for(int i = v1 - 1; i <= v1 + 1; i++){
        System.out.println("Test1");
        //Scrolls through all the Y values
        for(int j = v2 - 1; j <= v2 + 1; j++){
            Location tempLoc = new Location(i, j);
          System.out.println("Test1");
            // Checks if the current location is a pacman
            if(myMap.getLoc(tempLoc).contains(Map.Type.PACMAN)){
                myMap.move(myName, tempLoc, Map.Type.GHOST);
                System.out.println("Test3");
                return true;
            }
        }
      }
  
      return false;
    }

}

}

