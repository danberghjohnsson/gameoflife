package life;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Cell {
    public final int x;
    public final int y;

    public Cell(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Set<Cell> neighbours() {
        Set<Cell> result = new HashSet<Cell>();
        result.add(new Cell(x-1, y-1));
        result.add(new Cell(x, y-1));
        result.add(new Cell(x+1, y-1));

        result.add(new Cell(x-1, y));
        result.add(new Cell(x+1, y));

        result.add(new Cell(x-1, y+1));
        result.add(new Cell(x, y+1));
        result.add(new Cell(x+1, y+1));
        return result;
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
