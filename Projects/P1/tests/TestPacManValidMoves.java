import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManValidMoves extends TestCase {

  @Test
  public void testAdjacentGhost(){
    // Create a map with Walls and Tokens
    MainFrame frame = new MainFrame();

    // Create PacMan
    PacMan pacman = frame.addPacMan(new Location(5,10));

    ArrayList<Location> expectedMoves = {new Location(9,12), new Location(10,11), new Location(10,12)};

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

    ArrayList<Location> expectedMoves = {new Location(9,12), new Location(10,11), new Location(10,12)};

    System.out.println("test no ghost adjacent");

    assertEquals(pacman.get_valid_moves(), expectedMoves);
  }
}
