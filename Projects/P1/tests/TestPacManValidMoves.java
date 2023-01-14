import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {
  // Tests PacMan.get_valid_moves() when a Ghost is not next to it
  public void testPacManValidMoves() throws FileNotFoundException {
    // Create a map
    NoFrame frame = new NoFrame();

    // Create a pacman
	  PacMan pacman = frame.addPacMan(new Location(4, 1));
	  
	  ArrayList<Location> validMoveSet = pacman.get_valid_moves();
	  Location testLocation = new Location(3, 1);

	  assertTrue(validMoveSet.contains(testLocation));
  }
}
