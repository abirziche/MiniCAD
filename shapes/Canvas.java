package shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Canvas implements Shape {
    protected static BufferedImage canvas;
    private Color culoare;
    protected final int three = 3;
    protected final int four = 4;
    protected final int five = 5;
    protected final int six = 6;
    protected final int seven = 7;
    protected final int eight = 8;
    protected final int nine = 9;
    protected final int ten = 10;
    protected final int sixteen = 16;
    public Canvas(final String[] parts) {
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        culoare = getColor(parts[three], parts[four]);
        canvas = new BufferedImage(y, x, BufferedImage.TYPE_INT_ARGB);
    }
    public static BufferedImage getCanvas() {
        return canvas;
    }
    public final int getCCuloare() {
        return culoare.getRGB();
    }
    public Canvas() {
    }
    public final Color getColor(final String s1, final String s2) {
        char[] arr;
        arr = s1.toCharArray();
        int r = Character.getNumericValue(arr[1]) * sixteen
                + Character.getNumericValue(arr[2]);
        int g = Character.getNumericValue(arr[three]) * sixteen
                + Character.getNumericValue(arr[four]);
        int b = Character.getNumericValue(arr[five]) * sixteen
                + Character.getNumericValue(arr[six]);
        int a = Integer.parseInt(s2);
        return new Color(r, g, b, a);
    }
    /**
     * v.
     */
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
    // verifica daca un punct face parte din canvas
    public final boolean inCanvas(final int x, final int y) {
        if (x >= 0 && x < canvas.getWidth()) {
            if (y >= 0 && y < canvas.getHeight()) {
                return true;
            }
        }
        return false;
    }
    // algoritmul prezentat de trasare a unei linii
    public final void brasenheim(final int x1, final int y1, final int x2,
            final int y2, final int color) {
        int x = x1;
        int y = y1;
        int deltax = Math.abs(x2 - x1);
        int deltay = Math.abs(y2 - y1);
        int s1 = Integer.signum(x2 - x1);
        int s2 = Integer.signum(y2 - y1);
        int aux;
        int ok = 0;
        if (deltay > deltax) {
           aux = deltax;
           deltax = deltay;
           deltay = aux;
           ok = 1;
        }
        int error = 2 * deltay - deltax;
        for (int i = 0; i <= deltax; i++) {
            if (x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight()) {
                canvas.setRGB(x, y, color);
            }
            while (error > 0) {
                if (ok == 1) {
                    x = x + s1;
                } else {
                    y = y + s2;
                }
                error = error - 2 * deltax;
            }
             if (ok == 1) {
                y = y + s2;
            } else {
                x = x + s1;
            }
             error = error + 2 * deltay;
        }
    }
    // algoritmul pentru trasarea cercului
    public final void brasenheimCircle(final int xc, final int yc, final int r, final int c) {
        int x = 0;
        int y = r;
        int d = three - 2 * r;
        while (y >= x) {
            drawCircle(xc, yc, x, y, c);
            x++;
            if (d > 0) {
                y--;
                d = d + four * (x - y) + ten;
            } else {
                d = d + four * x + six;
            }
            drawCircle(xc, yc, x, y, c);
        }
    }
    // functie ajutatoare pentru trasarea cercului (cate 8 puncte)
    public final void drawCircle(final int xc, final int yc, final int x,
            final int y, final int c) {
        if (inCanvas(xc + x, yc + y)) {
            canvas.setRGB(xc + x, yc + y, c);
        }
        if (inCanvas(xc - x, yc + y)) {
            canvas.setRGB(xc - x, yc + y, c);
        }
        if (inCanvas(xc + x, yc - y)) {
            canvas.setRGB(xc + x, yc - y, c);
        }
        if (inCanvas(xc - x, yc - y)) {
            canvas.setRGB(xc - x, yc - y, c);
        }
        if (inCanvas(xc + y, yc + x)) {
            canvas.setRGB(xc + y, yc + x, c);
        }
        if (inCanvas(xc - y, yc + x)) {
            canvas.setRGB(xc - y, yc + x, c);
        }
        if (inCanvas(xc + y, yc - x)) {
            canvas.setRGB(xc + y, yc - x, c);
        }
        if (inCanvas(xc - y, yc - x)) {
            canvas.setRGB(xc - y, yc - x, c);
        }
    }
    // floodfill iterativ cu, coada
    public final void floodfill(final int x, final int y, final int c1, final int c2) {
        Point a = new Point(x, y);
        Queue<Point> q = new LinkedList<Point>();
        q.add(a);
        while (!q.isEmpty()) {
            a = q.remove();
            int x1 = a.getX();
            int y1 = a.getY();
            if (inCanvas(x1, y1)) {
                if (canvas.getRGB(x1, y1) != c2 && canvas.getRGB(x1, y1) != c1) {
                    q.add(new Point(x1 + 1, y1));
                    q.add(new Point(x1 - 1, y1));
                    q.add(new Point(x1, y1 - 1));
                    q.add(new Point(x1, y1 + 1));
                    canvas.setRGB(x1, y1, c2);
                }
            }
        }
    }
}
