package shapes;

public final class ShapeFactory {
    private static ShapeFactory instance = new ShapeFactory();
    private ShapeFactory() {
    }
    public Shape getShape(final String[] shape) {
        if (shape == null) {
            return null;
        } else if (shape[0].equalsIgnoreCase("Canvas")) {
            return new Canvas(shape);
        } else if (shape[0].equalsIgnoreCase("Line")) {
            return new Line(shape);
        } else if (shape[0].equalsIgnoreCase("Square")) {
            return new Square(shape);
        } else if (shape[0].equalsIgnoreCase("Rectangle")) {
            return new Rectangle(shape);
        } else if (shape[0].equalsIgnoreCase("Triangle")) {
            return new Triangle(shape);
        } else if (shape[0].equalsIgnoreCase("Diamond")) {
            return new Diamond(shape);
        } else if (shape[0].equalsIgnoreCase("Polygon")) {
            return new Polygon(shape);
        } else if (shape[0].equalsIgnoreCase("Circle")) {
            return new Circle(shape);
        }
        return null;
    }
    public static ShapeFactory getInstance() {
        return instance;
    }
}
