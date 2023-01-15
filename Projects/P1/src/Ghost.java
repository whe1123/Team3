import java.util.ArrayList;
import java.util.Random;

//import javax.tools.DocumentationTool.Location;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
	  ArrayList<Location> setOfMove = new ArrayList<Location>();
		
		if (myMap.getLoc(myLoc.shift(0, 1)) != null)
		{
			if (!myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.WALL))
			{
				setOfMove.add(myLoc.shift(0, 1));
			}
		}
		
		if (myMap.getLoc(myLoc.shift(0, -1)) != null)
		{
			if (!myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.WALL))
			{
				setOfMove.add(myLoc.shift(0, -1));
			}
		}
		
		if (myMap.getLoc(myLoc.shift(1, 0)) != null)
		{
			if (!myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.WALL))
			{
				setOfMove.add(myLoc.shift(1, 0));
			}
		}
		
		if (myMap.getLoc(myLoc.shift(-1, 0)) != null)
		{
			if (!myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.WALL))
			{
				setOfMove.add(myLoc.shift(-1, 0));
			}
		}
	    return setOfMove;
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
	  for(int i = tempX - 1; i < tempX + 1; i++)
	  {
		  // Scrolls through all the Y values
		  for(int j = tempY - 1; j < tempY + 1; j++)
		  {
			  Location tempLoc = new Location(j, j);
			  // Checks if the current location is a pacman

			  if(((myMap.getLoc(tempLoc).contains(Map.Type.GHOST))
							  || (myMap.getLoc(myLoc)).contains(Map.Type.GHOST)))
			  {
				  return true;
				  }
			  }
		  }
	  return false;
  }


  
  public boolean attack() {
	  if (is_pacman_in_range()) {
		  myMap.attack(myName);
		  return true;
	  }
	  return false;
  }
}
