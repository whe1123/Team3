import junit.framework.*;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
      NoFrame frame = new NoFrame();

      PacMan pacman = new PacMan("pacman", new Location(9, 12), frame.getMap());
      frame.addPacMan(new Location(9, 12));
      
      Ghost ghost = new Ghost("ghost", new Location(9, 11), frame.getMap());
      frame.addGhost(new Location(9, 11), "ghost", Color.red);

      Ghost ghost2 = new Ghost("ghost2", new Location(1, 1), frame.getMap());
      frame.addGhost(new Location(1, 1), "ghost2", Color.orange);

      frame.startGame();

      assertTrue(frame.attack("ghost"));
      assertFalse(frame.attack("ghost2"));
  }
}
