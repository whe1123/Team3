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
##### attack():
- **Author:** Dan Xu
- **Method Summary:** `() -> Bool`
This method checks to see if the provided ghost is able to attack PacMan.
- **Testing:** Creates a new map. Creates a PacMan and two new Ghosts and adds these characters to the map. The attack() function is called on the ghoststo see if the they are able to attack PacMan.


##### getLoc:
- **Author:** Uyen Nguyen
- **Method Summary:** `(Location loc) -> HashSet<Type>`
This method returns the type of object (Empty, Pacman, Cookie, Ghost, Wall) at a given location.
- **Testing:** To test this method, create a map, and a Pacman at location (2, 4). Then use assertTrue to to check if getLoc returns a HashSet contains a PacMan at that location.
#####
#####


