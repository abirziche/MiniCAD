package shapes;

import java.awt.Color;

public class Square extends Canvas implements Shape {
    private int x, y, l;
    private Color culoare1, culoare2;
    public Square(final String[] parts) {
        x = Integer.parseInt(parts[1]);
        y = Integer.parseInt(parts[2]);
        l = Integer.parseInt(parts[three]);
        culoare1 = getColor(parts[four], parts[five]);
        culoare2 = getColor(parts[six], parts[seven]);
    }
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
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
