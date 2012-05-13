
package br.ufpb.iged.tutor.ncm.connector;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ActionRole extends Role{
    private Action action = null;

    public Action getAction() {
        return action;
    }

    void setAction(Action action) {
        this.action = action;
    }
}
