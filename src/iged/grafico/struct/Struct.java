package iged.grafico.struct;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Struct extends Elemento {

    //Referência grafica
    protected Referencia ref;
    protected List<Referencia> referencias = new ArrayList<Referencia>();
    protected List<String> referenciasS = new ArrayList<String>();
    protected Point2D pi = null;
    protected Point2D pr = null;
    
    public abstract Point2D getPInit();
    //Ponto de incidência das Referencias
    public Point2D getPointPI() {
        return this.pi;
    }

    public abstract int getBond();

    public abstract void repintar();

    public abstract boolean isRepintado();

    public abstract void startRepaint();

    public abstract Struct readField(int field);

    public abstract void writeField(Struct s, int field);

    public abstract String readInfo();

    public abstract void writeInfo(String value);
    
    public abstract void add(String ref);
    
    public Point2D add(Referencia ref) {
        if (!this.referencias.contains(ref)) {
            this.referencias.add(ref);
        }
        return null;
    }
    
    public void addReference(String ref) {
        if (!this.referenciasS.contains(ref)) {
            this.referenciasS.add(ref);
        }
    }

    public void remove(Referencia ref) {
        if (this.referencias.contains(ref)) {
            this.referencias.remove(ref);
        }
    }
    
    public void removeReference(String ref) {
        if (this.referenciasS.contains(ref)) {
            this.referenciasS.remove(ref);
        }
    }
    
    public String getNameReferencia(){
        String s = "";
        if(this.referenciasS.size() == 1){
            s += this.referenciasS.get(0);
        }else{
            s += "{";
            int c = 0;
            for(String re : this.referenciasS){
                s += re;
                if(c != this.referenciasS.size()-1)
                    s += ",";
                ++c;
            }
            s += "}";
        }
        return s;
    }
}
