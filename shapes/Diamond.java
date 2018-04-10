package shapes;

import java.awt.Color;

public class Diamond extends Canvas implements Shape {
    private int x, y, diag1, diag2;
    private Color culoare1, culoare2;
    public Diamond(final String[] parts) {
        x = Integer.parseInt(parts[1]);
        y = Integer.parseInt(parts[2]);
        diag1 = Integer.parseInt(parts[three]);
        diag2 = Integer.parseInt(parts[four]);
        culoare1 = getColor(parts[five], parts[six]);
        culoare2 = getColor(parts[seven], parts[eight]);
    }
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final int getFD() {
        return diag1;
    }
    public final int getSD() {
        return diag2;
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
