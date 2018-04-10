package shapes;

import java.awt.Color;

public class Triangle extends Canvas implements Shape {
    private int x1, y1, x2, y2, x3, y3;
    private Color culoare1;
    private Color culoare2;
    public Triangle(final String[] parts) {
        x1 = Integer.parseInt(parts[1]);
        y1 = Integer.parseInt(parts[2]);
        x2 = Integer.parseInt(parts[three]);
        y2 = Integer.parseInt(parts[four]);
        x3 = Integer.parseInt(parts[five]);
        y3 = Integer.parseInt(parts[six]);
        culoare1 = getColor(parts[seven], parts[eight]);
        culoare2 = getColor(parts[nine], parts[ten]);
    }
    public final int getX1() {
        return x1;
    }
    public final int getY1() {
        return y1;
    }
    public final int getX2() {
        return x2;
    }
    public final int getY2() {
        return y2;
    }
    public final int getX3() {
        return x3;
    }
    public final int getY3() {
        return y3;
    }
    public final int getCuloare1() {
        return culoare1.getRGB();
    }
    public final int getCuloare2() {
        return culoare2.getRGB();
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
