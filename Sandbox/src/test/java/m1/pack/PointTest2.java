package m1.pack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest2 {

    @Test
    public void testDistance() {

        Point t1 = new Point(10, 1);
        Point t2 = new Point (1, 1);

        Assert.assertEquals(t1.distance(t2), 9.0);

    }
}

