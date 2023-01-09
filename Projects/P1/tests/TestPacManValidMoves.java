import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {
  // Tests PacMan.get_valid_moves() when a Ghost is next to it
  public void testAdjacentGhost() throws FileNotFoundException {
    // Create a map with Walls and Tokens
    MainFrame frame = new MainFrame();

    // Create PacMan
    PacMan pacman = frame.addPacMan(new Location(5,10));

    //Initialize Array List of Expected Locations
    ArrayList<Location> expectedMoves = new ArrayList<Location>();
    expectedMoves.add(new Location(9,12));
    expectedMoves.add(new Location(10,11));
    expectedMoves.add(new Location(10,12));

    System.out.println("test adjacent ghost");

    // Add ghost
    Ghost ghost = frame.addGhost(new Location(6,10), "name", Color.red);

    assertEquals(pacman.get_valid_moves(), expectedMoves);
  }

  public void testPacManValidMoves() throws FileNotFoundException {
    // Create a map with Walls and Tokens
    MainFrame frame = new MainFrame();

    // Create PacMan
    PacMan pacman = frame.addPacMan(new Location(5,10));

    //Initialize Array List of Expected Locations
    ArrayList<Location> expectedMoves = new ArrayList<Location>();
    expectedMoves.add(new Location(9,12));
    expectedMoves.add(new Location(10,11));
    expectedMoves.add(new Location(10,12));

    System.out.println("test no ghost adjacent");

    assertEquals(pacman.get_valid_moves(), expectedMoves);
  }
}
