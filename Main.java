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
        Histogramas aux = new Histogramas(imagen);
        aux.Graph();
    
        Image imagenS = FiltrosEspaciales.segmentarImagen(imagen,40);
        JframeImagen frame2 = new JframeImagen(imagenS);
        aux = new Histogramas(imagenS);
        aux.Graph();
       
       
       
        System.out.println();

    }
}