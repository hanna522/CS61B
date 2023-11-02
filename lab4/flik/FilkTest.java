package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilkTest {

    @Test
    public void test1() {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            boolean result = Flik.isSameNumber(i, j);
            assertTrue(result);
            System.out.println(result + " a : " + i + ", b: " + j);

        }
    }
}