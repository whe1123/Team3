import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

//import com.sun.xml.internal.bind.v2.runtime.Location;


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

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
	  if (type != Map.Type.EMPTY && type != Map.Type.WALL)
	  {
		  field.get(locations.get(name)).remove(type);
		  locations.put(name, loc);
		  components.get(name).setLocation(loc.y, loc.x);
		  
		  if (field.get(loc) == null)
		  {
			  field.put(loc, new HashSet<Type>());
		  }
		  
		  field.get(loc).add(type);
		  
		  return true;
		  
	  }
	  else
	  {
		  return false;
	  }
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return this.field.get(loc);
  }

  public boolean attack(String Name) {
    // update gameOver
	  Location ghost = locations.get(Name);
	  
	  if(field.get(ghost).contains(Map.Type.EMPTY))
	  {
		  return true;
		  
	  }
	  
	  return false;
    
  }

  public JComponent eatCookie(String name) {
    Location local = locations.get(name);
    String strCookie = "tok_x" + local.x + "_y" + local.y;
    JComponent compo = components.get(strCookie);

    if (locations.containsKey(strCookie)) {
        locations.remove(strCookie);  

        if (field.get(local).isEmpty()) {
            field.get(local).add(Map.Type.EMPTY);
            field.get(local).remove(Map.Type.COOKIE);
        }

 	cookies += 1;
    }
    return compo;
	  
  }
}
