package life;

import java.util.HashSet;
import java.util.Set;

/**
 * The world of an infinite grid on which life is played.
 * Consists of cells that might be populated or not.
 * The area of the world is not limited - the only limitation is that the number of populated cells must be finite.
 */
public class World {
    /** The cells that are populated */
    private Set<Cell> livecells = new HashSet<Cell>();

    /**
     * The populated neighbourhood of a cell, i e the populated cells at the distance of at most 1.
     */
    public Set<Cell> liveNeighbours(Cell cell1) {

        Set<Cell> result = new HashSet<Cell>(livecells);
        result.retainAll(cell1.neighbourArea().cells());

        return result;
    }

    /**
     * Add a cell as populated in the world
     */
    public void add(Cell populatedCell) {
        livecells.add(populatedCell);
    }

    /**
     * The city area is all cells that are adjacent to some populated cell.
     */
    Area cityArea() {
        Area r = new Area();
        for(Cell live : livecells) {
            Area area = live.neighbourArea();
            r = r.extendWith(area);
        }
        return r;
    }

    /**
     * Gives the world in the state of population at the next generation compared to the current state.
     */
    public World nextGen() {
        World result = new World();
        result.add(survivers());
        result.add(newborns());
        return result;
    }


    /**
     * The population of cells that will be newborn in the next generation.
     */
    private Set<Cell> newborns() {
        Set<Cell> newborn = new HashSet<Cell>();
        for(Cell c: cityArea().cells()) {
            if(liveNeighbours(c).size() == 3) {
                newborn.add(c);
            }
        }
        return newborn;
    }


    /**
     * The population of cells that will survive to the next generation.
     */
    private Set<Cell> survivers() {
        Set<Cell> survivers = new HashSet<Cell>();
        for(Cell c : livecells) {
            if(willSurvive(c))
                survivers.add(c);
        }
        return survivers;
    }


    /**
     * Adds a population of cells to the the world.
     */
    private void add(Set<Cell> cells) {
        livecells.addAll(cells);
    }

    /**
     * Decides whether the cell will survive (if populated) to the next generation.
     */
    boolean willSurvive(Cell c) {
        int live = this.liveNeighbours(c).size();
        return live == 2 || live == 3;
    }

    /** Is this cell populated in the world */
    public boolean isAlive(Cell cell) {
        return livecells.contains(cell);
    }
}
