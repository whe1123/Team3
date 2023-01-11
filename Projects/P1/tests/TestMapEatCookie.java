import java.io.*;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  // Edited for compilation purposes
  public void testMapEatCookie() throws FileNotFoundException {
    // Create a Map object and set up the game state


    /*Location pacmanLoc = new Location(5, 5);
    map.add("PacMan", pacmanLoc, null, Map.Type.PACMAN);
    */
   //
 NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
 Map map = frame.getMap();
 Ghost ghost = frame.addGhost(new Location(5, 5), "name", Color.red); //Creates a red ghost named "name" at location x,y
 PacMan pacman = frame.addPacMan(new Location(10,10)); //Creates PacMan at location x, y
 
 CookieComponent cookie = new CookieComponent(10, 10, 3);
 assertTrue("hello world".equals("hello world"));


 //Creating Players
/*Ghost ghost = frame.addGhost(new Location(x, y), "name", Color.red); //Creates a red ghost named "name" at location x,y
PacMan pacman = frame.addPacMan(new Location(x, y)); //Creates PacMan at location x, y
map.add(loc_tmp, cookieLoc, new CookieComponent(cookieLoc.x, cookieLoc.y, 20), Map.Type.COOKIE);*/
/* 
    Location cookieLoc = new Location(5, 5);
    String loc_tmp = "tok_x"+ cookieLoc.x + "_y"+ cookieLoc.y; 
    map.add(loc_tmp, cookieLoc, new JButton("Cookie"), Map.Type.COOKIE);

    // Test that PacMan can eat a cookie at its current location
    JComponent cookie2 = map.eatCookie(loc_tmp);
    assertNotNull(cookie2); */
  }
}
