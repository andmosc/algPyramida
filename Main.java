package pyramid;

public class Main {
    public static void main(String[] args) {
        Pyramid pyramid = new Pyramid();

        pyramid.add(20);
        pyramid.add(8);
        pyramid.add(6);
        pyramid.add(5);
        pyramid.add(25);
        pyramid.add(1);
        pyramid.add(10);
        pyramid.extractMin();
        System.out.println(pyramid.toString());
    }
}
