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
        Image grises = FiltrosEspaciales.generarImagenGrises(imagen);
        JframeImagen frame = new JframeImagen(grises);
        Histogramas ho = new Histogramas(grises);
        ho.GraphGrey();
        Image e = FiltrosEspaciales.ecualizarImagen(grises);
        JframeImagen frame2 = new JframeImagen(e);
        Histogramas he = new Histogramas(e);
        he.GraphGrey();
        // Image imagenExp = FiltrosEspaciales.expansionLineal(min, max, imagen);
        // Histogramas h2 = new  Histogramas(imagenExp);
        // h2.Graph(); 
       
       
       
        System.out.println();

    }
}