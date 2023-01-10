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
    if (components.containsKey(name) && (type == Map.Type.PACMAN || type ==Map.Type.GHOST)){
      if (field.containsKey(loc)) {
        HashSet<Type> tempTypeSet = field.get(loc);
        tempTypeSet.add(type);
        field.put(loc, tempTypeSet);
      } else { 
        return false
      }

      // Update locations, and components
      locations.put(name, loc);
      components.put(name, components.get(name)); // Seems redundant?

      // Update JComponent depending on type using setLocation(...)
      // to move it to the new location. Returns true
      if (type == Map.Type.PACMAN) {
        components.get(name).setLocation(loc.x, loc.y);
        return true;
      } else if (type == Map.Type.GHOST) {
        components.get(name).setLocation(loc.x, loc.y);
        return true;
      } else if (type == Map.Type.WALL) {
        components.get(name).setLocation(loc.x, loc.y); 
        return true;
      } else if (type == Map.Type.COOKIE) {
        components.get(name).setLocation(loc.x, loc.y);
        return true;
      } else {
        // Returns false for invalid Map.Types and Map.Type.Empty
        return false;
      }
    } else {
      // Returns false for trying to move objects with names
      // that do not match existing names (should use add instead)
      // OR for trying to move Map.Type.Empty objects.
      return false;
    }
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return null;
  }

  public boolean attack(String Name) {
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    return null;
  }
}
