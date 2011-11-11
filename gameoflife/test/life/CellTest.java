package life;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class CellTest {

    @Test
    public void shouldHaveEightNeighboursAtDistanceOne() {
        Cell cell = new Cell(0,0);

        Area area = cell.neighbourArea();
        assertEquals(8, area.size());

        for(Cell c : area.cells()) {
            assertTrue(Math.max(Math.abs(c.x), Math.abs(c.y)) == 1);
        }
    }

}
