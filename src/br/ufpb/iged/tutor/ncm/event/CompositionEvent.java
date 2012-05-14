
package br.ufpb.iged.tutor.ncm.event;

<<<<<<< HEAD
=======
import br.ufpb.iged.tutor.ncm.entity.CompositeNode;

>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
/**
 *
 * @author GILBERTO FARIAS
 */
<<<<<<< HEAD
public class CompositionEvent extends Event{
    private CompositionEvent source = null;

    @Override
    public CompositionEvent getSource() {
        return source;
    }

    void setSource(CompositionEvent source) {
        this.source = source;
    }
=======
public class CompositionEvent extends EntityEvent{
    private CompositeNode source = null;

    public CompositeNode getSource() {
        return source;
    }

    public void setSource(CompositeNode source) {
        this.source = source;
    }

   
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}
