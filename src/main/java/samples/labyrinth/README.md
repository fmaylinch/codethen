Your program has to accept an input like this (for example from a file).

This input represents a labyrinth. The X letters are walls, the spaces are ways where you can walk, the o letter is your starting point.

    X XXXXX
    X XX XX
    X    XX
    XX XX X
    XX  o X
    XXXXXXX

The labyrinth may be of any size, but it's always a rectangle.

Steps of the exercise:

1. First make a class (or classes) that can read a labyrinth from one or more sources (at least one): from a string (with new-line separators for each row), from a list of strings (one string per row), and from a file.

2. Make an interactive game where the user can't see the whole map and has to escape. The user can input L, R, U or D (left, right, up, down) to try to escape. The program tells the user if they could move to that direction (you moved left, you can't move to the left, etc.) and finish when they escape.

3. Make tests. For example, given a map (with your starting position) and a list of moves, check the result map (with current position). You position is indicated with the 'o' character. In the tests, the map may be given as a string or a list of strings (use the way you find more convenient). Check different things; for example, that the user can't move through walls.

4. This step is more difficult: make a function that, given a map (with your starting position), returns the shortest list of movements to get out. You may consider that there are no loops in the labyrinth (i.e. there is only one way to get out). To make it even more difficult, consider loops (you would have to avoid entering into a neverending loop!).

5. Bonus for more difficulty: Include a key in the game; the player needs to collect the key before escaping the labyrinth.
