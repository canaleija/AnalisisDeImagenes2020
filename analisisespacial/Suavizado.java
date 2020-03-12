package analisisespacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;
import java.awt.Color;

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

    public static Image suavizar(Image io,int[][] mascara){

        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        // recorres el buffer
        for(int x=0; x < bi.getWidth();x++){
            for(int y=0; y < bi.getHeight();y++){
            int rgb = calcularNuevoTono(x,y,bi,mascara);
            bnuevo.setRGB(x, y, rgb);
            }
        }
        return AbrirImagen.toImage(bnuevo);
    }

    private static int calcularNuevoTono(int x, int y, BufferedImage bi, int[][] mascara) {
        
        // recorrer la mascara
        // int r = x -1;
        //int c = y -1;
        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        int k = 0;
        for(int i = 0 , r = x -1; i<mascara.length;i++, r++){
            for(int j = 0, c = y -1; j < mascara[0].length;j++, c++){
                if(mascara[i][j]!=0){
                    try {
                        int rgb = bi.getRGB(r, c);
                        k++;
                        color = new Color(rgb);
                        auxR+= color.getRed();
                        auxG+= color.getGreen();
                        auxB+= color.getBlue();
                        
                    } catch (Exception e) {
                        // nada de nada 
                    }
                }
            }
        }
        if(k!=0){
        auxR/=k;
        auxG/=k;
        auxB/=k;}
        color = new Color(auxR,auxG,auxB);
        return color.getRGB();
    }


}