package redefiningEqualsMethod;

class Point {

    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        } else {
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }
    }
}
