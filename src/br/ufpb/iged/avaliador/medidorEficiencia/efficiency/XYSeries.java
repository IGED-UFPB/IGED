package efficiency;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;


public class XYSeries {

	public String title;
	
	public List<Point2D> listPoints = new LinkedList<Point2D>();
	
	public XYSeries(String s) {
		// TODO Auto-generated constructor stub
		this.title = s;
	}
	
	public void addPoint2D(Double point1, Double point2){
		
		Point2D point = new Point2D.Double(point1,point2);
		//this.point.distance(point1,point2);
		
		this.listPoints.add(point);
		
	}
	
	public List<Point2D> getListPoints(){
		
		return this.listPoints;
	}
	
	
	
}
