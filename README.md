# OutWalkin

OutWalkin is the skeleton of a Zork-style adventure game, which lets the user walk around (hence the name) a world defined in the supplied text file. OutWalkin is the main file, and requires a correctly-formatted txt file for the world information. A minimal world file is included.

## World file specifications

First line must be an integer >= 0 indicating the number of rooms. Each room must be in the format of a room name, room description, a `#` on its own line, and the room numbers, in order, of the rooms to the North, East, South, and West on separate lines. For non-exits, use -1.

### Example World File
```
2
Room Without a Description
#
1
-1
-1
-1
Room With A Description
This room is gorgeous.
Absolutely stunning. You are amazed at the beauty of it.
#
-1
-1
0
-1
```