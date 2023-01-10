import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  /**
   * This method takes a name, location, and Map.Type and puts the object
   * specified by the name at the location specified.
   * 
   * If the method is able to succesfully move the object, it returns True.
   * Otherwise, the method returns false.
   * 
   * The method requires the object specified by the name to already exist
   * to return true.
   * 
   * Method written by adhetzer
   */
  public boolean move(String name, Location loc, Type type) {
    // Check if the object to be moved exists in components. If not
    // return false. Otherwise continue to move.
    if (components.containsKey(name) && (type == Map.Type.PACMAN || type == Map.Type.GHOST)){
      if (field.containsKey(loc)) {
        HashSet<Type> tempTypeSet = field.get(loc);
        tempTypeSet.add(type);
        field.put(loc, tempTypeSet);
      } else { 
        // Returns false if location attempting to move to is not in field
        return false;
      }

      // Update locations, and components
      locations.put(name, loc);
      components.put(name, components.get(name)); // Seems redundant?

      // Update JComponent depending on type using setLocation(...)
      // to move it to the new location. Returns true
      components.get(name).setLocation(loc.x, loc.y);

      return true;
    } else {
      // Returns false for trying to move objects with names
      // that do not match existing names (should use add instead)
      // OR for trying to move objects that are not Map.Type.GHOST
      // or Map.Type.PACMAN 
      return false;
    }
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    HashSet<Type> typeObj = field.get(loc);
    return typeObj;
  }

  public boolean attack(String Name) {
    // update gameOver
    Location ghostLoc = locations.get(Name);

    if(map.getLoc(ghostLoc).is_pacman_in_range()){
        map.getLoc(ghostLoc).attack();
	gameOver = true;
	return true;
    }
    
    return false;
  }

  public JComponent eatCookie(String name) {
    Location loc = locations.get(name);
    HashSet<Type> types = getLoc(loc);
    if (!types.contains(Type.COOKIE)) {
      return null;
    }
    types.remove(Type.COOKIE);
    field.put(loc, types);
    cookies++;
    JComponent cookie = components.get("tok_" + loc.toString());
    locations.remove("tok_" + loc.toString());
    components.remove("tok_" + loc.toString());
    return cookie;
  }
}
