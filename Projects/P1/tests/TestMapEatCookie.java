import java.io.*;
import junit.framework.*;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    // Create a Map object and set up the game state
    Map map = new Map(10);
    Location pacmanLoc = new Location(5, 5);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    Location cookieLoc = new Location(5, 5);
    map.add("tok_" + cookieLoc.toString(), cookieLoc, new JButton("Cookie"), Type.COOKIE);

    // Test that PacMan can eat a cookie at its current location
    JComponent cookie = map.eatCookie("PacMan");
    assertNotNull(cookie);
    assertEquals(map.getCookies(), 1);

    // Test that PacMan can't eat a cookie at a different location
    pacmanLoc = new Location(0, 0);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    JComponent cookie = map.eatCookie("PacMan");
    assertNull(cookie);
    assertEquals(map.getCookies(), 1);
  }
}
