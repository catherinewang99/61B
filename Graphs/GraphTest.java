package graph;

import org.junit.Test;
import static org.junit.Assert.*;

/** Unit tests for the Graph class.
 *  @author Katie Kim
 */
public class GraphTest {

    // Add tests.  Here's a sample.

    @Test
    public void emptyGraph() {
        DirectedGraph dg = new DirectedGraph();
        assertEquals("Initial graph has vertices", 0, dg.vertexSize());
        assertEquals("Initial graph has edges", 0, dg.edgeSize());
    }

    @Test
    public void addVerticesTest() {
        UndirectedGraph ug = new UndirectedGraph();
        for (int i = 0; i < 10; i++) {
            ug.add();
        }
        assertEquals(10, ug.maxVertex());
        assertEquals(10, ug.vertexSize());
        assertEquals(0, ug.edgeSize());
    }

    @Test
    public void addEdgesTest() {
        UndirectedGraph ug = new UndirectedGraph();
        for (int i = 0; i < 10; i++) {
            ug.add();
        }
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(4, 10);
        assertEquals(true, ug.contains(1, 2));
        assertEquals(true, ug.contains(2, 1));
        assertEquals(false, ug.contains(3, 5));
        assertEquals(true, ug.contains(1, 3));
        assertEquals(true, ug.contains(4, 10));
    }

    @Test
    public void removeTest() {
        UndirectedGraph ug = new UndirectedGraph();
        for (int i = 0; i < 10; i++) {
            ug.add();
        }
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(4, 10);
        ug.remove(10);
        assertEquals(true, ug.contains(4));
        assertEquals(false, ug.contains(10));
        assertEquals(false, ug.contains(4, 10));
        assertEquals(false, ug.contains(10, 4));


    }
}
