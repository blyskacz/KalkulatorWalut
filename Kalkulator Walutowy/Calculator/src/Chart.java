

import java.awt.Color;
import javax.swing.JFrame;
        
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;

public class Chart 
{
    public ChartPanel cp ;
    public Calculator calc;
   
    public void draw(Currency c, Currency c2, int quantity) // zamieniiec na currency
    {

        XMLparser money = new XMLparser();
        calc = new Calculator();
        money.downloadCurrency();
        money.updateCurrency();
        XYSeries daily = new XYSeries("Wykres zmienności " + c.tag);     
        for(int k=0; k<quantity; k++)
            daily.add (k, (calc.caltulate(c.rates.get(k).rate, c2.rates.get(k).rate )));
	// Add the series to your data set
	XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(daily);
	// Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart(
        "Wykres zmienności waluty: "+c.tag, // Title
	"Dni", // x-axis Label
	"Kurs", // y-axis Label
	dataset, // Dataset
	PlotOrientation.VERTICAL, // Plot Orientation
	true, // Show Legend
	true, // Use tooltips
	false // Configure chart to generate URLs?  
	);
        chart.setBackgroundPaint(Color.lightGray);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white); // tlo wylkresu
        plot.setDomainGridlinePaint(Color.black); // kratki na wykresie
        plot.setRangeGridlinePaint(Color.black);
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis(); 
        rangeAxis.setAutoRangeIncludesZero(false); // zciesnienie kursow
	ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setMouseWheelEnabled(true);
	chartPanel.setPreferredSize(new Dimension(764, 318));
        this.cp = chartPanel;
    }
}