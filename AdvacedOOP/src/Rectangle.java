public class Rectangle extends Shape {

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public double area() {
        return height * width;
    }

    @Override
    public int perimeter() {
        return 0;
    }

}
