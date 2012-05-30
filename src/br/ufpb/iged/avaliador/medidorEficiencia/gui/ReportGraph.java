package br.ufpb.iged.avaliador.medidorEficiencia.gui;

import java.awt.geom.Point2D;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

//import org.jfree.data.xy.XYSeries;

import br.ufpb.iged.avaliador.medidorEficiencia.efficiency.TableMeter;
import br.ufpb.iged.avaliador.medidorEficiencia.efficiency.XYSeries;

public class ReportGraph {

	XYSeriesCollection dataSet = new XYSeriesCollection();
	
	static TableMeter tableMeter = TableMeter.getInstance();

	public void addSeries(String id_function){
		
		XYSeries XY =  tableMeter.getXYSeries(id_function);
		
		//XYSeries series1 = new XYSeries(id_function);
		org.jfree.data.xy.XYSeries serie = new  org.jfree.data.xy.XYSeries(XY.title);
		
		serie.add(0,0);
		
		for(Point2D point : XY.getListPoints()){
			
			serie.add(point.getX(), point.getY());
			//dataSet.addSeries(serie);
			
		}
				
		dataSet.addSeries(serie);				
	}
	
	public void showSeries(){
		
		JFreeChart chart = ChartFactory.createXYLineChart ("Grafico", "X", "Y", dataSet, PlotOrientation.VERTICAL, true, true, false);

		ChartFrame chartFrame = new ChartFrame("Test", chart);
		
		
		chartFrame.pack();
		//chartFrame.addMouseWheelListener(MouseEvent.MOUSE_WHEEL);
		
		
		chartFrame.setVisible(true);
		
	}
}
