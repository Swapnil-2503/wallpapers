import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class ProgrammerWallpaper extends JPanel {
    private BufferedImage image;
    private final int WIDTH = 1080; // HD resolution width
    private final int HEIGHT = 1920; // HD resolution height
    
    public ProgrammerWallpaper() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        generateWallpaper();
    }
    
    private void generateWallpaper() {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        Font font = new Font("Monospaced", Font.BOLD, 40);
        g.setFont(font);
        g.drawString("Programmer's", 100, 150);
        g.drawString("Wallpaper", 100, 200);
        g.drawString("I write code", 100, 300);
        g.drawString("Therefore I am", 100, 350);
        g.drawString("- Anonymous", 100, 450);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Programmer Wallpaper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ProgrammerWallpaper wallpaper = new ProgrammerWallpaper();
        frame.add(wallpaper);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
