import java.io.*;
import junit.framework.*;

public class TestAttack extends TestCase {

  public void testAttack()  {
    // Create a Map object and set up the game state
    Map map = new Map(10);
    Location pacmanLoc = new Location(5, 5);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    Location ghostLoc = new Location(4, 5);
    map.add("Ghost", ghostLoc, null, Map.Type.GHOST);

    // Create a Ghost object and set its myMap field to the Map object
    Ghost ghost = new Ghost("Ghost", ghostLoc, map);

    // Test that the attack is successful when PacMan is within range
    assertTrue(ghost.attack());

    // Test that the attack fails when PacMan is out of range
    ghostLoc = new Location(0, 0);
    ghost.myLoc = ghostLoc;
    assertFalse(ghost.attack());
  }
}
