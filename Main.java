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
        JFrameSegmentacion frame = new JFrameSegmentacion("Segementacion",imagen);
        
       
       
       
        System.out.println();

    }
}