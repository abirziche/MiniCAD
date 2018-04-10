package shapes;

import java.awt.Color;

public class Rectangle extends Canvas implements Shape {
    private int x, y, h, l;
    private Color culoare1, culoare2;
    public Rectangle(final String[] parts) {
        x = Integer.parseInt(parts[1]);
        y = Integer.parseInt(parts[2]);
        h = Integer.parseInt(parts[three]);
        l = Integer.parseInt(parts[four]);
        culoare1 = getColor(parts[five], parts[six]);
        culoare2 = getColor(parts[seven], parts[eight]);
    }
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final int getH() {
        return h;
    }
    public final int getL() {
        return l;
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
