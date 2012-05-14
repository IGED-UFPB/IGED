
package br.ufpb.iged.tutor.ncm.entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletNode extends ContentNode{
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
