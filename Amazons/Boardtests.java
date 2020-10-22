package amazons;
import org.junit.Test;
import static org.junit.Assert.*;
import ucb.junit.textui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static amazons.Piece.*;
import static amazons.Square.*;
import static amazons.Move.*;


public class Boardtests {

    @Test
    public void moveTest() {
        Board test = new Board();
        System.out.println(test);
        int[] start = {3, 30, 60, 93};
        for (int i: start) {
            assertTrue(test.isLegal(sq(i)));
        }
        int[] start1 = {6, 39, 69, 96, 1, 2, 5, 6, 7, 8, 9, 10};
        for (int i: start1) {
            assertFalse(test.isLegal(sq(i)));
        }
        Square sq1 = sq(3);
        Square sq2 = sq("c", "2");
        Square sq3 = sq("a", "6");
        Square sq4 = sq("a", "7");
        Square sq5 = sq("i", "4");
        assertEquals(WHITE, test.get(sq(3)));
        assertEquals(BLACK, test.get(sq(6)));
        assertTrue(test.isUnblockedMove(sq1, sq2, null));
        assertTrue(test.isUnblockedMove(sq1, sq3, null));
        assertFalse(test.isUnblockedMove(sq1, sq4, null));
        assertTrue(test.isUnblockedMove(sq1, sq5, null));
        assertFalse(test.isUnblockedMove(sq1, sq("j", "4"), null));
        Move move1 = mv("d1-d7(g7)");
        test.makeMove(move1);
        System.out.println(test);
        Move move2 = mv("d10-c9(h4)");
        test.makeMove(move2);
        System.out.println(test);
        Move move3 = mv("g1-g6(j9)");
        test.makeMove(move3);
        System.out.println(test);
        Board copy1 = new Board();
        copy1.copy(test);
        System.out.println("copy: ");
        System.out.println(copy1);
        copy1.makeMove(mv("c9-g5(j8)"));
        System.out.println(copy1);
        copy1.undo();
        System.out.println(copy1);
    }
    @Test
    public void iteratorTest() {
        Board test = new Board();
        Move move1 = mv("d1-d7(g7)");
        test.makeMove(move1);
        Move move2 = mv("d10-c9(h4)");
        test.makeMove(move2);
        Move move3 = mv("g1-g6(j9)");
        test.makeMove(move3);
        Iterator<Square> reach = test.reachableFrom(sq("a1"), null);
        System.out.println(test);
        int total = 0;
        while (reach.hasNext()) {
            Square next = reach.next();
            if (next != null) {
                System.out.println(next);
                total += 1;
            }
        }
        System.out.println(total);

    }

    @Test
    public void moveIteratorTest() {
        Board test = new Board();
        Move move1 = mv("d1-d7(g7)");
        test.makeMove(move1);
        Move move2 = mv("d10-c9(h4)");
        test.makeMove(move2);
        Move move3 = mv("g1-g6(j9)");
        test.makeMove(move3);
        Move move4 = mv("g10-e8(e7)");
        test.makeMove(move4);
        Move move5 = mv("j4-j6(i7)");
        test.makeMove(move5);
        Move move6 = mv("c9-i9(j8)");
        test.makeMove(move6);
        Move move7 = mv("a4-a6(b7)");
        test.makeMove(move7);
        Move move8 = mv("e8-i8(h9)");
        test.makeMove(move8);
        Move move9 = mv("d7-d8(a8)");
        test.makeMove(move9);
        Move move10 = mv("i8-h7(h8)");
        test.makeMove(move10);
        Move move11 = mv("j6-h6(j6)");
        test.makeMove(move11);
        Move move12 = mv("i9-i8(i9)");
        test.makeMove(move12);
        Move move13 = mv("d8-g8(c4)");
        test.makeMove(move13);
        Move move14 = mv("a7-b8(c8)");
        test.makeMove(move14);
        Move move15 = mv("h6-i6(h6)");
        test.makeMove(move15);
        Move move16 = mv("b8-b9(b8)");
        test.makeMove(move16);
        Move move17 = mv("a6-d6(d10)");
        test.makeMove(move17);
        Move move18 = mv("b9-a9(b9)");
        test.makeMove(move18);
        Move move19 = mv("d6-d8(b10)");
        test.makeMove(move19);
        Move move20 = mv("a9-a10(a9)");
        test.makeMove(move20);

        Iterator<Move> reach = test.legalMoves(BLACK);
        int total = 0;
        while (reach.hasNext()) {
            Move next = reach.next();
            System.out.println(next);
            if (next != null) {
                total += 1;
            }
        }
        System.out.println(total);
        System.out.println(test.winner());
        System.out.println(test);

    }    @Test
    public void undoTest() {
        Board test = new Board();
        Move move1 = mv("d1-d7(g7)");
        test.makeMove(move1);
        Move move2 = mv("d10-c9(h4)");
        test.makeMove(move2);
        Move move3 = mv("g1-g6(j9)");
        test.makeMove(move3);
        Move move4 = mv("g10-e8(e7)");
        test.makeMove(move4);
        Move move5 = mv("j4-j6(i7)");
        test.makeMove(move5);
        Move move6 = mv("c9-i9(j8)");
        test.makeMove(move6);
        Move move7 = mv("a4-a6(b7)");
        test.makeMove(move7);
        Move move8 = mv("e8-i8(h9)");
        test.makeMove(move8);
        Move move9 = mv("d7-d8(a8)");
        test.makeMove(move9);
        Move move10 = mv("i8-h7(h8)");
        test.makeMove(move10);
        Move move11 = mv("j6-h6(j6)");
        test.makeMove(move11);
        Move move12 = mv("i9-i8(i9)");
        test.makeMove(move12);
        Move move13 = mv("d8-g8(c4)");
        test.makeMove(move13);
        Move move14 = mv("a7-b8(c8)");
        test.makeMove(move14);
        Move move15 = mv("h6-i6(h6)");
        test.makeMove(move15);
        Move move16 = mv("b8-b9(b8)");
        test.makeMove(move16);
        Move move17 = mv("a6-d6(d10)");
        test.makeMove(move17);
        Move move18 = mv("b9-a9(b9)");
        test.makeMove(move18);
        Move move19 = mv("d6-d8(b10)");
        test.makeMove(move19);
        Move move20 = mv("a9-a10(a9)");
        test.makeMove(move20);
        for (int i = 0; i < 20; i++) {
            test.undo();
        }
        System.out.println(test);
        System.out.println(test.numMoves());

    }

}


