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

    public static Image expansionLineal(int r1, int r2, Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-r1)*(255/r2-r1);
            int g = (color.getGreen()-r1)*(255/r2-r1);
            int b = (color.getBlue()-r1)*(255/r2-r1);
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image expansionLineal(Histogramas h, Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-h.getMinR())*(255/h.getMaxR()-h.getMinR());
            int g = (color.getGreen()-h.getMinG())*(255/h.getMaxG()-h.getMinG());
            int b = (color.getBlue()-h.getMinB())*(255/h.getMaxB()-h.getMinB());
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

    public static int obtenerMin(double[] h){

        for(int x=0; x<h.length;x++){
            if(h[x]!=0) return x;
        }
     return -1;
    }

    public static int obtenerMax(double[] h){

        for(int x=h.length-1; x>=0;x--){
            if(h[x]!=0) return x;
        }
     return -1;
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

    public static Image segmentarImagen(Image imagen, int u1, int u2){
        // TODO: garantizar  que el u2>u1
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color, colorFondo;
        colorFondo = new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if (!(prom>= u1 && prom<=u2)){
                bi.setRGB(x,y,colorFondo.getRGB());
            }
                       
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image ecualizarImagen(Image imagen){
    
        int nxm = imagen.getWidth(null)*imagen.getHeight(null);
        Histogramas h = new Histogramas(imagen);
        double[] ho = h.getHRed();
        double[] daf = new double[256];
        int[] nt = new int[256];
        daf[0] = (int)ho[0];
        nt[0] = (int)Math.round((daf[0]/nxm)*255);
        // recorremos el histograma para acumular
        for(int x=1; x<ho.length;x++){
            daf[x] = (int)(ho[x]+daf[x-1]);
            double aux = daf[x]/nxm;
            int tmp = (int) Math.round(aux * 255);
            nt[x] = tmp;
        }

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int t = color.getRed();
            int t2 =nt[t];
            color = new Color(t2,t2,t2);     
            bi.setRGB(x,y,color.getRGB());
        }

        
        return AbrirImagen.toImage(bi);

    }
}