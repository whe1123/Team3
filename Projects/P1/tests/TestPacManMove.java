import java.io.*;
import junit.framework.*;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); // Create new map
    PacMan man = new PacMan("pacman", new Location(1, 3), frame.getMap());
    frame.addPacMan(new Location(1, 3));
    
    frame.startGame();

    assertTrue(frame.getMap().getLoc(new Location(1, 3)).contains(Map.Type.PACMAN));

    man.move();

    assertFalse(frame.getMap().getLoc(new Location(1, 3)).contains(Map.Type.PACMAN));
  }
}
