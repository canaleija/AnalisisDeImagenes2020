import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analisisespacial.Histogramas;
import gui.JframeImagen;

public class Main {

    public static void main(String[] args) {

        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        Histogramas hi = new Histogramas(imagen);
        hi.graficarHistogramaGrises();
        hi.graficarHistogramaAzul();
        hi.graficarHistogramaRojo();
        hi.graficarHistogramaVerde();
        hi.graficarHistogramas();
       
        System.out.println();

    }
}