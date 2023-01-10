# cmsc389T-winter23
# PACMAN by Team 3
## Aaron Hetzer, Uyen Nguyen, Dan Xu, Syed Zaidi

### 1. Image of playing PacMan

### 2. How to run the code from the command line
```bash
cd {path_to_P1}
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

### 3. Functions with implementation and testing
#### 3.1 PacMan Class
#####

##### get_valid_moves():
- **Author:** Aaron Hetzer
- **Method Summary:** `() -> ArrayList<Location>`
This method checks to see if it is valid for PacMan to move to his surrounding location. A move is considered valid if the location is not already occupied by a Map.Type.WALL object. This method returns an ArrayList<Location> of valid move locations.
- **Testing:** This method has two tests: `testAdjacentGhost()` checks if a `Ghost` next to the PacMan returns an incorrect ArrayList? It creates a new map. Creates a Pacman at location (5, 10). Creates an `ArrayList<Location>` of expected valid moves. Creates a `Ghost` object at location (6,10). Checks `get_valid_moves()` against the expected valid moves. `testPacManValidMoves()()` uses the same setup as `testAdjacentGhost()` but with no adjacent `Ghost`.

##### is_ghost_in_range():
- **Author:** Dan Xu
- **Method Summary:** `() -> Bool`
This method checks to see if there are any ghosts within attack range of PacMan. A ghost is considered in attack range if it is within 1 space of Pacman's position.
- **Testing:** Creates a new map. Creates two PacMans and a new Ghost and adds these characters to the map. The is_ghost_in_range() function is called on the Pacman objects to see if the ghost is within attacking range.

##### move():
- **Author:** Uyen Nguyen
- **Method Summary:** `() -> Bool`
This method implements PacMan's movements. First, it finds a set of locations where PacMan can move by using get_valid_moves. Then, it randomly chooses one of those locations, implements the move, and returns true. Otherwise, the set of location is empty, and the method returns false because PacMan cannot move.
- **Testing:** Create a new map. Create a Pacman at location (1, 3). Add the pacman to map at the same location. Use getLoc to check if Pacman is at (1, 3). Let it move. Use getLoc to check location (1, 3) to see whether Pacman is still there.
#####
#####
#### 3.2 Ghost Class
#####
##### is_pacman_in_range():
- **Author:** Dan Xu
- **Method Summary:** `() -> Bool`
This method checks to see if there PacMan is within attack range of a ghost. PacMan is considered in attack range if it is within 1 space of a ghost's position.
- **Testing:** Creates a new map. Creates a new Pacman and two new Ghosts and adds these characters to the map. The is_pacman_in_range() function is called on the ghosts to see if PacMan is within attacking range.

##### move():
- **Author:** Uyen Nguyen
- **Method Summary:** `() -> Bool`
This method implements Ghost's movements. First, it finds a set of locations where Ghost can move by using get_valid_moves. Then, it randomly chooses one of those locations, implements the move, and returns true. Otherwise, the set of location is empty, and the method returns false because Ghost cannot move.
- **Testing:** Create a new map. Create a ghost at location (1, 3). Add the ghost to map at the same location. Use getLoc to check if ghost is at (1, 3). Let it move. Use getLoc to check location (1, 3) to see whether ghost is still there.
#####
#####
#### 3.3 Map Class
#####

##### move():
- **Author:** Aaron Hetzer
- **Method Summary:** `(String name, Location loc, Type type) -> Bool`
This method takes in the name, and type of a Ghost or PacMan object on the Map, and a existing location to move that object to. If the name doesn't exist in `components`, the loc doesn't exist in `locations` or the type is not PACMAN or GHOST, then the method returns false. Otherwise, the method updates the `locations`, `field`, and `components` HashMaps to reflect this move, updates the JComponent based on the type, and returns true.
- **Testing:** This method has six tests. Each of them have the same setup: Initialize a set of variables, a Map, Ghost, and PacMan objects. The tests then use this set up to check if a valid PacMan move returns true, an invalid location PacMan move returns false, a valid Ghost move returns true, and a Wall move, an Empty move, and an invalid name move all return false

##### attack():
- **Author:** Dan Xu
- **Method Summary:** `() -> Bool`
This method checks to see if the provided ghost is able to attack PacMan.
- **Testing:** Creates a new map. Creates a PacMan and two new Ghosts and adds these characters to the map. The attack() function is called on the ghoststo see if the they are able to attack PacMan.


##### getLoc(Location loc):
- **Author:** Uyen Nguyen
- **Method Summary:** `(Location loc) -> HashSet<Type>`
This method returns the type of object (Empty, Pacman, Cookie, Ghost, Wall) at a given location.
- **Testing:** To test this method, create a map, and a Pacman at location (2, 4). Then use assertTrue to to check if getLoc returns a HashSet contains a PacMan at that location.
#####
#####


