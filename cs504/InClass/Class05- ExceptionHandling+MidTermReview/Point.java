public class Point {
    public int x;	// If I use private I must create getters and setters
    public int y;	// Or use constructors

    Point() {}
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
