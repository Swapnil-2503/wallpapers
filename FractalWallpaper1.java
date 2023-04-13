import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FractalWallpaper1 extends JPanel {
    private BufferedImage image;
    private final int WIDTH = 1920; // HD resolution width
    private final int HEIGHT = 1080; // HD resolution height
    private final int MAX_ITERATIONS = 1000;
    private final double ZOOM = 200;
    private final double X_COORD = -0.5;
    private final double Y_COORD = 0;
    
    public FractalWallpaper1() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        generateFractal();
    }
    
    private void generateFractal() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double zx = 0;
                double zy = 0;
                double cx = (x - WIDTH / 2.0) / ZOOM + X_COORD;
                double cy = (y - HEIGHT / 2.0) / ZOOM + Y_COORD;
                int iteration = 0;
                while (zx * zx + zy * zy < 4 && iteration < MAX_ITERATIONS) {
                    double xTemp = zx * zx - zy * zy + cx;
                    zy = 2 * zx * zy + cy;
                    zx = xTemp;
                    iteration++;
                }
                if (iteration == MAX_ITERATIONS) {
                    image.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    float hue = (float) iteration / MAX_ITERATIONS;
                    image.setRGB(x, y, Color.getHSBColor(hue, 1, 1).getRGB());
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Wallpaper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FractalWallpaper1 fractal = new FractalWallpaper1();
        frame.add(fractal);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
