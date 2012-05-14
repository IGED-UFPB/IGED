/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.connector;

/**
 *
 * @author GILBERTO FARIAS
 * Classe responsável por ativar o link que possui o conector que contém o
 * CoditionRole associado. 
 */
public class ConditionRole extends Role{
    private Condition condition = null;
    private String key = null;

    public Condition getCondition() {
        return condition;
    }

<<<<<<< HEAD
    void setCondition(Condition condition) {
=======
    public void setCondition(Condition condition) {
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
        this.condition = condition;
    }

    public String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }
    
}
