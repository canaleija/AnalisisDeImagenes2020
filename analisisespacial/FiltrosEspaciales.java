package analisisespacial;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;

import open.AbrirImagen;

public class FiltrosEspaciales{

    public static Image generarImagenGrises(Image io){

        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
            color = new Color(prom,prom,prom);
            bi.setRGB(x, y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image generarImagenNegativa(Image io){

        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            
            color = new Color(255-color.getRed()
                            ,255-color.getGreen()
                            ,255-color.getBlue());
            bi.setRGB(x, y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image iluminarImagen(Image imagen, int alpha){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen() + alpha;
            int b = color.getBlue() + alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image modificarTemperatura(Image imagen, int alpha){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen();
            int b = color.getBlue() - alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static int validarLimites (int aux){

        if (aux<0)return 0;
        if (aux>255)return 255;
        return aux;

    }

    public static Image segmentarImagen(Image imagen, int umbral){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color, colorFondo;
        colorFondo = new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if (prom>umbral){
                bi.setRGB(x,y,colorFondo.getRGB());
            }
                       
        }
        return AbrirImagen.toImage(bi);
    }
}