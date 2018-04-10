import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;


import shapes.Canvas;
import shapes.Drawing;
import shapes.Shape;
import shapes.ShapeFactory;
import shapes.Visitor;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        FileReader fileReader = null;
        BufferedReader buffer = null;
        String input = args[0];
        try {
            buffer = new BufferedReader(new FileReader(input));
            int n = Integer.parseInt(buffer.readLine());
            Shape[] figure = new Shape[n];
            ShapeFactory factory = ShapeFactory.getInstance();
            Visitor v = new Drawing();
            for (int i = 0; i < n; i++) {
                String s = buffer.readLine();
                String[] parts = s.split(" ");
                figure[i] = factory.getShape(parts);
                figure[i].accept(v);
            }
            ImageIO.write(Canvas.getCanvas(), "PNG", new File("drawing.png"));
        } catch (Exception e) {
            System.out.println("Eroare");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (buffer != null) {
                buffer.close();
            }
        }
    }
}
