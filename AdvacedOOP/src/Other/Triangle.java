package Other;

public class Triangle extends Shape {
    public Triangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return 0.5 * height * width;
    }

    @Override
    public int perimeter() {
        return 0;
    }
}
