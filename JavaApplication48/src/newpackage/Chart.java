package newpackage;

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

public class Chart extends JFrame
{
   
    public Chart(int i, int quantity) 
    {
         draw(i, quantity);
    }
    public void draw(int i, int quantity) // zamieniec na currency
    {
        XMLparser money = new XMLparser();
        money.downloadCurrency();
        money.updateCurrency();
        XYSeries daily = new XYSeries("Chart volatility of exchange rates");     
        for(int k=0; k<quantity; k++)
            daily.add (k, money.currency.get(i).rates.get(k).rate);
	// Add the series to your data set
	XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(daily);
	// Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart(
        "Chart volatility of exchange rates", // Title
	"Days", // x-axis Label
	"Rates", // y-axis Label
	dataset, // Dataset
	PlotOrientation.VERTICAL, // Plot Orientation
	true, // Show Legend
	true, // Use tooltips
	false // Configure chart to generate URLs?  
	);
        chart.setBackgroundPaint(Color.lightGray);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white); // tlo wykresu
        plot.setDomainGridlinePaint(Color.black); // kratki na wykresie
        plot.setRangeGridlinePaint(Color.black);
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis(); 
        rangeAxis.setAutoRangeIncludesZero(false); // zciesnienie kursow
	ChartPanel chartPanel = new ChartPanel(chart, false);
	chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setSize(500, 270);
    }
}