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
        h.GraphRed();; 
        int min = h.getMinR();
        int max = h.getMaxR();
        JFrameSegmentacion frameIO = new JFrameSegmentacion("original", imagen);
        
        // Image imagenExp = FiltrosEspaciales.expansionLineal(min, max, imagen);
        // Histogramas h2 = new  Histogramas(imagenExp);
        // h2.Graph(); 
       
       
       
        System.out.println();

    }
}