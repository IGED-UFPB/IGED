package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.connector.Bind;
import br.ufpb.iged.tutor.ncm.connector.ConditionRole;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class Link extends Entity {

    private List<Bind> binds;
    private HypermediaConnector connector;

    Link(HypermediaConnector conn) {
        connector = conn;
        this.binds = new LinkedList<Bind>();
    }

    public void add(Bind b) {
        this.binds.add(b);
    }

    public void remove(Bind b) {
        this.binds.remove(b);
    }

    public List<Bind> getBinds() {
        return binds;
    }

    public List<Bind> getBindsForRole(String roleName) {
        List<Bind> l = new LinkedList<Bind>();
        for (Bind b : this.binds) {
            if (roleName.equals(b.getRole())) {
                l.add(b);
            }
        }
        return l;
    }

    public HypermediaConnector getConnector() {
        return connector;
    }

    public void setConnector(HypermediaConnector connector) {
        this.connector = connector;
    }

    public abstract Link toReadXML(NamedNodeMap namedNode);
}
