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
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
