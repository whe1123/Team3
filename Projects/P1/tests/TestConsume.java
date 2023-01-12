import java.io.*;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.*;

public class TestConsume extends TestCase {

  public void testConsume() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map myMap = frame.getMap();
    PacMan pacman = frame.addPacMan(new Location(5,5));

    //Create a cookie at a specific location
    Location cookieLocation = new Location(5,5);
    CookieComponent tok = new CookieComponent(cookieLocation.x, cookieLocation.y, 20);
    myMap.add("tok_x5_y5", cookieLocation, tok, Map.Type.COOKIE);

    //Test that consuming a cookie returns the correct component
    assertEquals(tok, pacman.consume());
  }
}
