import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analisisespacial.FiltrosEspaciales;
import analisisespacial.Histogramas;
import gui.JFrameSegmentacion;
import gui.JframeImagen;

public class Main {

    public static void main(String[] args) {

        Image imagen = AbrirImagen.openImage();
        Histogramas h = new  Histogramas(imagen);
        h.Graph();
        JframeImagen fi = new JframeImagen(imagen);
        Image contraste = FiltrosEspaciales.expansionLineal(h, imagen);
        JframeImagen fic = new JframeImagen(contraste);
        Histogramas h1 = new  Histogramas(contraste);
        h1.Graph();
       
        // Image imagenExp = FiltrosEspaciales.expansionLineal(min, max, imagen);
        // Histogramas h2 = new  Histogramas(imagenExp);
        // h2.Graph(); 
       
       
       
        System.out.println();

    }
}