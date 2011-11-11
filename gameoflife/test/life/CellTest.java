package life;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class CellTest {

    @Test
    public void shouldHaveNeighboursAtHammingDistanceOne() {
        Cell cell = new Cell(0,0);

        for(Cell c : cell.neighbours()) {
            assertTrue(Math.max(Math.abs(c.x), Math.abs(c.y)) <= 1);
        }
        assertEquals(8, cell.neighbours().size());
    }

}
