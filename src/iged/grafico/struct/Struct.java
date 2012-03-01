package iged.grafico.struct;

import java.awt.geom.Point2D;

public interface Struct {

	public Point2D getPInit();

	public int getBond();
	
	public void repintar();
	
	public boolean isRepintado();
	
	public void startRepaint();

	public Struct readField(int field);

	public void writeField(Struct s, int field);

	public String readInfo();

	public void writeInfo(String value);
        
}
