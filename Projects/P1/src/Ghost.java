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

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  public boolean move() {
    return false;
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
  if (!is_pacman_in_range()) {
    return false;
    Location pacmanLoc = myMap.locations.get("PacMan");
    myMap.move(myName, pacmanLoc, Type.GHOST);
    return true;
  }
  Location pacmanLoc = myMap.locations.get("PacMan");
  myMap.move(myName, pacmanLoc, Type.GHOST);
  return true;
  }
}
