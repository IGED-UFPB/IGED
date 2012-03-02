package iged.grafico.struct;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Struct extends Elemento {

    protected List<Referencia> referencias = new ArrayList<Referencia>();

    public abstract Point2D getPInit();

    public abstract int getBond();

    public abstract void repintar();

    public abstract boolean isRepintado();

    public abstract void startRepaint();

    public abstract Struct readField(int field);

    public abstract void writeField(Struct s, int field);

    public abstract String readInfo();

    public abstract void writeInfo(String value);
}
