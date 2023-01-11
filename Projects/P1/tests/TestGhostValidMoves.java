import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {
  // Test Ghost.get_valid_moves() with PacMan next to the ghost
  public void testGhostValidMovesPacManAdjacent() throws FileNotFoundException {
    // Create a map with Walls and Tokens
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();
    

    // Create PacMan
    PacMan pacman = frame.addPacMan(new Location(6,10));

    //Initialize Array List of Expected Locations
    ArrayList<Location> expectedMoves;
    expectedMoves = new ArrayList<Location>();
      expectedMoves.add(new Location(9,12));
      expectedMoves.add(new Location(10,11));
      expectedMoves.add(new Location(10,12));

    System.out.println("test adjacent pacman");

    // Add ghost
    Ghost ghost = frame.addGhost(new Location(5,10), "name", Color.red);

    assertEquals(ghost.get_valid_moves(), expectedMoves);
  }

  // Tests Ghost.get_valid_moves() with nothing next to Ghost
  public void testGhostValidMovesNoAdjacent() throws FileNotFoundException {
    // Create a map with Walls and Tokens
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create PacMan
    Ghost ghost = frame.addGhost(new Location(5,10), "name", Color.red);

    //Initialize Array List of Expected Locations
    ArrayList<Location> expectedMoves;
    expectedMoves = new ArrayList<Location>();
      expectedMoves.add(new Location(9,12));
      expectedMoves.add(new Location(10,11));
      expectedMoves.add(new Location(10,12));

    System.out.println("test nothing adjacent");

    assertEquals(ghost.get_valid_moves(), expectedMoves);
  }
}
