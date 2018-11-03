package CountZeroInit.model.surroundings;

// I've used this somehow in the other classes... it's important for getting the Tile from MapSpec and is directly
// related to the LifeForm's ability to store col and row (it was outputting 0, 0 when the newly used Tree Tile class
// forgot to implement a currently empty Walkable interface).

public interface Walkable {
}
