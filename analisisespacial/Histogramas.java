package analisisespacial;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import org.jfree.chart.plot.XYPlot;

import open.AbrirImagen;

public class Histogramas{

    private double hRojo[];
    private double hVerde[];
    private double hAzul[];
    private double hGrises[];
    private Integer minR,maxR;
    private Integer minG,maxG;
    private Integer minB,maxB;


    public Histogramas(Image imagen){
        this.hRojo = new double[256];
      
        this.hVerde = new double[256];
        this.hAzul = new double[256];
        this.hGrises = new double[256];
        calcularHistogramas(imagen);
    }

    private void calcularHistogramas(Image imagen){
        // en solo corrimiento del buffer se calcula el histograma de frecuencias de color
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color aux = null;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
                aux = new Color(bi.getRGB(x, y));
                this.hRojo[aux.getRed()]++;
                this.hVerde[aux.getGreen()]++;
                this.hAzul[aux.getBlue()]++;
                int prom = (aux.getRed()+aux.getGreen()+aux.getBlue())/3;
                this.hGrises[prom]++;
            }
    
        calcularMinimosYMaximos();    
    } 
   
    
    public void Graph(){
        Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
        graph.agregarSerie("Rojo", hRojo);
        graph.agregarSerie("Azul", hAzul);
        graph.agregarSerie("Verde",hVerde);
        
        graph.crearGrafica();

        XYPlot plot = graph.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
        plot.getRenderer().setSeriesPaint(1, new Color(Color.BLUE.getRGB()));
        plot.getRenderer().setSeriesPaint(2, new Color(Color.GREEN.getRGB()));
        graph.muestraGrafica();
//           plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
 }
 
 public void GraphGrey(){
        Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de grises");
        graph.agregarSerie("Gris", hGrises );
        graph.crearGrafica();
        XYPlot plot = graph.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.DARK_GRAY.getRGB()));
        graph.muestraGrafica();
 }
 
 public void GraphRed(){
        Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
        graph.agregarSerie("Rojo", hRojo);
        graph.crearGrafica();
        XYPlot plot = graph.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
        graph.muestraGrafica();
 }
 public void GraphBlue(){
        Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
        graph.agregarSerie("Azul", hAzul);
        graph.crearGrafica();
        XYPlot plot = graph.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.BLUE.getRGB()));
        graph.muestraGrafica();
 }
 public void GraphGreen(){
        Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
        graph.agregarSerie("Verde", hVerde);
        graph.crearGrafica();
        XYPlot plot = graph.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.GREEN.getRGB()));
        graph.muestraGrafica();
 }

 private void calcularMinimosYMaximos(){
    this.minR = -1;
    this.minG = -1;
    this.minB = -1;
    this.maxR = 256;
    this.maxG = 256;
    this.maxB = 256;

    for(int t1 = 0, t2= hRojo.length-1; minR==-1 || maxR==256 ;t1++,t2--){
        if(hRojo[t1]!=0 && minR ==-1){
            minR = t1;
        }
        if(hRojo[t2]!=0 && maxR==256){
            maxR = t2;
        }
       
    }
    
   

 }
  
    public double[] getHRed(){
        return this.hRojo;
    }
    public double[] getHBlue(){
        return this.hAzul;
    }
    public double[] getGreen(){
        return this.hVerde;
    }
    public int getMinR(){
        return this.minR;
    }
    public int getMaxR(){
        return this.maxR;
    }
}