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
   * Method written by adhetzer
   */
  public boolean move(String name, Location loc, Type type) {
    // Update locations, and field
    locations.put(name, loc)
    field.put(loc, type)

    // Update components depending on type.
    // Use the setLocation method for the respective component 
    // to move it to the new location
    if (type == Map.Type.PACMAN) {
      components.put(name, new PacManComponent(loc.x, loc.y, 1)) // Should scale be 1?
      PacManComponent.setLocation(loc.x, loc.y) 

      return True
    } else if (type == Map.Type.GHOST) {
      components.put(name, new GhostComponent(loc.x, loc.y, Color.red, 1)) // Should scale be 1?
      GhostComponent.setLocation(loc.x, loc.y) 

      return True
    } else if (type == Map.Type.WALL) {
      components.put(name, new WallComponent(loc.x, loc.y, 1)) // Should scale be 1?
      WallComponent.setLocation(loc.x, loc.y) 

      return True
    } else if (type == Map.Type.COOKIE) {
      components.put(name, new CookieComponent(loc.x, loc.y, 1)) // Should scale be 1?
      CookieComponent.setLocation(loc.x, loc.y) 

      return True
    } else {
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
