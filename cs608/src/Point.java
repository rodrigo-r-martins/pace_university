class Point implements Comparable<Point> {
    public double x;
    public double y;
    private final double distance;

    @Override
    public int compareTo(Point p) {
        return Double.compare(distance, p.distance);
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.distance = getDistance();
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }
}
