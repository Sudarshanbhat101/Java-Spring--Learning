/**
 * Interface as a contract: class implements all abstract methods.
 */
interface Drawable {
    void draw();
}

class CircleShape implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}

class InterfaceContractDemo {

    public static void main(String[] args) {
        Drawable shape = new CircleShape();
        shape.draw();
    }
}
