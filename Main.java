import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analisisespacial.FiltrosEspaciales;
import analisisespacial.Histogramas;
import analisisespacial.Suavizado;
import gui.JFrameSegmentacion;
import gui.JframeImagen;

public class Main {

    public static void main(String[] args) {

        Image imagen = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagen);
        Histogramas ho = new Histogramas(imagen);
        ho.Graph();

        Image ruidoS = Suavizado.agregarRuidoSustractivo(imagen, 1);
        JframeImagen frame2 = new JframeImagen(ruidoS);
        Histogramas hrs = new Histogramas(ruidoS);
        hrs.Graph();

        int[][] mascara = new int[][]{{1,1,1},{1,0,1},{1,0,1}};
        Image imagenSuavizada = Suavizado.suavizar(ruidoS, mascara);
        JframeImagen frame3 = new JframeImagen(imagenSuavizada);
        Histogramas his = new Histogramas(imagenSuavizada);
        his.Graph();
        // Image imagenExp = FiltrosEspaciales.expansionLineal(min, max, imagen);
        // Histogramas h2 = new  Histogramas(imagenExp);
        // h2.Graph(); 
       
       
       
        System.out.println();

    }
}