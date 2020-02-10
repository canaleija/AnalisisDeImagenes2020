package analisisespacial;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafica{

   
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY,titulo;

    public Grafica(String ejeX, String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
    }
    public void agrearSerie(String nombre){
     XYSeries serie = new XYSeries(nombre);
     this.series.addSeries(serie);
    }
    public void agregarDatoASerie(String nombre, XYDataItem dato)   {
       this.series.getSeries(nombre).add(dato);
    }
    public void agregarSerie(String nombre, double[] datos){
    
        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
     
    }

    public JFreeChart getGrafica(){
        return this.grafica;
    }
    
    public void crearGrafica(){
        this.grafica = ChartFactory.createXYAreaChart(titulo, ejeX, ejeY, series);
    }

    public void muestraGrafica(){
    
        ChartFrame frame = new ChartFrame("Histograma de color", grafica);
        frame.setVisible(true);
        frame.setSize(500,370);
        
    }
    
    
}