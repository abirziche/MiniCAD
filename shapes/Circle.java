package shapes;

import java.awt.Color;

public class Circle extends Canvas implements Shape {
    private int x, y, r;
    private Color culoare1, culoare2;
    public Circle(final String[] parts) {
        x = Integer.parseInt(parts[1]);
        y = Integer.parseInt(parts[2]);
        r = Integer.parseInt(parts[three]);
        culoare1 = getColor(parts[four], parts[five]);
        culoare2 = getColor(parts[six], parts[seven]);
    }
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final int getR() {
        return r;
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
