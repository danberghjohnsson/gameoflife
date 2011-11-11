package life;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * A cell in the universe. It might be populated or not.
 */
public class Cell {
    public final int x;
    public final int y;

    public Cell(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * The neighbouring cells that are adjecent to this cell. This cell is not included in the result.
     */
    public Area neighbourArea() {
        Area r = new Area()
        .add(new Cell(x-1, y-1))
        .add(new Cell(x, y-1))
        .add(new Cell(x+1, y-1))

        .add(new Cell(x-1, y))
        .add(new Cell(x+1, y))

        .add(new Cell(x-1, y+1))
        .add(new Cell(x, y+1))
        .add(new Cell(x+1, y+1));
        return r;
    }

    @Override
    public boolean equals(Object other) {
        Cell o = (Cell) other;
        return o.x == x && o.y == y;

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
