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
    return false;
  }

  public boolean attack() {
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
