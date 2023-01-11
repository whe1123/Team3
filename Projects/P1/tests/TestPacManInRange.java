import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManInRange extends TestCase {

    public void testPacManInRange() throws FileNotFoundException {
        NoFrame frame = new NoFrame();

	PacMan pacman = new PacMan("pacman", new Location(9, 12), frame.getMap());
	frame.addPacMan(new Location(9, 12));

	Ghost ghost = new Ghost("ghost", new Location(9, 11), frame.getMap());
	frame.addGhost(new Location(9, 11), "ghost", Color.red);

	Ghost ghost2 = new Ghost("ghost2", new Location(1, 1), frame.getMap());
	frame.addGhost(new Location(1, 1), "ghost2", Color.orange);

	frame.startGame();

	assertTrue(ghost.is_pacman_in_range());
	assertFalse(ghost2.is_pacman_in_range());

    }
}
