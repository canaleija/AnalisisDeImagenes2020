import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analisisespacial.FiltrosEspaciales;
import analisisespacial.Histogramas;
import gui.JframeImagen;

public class Main {

    public static void main(String[] args) {

        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        Image imagenGrises = FiltrosEspaciales.generarImagenGrises(imagen);
        JframeImagen frame2 = new JframeImagen(imagenGrises);
        Image imagenN = FiltrosEspaciales.generarImagenNegativa(imagen);
        JframeImagen frame3 = new JframeImagen(imagenN);
       
       
        System.out.println();

    }
}