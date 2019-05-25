package m1.pack;


import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistance() {

        Point t1 = new Point(10, 1);
        Point t2 = new Point (1, 1);

        assert (t1.distance(t2)) == 9;

    }
}
