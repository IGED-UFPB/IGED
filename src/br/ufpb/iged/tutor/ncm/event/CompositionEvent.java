
package br.ufpb.iged.tutor.ncm.event;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CompositionEvent extends EntityEvent{
    private CompositionEvent source = null;

    @Override
    public CompositionEvent getSource() {
        return source;
    }

    void setSource(CompositionEvent source) {
        this.source = source;
    }
}
