
package br.ufpb.iged.tutor.ncm.event;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class EntityEvent {
    
    private int occurrences = 0; 
    private int staus = EntityEvent.SLEEPING;

    public int getOccurrences() {
        return occurrences;
    }

    void incrOccurrences() {
        ++this.occurrences;
    }

    public int getStaus() {
        return staus;
    }

    void setStaus(int staus) {
        this.staus = staus;
    }
    
    public abstract Object getSource();
    
    
    public static final int SLEEPING = 0;
    public static final int PAUSED = 1;
    public static final int OCCURING = 2;
}
