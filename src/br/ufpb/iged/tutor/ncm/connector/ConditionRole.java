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

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }
    
}
