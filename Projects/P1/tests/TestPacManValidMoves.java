import java.io.*;
import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  // Create a map with Walls and Tokens
  Mainframe frame = new MainFrame();

  // Create PacMan
  PacMan pacman = frame.addPacMan(new Location(5,10));


  @Test
  public void testAdjacentGhost(){
    System.out.println("test adjacent ghost")

    // Add ghost
    Ghost ghost = frame.addGhost(new Location(6,10), "name", Color.red);

    pacman.get_valid_moves()

  }

  public void testPacManValidMoves() throws FileNotFoundException {
    return null;
  }
}
