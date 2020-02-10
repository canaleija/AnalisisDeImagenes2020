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

}