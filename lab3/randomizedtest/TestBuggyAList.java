package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeC = correct.size();
                int sizeB = broken.size();
                assertEquals(sizeC, sizeB);
                System.out.println("size: " + sizeC);
            } else if (operationNumber == 2) {
                if (correct.size() == 0) {
                    continue;
                } else {
                    int lastC = correct.getLast();
                    int lastB = broken.getLast();
                    assertEquals(lastC, lastB);
                    System.out.println("getLast(" + lastC +")");
                }
            } else if (operationNumber == 3) {
                if (correct.size() == 0) {
                    continue;
                } else {
                    int removeC = correct.removeLast();
                    int removeB = broken.removeLast();
                    assertEquals(removeC, removeB);
                    System.out.println("getLast(" + removeC + ")");
                }
            }
        }

    }
}
