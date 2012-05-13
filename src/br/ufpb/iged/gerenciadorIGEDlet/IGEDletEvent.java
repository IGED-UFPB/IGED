/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorIGEDlet;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletEvent {
    
    int status;
    IGEDlet source;
    
    IGEDletEvent(int status, IGEDlet a){
        this.status = status;
        this.source = a;
    }
    
    public IGEDlet getSource(){
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
