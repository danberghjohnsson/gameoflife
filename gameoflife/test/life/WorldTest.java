package life;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class WorldTest {
    @Test
    public void shouldFindLiveNeighboursToCell() {
        World world = new World();
        Cell alice = new Cell(0, 0);
        world.add(alice);
        Cell bob = new Cell(0, 1);
        world.add(bob);

        Set<Cell> neighbours = world.liveNeighbours(alice);

        assertEquals(Collections.singleton(bob), neighbours);
    }

    @Test
    public void shouldGiveUnionOfAllLiveCellHoodsAsCity() {
        World world = new World();
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));

        assertEquals(12, world.cityArea().size());
    }

    @Test
    public void shouldLetLonelyCellDie() {
        World world = new World();
        Cell alice = new Cell(0, 0);
        world.add(alice);
        world.add(new Cell(0, 1));

        assertFalse(world.nextGen().isAlive(alice));
    }

    @Test
    public void shouldLetCellWithTwoNBLive() {
        World world = new World();
        Cell alice = new Cell(0, 0);
        world.add(alice);
        world.add(new Cell(-1, 0));
        world.add(new Cell(1, 0));

        assertTrue(world.nextGen().isAlive(alice));
    }

    @Test
    public void shouldLetCellWithThreeNBLive() {
        World world = new World();
        Cell alice = new Cell(0, 0);
        world.add(alice);
        world.add(new Cell(-1, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(1, 0));

        assertTrue(world.nextGen().isAlive(alice));
    }

    @Test
    public void shouldLetCrowedCellDie() {
        World world = new World();
        Cell alice = new Cell(0, 0);
        world.add(alice);
        world.add(new Cell(-1, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(1, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(1, 1));

        assertFalse(world.nextGen().isAlive(alice));

    }

    @Test
    public void shouldGiveBirthToCellIfThreeNeighbours() {
        World world = new World();
        Cell alice = new Cell(0, 0);
        world.add(new Cell(-1, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(1, 0));

        assertTrue(world.nextGen().isAlive(alice));

    }

}
