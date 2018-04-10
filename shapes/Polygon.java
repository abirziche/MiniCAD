package shapes;

import java.awt.Color;

public class Polygon extends Canvas implements Shape {
    private int numar;
    private int[] array; // salvez punctele aici
    private Color culoare1, culoare2;
    public Polygon(final String[] parts) {
        numar = Integer.parseInt(parts[1]);
        array = new int[numar * 2];
        int i;
        for (i = 0; i < 2 * numar; i++) {
            array[i] = Integer.parseInt(parts[i + 2]);
        }
        culoare1 = getColor(parts[i + 2], parts[i + three]);
        culoare2 = getColor(parts[i + four], parts[i + five]);
    }
    public final int getNr() {
        return numar;
    }
    public final int[] getPoints() {
        return array;
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
