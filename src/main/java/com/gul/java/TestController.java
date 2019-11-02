package com.gul.java;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("chart")
	public void view(HttpServletResponse response) throws IOException {
//		MultiLineChart example = new MultiLineChart("Line Chart Example");
//		example.setAlwaysOnTop(true);
//		example.pack();
//		example.setSize(600, 400);
//		example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		example.setVisible(true);
//		response.setContentType("image/png");

		OutputStream outputStream = response.getOutputStream();

		JFreeChart chart = ChartFactory.createBarChart("Car Usage Statistics", "Category", "Score",
				createDataset(), PlotOrientation.VERTICAL, true, true, false);
//		int width = 500;
//		int height = 350;
//		BufferedImage img = chart.createBufferedImage(600, 300);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(img, "PNG", baos);
////		TestController.writeChartAsPNG(outputStream, chart, width, height);
//
////		ChartUtilities.writeChartAsPNG(baos, chart, width, height);
////		try {
////			ByteArrayOutputStream bos = new ByteArrayOutputStream();
////			ChartUtilities.writeChartAsPNG(bos, chart, width, height);
////			return bos.toByteArray();
////		} catch (IOException e) {
////			return new byte[0];
////		}

		ChartUtilities.writeChartAsJPEG(outputStream, chart, 400, 400);
	}

	public JFreeChart getChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Ford", 23.3);
		dataset.setValue("Chevy", 32.4);
		dataset.setValue("Yugo", 44.2);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("Cars", dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.GREEN);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}

	private CategoryDataset createDataset() {
		final String fiat = "FIAT";
		final String audi = "AUDI";
		final String ford = "FORD";
		final String speed = "Speed";
		final String millage = "Millage";
		final String userrating = "User Rating";
		final String safety = "safety";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, fiat, speed);
		dataset.addValue(3.0, fiat, userrating);
		dataset.addValue(5.0, fiat, millage);
		dataset.addValue(5.0, fiat, safety);

		dataset.addValue(5.0, audi, speed);
		dataset.addValue(6.0, audi, userrating);
		dataset.addValue(10.0, audi, millage);
		dataset.addValue(4.0, audi, safety);

		dataset.addValue(4.0, ford, speed);
		dataset.addValue(2.0, ford, userrating);
		dataset.addValue(3.0, ford, millage);
		dataset.addValue(6.0, ford, safety);

		return dataset;
	}

}


// 	https://mvnrepository.com/artifact/org.jfree/jfreechart  
//		<dependency>
//			<groupId>org.jfree</groupId>
//			<artifactId>jfreechart</artifactId>
// 			<version>1.5.0</version> -->
//			    <version>1.0.19</version>
//		</dependency>