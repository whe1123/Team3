import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestAttack extends TestCase {

  public void testAttack() throws FileNotFoundException  {
    // Create a new NoFrame object to hold the game elements
    NoFrame frame = new NoFrame();

    // Create two Ghost objects and add them to the frame
    Ghost ghost1 = frame.addGhost(new Location(2, 2), "ghost1", Color.red);
    Ghost ghost2 = frame.addGhost(new Location(4, 5), "ghost2", Color.blue);

    // Create a PacMan object and add it to the frame
    PacMan pacman = frame.addPacMan(new Location(5,5));

    // Assert that ghost1.attack() returns false, since it is not in range of PacMan
    assertFalse(ghost1.attack());

    // Assert that ghost2.attack() returns true, since it is in range of PacMan
    assertTrue(ghost2.attack());
 
  }
}
