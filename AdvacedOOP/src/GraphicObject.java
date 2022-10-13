import Interfaces.Climb;

abstract public class GraphicObject implements Climb {
    int x, y;

    void moveTo(int newX, int newY) {

    }

    abstract void draw();

    abstract void resize();
}
