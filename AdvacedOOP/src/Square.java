public class Square extends Shape {
    int width = 5;
    int length = 5;

    @Override
    public double area() {
        return width * length;
    }
    public int perimeter()
    {
        return length + width;
    }
}
