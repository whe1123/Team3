# cmsc389T-winter23
# PACMAN by Team 3
## Aaron Hetzer, Uyen Nguyen, Dan Xu, Syed Zaidi

## Image of playing PacMan

## How to run the code from the command line
```bash
cd {path_to_P1}
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## Functions with implementation and testing
### PacMan Class
####
#### move():
- **Author:** Uyen Nguyen
- **Method Summary:** () -> Bool
This method implements PacMan's movements. First, it finds a set of locations where PacMan can move by using get_valid_moves. Then, it randomly chooses one of those locations, implements the move, and returns true. Otherwise, the set of location is empty, and the method returns false because PacMan cannot move.


JUnit Test:
####
####
### Ghost Class
####
#### move():
- **Author:** Uyen Nguyen
- **Method Summary:** () -> Bool
This method implements Ghost's movements. First, it finds a set of locations where Ghost can move by using get_valid_moves. Then, it randomly chooses one of those locations, implements the move, and returns true. Otherwise, the set of location is empty, and the method returns false because Ghost cannot move.
JUnit Test:
####
####
### Map Class
####
#### getLoc:
- **Author:** Uyen Nguyen
- **Method Summary:** (Location loc) -> HashSet<Type>
This method returns the type of object (Empty, Pacman, Cookie, Ghost, Wall) at a given location.
- **Testing:** To test this method, create a map, and a Pacman at location (2, 4). Then use assertTrue to to check if getLoc returns a HashSet contains a PacMan at that location.
####
####


