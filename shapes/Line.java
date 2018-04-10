package shapes;

import java.awt.Color;

public class Line extends Canvas implements Shape {
    private int x1, x2, y1, y2;
    private Color culoare;
    public Line(final String[] parts) {
        x1 = Integer.parseInt(parts[1]);
        y1 = Integer.parseInt(parts[2]);
        x2 = Integer.parseInt(parts[three]);
        y2 = Integer.parseInt(parts[four]);
        culoare = getColor(parts[five], parts[six]);
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
    public final int getCuloare() {
        return culoare.getRGB();
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
