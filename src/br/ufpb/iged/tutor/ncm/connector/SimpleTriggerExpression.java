/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.connector;

/**
 *
 * @author GILBERTO FARIAS
 */
public class SimpleTriggerExpression extends TriggerExpression{
    private String conditionRole;
    private String roleQualifier;

    public String getConditionRole() {
        return conditionRole;
    }

    public void setConditionRole(String conditionRole) {
        this.conditionRole = conditionRole;
    }

    public String getRoleQualifier() {
        return roleQualifier;
    }

    public void setRoleQualifier(String roleQualifier) {
        this.roleQualifier = roleQualifier;
    }
    
}
