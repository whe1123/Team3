import java.io.*;
import junit.framework.*;

public class TestConsume extends TestCase {

  public void testConsume() {
    // Create a Map object and set up the game state
    Map map = new Map(10);
    Location pacmanLoc = new Location(5, 5);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    Location cookieLoc = new Location(5, 5);
    map.add("tok_" + cookieLoc.toString(), cookieLoc, new JButton("Cookie"), Type.COOKIE);

    // Create a PacMan object and set its myMap field to the Map object
    PacMan pacman = new PacMan("PacMan", pacmanLoc, map);

    // Test that PacMan can consume a cookie at its current location
    JComponent cookie = pacman.consume();
    assertNotNull(cookie);

    // Test that PacMan can't consume a cookie at a different location
    pacmanLoc = new Location(0, 0);
    pacman.myLoc = pacmanLoc;
    JComponent cookie = pacman.consume();
    assertNull(cookie);
  }
}
