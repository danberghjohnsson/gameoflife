package life;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class World {
    private Set<Cell> livecells = new HashSet<Cell>();

    public Set<Cell> liveNeighbours(Cell alice) {

        Set<Cell> result = new HashSet<Cell>(livecells);
        result.retainAll(alice.neighbours());

        return result;
    }

    public void add(Cell cell) {
        livecells.add(cell);
    }

    public Set<Cell> city() {
        Set<Cell> result = new HashSet<Cell>();
        for(Cell live : livecells) {
            result.addAll(live.neighbours());
        }
        return result;
    }

    public World nextGen() {
        World result = new World();
        result.add(survivers());
        result.add(newborns());
        return result;
    }

    private Set<Cell> newborns() {
        Set<Cell> newborn = new HashSet<Cell>();
        for(Cell c: city()) {
            if(liveNeighbours(c).size() == 3) {
                newborn.add(c);
            }
        }
        return newborn;
    }

    private Set<Cell> survivers() {
        Set<Cell> survivers = new HashSet<Cell>();
        for(Cell c : livecells) {
            if(willSurvive(c))
                survivers.add(c);
        }
        return survivers;
    }

    private void add(Set<Cell> cells) {
        livecells.addAll(cells);
    }

    boolean willSurvive(Cell c) {
        int live = this.liveNeighbours(c).size();
        return live == 2 || live == 3;
    }

    public boolean isAlive(Cell cell) {
        return livecells.contains(cell);
    }
}
