import java.io.*;
import junit.framework.*;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); // Create new map
	  Ghost ghost = new Ghost("ghost", new Location(1, 3), frame.getMap());
	  frame.addGhost(new Location(1,3), "ghost", Color.orange);
	    
	  frame.startGame();

	  assertTrue(frame.getMap().getLoc(new Location(1, 3)).contains(Map.Type.GHOST));

	  ghost.move();

	  assertFalse(frame.getMap().getLoc(new Location(1, 3)).contains(Map.Type.GHOST));
  }
}
