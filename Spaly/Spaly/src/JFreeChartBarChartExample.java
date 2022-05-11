import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeChartBarChartExample extends JFrame {

   private static final long serialVersionUID = 1L;

   public JFreeChartBarChartExample(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createBarChart(chartTitle, "Category", "Spending", createDataset(),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      
        // add to contentPane
        setContentPane(chartPanel);
    }
  
   private CategoryDataset createDataset() {
     

      // column keys...
      final String transportation = "Transportation";
      final String food = "Food";
      final String clothing = "Clothing";
      final String other = "Other";

      // create the dataset...
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

      dataset.addValue(1.0, "Transportation", transportation);
      dataset.addValue(4.0, "Food", food);
      dataset.addValue(3.0, "Clothing", clothing);
      dataset.addValue(5.0, "Other", other);

      return dataset;
     
  }

   public static void main(String[] args) {
      JFreeChartBarChartExample chart = new JFreeChartBarChartExample("Daily Spending Statistics", "What categories did you spend today?");
      chart.pack();
      chart.setVisible(true);
   }
}