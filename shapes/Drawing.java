package shapes;

public class Drawing implements Visitor {

    @Override
    public final void visit(final Canvas canvas) {
        for (int i = 0; i < Canvas.getCanvas().getWidth(); i++) {
            for (int j = 0; j < Canvas.getCanvas().getHeight(); j++) {
                Canvas.getCanvas().setRGB(i, j, canvas.getCCuloare());
            }
        }
    }

    @Override
    public final void visit(final Line line) {
        int x1 = line.getX1();
        int x2 = line.getX2();
        int y1 = line.getY1();
        int y2 = line.getY2();
        int c = line.getCuloare();
        line.brasenheim(x1, y1, x2, y2, c);
    }

    @Override
    public final void visit(final Square square) {
        int x1 = square.getX();
        int y1 = square.getY();
        int l = square.getL();
        int c1 = square.getCuloare1();
        int c2 = square.getCuloare2();
        square.brasenheim(x1, y1, x1 + l - 1, y1, c1);
        square.brasenheim(x1, y1, x1, y1 + l - 1, c1);
        square.brasenheim(x1 + l - 1, y1, x1 + l - 1, y1 + l - 1, c1);
        square.brasenheim(x1, y1 + l - 1, x1 + l - 1, y1 + l - 1, c1);
        for (int i = x1 + 1; i < x1 + l - 1 && i < Canvas.getCanvas().getWidth(); i++) {
            for (int j = y1 + 1; j < y1 + l - 1 && j < Canvas.getCanvas().getHeight(); j++) {
                Canvas.getCanvas().setRGB(i, j, c2);
            }
        }
    }

    @Override
    public final void visit(final Rectangle rectangle) {
        int x1 = rectangle.getX();
        int y1 = rectangle.getY();
        int h = rectangle.getH();
        int l = rectangle.getL();
        int c1 = rectangle.getCuloare1();
        int c2 = rectangle.getCuloare2();
        rectangle.brasenheim(x1, y1, x1 + l - 1, y1, c1);
        rectangle.brasenheim(x1, y1, x1, y1 + h - 1, c1);
        rectangle.brasenheim(x1 + l - 1, y1, x1 + l - 1, y1 + h - 1, c1);
        rectangle.brasenheim(x1, y1 + h - 1, x1 + l - 1, y1 + h - 1, c1);
        for (int i = x1 + 1; i < x1 + l - 1 && i < Canvas.getCanvas().getWidth(); i++) {
            for (int j = y1 + 1; j < y1 + h - 1 && j < Canvas.getCanvas().getHeight(); j++) {
                Canvas.getCanvas().setRGB(i, j, c2);
            }
        }
    }

    @Override
    public final void visit(final Triangle triangle) {
        int x1 = triangle.getX1();
        int y1 = triangle.getY1();
        int x2 = triangle.getX2();
        int y2 = triangle.getY2();
        int x3 = triangle.getX3();
        int y3 = triangle.getY3();
        int c1 = triangle.getCuloare1();
        int c2 = triangle.getCuloare2();
        triangle.brasenheim(x1, y1, x2, y2, c1);
        triangle.brasenheim(x2, y2, x3, y3, c1);
        triangle.brasenheim(x3, y3, x1, y1, c1);
        int x = (x1 + x2 + x3) / (2 + 1);
        int y = (y1 + y2 + y3) / (2 + 1);
        triangle.floodfill(x, y, c1, c2);
    }

    @Override
    public final void visit(final Diamond diamond) {
        int x = diamond.getX();
        int y = diamond.getY();
        int sd1 = diamond.getFD() / 2;
        int sd2 = diamond.getSD() / 2;
        int c1 = diamond.getCuloare1();
        int c2 = diamond.getCuloare2();
        diamond.brasenheim(x, y - sd2, x - sd1, y, c1);
        diamond.brasenheim(x - sd1, y, x, y + sd2, c1);
        diamond.brasenheim(x, y + sd2, x + sd1, y, c1);
        diamond.brasenheim(x + sd1, y, x, y - sd2, c1);
        diamond.floodfill(x, y, c1, c2);
    }

    @Override
    public final void visit(final Polygon polygon) {
        int numar = polygon.getNr();
        int[] v = new int[numar];
        int c1 = polygon.getCuloare1();
        int c2 = polygon.getCuloare2();
        v = polygon.getPoints();
        int i;
        for (i = 0; i < (numar - 1) * 2; i += 2) {
            polygon.brasenheim(v[i], v[i + 1], v[i + 2], v[i + 2 + 1], c1);
        }
        polygon.brasenheim(v[i], v[i + 1], v[0], v[1], c1);
        // aflu mijlocul poligonului
        int x = 0, y = 0;
        for (i = 0; i < 2 * numar; i += 2) {
            x += v[i];
        }
        for (i = 1; i < 2 * numar; i += 2) {
            y += v[i];
        }
        x /= numar;
        y /= numar;
        polygon.floodfill(x, y, c1, c2);
    }

    @Override
    public final void visit(final Circle circle) {
        int x = circle.getX();
        int y = circle.getY();
        int r = circle.getR();
        int c1 = circle.getCuloare1();
        int c2 = circle.getCuloare2();
        circle.brasenheimCircle(x, y, r, c1);
        circle.floodfill(x, y, c1, c2);
    }
}
