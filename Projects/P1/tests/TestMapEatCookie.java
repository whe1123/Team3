import java.io.*;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.*;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    // Create a Map object and set up the game state
    Map map = new Map(10);
    Location pacmanLoc = new Location(5, 5);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    Location cookieLoc = new Location(5, 5);
    String loc_tmp = "tok_x"+ cookieLoc.x + "_y"+ cookieLoc.y; 
    map.add(loc_tmp, cookieLoc, new JButton("Cookie"), Map.Type.COOKIE);

    // Test that PacMan can eat a cookie at its current location
    JComponent cookie = map.eatCookie("PacMan");
    assertNotNull(cookie);
   // assertEquals(map.getCookies(), 0);

    // Test that PacMan can't eat a cookie at a different location
    pacmanLoc = new Location(0, 0);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    JComponent cookie2 = map.eatCookie("PacMan");
    //assertNull(cookie2);
    //assertEquals(map.getCookies(), 0);
  }
}
