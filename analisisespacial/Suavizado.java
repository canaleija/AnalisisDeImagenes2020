package analisisespacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import open.AbrirImagen;

public class Suavizado{

    public static Image agregarRuidoAditivo(Image io, int p){

        int dim = io.getWidth(null)*io.getHeight(null);
        int cp = dim/100*p;
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        Random ran = new Random(); 
       
        for(int x=0; x<cp;x++){
            int r = ran.nextInt(bi.getHeight());
            int c = ran.nextInt(bi.getWidth());
            bi.setRGB( c,r, Color.WHITE.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image agregarRuidoSustractivo(Image io, int p){

        int dim = io.getWidth(null)*io.getHeight(null);
        int cp = dim/100*p;
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        Random ran = new Random(); 
       
        for(int x=0; x<cp;x++){
            int r = ran.nextInt(bi.getHeight());
            int c = ran.nextInt(bi.getWidth());
            bi.setRGB(c,r, Color.BLACK.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

  


}