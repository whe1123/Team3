import java.io.*;
import junit.framework.*;
import java.awt.Color;


public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
      NoFrame frame = new NoFrame();

      PacMan pacman = new PacMan("pacman", new Location(9, 11), frame.getMap());
      frame.addPacMan(new Location(9, 11));

      Ghost ghost = new Ghost("ghost", new Location(9, 12), frame.getMap());
      frame.addGhost(new Location(9, 12), "ghost", Color.red);

      frame.startGame();

      assertTrue(pacman.is_ghost_in_range());

      return null;
  }
}
