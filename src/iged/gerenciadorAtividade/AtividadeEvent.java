/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

/**
 *
 * @author GILBERTO FARIAS
 */
public class AtividadeEvent {
    
    int status;
    Atividade source;
    
    AtividadeEvent(int status, Atividade a){
        this.status = status;
        this.source = a;
    }
    
    public Atividade getSource(){
        return this.source;
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public static final int NOT_INIT = -1;
    public static final int INIT = 0;
    public static final int SUCCESS = 1;
    public static final int FAIL = 2;
    
}
