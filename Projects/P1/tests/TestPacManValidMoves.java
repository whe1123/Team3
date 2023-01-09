import java.io.*;
import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  @Test
  public void testAdjacentGhost(){
    // Create a map with Walls and Tokens
    Mainframe frame = new MainFrame();

    // Create PacMan
    PacMan pacman = frame.addPacMan(new Location(5,10));

    System.out.println("test adjacent ghost");

    // Add ghost
    Ghost ghost = frame.addGhost(new Location(6,10), "name", Color.red);

    assertEquals(pacman.get_valid_moves(), {(9,12), (10,11), (10,12)});
  }

  public void testPacManValidMoves() throws FileNotFoundException {
    // Create a map with Walls and Tokens
    Mainframe frame = new MainFrame();

    // Create PacMan
    PacMan pacman = frame.addPacMan(new Location(5,10));

    System.out.println("test no ghost adjacent");

    assertEquals (pacman.get_valid_moves(), {(9,12), (10,11), (10,12)});
  }
}
