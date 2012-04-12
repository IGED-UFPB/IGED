
package br.ufpb.iged.tutor.ncm;

/**
 *
 * @author GILBERTO FARIAS
 */

public abstract class Role {
    private int id;
    private String eventType;
    
    private int minCardinality;
    private int maxCardinality;
    
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCardinality() {
        return maxCardinality;
    }

    public void setMaxCardinality(int maxCardinality) {
        this.maxCardinality = maxCardinality;
    }

    public int getMinCardinality() {
        return minCardinality;
    }

    public void setMinCardinality(int minCardinality) {
        this.minCardinality = minCardinality;
    }
}
