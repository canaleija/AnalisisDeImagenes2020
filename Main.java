import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.JframeImagen;

public class Main {

    public static void main(String[] args) {

        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color = new Color(57,255,20);
        bi.setRGB(50,50,color.getRGB());
        JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi));
       
        System.out.println();

    }
}