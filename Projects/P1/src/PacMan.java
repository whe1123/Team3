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

  public ArrayList<Location> get_valid_moves() {
    return null;
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
