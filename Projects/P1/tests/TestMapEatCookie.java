import java.io.*;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  // Edited for compilation purposes
  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map myMap = frame.getMap();
    int initialCookieCount = myMap.getCookies();
    
    //Create a cookie at a specific location
    Location cookieLocation = new Location(1,1);
    CookieComponent tok = new CookieComponent(cookieLocation.x, cookieLocation.y, 20);
    myMap.add("tok_x1_y1", cookieLocation, tok, Map.Type.COOKIE);

    //Test that the cookie is present in the map before being consumed
    assertTrue(myMap.getLoc(cookieLocation).contains(Map.Type.COOKIE));
    
    myMap.eatCookie("tok_x1_y1"); // Eating a cookie using its key
    
    //Test that eating a cookie decreases the total cookie count by 1
    assertEquals(initialCookieCount + 1, myMap.getCookies());  
  }
}
