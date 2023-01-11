import java.io.*;
import junit.framework.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); // Create a new map
		PacMan man = frame.addPacMan(new Location(2, 4)); 
		assertTrue(man.myMap.getLoc(new Location (2, 4)).contains(Map.Type.PACMAN));
  }
}
