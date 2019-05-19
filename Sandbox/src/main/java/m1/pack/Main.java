package m1.pack;

public class Main {

    public static void main(String[] args) {


        Point p1 = new Point();
        p1.x = 10;
        p1.y = 1;

        Point p2 = new Point();
        p2.x = 1;
        p2.y = 1;

        System.out.println(area(p1, p2));
    }
    public static double area(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}
