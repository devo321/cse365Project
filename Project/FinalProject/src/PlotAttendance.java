import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class PlotAttendance extends JFrame {
    /**
     * Creates a scatter plot with data from model
     * @param title Title of graph
     * @param model Data for graph
     */
    public PlotAttendance(String title, DefaultTableModel model){
        super(title);
        

        //Create a dataset
        XYDataset data = createDataset(model);

        //Create chart
        JFreeChart chart = ChartFactory.createScatterPlot("Attendance", "Student", "% of Attendance", data);

        //Set bg color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint( new Color(255,228,196));

        //Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
    /**
     * Creates a dataset to be used in the Scatter Plot
     * @param model Data to be turned into the data set
     * @return  dataset
     */
    private XYDataset createDataset(DefaultTableModel model){
        XYSeriesCollection dataset = new XYSeriesCollection();
        int numStudents = model.getRowCount();
        int numCols = model.getColumnCount();
        int numAttendDates = numCols - 6;
        double percent;

        //Creates data sets for each date
        for(int i = 0; i < numAttendDates; i++){
            XYSeries series = new XYSeries(model.getColumnName(6+i));
            for(int j = 0; j < numStudents; j++){
                //Calculate attendance % for that date
                if((int)model.getValueAt(j, 6+i) >= 75){
                    series.add(j+1, 100);
                }
                else{
                    percent = ((double)(int)model.getValueAt(j, 6+i) / 75) * 100;
                    series.add(j+1, percent);
                }
            }
            //adds series to the dataset
            dataset.addSeries(series);
        }
        return dataset;

    }
}
