import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapMove extends TestCase {
  // Test Map.Type.PACMAN valid
  public void testMapMovePACMAN() throws FileNotFoundException { 
    // Initialize variables
    int name_x = 5;
    int name_y = 5;
    int pac_x = 2;
    int pac_y = 4;

    // Create a Map
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create Players
    Ghost ghost = frame.addGhost(new Location(name_x, name_y), "name", Color.red);
    PacMan pacman = frame.addPacMan(new Location(pac_x, pac_y));

    // Begin test(s)
    // Check PACMAN valid move
    System.out.println("Testing Map.move() with pacman, at 2,4, as PACMAN -> Valid");
    assertEquals(true, frame.getMap().move("pacman", new Location(2,4), Map.Type.PACMAN));

    // Check PACMAN invalid move - invalid loc
    System.out.println("Testing Map.move() with pacman, at -1, -1, as PACMAN -> Invalid loc");
    assertEquals(frame.getMap().move("pacman", new Location(-1,-1), Map.Type.PACMAN), false);
  }

  // Test PACMAN at invalid location
  public void testMapMovePACMANInvalidLoc() throws FileNotFoundException { 
    // Initialize variables
    int name_x = 5;
    int name_y = 5;
    int pac_x = 2;
    int pac_y = 4;

    // Create a Map
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create Players
    Ghost ghost = frame.addGhost(new Location(name_x, name_y), "name", Color.red);
    PacMan pacman = frame.addPacMan(new Location(pac_x, pac_y));

    // Begin test(s)

    // Check PACMAN invalid move - invalid loc
    System.out.println("Testing Map.move() with pacman, at -1, -1, as PACMAN -> Invalid loc");
    assertEquals(false, frame.getMap().move("pacman", new Location(-1,-1), Map.Type.PACMAN));
  }

  // Test Map.Type.GHOST valid
  public void testMapMoveGHOST() throws FileNotFoundException {
    // Initialize variables
    int name_x = 5;
    int name_y = 5;
    int pac_x = 2;
    int pac_y = 4;

    // Create a Map
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create Players
    Ghost ghost = frame.addGhost(new Location(name_x, name_y), "name", Color.red);
    PacMan pacman = frame.addPacMan(new Location(pac_x, pac_y)); 
    
    // Begin test(s)
    // Check GHOST valid move
    System.out.println("Testing Map.move() with name, at 5,5, as GHOST -> Valid");
    assertEquals(true, frame.getMap().move("name", new Location(5,5), Map.Type.GHOST), true);

    // Check GHOST invalid move - Invalid name
    System.out.println("Testing Map.move() with name_invalid, at 5, 5, as GHOST -> Invalid name");
    assertEquals(frame.getMap().move("name_invalid", new Location(5,5), Map.Type.GHOST), false);
  }

  // Check WALL invalid move - all WALL are invalid moves
  public void testMapMoveWALL() throws FileNotFoundException {
    // Initialize variables
    int name_x = 5;
    int name_y = 5;
    int pac_x = 2;
    int pac_y = 4;

    // Create a Map
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create Players
    Ghost ghost = frame.addGhost(new Location(name_x, name_y), "name", Color.red);
    PacMan pacman = frame.addPacMan(new Location(pac_x, pac_y)); 

    // Begin test(s)
    System.out.println("Testing Map.move() with wall, at 0, 0, as WALL -> Valid");
    assertEquals(false, frame.getMap().move("wall", new Location(0, 0), Map.Type.WALL));
  }

  // Check EMPTY invalid move - all EMPTY are invalid moves
  public void testMapMoveEMPTY() throws FileNotFoundException {
    // Initialize variables
    int name_x = 5;
    int name_y = 5;
    int pac_x = 2;
    int pac_y = 4;

    // Create a Map
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create Players
    Ghost ghost = frame.addGhost(new Location(name_x, name_y), "name", Color.red);
    PacMan pacman = frame.addPacMan(new Location(pac_x, pac_y)); 

    // Begin test(s)
    // Check EMPTY invalid move - EMPTY can't move
    System.out.println("Testing Map.move() with empty, at 1, 1, as EMPTY -> Valid");
    assertEquals(false, frame.getMap().move("empty", new Location(1, 1), Map.Type.EMPTY));
  }

  // Check name not contained in components invalid move
  public void testMapMoveInvalidName() throws FileNotFoundException {
    // Initialize variables
    int name_x = 5;
    int name_y = 5;
    int pac_x = 2;
    int pac_y = 4;

    // Create a Map
    //MainFrame frame = new MainFrame();
    NoFrame frame = new NoFrame();

    // Create Players
    Ghost ghost = frame.addGhost(new Location(name_x, name_y), "name", Color.red);
    PacMan pacman = frame.addPacMan(new Location(pac_x, pac_y)); 

    // Begin test(s)
    System.out.println("Testing Map.move() with morbid_angel, at 1, 1, as PACMAN -> Invalid name");
    assertEquals(frame.getMap().move("morbid_angel", new Location(2, 4), Map.Type.PACMAN), false);
  }
}
