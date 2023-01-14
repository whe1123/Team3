import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {
  // Tests Ghost.get_valid_moves() with nothing next to Ghost
  public void testGhostValidMoves() throws FileNotFoundException {
    // Create the map
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(6, 11), "name", Color.red);

    ArrayList<Location> validMoveSet = ghost.get_valid_moves();
    Location testLocation = new Location(7, 11);

    assertTrue(validMoveSet.contains(testLocation));
  }
}