import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestAttack extends TestCase {

  public void testAttack() throws FileNotFoundException  {
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
    
    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name"
    PacMan pacman = frame.addPacMan(new Location(0,1)); //Creates PacMan at location x, y

    // Test that the attack is successful when PacMan is within range
    assertTrue(ghost.attack());
 
  }
}
