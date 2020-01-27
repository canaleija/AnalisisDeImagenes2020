import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    public static void main(String[] args) {

        Image imagen = AbrirImagen.openImage();
        JLabel etiqueta = new JLabel(new ImageIcon(imagen));
        JFrame frame = new JFrame(); 
        frame.add(etiqueta);
        frame.setSize(imagen.getWidth(null),imagen.getHeight(null));
        frame.setVisible(true);
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        int rgb = bi.getRGB(50,50);
        Color color = new Color(rgb);
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        System.out.println();

    }
}