package life;

import java.util.HashSet;
import java.util.Set;

/**
 * An area of cells, might be populated or not.
 */
public class Area {
    private Set<Cell> cells;

    private Area(Set<Cell> cells) {
        this.cells = cells;
    }

    public Area() {
        cells = new HashSet<Cell>();
    }

    public Set<Cell> cells() {
        return cells;
    }

    /** The size of the area, counted in number of cells */
    int size() {
        return cells().size();
    }

    /** Gives the area extended with a cell */
    public Area add(Cell cell) {
        HashSet<Cell> cells = new HashSet<Cell>(this.cells);
        cells.add(cell);
        return new Area(cells);
    }

    /** Extends this area with another */
    Area extendWith(Area area) {
        HashSet<Cell> extendedcells = new HashSet<Cell>(this.cells);
        extendedcells.addAll(area.cells());
        return new Area(extendedcells);
    }
}
